package ch.zli.m223.punchclock.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * Klasse: WebConfiguration
 * @author Tobias Sauter
 * @version 15.07.2022
 *
 * In diesem File werden allgemeine Web-Konfigurationen vorgenommen
 */
@Configuration
public class WebConfiguration {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**");
            }
        };
    }
}