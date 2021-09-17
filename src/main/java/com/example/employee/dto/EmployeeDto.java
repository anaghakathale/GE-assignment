package com.example.employee.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDto {
	private Integer empId;
	private String firstName;
	private String lastName;
	private Long salary;
	private String department;
}
