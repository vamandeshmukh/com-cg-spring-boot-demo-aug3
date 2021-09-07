package com.cg.spring.boot.demo.service;

import java.util.List;

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

	public Employee getEmployeeById(int eid) {
		LOG.info("getEmployeeById " + eid);
		return employeeRepository.findById(eid).get();
	}

	public List<Employee> getAllEmployees() {
		LOG.info("getAllEmployees");
		return employeeRepository.findAll();
	}

	public Employee addEmployee(Employee employee) {
		Employee emp = employeeRepository.save(employee);
		LOG.info(emp.toString());
		return emp;
	}

	public Employee updateEmployee(Employee employee) {
		LOG.info("updateEmployee");
		return employeeRepository.save(employee);
	}

	public int deleteEmployee(int eid) {
		employeeRepository.deleteById(eid);
		return eid;
	}

}
