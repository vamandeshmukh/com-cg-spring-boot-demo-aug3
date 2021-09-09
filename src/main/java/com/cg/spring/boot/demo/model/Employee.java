package com.cg.spring.boot.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "employees")
public class Employee {

	@Id
	@Column(name = "employee_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eid;

	@Column(name = "first_name", nullable = false)
	@Size(min = 1, max = 40, message = "Name must have between {min} and {max} characters.")
	@NotNull(message = "A name is required for employee.")
	private String firstName;

	@Column(name = "salary")
	@Min(message = "Salary cannot be negative", value = 1)
	private double salary;

	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;

	public Employee() {
		super();
	}

	public Employee(String firstName, double salary) {
		super();
		this.firstName = firstName;
		this.salary = salary;
	}

	public Employee(int eid, String firstName, double salary) {
		super();
		this.eid = eid;
		this.firstName = firstName;
		this.salary = salary;
	}

	public Employee(int eid, String firstName, double salary, Department department) {
		super();
		this.eid = eid;
		this.firstName = firstName;
		this.salary = salary;
		this.department = department;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", firstName=" + firstName + ", salary=" + salary + "]";
	}

}
