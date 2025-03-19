package com.expert.expertschool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.expert.expertschool.repository")
@EntityScan("com.expert.Expertschool.model")
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class ExpertschoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpertschoolApplication.class, args);
	}

}
