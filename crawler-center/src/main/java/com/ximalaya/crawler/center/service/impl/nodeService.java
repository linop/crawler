package com.ximalaya.crawler.center.service.impl;

import com.ximalaya.crawler.center.callback.ReminderCallback;
import com.ximalaya.crawler.center.service.INodeService;

import java.util.List;

/**
 * Created by caorong on 14-2-15.
 */
public class NodeService implements INodeService {
    @Override
    public List<String> getAliveNode() {
        return ReminderCallback.aliveNode;
    }
}
