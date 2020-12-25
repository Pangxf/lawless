package com.fengxiong.facade.test;

import com.fengxiong.service.TestFacadeService;

/**
 * @describle:
 * @author: pangxiaofeng
 * @create: 2020/12/24
 **/
public class TestFacadeServiceImpl implements TestFacadeService {
    @Override
    public String helloFacade() {
        return "helloFacade";
    }
}
