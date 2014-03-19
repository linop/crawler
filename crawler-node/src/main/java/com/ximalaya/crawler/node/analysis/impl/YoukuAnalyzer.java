/*
 * 文件名称: YoukuAnalyzer.java  Copyright 2011-2014 Nali All right reserved.
 */
package com.ximalaya.crawler.node.analysis.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ximalaya.crawler.node.analysis.AbstractAnalyzer;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.ximalaya.crawler.common.model.Album;
import com.ximalaya.crawler.common.model.Audio;
import com.ximalaya.crawler.common.model.Task;
import com.ximalaya.crawler.node.parse.impl.YoukuParser;

/**
 *
 * @author caorong created on 2014-3-11
 * @since 1.0
 */
public class YoukuAnalyzer extends AbstractAnalyzer {

    @Autowired
    public FlvcdApiAnalyzer flvcdAnalyzer;

    @Override
    public List<String> analysis(String url) throws Exception {
        List<String> reUrls = new ArrayList<String>();
        // get youku real path
        String ykJsonData = fetch(YoukuParser.site, "http://v.youku.com/player/getPlayList/VideoIDS/"
          + getVidByUrl(url));
        log.info("json url is {0}", "http://v.youku.com/player/getPlayList/VideoIDS/" + getVidByUrl(url));
        // test data
//        ykJsonData = "{\"data\":[{\"ct\":\"d\",\"cs\":\"2070|2074\",\"logo\":\"http://g2.ykimg.com/11270F1F465318F18DBDDC000000000FF8A718-A3B6-9FFE-F718-DB5FC32C8590\",\"seed\":8522,\"tags\":[\"3\u5929\"],\"categories\":\"97\",\"videoid\":\"170435681\",\"vidEncoded\":\"XNjgxNzQyNzI0\",\"list\":[{\"seq\":\"1\",\"vid\":\"170332182\",\"vidEncoded\":\"XNjgxMzI4NzI4\",\"title\":\"Three Days 01\",\"vv\":\"11455751\"},{\"seq\":\"2\",\"vid\":\"170435681\",\"vidEncoded\":\"XNjgxNzQyNzI0\",\"title\":\"Three Days 02\",\"vv\":\"9960135\"}],\"list_pre\":{\"seq\":\"1\",\"vid\":\"170332182\",\"vidEncoded\":\"XNjgxMzI4NzI4\",\"title\":\"Three Days 01\",\"vv\":\"11455751\"},\"list_next\":{\"seq\":3,\"vid\":\"170479556\",\"vidEncoded\":\"XNjgxOTE4MjI0\",\"title\":\"\u300aThree Days\u300b03\u96c6\u9884\u544a\u7247\"},\"username\":\"SBS\u97e9\u5267\",\"userid\":\"53328839\",\"title\":\"Three Days 02\",\"up\":0,\"down\":0,\"ts\":\"l*JrAzIVLFUxbRogATdb1aY\",\"tsup\":\"l*JvGzEVLFUxbRogAi9f1aY\",\"preview\":{\"thumbs\":[\"052100065318F1CD6A074167B60518D1\",\"052101065318F1CD6A074167B60518D1\",\"052102065318F1CD6A074167B60518D1\",\"052103065318F1CD6A074167B60518D1\",\"052104065318F1CD6A074167B60518D1\",\"052105065318F1CD6A074167B60518D1\"],\"sectiontime\":\"6000\",\"host\":\"http://g4.ykimg.com/\"},\"key1\":\"b14b1e64\",\"key2\":\"86b9a255a2c1a040\",\"tt\":\"0\",\"show\":{\"showid\":\"286761\",\"showid_encode\":\"4d92dcf292ce11e38b3f\",\"showname\":\"Three Days\",\"paid\":0,\"paid_type\":\"\",\"show_paid\":0,\"paid_url\":\"\",\"copyright\":1,\"show_videotype\":1,\"theaterid\":0,\"stage\":\"2\"},\"dvd\":{\"notsharing\":\"0\",\"point\":[{\"start\":\"731705\",\"ctype\":\"story\",\"title\":\"\u6cf0\u4eac\u65e0\u8f9c\u53d7\u6000\u7591 \u767e\u53e3\u83ab\u8fa9\u6210\u7591\u72af\",\"desc\":\"\"},{\"start\":\"1159031\",\"ctype\":\"story\",\"title\":\"\u5b9d\u5a9b\u6797\u4e2d\u88ab\u8ffd\u6740 \u53d7\u4f24\u9003\u4ea1\u6781\u60ca\u9669\",\"desc\":\"\"},{\"start\":\"1375643\",\"ctype\":\"standard\",\"title\":\"\",\"desc\":\"\"},{\"start\":\"1492719\",\"ctype\":\"story\",\"title\":\"\u6cf0\u4eac\u53d1\u73b0\u53ef\u7591\u70b9 \u7591\u662f\u5185\u9b3c\u5728\u4f5c\u795f\",\"desc\":\"\"},{\"start\":\"1922696\",\"ctype\":\"story\",\"title\":\"\u6cf0\u4eac\u63a8\u7406\u63ed\u771f\u76f8 \u5ba4\u957f\u7adf\u662f\u6697\u6740\u72af\",\"desc\":\"\"},{\"start\":\"2288507\",\"ctype\":\"story\",\"title\":\"\u4e0d\u60dc\u81ea\u4f24\u63a9\u7f6a\u884c \u5949\u79c0\u5ac1\u7978\u97e9\u6cf0\u4eac\",\"desc\":\"\"},{\"start\":\"2600981\",\"ctype\":\"standard\",\"title\":\"\",\"desc\":\"\"},{\"start\":\"2641050\",\"ctype\":\"story\",\"title\":\"\u5b9d\u5a9b\u53d7\u88ad\u5fd9\u8eb2\u85cf \u6cf0\u4eac\u89e3\u6551\u5973\u5de1\u8b66\",\"desc\":\"\"},{\"start\":\"2986023\",\"ctype\":\"story\",\"title\":\"\u6cf0\u4eac\u6cea\u773c\u5fc6\u4ea1\u7236 \u5b9d\u5a9b\u4e0d\u5fcd\u540c\u60b2\u621a\",\"desc\":\"\"}]},\"interact\":true,\"seconds\":\"3520.42\",\"streamfileids\":{\"flv\":\"19*0*19*19*19*2*19*12*19*19*6*0*24*40*33*34*29*19*6*12*24*30*19*0*2*32*29*29*33*22*22*40*0*12*6*46*6*0*8*32*29*40*22*8*32*29*29*24*8*22*7*2*29*8*33*1*1*34*29*12*24*19*29*22*24*40*\",\"mp4\":\"19*0*19*19*19*40*19*30*19*19*6*0*24*40*32*22*32*19*6*12*24*30*19*0*2*32*29*29*33*22*22*40*0*12*6*46*6*0*8*32*29*40*22*8*32*29*29*24*8*22*7*2*29*8*33*1*1*34*29*12*24*19*29*22*24*40*\",\"hd2\":\"19*0*19*19*19*24*24*2*19*19*6*0*24*40*46*24*40*12*6*12*24*30*19*0*2*32*29*29*33*22*22*40*0*12*6*46*6*0*8*32*29*40*22*8*32*29*29*24*8*22*7*2*29*8*33*1*1*34*29*12*24*19*29*22*24*40*\"},\"segs\":{\"flv\":[{\"no\":\"0\",\"size\":\"16803031\",\"seconds\":364,\"k\":\"f0acaee5079fc7142411bbc1\",\"k2\":\"1414f5965a4a9288c\"},{\"no\":\"1\",\"size\":\"13534510\",\"seconds\":388,\"k\":\"3f105b8dad3852d8261d8e42\",\"k2\":\"1c205e71eb59ea6de\"},{\"no\":\"2\",\"size\":\"9205373\",\"seconds\":371,\"k\":\"469396336a5322a1282960c3\",\"k2\":\"17cf2df8597c15be7\"},{\"no\":\"3\",\"size\":\"16472771\",\"seconds\":408,\"k\":\"c539b7b9bd23dd392411bbc1\",\"k2\":\"1b8b03ec567243c67\"},{\"no\":\"4\",\"size\":\"13661788\",\"seconds\":372,\"k\":\"c2c7199450a3e583282960c3\",\"k2\":\"131a2004fc12b0656\"},{\"no\":\"5\",\"size\":\"11145718\",\"seconds\":380,\"k\":\"e6a3d74745e0aa6c2411bbc1\",\"k2\":\"1f868addec97d0d0e\"},{\"no\":\"6\",\"size\":\"16652703\",\"seconds\":404,\"k\":\"f3e70eb0c1fa960f282960c3\",\"k2\":\"1dae1c7d96c18a600\"},{\"no\":\"7\",\"size\":\"11450722\",\"seconds\":377,\"k\":\"27b7bfcdb33bc3db261d8e42\",\"k2\":\"133dcb976b65168dd\"},{\"no\":\"8\",\"size\":\"9380929\",\"seconds\":255,\"k\":\"88dd8d74e1147dcd282960c3\",\"k2\":\"19d053216a5355180\"},{\"no\":\"9\",\"size\":\"8114965\",\"seconds\":202,\"k\":\"daa78d11cb5483622411bbc1\",\"k2\":\"1db07f424a3a16f45\"}],\"mp4\":[{\"no\":\"0\",\"size\":\"34557498\",\"seconds\":403,\"k\":\"bebff6edfa88538a2411bbc1\",\"k2\":\"1fdb9af4206ce073c\"},{\"no\":\"1\",\"size\":\"23116018\",\"seconds\":369,\"k\":\"d2ff7e0a5522ad42282960c3\",\"k2\":\"198b7a3e812896a78\"},{\"no\":\"2\",\"size\":\"17920942\",\"seconds\":366,\"k\":\"775dad462a6a8d1a282960c3\",\"k2\":\"1bfc52d3a93563249\"},{\"no\":\"3\",\"size\":\"30817722\",\"seconds\":397,\"k\":\"2ea55f8836167cec261d8e42\",\"k2\":\"130e7899db72a55b4\"},{\"no\":\"4\",\"size\":\"28459168\",\"seconds\":407,\"k\":\"e4ea705f0179cc44261d8e42\",\"k2\":\"1515521a6f1c7d07f\"},{\"no\":\"5\",\"size\":\"20518062\",\"seconds\":393,\"k\":\"1aebc5865bcdad8a282960c3\",\"k2\":\"17e5157b4f6bf1eaf\"},{\"no\":\"6\",\"size\":\"34252819\",\"seconds\":396,\"k\":\"f03586195b6d18802411bbc1\",\"k2\":\"16183ec9a5751fc66\"},{\"no\":\"7\",\"size\":\"21290839\",\"seconds\":372,\"k\":\"22762a635ea4c536282960c3\",\"k2\":\"16445a61beef37107\"},{\"no\":\"8\",\"size\":\"31642884\",\"seconds\":418,\"k\":\"37ffbfaa1b96b82b261d8e42\",\"k2\":\"10bab85032988981f\"}],\"hd2\":[{\"no\":\"0\",\"size\":\"35481064\",\"seconds\":210,\"k\":\"0a554beae9e4cc3a282960c3\",\"k2\":\"182ea6e8f026114c4\"},{\"no\":\"1\",\"size\":\"36011667\",\"seconds\":194,\"k\":\"afe61dc40468f145282960c3\",\"k2\":\"1ceb1b58e536be777\"},{\"no\":\"2\",\"size\":\"31991282\",\"seconds\":210,\"k\":\"62369b42f86d8ddb2411bbc1\",\"k2\":\"1fea5c35f571e0960\"},{\"no\":\"3\",\"size\":\"22856166\",\"seconds\":194,\"k\":\"216ed39489e9c388282960c3\",\"k2\":\"19329168aa436f9b9\"},{\"no\":\"4\",\"size\":\"23220530\",\"seconds\":204,\"k\":\"8e076ccbdc96c3c3261d8e42\",\"k2\":\"10ae6f77bca29eb59\"},{\"no\":\"5\",\"size\":\"31459908\",\"seconds\":200,\"k\":\"510a72c484b617332411bbc1\",\"k2\":\"108fcf3eca0cd80fe\"},{\"no\":\"6\",\"size\":\"36102102\",\"seconds\":196,\"k\":\"7026967884d188392411bbc1\",\"k2\":\"1bfade0b124f7bb06\"},{\"no\":\"7\",\"size\":\"21162505\",\"seconds\":201,\"k\":\"bed1a32db037ebc8282960c3\",\"k2\":\"1c0dfe62472abdfaf\"},{\"no\":\"8\",\"size\":\"30557129\",\"seconds\":186,\"k\":\"282644913908b2e8282960c3\",\"k2\":\"11e1e996ab23ddf13\"},{\"no\":\"9\",\"size\":\"30274093\",\"seconds\":200,\"k\":\"d355d55921fe13f0282960c3\",\"k2\":\"1f1af308e9acfb0be\"},{\"no\":\"10\",\"size\":\"22951612\",\"seconds\":182,\"k\":\"7dc1b4dfc8dbc3022411bbc1\",\"k2\":\"150ad73bf5b66edde\"},{\"no\":\"11\",\"size\":\"21630857\",\"seconds\":193,\"k\":\"c2cf3de33aec2e1c2411bbc1\",\"k2\":\"1a4649f3c55052fbf\"},{\"no\":\"12\",\"size\":\"39304589\",\"seconds\":200,\"k\":\"bbdc3d5da9c0b217282960c3\",\"k2\":\"13026ebef60744db4\"},{\"no\":\"13\",\"size\":\"33641427\",\"seconds\":208,\"k\":\"bcbe1f86a4e080be2411bbc1\",\"k2\":\"18284bc27bd74c5e2\"},{\"no\":\"14\",\"size\":\"23520128\",\"seconds\":202,\"k\":\"5611fcc4afd375012411bbc1\",\"k2\":\"1852eb0fc74dd14f5\"},{\"no\":\"15\",\"size\":\"37987987\",\"seconds\":210,\"k\":\"1150ecd04b64b7c9282960c3\",\"k2\":\"1d88a7f2ac3db2028\"},{\"no\":\"16\",\"size\":\"21052242\",\"seconds\":164,\"k\":\"6cf6bcb8f56d3f87261d8e42\",\"k2\":\"1a18c0901b38a7041\"},{\"no\":\"17\",\"size\":\"30512542\",\"seconds\":168,\"k\":\"bade49db38998fbd261d8e42\",\"k2\":\"17f3e626008154cd1\"}]},\"streamsizes\":{\"flv\":\"126422510\",\"mp4\":\"242575952\",\"hd2\":\"529717830\"},\"stream_ids\":{\"flv\":\"180843192\",\"mp4\":\"180853591\",\"hd2\":\"180858655\"},\"streamlogos\":{\"flv\":0,\"mp4\":0,\"hd2\":0},\"streamtypes\":[\"flv\",\"mp4\",\"hd2\"],\"streamtypes_o\":[\"hd2\",\"flvhd\",\"mp4\"]}],\"user\":{\"id\":0},\"controller\":{\"search_count\":true,\"mp4_restrict\":1,\"stream_mode\":1,\"video_capture\":true,\"hd3_enabled\":false,\"area_code\":310000,\"dma_code\":23853,\"continuous\":0,\"playmode\":\"show\",\"circle\":false,\"tsflag\":false,\"other_disable\":false,\"xplayer_disable\":false,\"app_disable\":false,\"share_disabled\":false,\"download_disabled\":false,\"pc_disabled\":false,\"pad_disabled\":false,\"mobile_disabled\":false,\"tv_disabled\":true,\"comment_disabled\":false}}";

        Map<String, Object> jdata = (Map<String, Object>) JSON.parse(ykJsonData);
//        System.out.println(dataMap);
//        segs = info['data'][0]['segs']
//                types = segs.keys()
        Map<String, Object> dataMap = (Map<String, Object>) ((List<Object>) jdata.get("data")).get(0);
        Map<String, Object> segs = (Map<String, Object>) dataMap.get("segs");
        Integer seed = (Integer) dataMap.get("seed");
        // for the simplest just take the flv
        List<Map<String, Object>> flvs = (List<Map<String, Object>>) segs.get("flv");
        String flvidsstr = (String) ((Map<String, Object>) dataMap.get("streamfileids")).get("flv");
        String[] flvids = flvidsstr.split("\\*");

        String source = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ/\\:._-1234567890";
        List<Character> sources = new ArrayList<Character>(source.length() + 10);
        for (Character c : source.toCharArray()) {
            sources.add(c);
        }
        System.out.println(sources);
        StringBuffer mixedsb = new StringBuffer();
        while (!sources.isEmpty()) {
//            seed = (seed * 211 + 30031) & 0xFFFF
//            index = seed * len(source) >> 16
//            c = source.pop(index)
//            mixed += c
            seed = (seed * 211 + 30031) & 0xFFFF;
//            System.out.println(seed);
            int index = seed * sources.size() >> 16;
//            System.out.println(index);
//            Character c = sources.get(index);
//            Character c = sources.remove((int) index);
            Character c = sources.remove(index);
            mixedsb.append(c);
        }
        String mixed = mixedsb.toString();
        char[] mixedArray = mixed.toCharArray();
        StringBuffer vidsb = new StringBuffer();
        for (String id : flvids) {
            vidsb.append(mixedArray[Integer.parseInt(id.trim())]);
        }
        String vid = vidsb.toString();
        String sid = new Date().getTime() + "" + (new Random().nextInt(999) + 1000)
          + (new Random().nextInt(999) + 1000);
//        System.out.println(mixed);
//        System.out.println(sid );
//        System.out.println(vid );

        for (Map<String, Object> m : flvs) {
//            no = '%02x' % int(s['no'])
            String no = String.format("%02x", Integer.parseInt(m.get("no").toString()));
            System.out.println(no);
            //http://f.youku.com/player/getFlvPath/sid/%s_%s/st/%s/fileid/%s%s%s?K=%s&ts=%s' %
            //(sid, no, file_type, vid[:8], no.upper(), vid[10:], s['k'], s['seconds'])
            reUrls.add("http://f.youku.com/player/getFlvPath/sid/" + sid + "_" + no + "/st/flv/fileid/"
              + vid.substring(0, 8) + no.toUpperCase() + vid.substring(10, vid.length())
              + "?K=" + m.get("k") + "&ts=" + m.get("seconds"));
        }
        return reUrls;
    }

    public String getVidByUrl(String url) {
        Pattern pattern = Pattern.compile("http://v.youku.com/v_show/id_([\\w=]+).html");
        Matcher matcher = pattern.matcher(url);
        if (matcher.find() && matcher.groupCount() > 0) {
            return matcher.group(1).trim();
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        String url = "http://v.youku.com/v_show/id_XNjgwMDkyNDgw.html";
        System.out.println(new YoukuAnalyzer().analysis(url));
//        System.out.println(new YoukuAnalyzer().getVidByUrl(url));
    }
}
