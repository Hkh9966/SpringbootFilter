package com.hukaihan.security.webConfig;

import com.hukaihan.security.webConfig.filter.AuthorizationFilter;
import com.hukaihan.security.webConfig.filter.SessionFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: security
 * @description: None
 * @author: HKH
 * @create: 2019-11-27 09:44
 **/
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new SessionFilter());
        List<String> urlPatterns = new ArrayList<>();
        urlPatterns.add("/api/*");
        registrationBean.setUrlPatterns(urlPatterns);
        return registrationBean;
    }
    @Bean
    public FilterRegistrationBean filterRegistrationBean2() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new AuthorizationFilter());
        List<String> urlPatterns = new ArrayList<>();
        urlPatterns.add("/api/*");
        registrationBean.setUrlPatterns(urlPatterns);
        return registrationBean;
    }


}
