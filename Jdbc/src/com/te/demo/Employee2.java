package com.te.demo;

import java.io.Serializable;

public class Employee2 implements Serializable{
	
	int empid;
	String name;
	int salary;
	String doj;
	public Employee2() {
		super();
	}
	public Employee2(int empid, String name, int salary, String doj) {
		super();
		this.empid = empid;
		this.name = name;
		this.salary = salary;
		this.doj = doj;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getDoj() {
		return doj;
	}
	public void setDoj(String doj) {
		this.doj = doj;
	}
	
	

}
