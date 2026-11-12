package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class Ms31Application {

	@Bean
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }
	public static void main(String[] args) {
		SpringApplication.run(Ms31Application.class, args);
		System.out.println("MS3 running..!");
	}

}
