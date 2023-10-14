package com.designs.interior;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.designs.interior")
public class InteriorDesignsProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(InteriorDesignsProjectApplication.class, args);
		System.out.println("Project Running Successfully!");
	}

}
