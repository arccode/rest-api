package com.arccode.core.entity;

/**
 * ArcNotFoundException : 查询时如果未查找到相关数据, 抛出该异常
 *
 * @author http://arccode.net
 * @since 2015-04-16 16:49
 */
public class ArcNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 8096927982277821689L;

    public ArcNotFoundException() {
    }

    public ArcNotFoundException(String message) {
        super(message);
    }
}
