/*
 *
 *  * 文件名称: SuffixFileFilter.java  Copyright 2011-2013 Nali All right reserved.
 *
 */

package com.ximalaya.crawler.common.file.filter;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Created by caorong on 14-1-29.
 */
public class SuffixFileFilter implements FilenameFilter {

    /** The filename suffixes to search for */
    private final String[] suffixes;

    /**
     * Constructs a new Suffix file filter for a single extension specifying case-sensitivity.
     *
     * @param suffix the suffix to allow, must not be null
     * @throws IllegalArgumentException if the suffix is null
     * @since
     */
    public SuffixFileFilter(String suffix) {
        if (suffix == null) {
            throw new IllegalArgumentException("The suffix must not be null");
        }
        this.suffixes = new String[] { suffix };
    }

    /**
     * Constructs a new Suffix file filter for an array of suffixs.
     * <p>
     * The array is not cloned, so could be changed after constructing the instance. This would be inadvisable however.
     *
     * @param suffixes the suffixes to allow, must not be null
     * @throws IllegalArgumentException if the suffix array is null
     */
    public SuffixFileFilter(String[] suffixes) {
        this.suffixes = suffixes;
    }

    /**
     * (non-Javadoc)
     *
     * @see java.io.FilenameFilter#accept(java.io.File, java.lang.String)
     */
    @Override
    public boolean accept(File dir, String name) {
        for (String suffix : this.suffixes) {
            if (name.endsWith(suffix)) {
                return true;
            }
        }
        return false;
    }
}