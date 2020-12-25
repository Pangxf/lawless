package com.fengxiong.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fengxiong.config.formatter.LocalDateTimeFormatter;
import com.fengxiong.config.formatter.LongFormatter;
import com.fengxiong.config.interceptor.TimeMonitorInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.io.IOException;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @describle: WEB配置
 * @author: pangxiaofeng
 * @create: 2020/12/22
 **/
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

    @Value("${monitor.path}")
    private String timeMonitorPathStr;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedOrigins("*")
                .allowedMethods("GET,POST,DELETE,PUT")
                .allowedHeaders("Authorization,Content-Type")
                .maxAge(86400)
        ;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        if (!StringUtils.isEmpty(timeMonitorPathStr)) {
            registry.addInterceptor(new TimeMonitorInterceptor()).addPathPatterns(timeMonitorPathStr.split(",")).order(1);
        }
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatterForFieldType(LocalDateTime.class, new LocalDateTimeFormatter());
        registry.addFormatterForFieldType(Long.class, new LongFormatter());
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        MappingJackson2HttpMessageConverter jacksonHttpMessageConverter = new MappingJackson2HttpMessageConverter();
        converters.clear();
        converters.add(jacksonHttpMessageConverter);
    }

}
