package com.example.terminalMarittimo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class corsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/*") // 1. Applica CORS a tutte le rotte
        .allowedOrigins("") // 2. Tutti i domini possono fare richieste
        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // 3. Metodi HTTP permessi
        .allowedHeaders("*") // 4. Quali header può inviare il client
        .allowCredentials(false); // 5. Non permette cookie/authorization header
    }
}