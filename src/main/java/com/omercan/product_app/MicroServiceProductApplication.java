package com.omercan.product_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = SecurityAutoConfiguration.class)

public class MicroServiceProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceProductApplication.class, args);
	}

}
