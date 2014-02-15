/*
 * 文件名称: Startup.java Copyright 2011-2014 Nali All right reserved.
 */
package com.ximalaya.crawler.node;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ted
 */
public class Startup {
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                new String[] { "classpath:application-context.xml" });
        Thread.sleep(1000*100);
    }
}
