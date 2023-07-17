package com.sz.springcloudsamples.order.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sz.springcloudsamples.common.mvc.entity.BaseEntity;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Yanghj
 * @date 2023/7/17 16:49
 */
@Data
@TableName("t_order")
public class OrderEntity extends BaseEntity {

    @TableId(type = IdType.AUTO)
    private Long id;

    private Long userId;

    private Long productId;

    private Integer count;

    private BigDecimal money;

    /**
     * 订单状态：0：创建中；1：已完结
     */
    private Integer status;
}
