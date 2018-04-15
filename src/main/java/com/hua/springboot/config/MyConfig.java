package com.hua.springboot.config;

import com.hua.springboot.component.MyLocalResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
//@EnableWebMvc
public class MyConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //super.addViewControllers(registry);
        //浏览器发送 /hua 请求来到success页面
        registry.addViewController("/hua").setViewName("success");
    }

    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocalResolver();
    }

    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter() {
        WebMvcConfigurerAdapter webMvcConfigurerAdapter =
                new WebMvcConfigurerAdapter() {
                    @Override
                    public void addViewControllers(ViewControllerRegistry registry) {
                        registry.addViewController("/").setViewName("login");
                        registry.addViewController("/index.html").setViewName("login");
                        registry.addViewController("/home.html").setViewName("dashboard");

                    }

                    @Override
                    public void addInterceptors(InterceptorRegistry registry) {
//                registry.addInterceptor(new LoginHandlerInterceptor())
//                        .addPathPatterns("/**")
//                        .excludePathPatterns("/index.html", "/", "/user/login");
                    }
                };



        return webMvcConfigurerAdapter;
    }






}
