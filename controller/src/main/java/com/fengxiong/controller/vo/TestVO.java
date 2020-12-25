package com.fengxiong.controller.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @describle:
 * @author: pangxiaofeng
 * @create: 2020/12/23
 **/
@Data
public class TestVO {
    private LocalDateTime date;
    private Long time;
    private Integer count;
}
