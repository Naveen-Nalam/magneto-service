package com.magneto.java.magnetoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ComponentScan("com.magneto.*")
@PropertySource({"classpath:application.properties"})
public class MagnetoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MagnetoServiceApplication.class, args);
	}
}
