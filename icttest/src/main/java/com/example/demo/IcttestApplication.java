package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("conf/ex.properties")
public class IcttestApplication {

	public static void main(String[] args) {
		SpringApplication.run(IcttestApplication.class, args);
	}
}
