package com.sz.springcloudsamples.order.vo;

import java.math.BigDecimal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import com.sz.springcloudsamples.common.mvc.vo.BaseVO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Yanghj
 * @date 2023/7/17 18:37
 */
@Data
public class OrderVO extends BaseVO {

    @ApiModelProperty("主键id")
    @Null(groups = Add.class, message = "插入时不能传输Id")
    @NotNull(groups = Update.class, message = "Id不能为空")
    private Long id;

    private Long userId;

    private Long productId;

    private Integer count;

    private BigDecimal money;

    /** 订单状态：0：创建中；1：已完结 */
    private Integer status;
}
