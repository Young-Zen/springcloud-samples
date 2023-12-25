package com.sz.springcloudsamples.common.mvc.controller;

import com.sz.springcloudsamples.common.mvc.dto.ResponseResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Validated  //校验方法参数
/**
 * 基本控制器类
 *
 * @author Yanghj
 * @date 1/10/2020
 */
public class BaseController {

    // 线程安全
    // 在Spring中，Controller的scope是singleton(单例)，但是其中注入的request却是线程安全的，原因在于：
    // 使用这种方式，当Bean初始化时，Spring并没有注入一个request对象，而是注入了一个代理（proxy）；
    // 当Bean中需要使用request对象时，通过该代理获取request对象。代理的实现参见AutowireUtils的内部类。
    @SuppressWarnings("PMD")
    @Autowired
    protected HttpServletRequest request;
    @Autowired
    protected HttpServletResponse response;

    @SuppressWarnings("PMD")
    // 线程不安全
    // @ModelAttribute注解用在Controller中修饰方法时，其作用是Controller中的每个@RequestMapping方法执行前，该方法都会执行。
    // 因此，setReqAndRes()的作用是在每个HandlerMethod执行前为request对象赋值。
    // 虽然setReqAndRes()中的参数request本身是线程安全的，但由于Controller是单例的，request作为Controller的一个域，无法保证线程安全。
    /*@ModelAttribute
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }*/

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
