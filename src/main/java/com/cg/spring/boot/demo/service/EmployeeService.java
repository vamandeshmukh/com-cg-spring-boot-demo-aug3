package com.cg.spring.boot.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.spring.boot.demo.model.Employee;
import com.cg.spring.boot.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	private static final Logger LOG = LoggerFactory.getLogger(EmployeeService.class);

	public Employee getEmployee() {
		LOG.info("getEmployee");
//		return new Employee(101, "Sonu", 10.5);
//		employeeRepository.findAll();
		return employeeRepository.findById(101).get();

	}

	public Employee addEmployee(Employee employee) {
		Employee emp = employeeRepository.save(employee);
		LOG.info(emp.toString());
		return emp;
	}

}
