//package com.ssmp.config;
//
//import com.ssmp.config.firstInterceptor;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
//
////代替原来的springmvc.xml文件，实现springmvc的自动化配置
////可以配置 视图解析器  拦截器 文件上传解析器  注解驱动 异常处理  组件扫描范围
//@Configuration
//public class SpringMvcConfig implements WebMvcConfigurer {
//    //    registry是整个拦截器的注册中心
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new firstInterceptor())
//                .addPathPatterns("/**")
//                .excludePathPatterns("/","/index");
//    }
//}