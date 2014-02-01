/*
 * 文件名称: IOperation.java Copyright 2011-2014 Nali All right reserved.
 */
package com.ximalaya.crawler.node.command;

import com.ximalaya.crawler.common.model.Task;

/**
 * 定义所有操作的接口
 * <p>
 * <li>一个业务流程包括多个操作</li>
 * <li>每一个操作都保持一个状态</li>
 * <li>操作成功，状态即改变，失败，状态不变</li>
 * <li>所有操作结束，则一个业务流程完成</li>
 * <li>在任何一个操作过程中失败，下次启动将从此操作继续业务流程</li>
 * <p>
 * <Note>一个操作内的业务逻辑是原子性的,要么全部成功,要么全部重做</Note>
 * 
 * @author ted
 */
public interface ICommand {
    Task execute(Task task);

    String getName();
}
