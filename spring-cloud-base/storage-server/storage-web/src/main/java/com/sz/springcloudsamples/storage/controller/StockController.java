package com.sz.springcloudsamples.storage.controller;

import com.sz.springcloudsamples.common.mvc.controller.BaseController;
import com.sz.springcloudsamples.common.mvc.dto.ResponseResultDTO;
import com.sz.springcloudsamples.storage.service.StockService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Yanghj
 * @date 2023/7/17 18:52
 */
@RestController
@RequestMapping("/stock")
@Api(tags = "订单控制器")
public class StockController extends BaseController {

    @Autowired
    private StockService stockService;

    /**
     * 扣减库存
     *
     * @param productId 产品id
     * @param count     数量
     * @return
     */
    @PostMapping("decrease")
    public ResponseResultDTO decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count) {
        stockService.decrease(productId, count);
        return super.ok("Decrease stock success");
    }
}
