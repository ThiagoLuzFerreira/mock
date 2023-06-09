package com.thiago.faker.config;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;

@Configuration
public class SampleDataConfig {

    @Bean
    Faker faker(){
        return new Faker(new Locale("pt-BR"));
    }
}
