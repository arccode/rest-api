package com.arccode.web.controller.handler.global;

import com.arccode.core.entity.ArcExceptionResponse;
import com.arccode.core.entity.ArcNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * GlobalExceptionHandler : 全局异常处理, 通用的异常在此进行处理, 例如: http method不匹配(405), 用户为未认证(401), 用户未获取到授权(403)
 * 所有异常均向上抛, 统一在controller层进行处理
 *
 * @author http://arccode.net
 * @since 2015-04-16 16:21
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理Http method使用不正确的错误, 例如: 新增产品应该使用POST, 但实际使用了GET
     * @param req
     * @param ex
     * @return
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ResponseBody
    public ArcExceptionResponse handleHttp405Exception(HttpServletRequest req, Exception ex) {

        return ArcExceptionResponse.create(HttpStatus.METHOD_NOT_ALLOWED.value(), ex.getMessage());
    }

    /**
     * 处理未发现的异常,比如用户名不存在, 产品不存在等等, 抛出http status 404
     * @param req
     * @param ex
     * @return
     */
    @ExceptionHandler(ArcNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ArcExceptionResponse handleNotFoundException(HttpServletRequest req, Exception ex) {

        return ArcExceptionResponse.create(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }
}
