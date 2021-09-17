package com.example.employee.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.employee.dto.EmployeeDto;
import com.example.employee.entity.Cache;
import com.example.employee.entity.Employee;

@Repository
public class EmployeeRepository {
	
	public Employee save(EmployeeDto empDto) {
		Employee emp = new Employee();
		emp.setEmpId(empDto.getEmpId());
		emp.setFirstName(empDto.getFirstName());
		emp.setLastName(empDto.getLastName());
		emp.setSalary(empDto.getSalary());
		emp.setDepartment(empDto.getDepartment());
		Cache.mapEmployee.put(empDto.getEmpId(), emp);
		return emp;
	}
	
	public void delete(Integer id){
		Cache.mapEmployee.remove(id);
		
	}
	
	public List<Employee> getAllEmployees() {
		
		return Cache.mapEmployee.values().stream().collect(Collectors.toList());
	}
	
	public Employee getEmployeebyId(int id) {
		return Cache.mapEmployee.get(id);
	}
}
