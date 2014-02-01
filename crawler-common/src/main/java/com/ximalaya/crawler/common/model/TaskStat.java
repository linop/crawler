/*
 * 文件名称: TaskState.java Copyright 2011-2014 Nali All right reserved.
 */
package com.ximalaya.crawler.common.model;

import com.ximalaya.crawler.common.model.base.BaseModel;

/**
 * @author ted
 */
public class TaskStat extends BaseModel {
    private Long id;
    private Long taskId;
    private Long startAt;
    private Long stopAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Long getStartAt() {
        return startAt;
    }

    public void setStartAt(Long startAt) {
        this.startAt = startAt;
    }

    public Long getStopAt() {
        return stopAt;
    }

    public void setStopAt(Long stopAt) {
        this.stopAt = stopAt;
    }

    @Override
    public String toString() {
        return "TaskStat [id=" + id + ", taskId=" + taskId + ", startAt=" + startAt + ", stopAt="
            + stopAt + "]";
    }
}
