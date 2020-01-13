package com.sz.springcloudsamples.common.exception;

import com.sz.springcloudsamples.common.mvc.dto.ResponseResultDTO;
import com.sz.springcloudsamples.common.mvc.enums.ResponseCodeEnum;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Yanghj
 * @date 1/13/2020
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseResultDTO handleException(Exception e) {
        return ResponseResultDTO.fail(ResponseCodeEnum.INTERNAL_SERVER_ERROR.getCode(), e.getClass().getName());
    }

    @ExceptionHandler(BaseException.class)
    public ResponseResultDTO handleBaseException(BaseException e) {
        return ResponseResultDTO.fail(e.getCode(), e.getMsg());
    }
}
