package com.arccode.core.entity;

/**
 * DateFormat : 时间类型
 *
 * @author arccode
 * @since 2014-12-11 18:26
 */
public enum DateFormat {

    Date("yyyy-MM-dd"), DateTime("yyyy-MM-dd HH:mm:ss"), DatePath("yyyy/MM/dd"), DatePathSingle("yyyy/M/d");

    private final String format;

    private DateFormat(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }
}
