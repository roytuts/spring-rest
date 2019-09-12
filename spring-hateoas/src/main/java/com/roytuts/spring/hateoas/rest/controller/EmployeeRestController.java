package com.roytuts.spring.hateoas.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.roytuts.spring.hateoas.service.EmployeeService;
import com.roytuts.spring.hateoas.vo.EmployeeVo;

@RestController
public class EmployeeRestController {

	@Autowired
	private EmployeeService service;

	@GetMapping("/employees")
	public ResponseEntity<List<EmployeeVo>> getEmployeeList() {
		List<EmployeeVo> list = service.getEmployeeList();

		list.forEach(ev -> {
			ev.add(ControllerLinkBuilder
					.linkTo(ControllerLinkBuilder.methodOn(EmployeeRestController.class).getEmployeeById(ev.getEmpId()))
					.withRel("employee-by-id"));
			ev.add(ControllerLinkBuilder.linkTo(
					ControllerLinkBuilder.methodOn(EmployeeRestController.class).getEmployeeByName(ev.getName()))
					.withRel("employee-by-name"));
			ev.add(ControllerLinkBuilder.linkTo(
					ControllerLinkBuilder.methodOn(EmployeeRestController.class).getEmployeeByEmail(ev.getEmail()))
					.withRel("employee-by-email"));
		});

		return new ResponseEntity<List<EmployeeVo>>(list, HttpStatus.OK);
	}

	@GetMapping("/employee/id/{id}")
	public ResponseEntity<EmployeeVo> getEmployeeById(@PathVariable int id) {
		EmployeeVo emp = service.getEmployeeById(id);

		emp.add(ControllerLinkBuilder
				.linkTo(ControllerLinkBuilder.methodOn(EmployeeRestController.class).getEmployeeList())
				.withRel("employee-list"));
		emp.add(ControllerLinkBuilder
				.linkTo(ControllerLinkBuilder.methodOn(EmployeeRestController.class).getEmployeeById(id))
				.withSelfRel());
		emp.add(ControllerLinkBuilder
				.linkTo(ControllerLinkBuilder.methodOn(EmployeeRestController.class).getEmployeeByName(emp.getName()))
				.withRel("employee-by-name"));
		emp.add(ControllerLinkBuilder
				.linkTo(ControllerLinkBuilder.methodOn(EmployeeRestController.class).getEmployeeByEmail(emp.getEmail()))
				.withRel("employee-by-email"));

		return new ResponseEntity<EmployeeVo>(emp, HttpStatus.OK);
	}

	@GetMapping("/employee/name/{name}")
	public ResponseEntity<EmployeeVo> getEmployeeByName(@PathVariable String name) {
		EmployeeVo emp = service.getEmployeeByName(name);

		// ...you can add relevant links

		return new ResponseEntity<EmployeeVo>(emp, HttpStatus.OK);
	}

	@GetMapping("/employee/email/{email}")
	public ResponseEntity<EmployeeVo> getEmployeeByEmail(@PathVariable String email) {
		EmployeeVo emp = service.getEmployeeByEmail(email);

		// ...you can add relevant links

		return new ResponseEntity<EmployeeVo>(emp, HttpStatus.OK);
	}

	@PostMapping("/employee")
	public ResponseEntity<Void> saveEmployee(@RequestBody EmployeeVo employeeVo) {
		service.saveEmployee(employeeVo);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@PutMapping("/employee")
	public ResponseEntity<Void> updateEmployee(@RequestBody EmployeeVo employeeVo) {
		service.updateEmployee(employeeVo);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@DeleteMapping("/employee/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable int id) {
		service.deleteEmployeeById(id);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
