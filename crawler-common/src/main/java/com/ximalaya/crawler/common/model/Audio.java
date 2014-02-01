/*
 * 文件名称: Audio.java Copyright 2011-2014 Nali All right reserved.
 */
package com.ximalaya.crawler.common.model;

import com.ximalaya.crawler.common.model.base.BaseModel;

/**
 * @author ted
 */
public class Audio extends BaseModel {
    private Long id;
    private String title;
    private String intro;
    private String guest;
    private String host;
    private String broadcast;
    private String category;
    private String tag;
    private String localPath;
    private String localPath32;
    private String localPath64;
    private String localPath128;
    private String localPathAac;
    private String remotePath;
    private String remotePath32;
    private String remotePath64;
    private String remotePath128;
    private String remotePathAac;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getGuest() {
        return guest;
    }

    public void setGuest(String guest) {
        this.guest = guest;
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

    public String getLocalPath() {
        return localPath;
    }

    public void setLocalPath(String localPath) {
        this.localPath = localPath;
    }

    public String getLocalPath32() {
        return localPath32;
    }

    public void setLocalPath32(String localPath32) {
        this.localPath32 = localPath32;
    }

    public String getLocalPath64() {
        return localPath64;
    }

    public void setLocalPath64(String localPath64) {
        this.localPath64 = localPath64;
    }

    public String getLocalPath128() {
        return localPath128;
    }

    public void setLocalPath128(String localPath128) {
        this.localPath128 = localPath128;
    }

    public String getLocalPathAac() {
        return localPathAac;
    }

    public void setLocalPathAac(String localPathAac) {
        this.localPathAac = localPathAac;
    }

    public String getRemotePath() {
        return remotePath;
    }

    public void setRemotePath(String remotePath) {
        this.remotePath = remotePath;
    }

    public String getRemotePath32() {
        return remotePath32;
    }

    public void setRemotePath32(String remotePath32) {
        this.remotePath32 = remotePath32;
    }

    public String getRemotePath64() {
        return remotePath64;
    }

    public void setRemotePath64(String remotePath64) {
        this.remotePath64 = remotePath64;
    }

    public String getRemotePath128() {
        return remotePath128;
    }

    public void setRemotePath128(String remotePath128) {
        this.remotePath128 = remotePath128;
    }

    public String getRemotePathAac() {
        return remotePathAac;
    }

    public void setRemotePathAac(String remotePathAac) {
        this.remotePathAac = remotePathAac;
    }

    @Override
    public String toString() {
        return "Audio [id=" + id + ", title=" + title + ", intro=" + intro + ", guest=" + guest
            + ", host=" + host + ", broadcast=" + broadcast + ", category=" + category + ", tag="
            + tag + ", localPath=" + localPath + ", localPath32=" + localPath32 + ", localPath64="
            + localPath64 + ", localPath128=" + localPath128 + ", localPathAac=" + localPathAac
            + ", remotePath=" + remotePath + ", remotePath32=" + remotePath32 + ", remotePath64="
            + remotePath64 + ", remotePath128=" + remotePath128 + ", remotePathAac="
            + remotePathAac + "]";
    }
}
