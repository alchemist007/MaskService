package com.initech.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"com.initech"})
public class MaskServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaskServiceApplication.class, args);
	}

}
