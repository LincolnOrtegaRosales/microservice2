package com.lundero.m2;

import controller.GenericController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = {GenericController.class})
public class M2Application {

	public static void main(String[] args) {
		SpringApplication.run(M2Application.class, args);
	}

}
