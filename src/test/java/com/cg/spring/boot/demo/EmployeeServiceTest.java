package com.cg.spring.boot.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.spring.boot.demo.model.Employee;
import com.cg.spring.boot.demo.service.EmployeeService;

@SpringBootTest
public class EmployeeServiceTest {

	private static Logger LOG = LoggerFactory.getLogger(EmployeeServiceTest.class);

	@Autowired
	private EmployeeService employeeService;

	@Test
	public void testFindEmployeeById() throws Exception {
		LOG.info("testFindEmployeeById");
		Employee expected = new Employee(101, "Sonu", 31.00);
		Employee actual = employeeService.findEmployeeById(101);
		assertEquals(expected.getEid(), actual.getEid());
		assertEquals(expected.getEname(), actual.getEname());
		// other fields also
	}

	@Test
	public void testFindEmployeeByIdNotFound() throws Exception {
		LOG.info("testFindEmployeeById");
		Employee unexpected = new Employee(102, "Monu", 25.0);
		Employee actual = employeeService.findEmployeeById(101);
		assertNotEquals(unexpected.getEid(), actual.getEid());
	}

}

//<dependency>
//<groupId>org.springframework.boot</groupId>
//<artifactId>spring-boot-starter-test</artifactId>
//<scope>test</scope>
//</dependency>
