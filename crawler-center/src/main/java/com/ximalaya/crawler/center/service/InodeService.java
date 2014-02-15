package com.ximalaya.crawler.center.service;

import com.ximalaya.crawler.center.callback.ReminderCallback;

import java.util.List;

/**
 * Created by caorong on 14-2-15.
 */
public interface INodeService {

    /**
     * get the current alive crawler node
     * @return
     */
    public List<String> getAliveNode();
}
