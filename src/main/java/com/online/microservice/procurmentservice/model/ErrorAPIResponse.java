package com.online.microservice.procurmentservice.model;

import org.springframework.http.HttpStatus;

public class ErrorAPIResponse extends BaseAPIResponse {

	public ErrorAPIResponse() {
		// TODO Auto-generated constructor stub
		this("There is something went wrong");
	}

	public ErrorAPIResponse(String message) {
		// TODO Auto-generated constructor stub
		this(HttpStatus.INTERNAL_SERVER_ERROR.value(),
				HttpStatus.INTERNAL_SERVER_ERROR.name(), message);
	}

	public ErrorAPIResponse(int code, String status, String message) {
		super(code, status, message);
		// TODO Auto-generated constructor stub
	}

}
