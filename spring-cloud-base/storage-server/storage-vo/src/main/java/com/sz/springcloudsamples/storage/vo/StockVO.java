package com.sz.springcloudsamples.storage.vo;

import com.sz.springcloudsamples.common.mvc.vo.BaseVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 * @author Yanghj
 * @date 2023/7/17 18:37
 */
@Data
public class StockVO extends BaseVO {

    @ApiModelProperty("主键id")
    @Null(groups = Add.class, message = "插入时不能传输Id")
    @NotNull(groups = Update.class, message = "Id不能为空")
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
