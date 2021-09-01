package com.api.restServices.employee;

import com.api.restServices.employee.employeeActions.EmployeeActions;

public class Employee {

	 public static final String BASEURL="https://reqres.in/api/users";
	
	
	
	public EmployeeActions employeeActions() {
		return new EmployeeActions();
	}
}
