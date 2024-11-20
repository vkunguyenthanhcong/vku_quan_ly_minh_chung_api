package com.example.qlmc;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Corrected to serve files from the uploads directory
        registry.addResourceHandler("/uploads/**")
                .addResourceLocations("file:./uploads/");  // Assuming uploads are in the root folder of your project
    }
}
