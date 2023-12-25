package com.sz.springcloudsamples.common.mvc.vo;

import java.time.LocalDateTime;
import javax.validation.groups.Default;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 基本视图对象
 *
 * @author Yanghj
 * @date 1/10/2020
 */
@Data
public class BaseVO {

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(hidden = true)
    private LocalDateTime createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(hidden = true)
    private LocalDateTime updateTime;

    /** 继承Default类，可以在不指定 @Validated 的 group 时，使用所有默认校验方式。 */
    public interface Add extends Default {}

    public interface Update extends Default {}
}
