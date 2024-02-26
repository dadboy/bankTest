package com.example.banktest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class BanktestApplication {


	public static void main(String[] args) {
		SpringApplication.run(BanktestApplication.class, args);
	}


}
