package com.arccode.core.util;


import com.arccode.core.constant.BaseConstant;

/**
 * StringUtil : 字符串工具类
 *
 * @author arccode
 * @since 2014-12-11 18:43
 */
public class StringUtil {

    /**
     * 返回去除首尾空格的字符串
     * @param str
     * @return
     */
    public static String trim2Empty(String str) {
        if(null == str || str.isEmpty()) {
            return "";
        }
        if(str.equals(BaseConstant.WORD_SEPARATOR)) {
            return str;
        }
        return str.trim();
    }
}
