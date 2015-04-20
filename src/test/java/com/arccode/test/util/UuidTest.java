package com.arccode.test.util;

import com.arccode.core.util.ApplicationUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * UuidTest :
 *
 * @author http://arccode.net
 * @since 2015-04-16 14:16
 */
public class UuidTest {

    private final Logger logger = LoggerFactory.getLogger(UuidTest.class);

    @Test
    public void test() {
        logger.info(ApplicationUtils.randomUUID());
    }
}
