package com.example.employee.entity;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {
	private Integer empId;
	private String firstName;
	private String lastName;
	private Long salary;
	private String department;
}
