package com.example.front_e_back.WebConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry){
        //permite qualquer origem com credenciais
        registry.addMapping("/**")
                .allowedOriginPatterns("*")//permite qualquer
                .allowedMethods("*")
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(3600);
    }
}
