package com.fengxiong.controller;

import com.fegnxiong.dto.TestFacadeDTO;
import com.fengxiong.service.TestFacadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @describle:
 * @author: pangxiaofeng
 * @create: 2020/12/24
 **/
@RestController
@RequestMapping("/facade/test")
public class TestFacadeController {

    @Autowired
    private TestFacadeService testFacadeService;

    @GetMapping("helloFacade")
    public TestFacadeDTO helloFacade(){
        testFacadeService.helloFacade();
        return null;
    }
}
