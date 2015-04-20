package com.arccode.core.entity;

/**
 * Meta : 封装返回给前端的metadata
 *
 * @author http://arccode.net
 * @since 2015-04-16 16:04
 */
public class Meta {

    private Integer code;

    private String message;

    public Meta() {
    }

    public Meta(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
