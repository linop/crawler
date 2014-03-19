/*
 *
 *  * 文件名称: IfentParser.java  Copyright 2011-2013 Nali All right reserved.
 *
 */

package com.ximalaya.crawler.node.parse.impl;

import com.ximalaya.crawler.node.parse.AbstractParser;
import com.ximalaya.crawler.node.utils.HttpConstants;
import us.codecraft.webmagic.Site;

/**
 * Created by caorong on 14-3-19.
 */

public class IfengParser  extends AbstractParser {
    public static Site site = new Site();

    static {
        site.addHeader(HttpConstants.USER_AGENT, HttpConstants.FIREFOX_V14);
        // opensourceSite.setCharset("utf-8");
        site.setDomain("http://v.ifeng.com/");
        // timeout 100s
        site.setTimeOut(100 * 1000);
    }
}
