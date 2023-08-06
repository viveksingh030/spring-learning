package com.visher.spring.boot.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@ComponentScan("com.visher.*")
public class TennisPlayerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TennisPlayerApplication.class, args);
	}
	
}
