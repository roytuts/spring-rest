package com.roytuts.spring.hateoas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roytuts.spring.hateoas.entity.Employee;
import com.roytuts.spring.hateoas.repository.EmployeeRepository;
import com.roytuts.spring.hateoas.vo.EmployeeVo;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	public List<EmployeeVo> getEmployeeList() {
		List<Employee> employees = repository.findAll();

		return employees.stream().map(e -> {
			EmployeeVo vo = new EmployeeVo();
			vo.setEmpId(e.getEmpId());
			vo.setName(e.getName());
			vo.setEmail(e.getEmail());
			return vo;
		}).collect(Collectors.toList());
	}

	public EmployeeVo getEmployeeById(int id) {
		EmployeeVo employeeVo = new EmployeeVo();

		Employee employee = repository.findById(id);

		employeeVo.setEmpId(employee.getEmpId());
		employeeVo.setName(employee.getName());
		employeeVo.setEmail(employee.getEmail());

		return employeeVo;
	}

	public EmployeeVo getEmployeeByName(String name) {
		EmployeeVo employeeVo = new EmployeeVo();

		Employee employee = repository.findByName(name);

		employeeVo.setEmpId(employee.getEmpId());
		employeeVo.setName(employee.getName());
		employeeVo.setEmail(employee.getEmail());

		return employeeVo;
	}

	public EmployeeVo getEmployeeByEmail(String email) {
		EmployeeVo employeeVo = new EmployeeVo();

		Employee employee = repository.findByEmail(email);

		employeeVo.setEmpId(employee.getEmpId());
		employeeVo.setName(employee.getName());
		employeeVo.setEmail(employee.getEmail());

		return employeeVo;
	}

	public void saveEmployee(EmployeeVo employeeVo) {
		Employee employee = new Employee();
		employee.setName(employeeVo.getName());
		employee.setEmail(employeeVo.getEmail());
		repository.save(employee);
	}

	public void updateEmployee(EmployeeVo employeeVo) {
		Employee employee = new Employee();
		employee.setEmpId(employeeVo.getEmpId());
		employee.setName(employeeVo.getName());
		employee.setEmail(employeeVo.getEmail());
		repository.save(employee);
	}

	public void deleteEmployeeById(int id) {
		repository.deleteById(id);
	}

}
