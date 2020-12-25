package com.fengxiong.config.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @describle:
 * @author: pangxiaofeng
 * @create: 2020/12/23
 **/
@Component
@Slf4j
public class TimeMonitorInterceptor implements HandlerInterceptor {

    private ThreadLocal<MonitorModel> monitor = new ThreadLocal<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        MonitorModel monitorModel = new MonitorModel();
        monitorModel.setStartTime(System.currentTimeMillis());
        monitorModel.setPath(request.getServletPath());
        monitor.set(monitorModel);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        MonitorModel monitorModel = monitor.get();
        monitorModel.setEndTime(System.currentTimeMillis());
        monitorModel.setTotalMillis(monitorModel.getEndTime() - monitorModel.getStartTime());
        ObjectMapper objectMapper = new ObjectMapper();
        log.info(objectMapper.writeValueAsString(monitor.get()));
    }

    @Data
    class MonitorModel {
        private String path;
        private Long startTime;
        private Long endTime;
        private Long totalMillis;
    }
}
