package com.arccode.core.util;

import com.arccode.core.constant.SymbolConstant;
import com.arccode.core.entity.DateFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * DateUtil : 日期工具类
 *
 * @author arccode
 * @since 2014-12-11 18:22
 */
public class DateUtil {

    private static final Logger logger = LoggerFactory.getLogger(DateUtil.class);

    /**
     * 日期类型转字符串
     * @param date java.util.Date
     * @param dateFormat  格式化格式, 使用自定义的枚举类封装所有格式化类型
     * @return
     */
    public static String convertDate2String(Date date, DateFormat dateFormat) {

        if(null == date) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat.getFormat());
        String dateStr = sdf.format(date);
        return StringUtil.trim2Empty(dateStr);
    }

    /**
     * 字符串转日期类型
     * @param dateStr
     * @param dateFormat
     * @return
     */
    public static Date convertString2Date(String dateStr, DateFormat dateFormat) {
        if(null == dateStr || "".equals(dateStr.trim())) {
            return new Date();
        }

        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat.getFormat());
        Date result = new Date();
        try {
            result = sdf.parse(dateStr);
        } catch (ParseException e) {
            logger.warn(SymbolConstant.POUND_TWENTY + "字符串日期不合法" + SymbolConstant.COLON
                + dateStr
                + SymbolConstant.POUND_TWENTY);
        }

        return result;
    }

    /**
     * 获取指定的date, 参看calendar api
     * @param field
     * @param amount
     * @return
     */
    public static Date getDefineTime(int field, int amount) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(field, amount);
        return calendar.getTime();
    }

    /**
     * 获取指定日期的起始值, e.g: 2014-11-11 10:11:22 -> 2014-11-11 00:00:00
     * @param date
     * @return
     */
    public static Date getDateStartByDate(Date date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        return calendar.getTime();
    }

    /**
     * 获取指定日期的结束值, e.g: 2014-11-11 10:11:22 -> 2014-11-11 23:59:59
     * @param date
     * @return
     */
    public static Date getDateEndByDate(Date date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);

        return calendar.getTime();
    }

    /**
     * 返回当前日期
     * @return
     */
    public static Date getNow() {
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime();
    }

}
