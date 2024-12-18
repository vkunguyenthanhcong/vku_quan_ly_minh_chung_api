package com.example.qlmc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Cho phép tất cả các endpoint
                        .allowedOrigins("http://192.168.1.49:3000", "http://localhost:3000") // Cho phép frontend
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Các HTTP method cho phép
                        .allowedHeaders("*") // Cho phép tất cả các header
                        .allowCredentials(true); // Cho phép gửi cookie, session
            }
        };
    }
}
