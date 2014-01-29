/*
 *
 *  * 文件名称: BaseModel.java  Copyright 2011-2013 Nali All right reserved.
 *
 */

package com.ximalaya.crawler.common.model.base;

/**
 * model基类.
 *
 * Created by caorong on 14-1-29.
 */
public class BaseModel {
    /**
     * 分页参数
     */

    transient Limit limit = null;

    /**
     * 分表参数
     */
    transient Shard shard = null;

    public BaseModel() {

    }

    /**
     * @param shard
     *            the shard to set
     */
    public void setShard(Shard shard) {
        this.shard = shard;
    }

    /**
     * @return the limit
     */
    public Limit getLimit() {
        return limit;
    }

    /**
     * @param limit
     *            the limit to set
     */
    public void setLimit(Limit limit) {
        this.limit = limit;
    }

    /**
     * @return the shard
     */
    public Shard getShard() {
        return shard;
    }
}
