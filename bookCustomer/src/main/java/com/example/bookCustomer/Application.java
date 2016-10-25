package com.example.bookCustomer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RestController;

@EnableFeignClients
//@EnableCircuitBreaker
//@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = "com.example")
@EnableJpaRepositories(basePackages = "com.example")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}



