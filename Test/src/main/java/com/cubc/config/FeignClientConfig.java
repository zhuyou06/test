//package com.cubc.config;
//
//import feign.RequestInterceptor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import static com.cubc.constant.FeignClientConst.*;
//
//@Configuration
//public class FeignClientConfig {
//    @Bean
//    public RequestInterceptor requestInterceptor() {
//        return template -> {
//            if(CLIENT_CD.equals(template.feignTarget().name())){
//                template.header("Content-Type", "application/json; charset=utf-8");
//            }
//
//        };
//    }
//}
