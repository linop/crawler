package com.ximalaya.crawler.node.parse.impl;

import com.ximalaya.crawler.node.parse.AbstractParser;
import com.ximalaya.crawler.node.utils.HttpConstants;
import us.codecraft.webmagic.Site;

/**
 * Created by caorong on 14-3-8.
 */
public class SohuParser extends AbstractParser {

    public static Site sohuSite = new Site();

    static {
        sohuSite.addHeader(HttpConstants.USER_AGENT, HttpConstants.CHROME_V33);
//        sohuSite.setCharset("GBK");
        sohuSite.setDomain("tv.sohu.com");
        // timeout 100s
        sohuSite.setTimeOut(1000 * 1000);
    }
}
