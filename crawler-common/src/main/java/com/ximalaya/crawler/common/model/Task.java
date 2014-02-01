/*
 * 文件名称: Task.java Copyright 2011-2014 Nali All right reserved.
 */
package com.ximalaya.crawler.common.model;

import java.util.Date;

import com.ximalaya.crawler.common.model.base.BaseModel;

/**
 * @author ted
 */
public class Task extends BaseModel {
    private Long id;
    private Long configId;
    private Long audioId;
    private String url;
    private Short priority;
    private Short type;
    private Date createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getConfigId() {
        return configId;
    }

    public void setConfigId(Long configId) {
        this.configId = configId;
    }

    public Long getAudioId() {
        return audioId;
    }

    public void setAudioId(Long audioId) {
        this.audioId = audioId;
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

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Task [id=" + id + ", configId=" + configId + ", audioId=" + audioId + ", url="
            + url + ", priority=" + priority + ", type=" + type + ", createdAt=" + createdAt + "]";
    }
}
