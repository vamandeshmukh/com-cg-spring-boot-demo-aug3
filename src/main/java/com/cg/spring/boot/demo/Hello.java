package com.cg.spring.boot.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

	@GetMapping("/hello")
	public String hello() {
		System.out.println("hello");
		return "Hello world!";
	}

}
