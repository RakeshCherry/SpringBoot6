package com.expert.expertschool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@SpringBootApplication
public class ExpertchoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExpertchoolApplication.class, args);
    }

}
