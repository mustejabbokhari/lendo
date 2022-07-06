package com.lendo.assignment.config.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class RestTemplateConfig {
    @Value("${rest.connection.timeout}")
    private int conenctionTimeOut;
    @Value("${rest.read.timeout}")
    private int readTimeOut;

    @Bean
    public CustomRestTemplateCustomizer customRestTemplateCustomizer(){
        return new CustomRestTemplateCustomizer();
    }

    @Bean
    public RestTemplateBuilder restTemplateBuilder(){
        return new RestTemplateBuilder(customRestTemplateCustomizer());
    }

    @Bean
    public RestTemplate restTemplate(){
        return restTemplateBuilder()
                .setConnectTimeout(Duration.ofMillis(conenctionTimeOut))
                .setReadTimeout(Duration.ofMillis(readTimeOut))
                .build();
    }
}
