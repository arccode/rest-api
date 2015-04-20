package com.arccode.test.util;

import com.arccode.core.entity.DateFormat;
import com.arccode.core.util.DateUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;
import java.util.Date;

/**
 * DateUtilTest :
 *
 * @author arccode
 * @since 2014-12-19 14:42
 */
public class DateUtilTest {

    private final static Logger logger = LoggerFactory.getLogger(DateUtil.class);

    /**
     * 获取给定日期前n天的日期
     */
    @Test
    public void getNAgo() {

        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        p(calendar);
        calendar.add(Calendar.MONTH, -1);
        p(DateUtil.convertDate2String(calendar.getTime(), DateFormat.DatePathSingle));



    }

    private void p(Object o) {
        System.out.println(o);
    }

    @Test
    public void dateBefore() throws InterruptedException {
        Date d1 = new Date();
        Thread.sleep(1000);
        Date d2 = new Date();

        logger.info(d1.before(d2) + "");
    }
}
