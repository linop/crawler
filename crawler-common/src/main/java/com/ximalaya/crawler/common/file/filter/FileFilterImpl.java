/*
 *
 *  * 文件名称: FileFilterImpl.java  Copyright 2011-2013 Nali All right reserved.
 *
 */

package com.ximalaya.crawler.common.file.filter;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件过滤器
 * <p>
 * 过滤掉所有名称在excludeFileNames中的文件
 *
 * Created by caorong on 14-1-29.
 */
public class FileFilterImpl implements FilenameFilter {

    private List<String> includeFileNames;

    public FileFilterImpl(List<String> includeFileNames) {
        this.includeFileNames = includeFileNames;
    }

    public FileFilterImpl(String includeFileName) {
        this.includeFileNames = new ArrayList<String>();
        this.includeFileNames.add(includeFileName);
    }

    /**
     * (non-Javadoc)
     *
     * @see java.io.FilenameFilter#accept(java.io.File, java.lang.String)
     */
    @Override
    public boolean accept(File dir, String name) {
        if (includeFileNames.contains(name)) {
            return true;
        }
        return false;
    }

}
