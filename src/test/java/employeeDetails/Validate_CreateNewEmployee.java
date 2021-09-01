package employeeDetails;

import org.testng.annotations.Test;

import com.api.restServices.helpers.PayloadReader;
import com.api.restServices.helpers.RestHttpResponse;

import baseTests.EmployeeBaseTest;
/**
 * Test to create a new employee and validate the response
 * @author 193870
 * @version 1
 * @date 31 Aug 2021
 *
 */
public class Validate_CreateNewEmployee extends EmployeeBaseTest {
	RestHttpResponse createRes;

	@Test
	public void verifyCreateNewEmployee() throws Exception {
		// Retrieve the payload for create employee
		String jsonPayload = PayloadReader.getPayload("create");
		
		// Set the test data for the name and job
		jsonPayload = jsonPayload.replace("$$NAME$$", "Steve Perry");
		jsonPayload = jsonPayload.replace("$$JOB$$", "Programmer");
		
		//Call method to create a new employee
		createRes = createNewEmployee(jsonPayload);
		
		//Printing URL
		System.out.println(createRes.getURL());
		
		//Printing Request/payload
		System.out.println("Request------------------------------------------------------------");
		System.out.println(createRes.getRequestBody());
		
		//Printing Response
		System.out.println("RESPONSE------------------------------------------------------------");
		System.out.println(createRes.getResponse());

	}

}
