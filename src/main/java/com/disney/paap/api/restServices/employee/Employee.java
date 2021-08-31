package com.disney.paap.api.restServices.employee;

import com.disney.paap.api.restServices.employee.employeeActions.EmployeeActions;

public class Employee {

	 public static final String BASEURL="https://reqres.in/api/users";
	
	
	
	public EmployeeActions employeeActions() {
		return new EmployeeActions();
	}
}
