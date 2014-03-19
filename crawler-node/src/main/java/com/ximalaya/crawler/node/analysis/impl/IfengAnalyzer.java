/*
 * 文件名称: IfengAnalyzer.java  Copyright 2011-2014 Nali All right reserved.
 */
package com.ximalaya.crawler.node.analysis.impl;

import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ximalaya.crawler.node.analysis.AbstractAnalyzer;
import com.ximalaya.crawler.node.parse.impl.IfengParser;
import com.ximalaya.crawler.node.utils.HttpConstants;
import org.springframework.beans.factory.annotation.Autowired;

import us.codecraft.webmagic.Site;
import us.codecraft.xsoup.Xsoup;

import com.google.common.collect.ImmutableList;
import com.ximalaya.crawler.common.model.Album;
import com.ximalaya.crawler.common.model.Audio;
import com.ximalaya.crawler.common.model.Task;
import com.ximalaya.crawler.node.parse.AbstractParser;

/**
 *
 * @author caorong created on 2014-3-11
 * @since 1.0
 */
public class IfengAnalyzer extends AbstractAnalyzer {

    @Autowired
    public FlvcdApiAnalyzer flvcdAnalyzer;

    public static Site ifengApi = new Site();

    static {
        ifengApi.addHeader(HttpConstants.USER_AGENT, HttpConstants.FIREFOX_V14);
        ifengApi.setCharset("UTF-8");
        ifengApi.setDomain("http://v.ifeng.com");
        // timeout 100s
        ifengApi.setTimeOut(1000 * 10);
    }

    @Override
    public List<String> analysis(String url) throws Exception {
        String id = null;
        try {
            // use flvcd for the first time
            // System.out.println(flvcdAnalyzer.analysis(url).toString()+""+flvcdAnalyzer.analysis(url).size());
            List<String> relist = flvcdAnalyzer.analysis(url);
            if (relist.size() == 0) {
                return relist;
            }
        } catch (Exception e) {
            log.error("get real url by flvcd fail!!! ,try ifeng analyzer", e);
        }
        try {
            id = getIdFromUrl(url);
        } catch (Exception e) {
            log.error("ifeng get id from url error");
        }
        if (id == null)
            id = getIdFromHtml(url);
        // request xml
        if (id != null) {
            String requestxml = "http://v.ifeng.com/video_info_new/"
              + id.charAt(id.length() - 2) + "/"
              + id.substring(id.length() - 2, id.length()) + "/" + id
              + ".xml";
            // %s/%s/%s.xml' % (id[-2], id[-2:], id)";
            log.debug("ifeng data xml url is {0}", requestxml);
            String xmldata = fetch(ifengApi, requestxml);
            // System.out.println(Xsoup.select(xmldata,
            // "//playlist/item/@VideoPlayUrl").get());
            return ImmutableList.of(Xsoup.select(xmldata,
              "//playlist/item/@VideoPlayUrl").get());
        }
        return null;
    }

    public String getIdFromUrl(String url) {
        Pattern pattern = Pattern
          .compile("([0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}).shtml");
        Matcher matcher = pattern.matcher(url);
        if (matcher.find() && matcher.groupCount() > 0) {
            return matcher.group(1).trim();
        }
        return null;
    }

    public String getIdFromHtml(String url) {
        // Pattern pattern =
        // Pattern.compile("var vid=\"([0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12})\"");
        Pattern pattern = Pattern
          .compile("\"([0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12})\"");
        Matcher matcher = pattern.matcher(fetch(IfengParser.site, url));
        if (matcher.find() && matcher.groupCount() > 0) {
            return matcher.group(1).trim();
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        String url = "http://v.ifeng.com/news/world/2014003/0157db05-de2d-4af7-8c21-852f32b1c604.shtml";
        url = "http://v.ifeng.com/v/news/mhkjsl4/index.shtml#01669b4b-86e3-4cb7-9c82-f9d06aca9a80";
        // url =
        // "http://v.ifeng.com/v/news/mhkjsl3/index.shtml#01893190-e33b-49d0-bbd3-3bedda09550f";
        // System.out.println(url.charAt(url.length() - 2));
        // System.out.println(url.substring(url.length() - 2, url.length()));
        // System.out.println(new IfengAnalyzer().getIdFromUrl(url));
        System.out.println(new IfengAnalyzer().analysis(url));
        // System.out.println(new IfengAnalyzer().getIdFromHtml( url));
        // new IfengAnalyzer().test(url);
    }
}
