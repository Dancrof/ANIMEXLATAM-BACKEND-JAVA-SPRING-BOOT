package com.server.animexlatam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication( exclude = SecurityAutoConfiguration.class )
public class AnimexlatamApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnimexlatamApplication.class, args);
	}

}
