package com.zecss13.library;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins(
                        "http://localhost:5173",
                        "https://library-frontend-k42jgtm4u-ezequiel-santos-s-projects.vercel.app",
                        "https://library-frontend-k3hl2cd0s-ezequiel-santos-s-projects.vercel.app",
                        "https://library-frontend-ecbk9d4xv-ezequiel-santos-s-projects.vercel.app",
                        "https://library-frontend-jr3lh5sb4-ezequiel-santos-s-projects.vercel.app"
                    )
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*")
                        .allowCredentials(true);
            }
        };
    }

    
}
