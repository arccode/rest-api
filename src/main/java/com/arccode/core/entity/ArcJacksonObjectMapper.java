package com.arccode.core.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * ArcJaxbJacksonObjectMapper : 禁用Jackson的FAIL_ON_EMPTY_BEANS
 *
 * @author http://arccode.net
 * @since 2015-04-17 00:27
 */
public class ArcJacksonObjectMapper extends ObjectMapper {


    private static final long serialVersionUID = -6588193192037263348L;

    public ArcJacksonObjectMapper() {

        this.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY)
                .setVisibility(PropertyAccessor.CREATOR, JsonAutoDetect.Visibility.ANY)
                .setVisibility(PropertyAccessor.SETTER, JsonAutoDetect.Visibility.NONE)
                .setVisibility(PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE)
                .setVisibility(PropertyAccessor.IS_GETTER, JsonAutoDetect.Visibility.NONE);

        // 禁用空对象转换json校验
        this.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    }
}
