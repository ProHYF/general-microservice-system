package com.ytravler.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages ="com")
@EnableAutoConfiguration
public class ParsedemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParsedemoApplication.class, args);
	}
}
