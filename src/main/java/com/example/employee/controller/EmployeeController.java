package com.example.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.dto.EmployeeDto;
import com.example.employee.entity.Employee;
import com.example.employee.exception.MessageResponseDto;
import com.example.employee.service.EmployeeService;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@PostMapping(value = "/save")
	public ResponseEntity<Employee> save(@RequestBody EmployeeDto dto){
		Employee emp= employeeService.save(dto);
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}
	
	@PutMapping(value = "/update")
	public ResponseEntity<Employee> update(@RequestBody EmployeeDto dto){
		Employee emp = employeeService.update(dto);
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/delete")
	public ResponseEntity<MessageResponseDto> delete(@RequestParam Integer id)  {
		String msg = employeeService.delete(id);
		return new ResponseEntity<MessageResponseDto>(new MessageResponseDto(msg),HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/getEmployeeByDept")
	public ResponseEntity<List<Employee>> getEmployeeByDepartmentWise(@RequestParam String deptName){
		List<Employee> empList = employeeService.getEmployeeByDepartmentWise(deptName); 
		return new ResponseEntity<List<Employee>>(empList, HttpStatus.OK);
	}
}
