package com.cg.spring.boot.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmployeeControllerTests {

	private static Logger LOG = LoggerFactory.getLogger(EmployeeControllerTests.class);

	@Test
	public void testMethod() {
		LOG.info("testMethod");
		assertEquals(10, 10);
	}

}
