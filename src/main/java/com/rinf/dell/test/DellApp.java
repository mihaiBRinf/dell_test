package com.rinf.dell.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class DellApp extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DellApp.class);
	}

	public static void main(String[] args) {
		System.out.println(System.setProperty("catalina.base", "../../main/resources/"));

		SpringApplication.run(DellApp.class, args);
	}
}
