package com.cg.spring.boot.demo.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.spring.boot.demo.exception.EmployeeNotFoundException;
import com.cg.spring.boot.demo.model.Employee;
import com.cg.spring.boot.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	private static final Logger LOG = LoggerFactory.getLogger(EmployeeService.class);

//	public Employee getEmployeeById(int eid) {
//		LOG.info("getEmployeeById " + eid);
//		return employeeRepository.findById(eid).get();
//	}

	public Employee getEmployeeById(int eid) {
		LOG.info("getEmployeeById " + eid);
		Optional<Employee> optEmp = employeeRepository.findById(eid);
		if (optEmp.isEmpty()) {
			LOG.error("Employee not found.");
			throw new EmployeeNotFoundException();
		} else
			return optEmp.get();
	}

	public List<Employee> getEmployeeWithSalaryGreaterThan(double salary) {
		LOG.info("getEmployeeWithSalaryGreaterThan " + salary);
		List<Employee> empList = employeeRepository.findBySalaryGreaterThan(salary);
		if (empList.size() == 0) {
			LOG.error("Employee not found.");
			throw new EmployeeNotFoundException();
		} else
			return empList;
	}

	public List<Employee> getAllEmployees() {
		LOG.info("getAllEmployees");
		return employeeRepository.findAll();
	}

	public Employee addEmployee(Employee employee) {
		LOG.info("addEmployee");
		try {
			return employeeRepository.save(employee);
		} catch (IllegalArgumentException iae) {
			LOG.error(iae.getMessage());
			return null;
		}
	}

	public Employee updateEmployee(Employee employee) {
		LOG.info("updateEmployee");
		return employeeRepository.save(employee);
	}

	// handle this exception
	// EmptyResultDataAccessException:
	public int deleteEmployee(int eid) {
		LOG.info("deleteEmployee");
		// here 
		employeeRepository.deleteById(eid);
		return eid;
	}

}
