package com.api.restServices.employee.employeeActions;

import java.io.IOException;

import org.apache.commons.lang3.time.StopWatch;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.api.restServices.employee.Employee;
import com.api.restServices.helpers.RestHttpResponse;

public class EmployeeActions {

	private static final String create = "";
	private static String update = "/2";
	private static String retrieve = "/2";
	private static String retrieveAll = "?page=2";
	private static String delete = "/2";

	public RestHttpResponse create(String payload) throws Exception {
		HttpClient client = HttpClientBuilder.create().build();
		System.out.println(Employee.BASEURL + create);
		HttpPost request = new HttpPost(Employee.BASEURL + create);
		StringEntity entity = new StringEntity(payload);
		request.setEntity(entity);
		StopWatch execution = StopWatch.createStarted();
		HttpResponse httpResponse = client.execute(request);
		execution.stop();
		String executionTime = execution.toString();
		RestHttpResponse restResponse= new RestHttpResponse( "environment",  request,  httpResponse,  executionTime);
		return restResponse;
	}

	public RestHttpResponse update(String payload, String id) throws Exception {
		HttpClient client = HttpClientBuilder.create().build();
		update = update.replace("$$ID$$", id);
		HttpPut request = new HttpPut(Employee.BASEURL + update);
		StringEntity entity = new StringEntity(payload);
		request.setEntity(entity);
		StopWatch execution = StopWatch.createStarted();
		HttpResponse httpResponse = client.execute(request);
		execution.stop();
		String executionTime = execution.toString();
		RestHttpResponse restResponse= new RestHttpResponse( "environment",  request,  httpResponse,  executionTime);
		return restResponse;
	}

	public RestHttpResponse delete(String payload, String id) throws Exception {
		HttpClient client = HttpClientBuilder.create().build();
		delete = delete.replace("$$ID$$", id);
		HttpDelete request = new HttpDelete(Employee.BASEURL + delete);
		StopWatch execution = StopWatch.createStarted();
		HttpResponse httpResponse = client.execute(request);
		execution.stop();
		String executionTime = execution.toString();
		RestHttpResponse restResponse= new RestHttpResponse( "environment",  request,  httpResponse,  executionTime);
		return restResponse;
	}

	public RestHttpResponse getDetails(String empId) throws Exception {
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request;

		if (empId != null) {
			retrieve = retrieve.replace("$$ID$$", empId);
			request = new HttpGet(Employee.BASEURL + retrieve);
		} else {
			request = new HttpGet(Employee.BASEURL + retrieveAll);
		}
		StopWatch execution = StopWatch.createStarted();
		HttpResponse httpResponse = client.execute(request);
		execution.stop();
		String executionTime = execution.toString();
		RestHttpResponse restResponse= new RestHttpResponse( "environment",  request,  httpResponse,  executionTime);
		return restResponse;
	}

}
