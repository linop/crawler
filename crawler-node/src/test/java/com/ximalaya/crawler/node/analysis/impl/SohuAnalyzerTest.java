package com.ximalaya.crawler.node.analysis.impl;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

/**
 * Created by caorong on 14-3-9.
 */
public class SohuAnalyzerTest {


    String[] testUrls = {"http://tv.sohu.com/20140306/n396175735.shtml","http://tv.sohu.com/20140226/n395640052.shtml"};
    private SohuAnalyzer analyzer;
    @Before
    public void setUp() throws Exception {
        analyzer = new SohuAnalyzer();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testAnalysis() throws Exception {
        for(String url:testUrls)
            Assert.assertNotNull(analyzer.analysis(url));
    }

    @Test
    public void testGetRealUrlsBySohuMobile() throws Exception {
        for(String url:testUrls)
            Assert.assertNotNull(analyzer.analysis(url));
    }

    @Test
    public void testGetRealUrlsByApi() throws Exception {
        for(String url:testUrls)
            Assert.assertNotNull(analyzer.analysis(url));
    }

    @Test
    public void testGetRealUrl() throws Exception {
        for(String url:testUrls)
            Assert.assertNotNull(analyzer.analysis(url));
    }

}
