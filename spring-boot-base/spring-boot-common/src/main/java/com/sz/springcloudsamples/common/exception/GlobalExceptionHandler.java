package com.sz.springcloudsamples.common.exception;

import com.sz.springcloudsamples.common.mvc.dto.ResponseResultDTO;
import com.sz.springcloudsamples.common.mvc.enums.ResponseCodeEnum;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseResultDTO handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
        Map<String, String> errors = new HashMap<>(allErrors.size());
        allErrors.forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return ResponseResultDTO.fail(ResponseCodeEnum.ARGUMENT_VALID_FAIL).setData(errors);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseResultDTO handleConstraintViolationException(ConstraintViolationException e) {
        return ResponseResultDTO.fail(ResponseCodeEnum.ARGUMENT_VALID_FAIL.getCode(), e.getMessage());
    }
}
