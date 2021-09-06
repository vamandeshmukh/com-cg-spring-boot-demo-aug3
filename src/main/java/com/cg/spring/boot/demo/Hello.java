package com.cg.spring.boot.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

	private static final Logger LOG = LoggerFactory.getLogger(Hello.class);

	@GetMapping("/hello") // endpoint / API
	public String hello() {
		LOG.info("hello");
		return "Hello world!";
	}

	@GetMapping("/emp")
	public Employee emp() {
		LOG.info("emp");
		return new Employee(101, "Sonu", 10.5);
	}

}
