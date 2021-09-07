package com.cg.spring.boot.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cg.spring.boot.demo.model.Employee;

public class EmployeeService {

	private static final Logger LOG = LoggerFactory.getLogger(EmployeeService.class);

	public Employee getEmployee() {
		LOG.info("getEmployee");
		return new Employee(101, "Sonu", 10.5);
	}
}
