/*
 * 文件名称: Album.java Copyright 2011-2014 Nali All right reserved.
 */
package com.ximalaya.crawler.common.model;

import java.util.Date;

import com.ximalaya.crawler.common.model.base.BaseModel;

/**
 * @author ted
 */
public class Album extends BaseModel {
    private Long id;
    private String intro;
    private String title;
    private String host;
    private String broadcast;
    private String category;
    private String tag;
    private Date createdAt;
    private String cover;
    private Boolean isDeleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getBroadcast() {
        return broadcast;
    }

    public void setBroadcast(String broadcast) {
        this.broadcast = broadcast;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "Album [id=" + id + ", intro=" + intro + ", title=" + title + ", host=" + host
            + ", broadcast=" + broadcast + ", category=" + category + ", tag=" + tag
            + ", createdAt=" + createdAt + ", cover=" + cover + ", isDeleted=" + isDeleted + "]";
    }
}
