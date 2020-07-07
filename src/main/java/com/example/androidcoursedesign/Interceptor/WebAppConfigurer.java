package com.example.androidcoursedesign.Interceptor;

import com.example.androidcoursedesign.handler.LoginHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebAppConfigurer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 可添加多个
        registry.addInterceptor(new LoginHandler()).addPathPatterns("/**");
        registry.addInterceptor(new LoginHandler()).excludePathPatterns("/login");
    }

}
