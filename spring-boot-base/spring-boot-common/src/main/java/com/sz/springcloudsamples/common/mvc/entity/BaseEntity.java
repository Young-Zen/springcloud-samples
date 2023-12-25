package com.sz.springcloudsamples.common.mvc.entity;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableField;

import lombok.Data;

/**
 * 基本数据实体类
 *
 * @author Yanghj
 * @date 1/10/2020
 */
@Data
public class BaseEntity {

    @TableField("create_time")
    private LocalDateTime createTime;

    @TableField("update_time")
    private LocalDateTime updateTime;
}
