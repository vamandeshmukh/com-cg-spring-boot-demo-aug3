package com.cg.spring.boot.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.spring.boot.demo.model.Employee;
import com.cg.spring.boot.demo.service.EmployeeService;

@RestController
@CrossOrigin(origins = "*")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);

//	// http://localhost:8082/getEmp/101
//	@GetMapping("/getEmp/{eid}")
//	public Employee getEmpById(@PathVariable int eid) {
//		LOG.info("getEmp");
//		return employeeService.getEmployeeById(eid);
//	}

	// http://localhost:8082/getEmp/101
	@GetMapping("/getEmp/{eid}")
	public ResponseEntity<Employee> getEmpById(@PathVariable int eid) {
		LOG.info("getEmp");
		Employee emp = employeeService.getEmployeeById(eid);
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}

	// http://localhost:8082/getEmpWithSalaryGreaterThan/10.5
	@GetMapping("/getEmpWithSalaryGreaterThan/{salary}")
	public ResponseEntity<List<Employee>> getEmpWithSalaryGreaterThan(@PathVariable double salary) {
		LOG.info("getEmpWithSalaryGreaterThan");
		List<Employee> empList = employeeService.getEmployeeWithSalaryGreaterThan(salary);
		return new ResponseEntity<>(empList, HttpStatus.OK);
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
	@DeleteMapping("/deleteEmp/{eid}")
	public int deleteEmp(@PathVariable int eid) {
		LOG.info("deleteEmp");
		return employeeService.deleteEmployee(eid);
	}

}
