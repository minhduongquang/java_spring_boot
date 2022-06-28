package com.example.tp1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})
@SpringBootApplication
public class Tp1Application {

    public static void main(String[] args) {
        SpringApplication.run(Tp1Application.class, args);
    }

}
