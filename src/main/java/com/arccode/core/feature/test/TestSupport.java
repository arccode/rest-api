package com.arccode.core.feature.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/**
 * TestSupport : Spring测试支持,用于测试由Spring 管理的bean,编写测试类时,继承该类 
 *
 * @author arccode
 * @since 2014-11-27
 */
@ContextConfiguration(locations = {"classpath*:spring-root.xml"})
public class TestSupport extends AbstractJUnit4SpringContextTests {

    /**
     * 日志
     */
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    protected long startTime;
    protected long endTime;

    /**
     * 记录 开始运行时间
     *
     * @return
     */
    protected long start() {
        this.startTime = System.currentTimeMillis();
        return startTime;
    }

    /**
     * 记录 结束运行时间
     *
     * @return
     */
    protected long end() {
        this.endTime = System.currentTimeMillis();
        this.log();
        return endTime;
    }

    /**
     * 输出记录
     */
    protected void log() {
        String text = "\n开始时间 : " + this.startTime + "\n结束时间 : " + this.endTime + "\n执行时间 : " + (this.endTime - this.startTime);
        logger.info(text);
    }
}