package com.ssmp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CrossConfig implements WebMvcConfigurer {
    public static  final String[] METHOD= {"GET","POST","PUT","PATCH","DELETE"};

    /**
     * 允许跨域
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")//对于哪些请求进行拦截
                .allowedOriginPatterns("*")
                .allowedHeaders("*")
                .allowedMethods(METHOD)
                .allowCredentials(false)
                .maxAge(6000);
    }
}
