package com.cg.spring.boot.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

	private static final Logger LOG = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {

		LOG.info("Start...");

		SpringApplication.run(App.class, args);

		LOG.warn("This is a warning.");
		LOG.error("This is an error.");
		LOG.info("End");

	}

}
