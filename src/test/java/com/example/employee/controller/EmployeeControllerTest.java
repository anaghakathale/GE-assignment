package com.example.employee.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.employee.dto.EmployeeDto;
import com.example.employee.entity.Employee;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.serviceimpl.EmployeeServiceImpl;

@ExtendWith(MockitoExtension.class)
class EmployeeControllerTest {

	Employee hrE = new Employee();
	Employee salesE = new Employee();
	Employee techE = new Employee();
	List<Employee> totalResultSet = new ArrayList<>();
	
	@Mock
	EmployeeRepository repository;
	
	@InjectMocks
	EmployeeServiceImpl serviceMock;
	
	@BeforeEach
	public void setup() {
		hrE.setDepartment("HR");
		hrE.setEmpId(1);
		hrE.setFirstName("Anagha");
		hrE.setLastName("Kathale");
		hrE.setSalary(100L);
		totalResultSet.add(hrE);
		
		salesE.setDepartment("Sales");
		salesE.setEmpId(2);
		salesE.setFirstName("Anata");
		salesE.setLastName("Kathale");
		salesE.setSalary(1200L);
		totalResultSet.add(salesE);
		
		techE.setDepartment("Technology");
		techE.setEmpId(3);
		techE.setFirstName("Sushant");
		techE.setLastName("Joshi");
		techE.setSalary(120000L);
		totalResultSet.add(techE);
		
		//serviceMock = mock(EmployeeServiceImpl.class);
	}
	
	@Test
	void testIfAllEmployeeReturned() {
		
		when(repository.getAllEmployees()).thenReturn(Arrays.asList(hrE, salesE, techE));
		List<Employee> actualResult = new ArrayList<>();
		actualResult.add(hrE);
		actualResult.add(salesE);
		actualResult.add(techE);
		
		assertThat(serviceMock.getEmployeeByDepartmentWise(null)).isEqualTo(actualResult);
	}
	
	@Test
	void testIfEmployeeIsReturnedForHRDept() {
		when(repository.getAllEmployees()).thenReturn(Arrays.asList(hrE, salesE, techE));
		
		List<Employee> actualResult = new ArrayList<>();
		actualResult.add(hrE);
		
		assertThat(serviceMock.getEmployeeByDepartmentWise("HR")).isEqualTo(actualResult); 
	}
	@Test
	void testSave() {
		EmployeeDto dto = new EmployeeDto();
		dto.setDepartment("HR");
		dto.setEmpId(1);
		dto.setFirstName("Anagha");
		dto.setLastName("Kathale");
		dto.setSalary(100L);
		
		when(repository.save(dto)).thenReturn(hrE);
		
		Employee savedEmployee = serviceMock.save(dto);
		
		assertThat(savedEmployee).isEqualTo(hrE);
		
	}
}
