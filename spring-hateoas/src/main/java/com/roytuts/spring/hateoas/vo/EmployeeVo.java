package com.roytuts.spring.hateoas.vo;

import org.springframework.hateoas.ResourceSupport;

public class EmployeeVo extends ResourceSupport {

	private Integer empId;
	private String name;
	private String email;

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
