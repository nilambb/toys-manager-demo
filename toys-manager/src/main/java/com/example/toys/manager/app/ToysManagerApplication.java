package com.example.toys.manager.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.*")
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = {"com.example.toys.manager.*"})
@EntityScan(basePackages="com.example.toys.manager.*")
//@PropertySources(value    {@PropertySource("classpath:application.properties")})
public class ToysManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToysManagerApplication.class, args);
	}

}
