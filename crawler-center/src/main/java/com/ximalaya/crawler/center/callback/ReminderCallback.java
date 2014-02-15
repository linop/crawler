package com.ximalaya.crawler.center.callback;

import com.ximalaya.reminder.service.discover.callback.ClientDiscoveryCallback;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by caorong on 14-2-15.
 */
public class ReminderCallback implements ClientDiscoveryCallback {

    public static List<String> aliveNode = new ArrayList<String>(15);

    @Override
    public void getServerList(Set<String> serverList) {
        aliveNode.clear();
        aliveNode.addAll(serverList);
    }
}
