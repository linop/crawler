/*
 * 文件名称: QuartzTest.java Copyright 2011-2014 Nali All right reserved.
 */
package com.ximalaya.crawler.center;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ximalaya.crawler.center.schedule.ScheduleJob;

/**
 * @author ted
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context-test.xml")
public class QuartzTest {
    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() throws Exception {
        JobDetail jobDetail = JobBuilder.newJob(ScheduleJob.class)
            .usingJobData("task.config.id", 1L).withIdentity("test-job").build();
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("test-cronTrigger")
            .usingJobData("task.config.id", 2L)
            .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?")).startNow().build();
        schedulerFactoryBean.getScheduler().scheduleJob(jobDetail, trigger);
        Thread.sleep(10000);
    }
}
