package com.ximalaya.crawler.node.analysis.impl;


import com.alibaba.fastjson.JSON;
import com.google.common.collect.ImmutableList;
import com.ximalaya.crawler.node.analysis.AbstractAnalyzer;
import com.ximalaya.crawler.node.parse.impl.SohuParser;
import com.ximalaya.crawler.node.utils.HttpConstants;
import org.apache.commons.lang.StringUtils;
import us.codecraft.webmagic.Site;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * get the real download path of sohu video / by hacking sohu's web/mobile web api
 * Created by caorong on 14-3-8.
 */
public class SohuAnalyzer extends AbstractAnalyzer {
    public static Site sohuApi = new Site();

    static {
        sohuApi.addHeader(HttpConstants.USER_AGENT, HttpConstants.CHROME_V33);
//        sohuApi.setCharset("GBK");
        sohuApi.setDomain("tv.sohu.com");
        // timeout 100s
        sohuApi.setTimeOut(1000 * 1000);
    }

    @Override
    public List<String> analysis(String url) throws Exception {
        List<String> urls = null;
        urls = getRealUrlsByApi(url);
        if (urls == null || urls.size() == 0) {
            // TODO use redis to check web api fail counts
            log.info("get urls through api fail, try sohu mobile");
            urls = getRealUrlsBySohuMobile(url);
            if (urls == null) {
                log.error("get real url by sohu mobile fail !!!");
            }
        }
        return urls;
    }

    /**
     * get sohu video's real download path by it's mobile web page
     * which its mp4 urls are just in its html page.
     * @param url
     * @return
     */
    public List<String> getRealUrlsBySohuMobile(String url) {
        String mainPage = fetch(SohuParser.sohuSite, url);
        String vid = getVidFromPage(mainPage);
        String nid = getNidFromPage(mainPage);
        assert vid != null;
        assert nid != null;
        // mobile page is suck utf-8
        String mobilePage = fetch(sohuApi, "http://m.tv.sohu.com/" + vid + "/n" + nid + ".shtml");
        Pattern pattern = Pattern.compile("var VideoData = (\\{[.\\s\\S]+\\});");
        Matcher matcher = pattern.matcher(mobilePage);
        if (matcher.find() && matcher.groupCount() == 1) {
            String data = matcher.group(1);
            Map<String, Object> dataMap = (Map<String, Object>) JSON.parse(data);
            // may get 2 url string, for small screen and big screen. so only take the first one.
            List<String> mp4list = (List<String>) ((Map<String, Object>) dataMap.get("urls")).get("mp4");
            String mp4UrlStr = null;
            for (String s : mp4list) {
                if (!StringUtils.isEmpty(s.trim())) {
                    mp4UrlStr = s;
                    break;
                }
            }
            if (mp4list != null) {
                String[] mp4Urlarr = mp4UrlStr.split(",");
                return Arrays.asList(mp4Urlarr);
            }
        }
        return null;
    }

    /**
     * get sohu video's real download path by web api
     *
     * @param url
     * @return
     */
    public List<String> getRealUrlsByApi(String url) {
        String mainPage = fetch(SohuParser.sohuSite, url);
        System.out.println(mainPage);
        String vid = getVidFromPage(mainPage);
        log.debug("sohu analyzer vid is {}", vid);
        if (vid == null) {
            log.warn("get soho vid fail !!!");
            return null;
        }
        String dataJson = fetch(sohuApi, "http://hot.vrs.sohu.com/vrs_flash.action?vid=" + vid);
        log.debug("sohu Api json is {}", dataJson);
        Map<String, Object> dataMap = (Map<String, Object>) JSON.parse(dataJson);
        String host = (String) dataMap.get("allot");
        String prot = dataMap.get("prot").toString();
        // catcode may be null
        String catcode = dataMap.get("catcode") == null ? "" : dataMap.get("catcode").toString();
        Map<String, Object> subDataMap = (Map<String, Object>) dataMap.get("data");
        log.debug("host -> {}, prot -> {}, catcode -> {}, subDataMap -> {}", host, prot, catcode, subDataMap);
        // ch may be null
        String ch = subDataMap.get("ch") == null ? "" : subDataMap.get("ch").toString();
        List<Object> clipsBytes = (List<Object>) subDataMap.get("clipsBytes");
        List<String> clipsURLs = (List<String>) subDataMap.get("clipsURL");
        List<String> su = (List<String>) subDataMap.get("su");
        // check if 3 list equal
        if (clipsBytes.size() != clipsURLs.size() || clipsBytes.size() != su.size()) {
            log.error("sub urls data not match !!! clipsByte => {}, clipsURLs => {}, su => {}", clipsBytes, clipsURLs, su);
            return null;
        }
        if (clipsBytes.size() == 0) {
            log.error("get 0 urls");
            return null;
        }
        Long sum = 0L;
        for (Object i : clipsBytes) {
            sum = Long.parseLong(i.toString());
        }
        log.debug("clipsURLs => {}, su => {}, total size => {} MB ", clipsURLs, su, sum / 1024 / 1024.0);
        List<String> realUrls = new ArrayList<String>(clipsURLs.size());
        for (int i = 0; i < clipsBytes.size(); i++) {
            String realurl = getRealUrl(host, prot, clipsURLs.get(i), su.get(i), ch, catcode);
            if (realurl == null) {
                return null;
            }
            realUrls.add(realurl);
        }
        return realUrls;
    }

    public String getRealUrl(String host, String prot, String file, String _new, String ch, String catcode) {
        String url = "http://" + host + "/?prot=" + prot + "&file=" + file + "&new=" + _new;
        String data = fetch(sohuApi, url);
        log.debug("sohu searct data, url => {}, data => {}", url, data);
        // try split by "|" !!! blackhole !!!
        String[] datas = data.split("\\|");
        if (datas.length > 0) {
            return datas[0].substring(0, datas[0].length() - 1) + _new + "?key=" +
                    datas[3] + "&ch=" + ch + "&catcode=" + catcode + "&n=" + datas[6] + "&a=" + datas[7];
        }
        return null;
    }

    public String getVidFromPage(String html) {
        Pattern pattern = Pattern.compile("var vid=\"(\\d+)\"");
        Matcher matcher = pattern.matcher(html);
        if (matcher.find() && matcher.groupCount() > 0) {
            return matcher.group(1);
        }
        return null;
    }

    public String getNidFromPage(String html) {
        // take care of the blank " " around "="
        Pattern pattern = Pattern.compile("var nid = \"(\\d+)\"");
        Matcher matcher = pattern.matcher(html);
        if (matcher.find() && matcher.groupCount() > 0) {
            return matcher.group(1);
        }
        return null;
    }


}
