package com.sz.springcloudsamples.demo.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import com.sz.springcloudsamples.common.mvc.entity.BaseEntity;

import lombok.Data;

/**
 * @author Yanghj
 * @date 1/10/2020
 */
@Data
@TableName("t_person")
public class PersonEntity extends BaseEntity {

    @TableId(type = IdType.AUTO)
    @TableField("pk_person_id")
    private Long pkPersonId;

    @TableField("name")
    private String name;

    @TableField("age")
    private Integer age;

    @TableField("birthday")
    private LocalDate birthday;

    @TableField("account")
    private BigDecimal account;

    @TableField("is_deleted")
    private Boolean deleted;
}
