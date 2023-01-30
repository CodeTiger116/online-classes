package com.hanhu.serve;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * 启动类
 */
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@SpringBootApplication
@MapperScan("com.hanhu.serve.mapper")
//@MapperScan("com.hanhu.serve.config.security")
@EnableWebMvc
@EnableSwagger2
public class OnlineClassesApplication {

    public static void main(String[] args) {

        SpringApplication.run(OnlineClassesApplication.class,args);
    }
//
//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurerAdapter() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**")
//                        .allowedOrigins("*")
//                        .allowedMethods("PUT", "DELETE","GET","POST")
//                        .allowedHeaders("*")
//                        .exposedHeaders("access-control-allow-headers",
//                                "access-control-allow-methods",
//                                "access-control-allow-origin",
//                                "access-control-max-age",
//                                "X-Frame-Options")
//                        .allowCredentials(false).maxAge(3600);
//            }
//        };
//
//    }


}
