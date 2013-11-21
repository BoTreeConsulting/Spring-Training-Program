package com.botree.hibernate.example;

public class Employee {
	
	int employeeId;
	String employeeName;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	@Override
	public String toString() {
		return "ID: " + employeeId + "\tName: " + employeeName + "\n";
	}
}
