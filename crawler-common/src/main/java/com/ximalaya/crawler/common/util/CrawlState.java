/*
 * 文件名称: CrawlState.java Copyright 2011-2014 Nali All right reserved.
 */
package com.ximalaya.crawler.common.util;

/**
 * @author ted
 */
public enum CrawlState {
    INIT(0) {
    },
    PARSE(1) {
    },
    DOWNLOAD(2) {
    },
    CONVERT(3) {
    },
    UPLOAD(4) {
    },
    SUCCESS(5) {
    },
    FAIL(6) {
    },
    RETRY(7) {
    };
    private int val;

    private CrawlState(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }
}
