package com.roytuts.spring.rest.different.data.format.model;

public class Employee {

    private String name;
    private String designation;

    public Employee() {
    }

    public Employee(String name, String designation) {
        this.name = name;
        this.designation = designation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "Employee [name=" + name + ", designation=" + designation + "]";
    }

}
