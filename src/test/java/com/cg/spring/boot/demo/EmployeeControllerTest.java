package com.cg.spring.boot.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cg.spring.boot.demo.controller.EmployeeController;
import com.cg.spring.boot.demo.model.Employee;

@SpringBootTest
public class EmployeeControllerTest {

	private static Logger LOG = LoggerFactory.getLogger(EmployeeControllerTest.class);

	@Autowired
	private EmployeeController employeeController;

	@Test
	public void testGetEmployeeById() throws Exception {

		LOG.info("testGetEmployeeById");

		HttpStatus expected = HttpStatus.OK;

		ResponseEntity<Employee> actual = employeeController.getEmployeeById(101);

		assertEquals(expected, actual.getStatusCode());
	}

}
