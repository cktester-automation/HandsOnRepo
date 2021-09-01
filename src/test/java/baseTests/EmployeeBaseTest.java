package baseTests;

import com.api.restServices.Rest;
import com.api.restServices.helpers.RestHttpResponse;

public class EmployeeBaseTest {
	
/** 
 * Method to create new employee
 * @param jsonPayload
 * @return
 * @throws Exception
 */
	public RestHttpResponse createNewEmployee(String jsonPayload) throws Exception {
		RestHttpResponse response = Rest.employee().employeeActions().create(jsonPayload);
		return response;
	}
	
	/**
	 * Method to update existing employee
	 * @param jsonPayload
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public RestHttpResponse updateEmployee(String jsonPayload,String id) throws Exception {
		RestHttpResponse response = Rest.employee().employeeActions().update(jsonPayload,id);
		return response;
	}
	
	/**
	 * Method to delete employee
	 * @param jsonPayload
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public RestHttpResponse deleteEmployee(String jsonPayload,String id) throws Exception {
		RestHttpResponse response = Rest.employee().employeeActions().delete(jsonPayload,id);
		return response;
	}
	/**
	 * Method to retrieve employee details. Pass id as "null" if you want to retrieve all the employee data
	 * @param jsonPayload
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public RestHttpResponse retrieveEmployee(String jsonPayload,String id) throws Exception {
		RestHttpResponse response = Rest.employee().employeeActions().getDetails(id);
		return response;
	}

}
