package com.alfred.hellospringwebapp.config;

import com.alfred.hellospringwebapp.filters.MyNewFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyFilterConfig {

    public FilterRegistrationBean<MyNewFilter> registrationBean() {

        FilterRegistrationBean<MyNewFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new MyNewFilter());
        registrationBean.addUrlPatterns("/customers/*");

        return registrationBean;

    }

}
