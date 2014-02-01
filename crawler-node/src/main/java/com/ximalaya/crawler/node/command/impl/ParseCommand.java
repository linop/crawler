/*
 * 文件名称: ParseCommand.java Copyright 2011-2014 Nali All right reserved.
 */
package com.ximalaya.crawler.node.command.impl;

import java.util.Map;

import com.ximalaya.crawler.common.model.Task;
import com.ximalaya.crawler.common.util.CommonUtils;
import com.ximalaya.crawler.node.command.ICommand;
import com.ximalaya.crawler.node.parse.IParser;

/**
 * @author ted
 */
public abstract class ParseCommand implements ICommand {
    protected Map<String, IParser> parsers;

    public void setParsers(Map<String, IParser> parsers) {
        this.parsers = parsers;
    }

    protected IParser getParser(String url) {
        String group = CommonUtils.getGroupName(url);
        IParser retParser = parsers.get(group);
        return retParser;
    }
}
