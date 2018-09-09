package com.sm.filter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 允许ajax跨域
 * @author PC
 */
@Configuration
public class AppConfigurer extends WebMvcConfigurerAdapter{

    @Override
    public void addCorsMappings(CorsRegistry registry) {
           registry.addMapping("/api/**")
           .allowedOrigins("*")
           .allowedMethods("GET", "POST")
           .allowCredentials(false).maxAge(3600);
    }
}