/*
 *
 *  * 文件名称: Shard.java  Copyright 2011-2013 Nali All right reserved.
 *
 */

package com.ximalaya.crawler.common.model.base;

/**
 * 数据库分表信息,用于查询时生成表名
 *
 * Created by caorong on 14-1-29.
 */
public class Shard {
    public String databaseSuffix;

    public String tableSuffix;

    /**
     * @return the databaseSuffix
     */
    public String getDatabaseSuffix() {
        return databaseSuffix;
    }

    /**
     * @param databaseSuffix
     *            the databaseSuffix to set
     */
    public void setDatabaseSuffix(String databaseSuffix) {
        this.databaseSuffix = databaseSuffix;
    }

    /**
     * @return the tableSuffix
     */
    public String getTableSuffix() {
        return tableSuffix;
    }

    /**
     * @param tableSuffix
     *            the tableSuffix to set
     */
    public void setTableSuffix(String tableSuffix) {
        this.tableSuffix = tableSuffix;
    }

    @Override
    public String toString() {
        return "shard[databaseSuffix=" + databaseSuffix + ",tableSuffix=" + tableSuffix + "]";
    }

}
