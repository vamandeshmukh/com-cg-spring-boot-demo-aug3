package com.cg.spring.boot.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.spring.boot.demo.model.Employee;
import com.cg.spring.boot.demo.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);

	// http://localhost:8082/getEmp/101
	// http://localhost:8082/getEmp/102
	@GetMapping("/getEmp{eid}")
	public Employee getEmpById(@PathVariable int eid) {
		LOG.info("getEmp");
		return employeeService.getEmployee(eid);
	}

	// http://localhost:8082/getAllEmp
	@GetMapping("/getAllEmp")
	public List<Employee> getAllEmp() {
		LOG.info("getAllEmp");
		return employeeService.getAllEmployees();
	}

	// http://localhost:8082/addEmp
	@PostMapping("/addEmp")
	public Employee addEmp(@RequestBody Employee employee) {
		LOG.info("addEmp");
		return employeeService.addEmployee(employee);
	}

	// http://localhost:8082/updateEmp
	@PutMapping("/updateEmp")
	public Employee updateEmp(@RequestBody Employee employee) {
		LOG.info("updateEmp");
		return employeeService.updateEmployee(employee);
	}

	// http://localhost:8082/deleteEmp/{eid}
	@PutMapping("/deleteEmp")
	public Employee deleteEmp(@PathVariable int eid) {
		LOG.info("deleteEmp");
		return employeeService.deleteEmployee(eid);
	}

}
