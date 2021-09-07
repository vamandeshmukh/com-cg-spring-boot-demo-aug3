package com.cg.spring.boot.demo;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

	private static final Logger LOG = LoggerFactory.getLogger(Hello.class);

	@GetMapping("/hello") // endpoint / API
	public String hello() {
		LOG.info("hello");
		return "Hello world!";
	}

	@PostMapping("/hi")
	public String hi(@RequestBody String myName) {
		LOG.info("Hi " + myName);
		return "Hi " + myName;
	}

	@GetMapping("/emp")
	public Employee emp() {
		Employee emp = new Employee(101, "Sonu", 10.5);
		LOG.info(emp.toString());
		return emp;
	}

	@GetMapping("/empList")
	public List<Employee> empList() {
		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee(101, "Sonu", 10.50));
		empList.add(new Employee(102, "Monu", 20.25));
		empList.add(new Employee(103, "Tonu", 15.75));
		LOG.info("empList");
		return empList;
	}

}
