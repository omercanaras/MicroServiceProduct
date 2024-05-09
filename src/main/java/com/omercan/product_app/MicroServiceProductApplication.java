package com.omercan.product_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.PropertySource;

//Development profilinde hangi ayar dosyasının baz alınacağını belirtiyor
@PropertySource("classpath:application-${spring.profiles.active:default}.properties")
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)

public class MicroServiceProductApplication {


	public static void main(String[] args)

	{
		SpringApplication.run(MicroServiceProductApplication.class, args);
	}

}
