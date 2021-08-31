package com.disney.paap.api.restServices.helpers;

import java.io.IOException;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.util.EntityUtils;

public class RestHttpResponse {

	private String environment = null;
	private String originalRequestBody = "";
	private String method = null;
	private HttpResponse response = null;
	private int statusCode = 0;
	private String responseFormat = "";
	private String responseAsString = "";
	private String url = "";
	private StringBuffer buffer = new StringBuffer();
	private String executionTime;
	private Header[] requestHeaders;
	private Header[] responseHeaders;

	public RestHttpResponse(HttpResponse httpResponse) throws Exception {
		response = httpResponse;
		statusCode = response.getStatusLine().getStatusCode();
		responseFormat = ContentType.getOrDefault(response.getEntity()).getMimeType().replace("application/", "");
		try {
			responseAsString = EntityUtils.toString(response.getEntity());

		} catch (ParseException | IOException e) {
			throw new Exception(e.getMessage(), e);
		}
	}

	public RestHttpResponse(String environment, HttpUriRequest request, HttpResponse httpResponse, String executionTime)
			throws Exception {
		HttpUriRequest originalRequest = request;
		requestHeaders = request.getAllHeaders();
		responseHeaders = httpResponse.getAllHeaders();
		this.environment = environment;
		this.executionTime = executionTime;
		if (request instanceof HttpEntityEnclosingRequestBase) {
			HttpEntity entity = ((HttpEntityEnclosingRequest) request).getEntity();

			if (entity != null) {
				try {
					originalRequestBody = EntityUtils.toString(entity);
				} catch (ParseException | IOException throwAway) {
				}
			}
		}

		url = request.getURI().toString();
		method = request.getMethod();
		response = httpResponse;
		statusCode = response.getStatusLine().getStatusCode();
		responseFormat = ContentType.getOrDefault(response.getEntity()).getMimeType().replace("application/", "");
		try {
			if (statusCode != 204 && response.getEntity() != null) {
				responseAsString = EntityUtils.toString(response.getEntity());
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage(), e);
		} finally {
			try {
				EntityUtils.consume(httpResponse.getEntity());
			} catch (IOException e) {
			}
		}
	}

	public String getWebServiceType() {
		return "REST";
	}

	public String getEnvironment() {
		return environment;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public String getResponseFormat() {
		return responseFormat;
	}

	public String getResponse() {
		return responseAsString;
	}

	public String getMethod() {
		return method;
	}

	public Header[] getRequestHeaders() {
		return requestHeaders;
	}

	public Header[] getHeaders() {
		return response.getAllHeaders();
	}

	public String getRequestBody() {
		return originalRequestBody;
	}

	public String getURL() {
		return url;
	}

	public String getExecutionTime() {
		return executionTime;
	}
}
