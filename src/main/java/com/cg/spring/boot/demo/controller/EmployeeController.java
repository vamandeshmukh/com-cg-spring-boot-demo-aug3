package com.cg.spring.boot.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.spring.boot.demo.model.Employee;

@RestController
public class EmployeeController {

	private static final Logger LOG = LoggerFactory.getLogger(Employee.class);

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
