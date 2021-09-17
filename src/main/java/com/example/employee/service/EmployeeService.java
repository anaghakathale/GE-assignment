package com.example.employee.service;

import java.util.List;

import com.example.employee.dto.EmployeeDto;
import com.example.employee.entity.Employee;

public  interface EmployeeService {
	public Employee save(EmployeeDto emp);

	public Employee update(EmployeeDto dto);

	public String delete(Integer id);

	public List<Employee> getEmployeeByDepartmentWise(String deptName);
}
