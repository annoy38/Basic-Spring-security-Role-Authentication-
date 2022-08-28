package com.securityproject.securityproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.securityproject.securityproject.repository.Userrepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = Userrepository.class)
public class SecurityProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityProjectApplication.class, args);
	}

}
