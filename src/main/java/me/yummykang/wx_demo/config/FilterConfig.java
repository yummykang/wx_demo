package me.yummykang.wx_demo.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.weixin4j.WeixinUrlFilter;

/**
 * write something to describe this file.
 *
 * @author demon
 * @date 18-1-10 下午6:04
 */
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean wxUrlFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new WeixinUrlFilter());
        registration.addUrlPatterns("/api/weixin4j");
        return registration;
    }
}
