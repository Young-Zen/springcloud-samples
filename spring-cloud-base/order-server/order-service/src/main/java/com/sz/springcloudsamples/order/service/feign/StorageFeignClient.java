package com.sz.springcloudsamples.order.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sz.springcloudsamples.common.mvc.dto.ResponseResultDTO;

/**
 * @author Yanghj
 * @date 2023/7/17 19:50
 */
@FeignClient(value = "storage-server", url = "${feign.url.storage}")
public interface StorageFeignClient {

    /**
     * 扣减库存
     *
     * @param productId
     * @param count
     * @return
     */
    @PostMapping(value = "api/storage/stock/decrease")
    ResponseResultDTO decrease(
            @RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
