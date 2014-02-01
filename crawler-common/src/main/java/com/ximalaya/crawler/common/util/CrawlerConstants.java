/*
 * 文件名称: CrawlerConstants.java Copyright 2011-2014 Nali All right reserved.
 */
package com.ximalaya.crawler.common.util;

/**
 * @author ted
 */
public class CrawlerConstants {
    /** 任务状态 */
    static final Short TASK_STATE_INITIAL = 0;
    static final Short TASK_STATE_FETCHING = 1;
    static final Short TASK_STATE_DOWNLOADING = 2;
    static final Short TASK_STATE_CONVERTING = 3;
    static final Short TASK_STATE_UPLOADING = 4;
    static final Short TASK_STATE_SUCCESS = 5;
    static final Short TASK_STATE_FAILED = 6;
    static final Short TASK_STATE_RETRYING = 7;
    // static final Short TASK_STATE_AD_DEL = 100;// 任务所对应的tb_audio中的记录被误删的状态
    static final Short TASK_STATE_VD_404 = 404;// 任务对应的url404，造成到flvcd解析后的真实url为空的状态
    static final String STATISTICS_LOG_NAME = "com.ximalaya.crawler.statistics";
    static final String PROXY_LOG_NAME = "com.ximalaya.crawler.proxy";
    /** END */
    static final Short LIST_TASK_TYPE = 1;
    static final Short DETAIL_TASK_TYPE = 2;
    static final Short EXCEL_LIST_TASK_TYPE = 3;
    static final Short EXCEL_DETAIL_TASK_TYPE = 4;
    // xiami signerlistTask add by caorong at 2013-8-22
    static final Short SINGER_ALBUM_LIST_TASK_TYPE = 5;
    // crawler ftp task add by caorong at 2013-11-6
    static final Short FTP_DETAIL_TASK_TYPE = 6;
    static final String LAN_REN_TING_SHU = "yytingting";
    static final String ITUNES_PODCAST = "itunespodcast";
    static final String EXCEL_TASK_PREFIX = "file";
    static final String EMPTY_STR = "";
    static final Short HIGH_PRIORITY = 9;
    static final Short NORMAL_PRIORITY = 5;
    static final Short LOW_PRIORITY = 1;
    static final Short OFFLINE = 0;
    static final Short ONLINE = 1;
    static final String MP3 = ".mp3";
    static final String FLV = ".flv";
    static final Short CONF_ENABLE = 1;
    static final Short CONF_DISABLE = 2;
    // ERROR MESSAGE
    static final String ERROR_000 = "未知错误";
    static final String ERROR_001 = "页面不存在";
    static final String ERROR_002 = "网络连接错误";
    static final String ERROR_003 = "解析网页错误";
    static final String ERROR_004 = "解析FLVCD网页错误";
    static final String ERROR_005 = "下载地址错误";
    static final String ERROR_006 = "下载流异常终止";
    static final String ERROR_007 = "转码错误";
    static final String ERROR_008 = "上传错误";
    static final String ERROR_009 = "任务提交时错误";
    static final String ERROR_010 = "FLVCD没有返回下载地址";
    static final String ERROR_011 = "获取爱奇艺密钥错误";
    static final String ERROR_012 = "解析cntv错误";
    static final String ERROR_013 = "该页没有内容，请检查源地址页";
    static final String ERROR_014 = "该专辑不存在或者由于版权到期而下线";
    static final String ERROR_015 = "flvcd 挂了";
    static final String ERROR_100 = "解析excel错误";
    static final String ERROR_101 = "文件路径错误,不存在或者不能访问";
    static final String ERROR_502 = "goagent代理错误";
    static final String ERROR_500 = "ADSL代理错误";
    static final String ERROR_501 = "ADSL代理超时";
}
