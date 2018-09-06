package com.hellokoding.springboot;


import com.hellokoding.springboot.adapters.InMemoryGreetingRepository;
import com.hellokoding.springboot.domain.repositories.GreetingRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WebApplication {



    @Bean
    public GreetingRepository greetingRepository() {
        return new InMemoryGreetingRepository();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(WebApplication.class, args);

    }

}

