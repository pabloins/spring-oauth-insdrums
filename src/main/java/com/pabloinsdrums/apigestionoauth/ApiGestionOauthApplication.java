package com.pabloinsdrums.apigestionoauth;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ApiGestionOauthApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGestionOauthApplication.class, args);
	}

}
