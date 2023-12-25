package com.sz.springcloudsamples.demo.vo;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.sz.springcloudsamples.common.mvc.vo.BaseVO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Yanghj
 * @date 1/10/2020
 */
@Data
@Accessors(chain = true)
@ApiModel(description = "Person 模型")
public class PersonVO extends BaseVO {

    @ApiModelProperty("主键id")
    @Null(groups = Add.class, message = "插入时不能传输Id")
    @NotNull(groups = Update.class, message = "Id不能为空")
    private Long personId;

    @ApiModelProperty(value = "昵称", required = true)
    @NotNull(
            groups = {Add.class, Update.class},
            message = "用户名不能为空")
    @Length(
            groups = {Add.class, Update.class},
            min = 5,
            max = 64,
            message = "用户名个数必须为5-64位")
    private String name;

    @ApiModelProperty("年龄")
    @Min(
            groups = {Add.class, Update.class},
            value = 1,
            message = "最小年龄为1")
    private Integer age;

    @ApiModelProperty(value = "生日", example = "2020-05-20")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    @ApiModelProperty("账户余额")
    @DecimalMin(
            groups = {Add.class, Update.class},
            value = "0",
            message = "最小金额为0")
    private BigDecimal account;

    @ApiModelProperty("是否删除标识")
    private Boolean deleted;
}
