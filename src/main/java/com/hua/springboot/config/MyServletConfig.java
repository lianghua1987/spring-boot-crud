package com.hua.springboot.config;


import com.hua.springboot.filter.MyFilter;
import com.hua.springboot.listener.MyListener;
import com.hua.springboot.servlet.MyServlet;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class MyServletConfig {


    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        return new ServletRegistrationBean(new MyServlet(), "/myServlet");
    }

    @Bean
    public ConfigurableServletWebServerFactory configurableServletWebServerFactory() {
        return new TomcatServletWebServerFactory(8085);
        //return new JettyServletWebServerFactory(8084);

    }


    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean filterRegistrationBean =  new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new MyFilter());
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/hello", "/myServlet"));
        return filterRegistrationBean;
    }


    @Bean
    public ServletListenerRegistrationBean servletListenerRegistrationBean(){
       return new ServletListenerRegistrationBean(new MyListener());
    }
}
