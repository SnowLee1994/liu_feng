package com.newcolor.web.config.security;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuewen.li
 * @date 2021/4/323:30
 * @Description: 过滤器优先级配置
 */
@Configuration
public class FilterConfiguration {
    @Bean
    public FilterRegistrationBean<JwtCorsFilter> filterRegistrationBean() {
        FilterRegistrationBean<JwtCorsFilter> registrationBean = new FilterRegistrationBean<>();
        JwtCorsFilter corsFilter = new JwtCorsFilter();
        registrationBean.setFilter(corsFilter);
        List<String> urlPatterns = new ArrayList<String>();
        urlPatterns.add("/*");
        registrationBean.setUrlPatterns(urlPatterns);
        registrationBean.setOrder(Integer.MIN_VALUE);//设置该过滤器的优先级，数字越小，优先级越高
        return registrationBean;
    }
}
