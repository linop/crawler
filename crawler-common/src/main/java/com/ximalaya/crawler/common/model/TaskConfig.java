/*
 * 文件名称: TaskConfig.java Copyright 2011-2014 Nali All right reserved.
 */
package com.ximalaya.crawler.common.model;

import java.util.Date;

import com.ximalaya.crawler.common.model.base.BaseModel;

/**
 * @author ted
 */
public class TaskConfig extends BaseModel {
    private Long id;
    private String name;//名称
    private String url; // 任务的url
    private Short priority; //任务的优先级
    private Date createdAt; // 创建时间
    private Date updatedAt; // 更新时间
    private Date startAt; //开始时间
    private Date stopAt; //停止时间
    private Long interval; // 单位毫秒
    private String cronExp; // cronTrigger表达式
    private Short state; // 状态

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Short getPriority() {
        return priority;
    }

    public void setPriority(Short priority) {
        this.priority = priority;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getStartAt() {
        return startAt;
    }

    public void setStartAt(Date startAt) {
        this.startAt = startAt;
    }

    public Date getStopAt() {
        return stopAt;
    }

    public void setStopAt(Date stopAt) {
        this.stopAt = stopAt;
    }

    public Long getInterval() {
        return interval;
    }

    public void setInterval(Long interval) {
        this.interval = interval;
    }

    public String getCronExp() {
        return cronExp;
    }

    public void setCronExp(String cronExp) {
        this.cronExp = cronExp;
    }

    public Short getState() {
        return state;
    }

    public void setState(Short state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "TaskConfig [id=" + id + ", name=" + name + ", url=" + url + ", priority="
            + priority + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", startAt="
            + startAt + ", stopAt=" + stopAt + ", interval=" + interval + ", cronExp=" + cronExp
            + ", state=" + state + "]";
    }
}
