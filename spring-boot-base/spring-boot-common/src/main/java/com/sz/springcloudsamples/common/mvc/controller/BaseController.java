package com.sz.springcloudsamples.common.mvc.controller;

import com.sz.springcloudsamples.common.mvc.dto.ResponseResultDTO;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Yanghj
 * @date 1/10/2020
 */
public class BaseController {

    protected HttpServletRequest request;
    protected HttpServletResponse response;

    @ModelAttribute
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    protected ResponseResultDTO ok() {
        return ResponseResultDTO.ok();
    }

    protected ResponseResultDTO ok(ResponseResultDTO responseResultDTO) {
        return responseResultDTO;
    }

    protected ResponseResultDTO ok(String msg) {
        return ResponseResultDTO.ok(msg);
    }

    protected ResponseResultDTO ok(Object data) {
        return ResponseResultDTO.ok(data);
    }

    protected ResponseResultDTO ok(String msg, Object data) {
        return ResponseResultDTO.ok(msg, data);
    }

    protected ResponseResultDTO ok(String code, String msg) {
        return ResponseResultDTO.ok(code, msg);
    }

    protected ResponseResultDTO ok(String code, String msg, Object data) {
        return ResponseResultDTO.ok(code, msg, data);
    }

    protected ResponseResultDTO fail() {
        return ResponseResultDTO.fail();
    }

    protected ResponseResultDTO fail(String msg) {
        return ResponseResultDTO.fail(msg);
    }

    protected ResponseResultDTO fail(ResponseResultDTO responseResultDTO) {
        return responseResultDTO;
    }

    protected ResponseResultDTO fail(String errCode, String msg) {
        return ResponseResultDTO.fail(errCode, msg);
    }

    protected ResponseResultDTO fail(String errCode, String msg, Object data) {
        return ResponseResultDTO.fail(errCode, msg, data);
    }
}
