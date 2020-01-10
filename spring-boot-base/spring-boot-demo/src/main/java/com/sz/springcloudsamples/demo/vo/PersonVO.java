package com.sz.springcloudsamples.demo.vo;

import com.sz.springcloudsamples.common.mvc.vo.BaseVO;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author Yanghj
 * @date 1/10/2020
 */
@Data
@Accessors(chain = true)
public class PersonVO extends BaseVO {

    private String name;

    private int age;

    private LocalDate birthday;

    private BigDecimal account;

    private boolean deleted;
}
