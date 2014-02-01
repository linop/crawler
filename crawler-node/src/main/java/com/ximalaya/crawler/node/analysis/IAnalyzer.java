/*
 * 文件名称: IAnalyzer.java Copyright 2011-2014 Nali All right reserved.
 */
package com.ximalaya.crawler.node.analysis;

import java.util.List;

/**
 * 解析获取下载地址接口
 * 
 * @author ted
 */
public interface IAnalyzer {
    List<String> analysis(String url) throws Exception;
}
