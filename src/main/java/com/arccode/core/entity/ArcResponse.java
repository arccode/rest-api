package com.arccode.core.entity;

import com.arccode.core.constant.EmptyObjectConstant;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * ArcResponse : 通用响应对象, 封装数据如下
 *
 * {"meta":{"code":200,"message":"创建成功"},"data":{"id":"5308e9c2-a4ce-4dca-9373-cc1ffe63d5f9","name":"Apple Watch SPORT","description":"Sport 系列的表壳材料为轻巧的银色及深空灰色阳极氧化铝金属，强化 Ion-X 玻璃材质为显示屏提供保护。搭配高性能 Fluoroelastomer 表带，共有 5 款缤纷色彩。"}}
 *
 * @author http://arccode.net
 * @since 2015-04-16 17:47
 */
public class ArcResponse<T> {

    private Meta meta;

    private T data;

    public ArcResponse() {

    }

    public ArcResponse(Meta meta, T data) {
        this.meta = meta;
        this.data = data;
    }

    public ArcResponse(Integer code, String message) {
        this.meta = new Meta(code, message);
        this.data = (T)new Object();
    }

    public ArcResponse(Integer code, String message, T data) {
        this.meta = new Meta(code, message);
        this.data = data;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
