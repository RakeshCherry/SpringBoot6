package com.expert.expertschool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.expert.expertschool.proxy")
public class ExpertschoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpertschoolApplication.class, args);
	}

}
