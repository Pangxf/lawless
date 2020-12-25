package com.fengxiong.controller;

import com.fengxiong.controller.vo.TestVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @describle:
 * @author: pangxiaofeng
 * @create: 2020/12/23
 **/
@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("/helloWorld")
    public String helloWorld() {
        return "hello world";
    }

    @GetMapping("/helloException")
    public String helloException() throws Exception {
        throw new Exception("嘻嘻哈哈");
    }

    @GetMapping("/helloFormatter")
    public TestVO helloFormatter() throws Exception {
        TestVO vo = new TestVO();
        vo.setDate(LocalDateTime.now());
        vo.setTime(1234567890123456799L);
        return vo;
    }
}
