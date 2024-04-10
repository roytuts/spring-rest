package com.roytuts.springrestserver.model;

public class Employee {

	private Integer id;

	private String employeeName;

	private Double employeeSalary;

	public Employee() {
	}

	public Employee(Integer id, String employeeName, Double employeeSalary) {
		this.id = id;
		this.employeeName = employeeName;
		this.employeeSalary = employeeSalary;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Double getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(Double employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

}
