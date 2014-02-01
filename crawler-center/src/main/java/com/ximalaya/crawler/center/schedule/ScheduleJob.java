/*
 * 文件名称: ScheduleJob.java Copyright 2011-2014 Nali All right reserved.
 */
package com.ximalaya.crawler.center.schedule;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * crawler schedule job implements
 * <p>
 * this job will be execution after every job trigger be triggered
 * 
 * @author ted
 */
@DisallowConcurrentExecution
public class ScheduleJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        // get task config id
        Long id = context.getTrigger().getJobDataMap().getLong("task.config.id");
        Long id2 = context.getJobDetail().getJobDataMap().getLong("task.config.id");
        // select task config by id from database
        // then generate new task, and insert into database
    }
}
