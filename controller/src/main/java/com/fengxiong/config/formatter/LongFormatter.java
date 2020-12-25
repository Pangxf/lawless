package com.fengxiong.config.formatter;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

/**
 * @describle:
 * @author: pangxiaofeng
 * @create: 2020/12/23
 **/
public class LongFormatter implements Formatter<Long> {
    @Override
    public Long parse(String s, Locale locale) throws ParseException {
        return Long.valueOf(s);
    }

    @Override
    public String print(Long aLong, Locale locale) {
        return String.valueOf(aLong);
    }
}
