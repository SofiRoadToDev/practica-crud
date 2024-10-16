package com.sofi.practica_crud_rapido;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@Configuration
public class PracticaCrudRapidoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticaCrudRapidoApplication.class, args);
	}


	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry
						.addMapping("/api/v1/**")
						.allowedOrigins("http://localhost:4200")
						.allowedMethods("GET","POST","PUT","DELETE")
						.allowedHeaders("*");
			}
		};
	}
}


