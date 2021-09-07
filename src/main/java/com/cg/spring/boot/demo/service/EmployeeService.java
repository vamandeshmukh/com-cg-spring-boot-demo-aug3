package com.cg.spring.boot.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cg.spring.boot.demo.model.Employee;

@Service
public class EmployeeService {

	private static final Logger LOG = LoggerFactory.getLogger(EmployeeService.class);

	public Employee getEmployee() {
		LOG.info("getEmployee");
		return new Employee(101, "Sonu", 10.5);
	}

	public Employee addEmployee(Employee employee) {
		Employee emp = employee;
		LOG.info(emp.toString());
		return emp;
	}

}
