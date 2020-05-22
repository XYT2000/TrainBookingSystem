package com.bupt.trainbookingsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class MyPicConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/picture/ad/**").addResourceLocations("File:C:\\Users\\xytbu\\ly1\\TrainBookingSystem\\src\\main\\resources\\static\\picture\\ad\\");
    }
}
