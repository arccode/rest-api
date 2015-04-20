package com.arccode.core.entity;

/**
 * ArcExceptionResponse : 异常响应, 消息将封装至返回json的meta中
 *
 * @author http://arccode.net
 * @since 2015-04-16 16:16
 */
public class ArcExceptionResponse {

    private Meta meta;

    public ArcExceptionResponse() {
    }

    public ArcExceptionResponse(Meta meta) {
        this.meta = meta;
    }

    public static ArcExceptionResponse create(Integer code, String message) {

        Meta exceptionMeta = new Meta(code, message);

        return new ArcExceptionResponse(exceptionMeta);
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }
}
