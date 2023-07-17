package com.sz.springcloudsamples.storage.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sz.springcloudsamples.common.mvc.entity.BaseEntity;
import lombok.Data;

/**
 * @author Yanghj
 * @date 2023/7/17 16:49
 */
@Data
@TableName("t_stock")
public class StockEntity extends BaseEntity {

    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 产品id
     */
    private Long productId;

    /**
     * 总库存
     */
    private Integer total;

    /**
     * 已用库存
     */
    private Integer used;

    /**
     * 剩余库存
     */
    private Integer residue;
}
