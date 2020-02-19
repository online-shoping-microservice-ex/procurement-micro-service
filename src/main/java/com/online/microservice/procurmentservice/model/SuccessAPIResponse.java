package com.online.microservice.procurmentservice.model;

import org.springframework.http.HttpStatus;

public class SuccessAPIResponse extends BaseAPIResponse {

	public SuccessAPIResponse() {
		// TODO Auto-generated constructor stub
		this("Success");
	}

	public SuccessAPIResponse(String message) {
		// TODO Auto-generated constructor stub
		this(HttpStatus.OK.value(), HttpStatus.OK.name(), message);
	}
	public SuccessAPIResponse(int code, String status, String message) {
		super(code, status, message);
		// TODO Auto-generated constructor stub
	}

}
