package com.sz.springcloudsamples.order.controller;

import com.sz.springcloudsamples.common.mvc.controller.BaseController;
import com.sz.springcloudsamples.common.mvc.dto.ResponseResultDTO;
import com.sz.springcloudsamples.order.service.OrderService;
import com.sz.springcloudsamples.order.vo.OrderVO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author Yanghj
 * @date 2023/7/17 18:52
 */
@RestController
@RequestMapping("/order")
@Api(tags = "订单控制器")
public class OrderController extends BaseController {

    @Autowired
    private OrderService orderService;

    /**
     * 创建订单
     *
     * @param order
     * @return
     */
    @PostMapping("create")
    public ResponseResultDTO create(@Validated(OrderVO.Add.class) @RequestBody OrderVO order) {
        orderService.create(order);
        return ResponseResultDTO.ok("Create order success");
    }

    /**
     * 修改订单状态
     *
     * @param id
     * @param money
     * @param status
     * @return
     */
    @PutMapping("update")
    ResponseResultDTO update(@RequestParam("id") Long id, @RequestParam("money") BigDecimal money,
                  @RequestParam("status") Integer status) {
        orderService.update(id, money, status);
        return ResponseResultDTO.ok("订单状态修改成功");
    }
}
