package com.example.employee.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.employee.dto.EmployeeDto;
import com.example.employee.entity.Cache;
import com.example.employee.entity.Employee;
import com.example.employee.exception.CustomException;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee save(EmployeeDto emp) {
		return employeeRepository.save(emp);

	}

	@Override
	public Employee update(EmployeeDto dto) {
		Employee returnedResult;
		if (null != employeeRepository.getEmployeebyId(dto.getEmpId())) {
			returnedResult = employeeRepository.save(dto);
		} else {
			throw new CustomException("Id is not present for updating record");
		}
		return returnedResult;
	}

	@Override
	public String delete(Integer id) {
		if (null != employeeRepository.getEmployeebyId(id)) {
			Cache.mapEmployee.remove(id);
		} else {
			throw new CustomException("Id is not present for deletion of employee");
		}
		return "Employee is deleted successfully";
	}

	@Override
	public List<Employee> getEmployeeByDepartmentWise(String deptName) {
		if (StringUtils.hasLength(deptName)) {
			return employeeRepository.getAllEmployees().stream()
					.filter(a -> a.getDepartment().equalsIgnoreCase(deptName)).collect(Collectors.toList());
		}
		return employeeRepository.getAllEmployees();
	}

}
