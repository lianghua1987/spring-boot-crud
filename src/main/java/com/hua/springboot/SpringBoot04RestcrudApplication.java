package com.hua.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

@SpringBootApplication
@ComponentScan(basePackages = "com.hua.springboot.*")
public class SpringBoot04RestcrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot04RestcrudApplication.class, args);
    }



//    @Bean
//    public ViewResolver myViewResolver(){
//        return new MyViewResolver();
//    }
//
//    private static class MyViewResolver implements  ViewResolver{
//
//        @Override
//        public View resolveViewName(String s, Locale locale) throws Exception {
//            return null;
//        }
//    }


}
