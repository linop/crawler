/*
 * 文件名称: CommonUtils.java Copyright 2011-2014 Nali All right reserved.
 */
package com.ximalaya.crawler.common.util;

/**
 * @author ted
 */
public class CommonUtils {
    /**
     * 根据url获得groupname
     * 
     * @param url
     * @return
     */
    public static String getGroupName(String url) {
        String groupname = null;
        int endIndex = url.indexOf(".com");
        if (endIndex < 0) {
            endIndex = url.lastIndexOf(".cn");
        }
        if (endIndex <= 0) {
            throw new IllegalArgumentException("Unknown group from url: " + url);
        }
        String temp = url.substring(0, endIndex);
        int startIndex = temp.lastIndexOf(".") + 1;
        groupname = url.substring(startIndex, endIndex);
        return groupname;
    }
}
