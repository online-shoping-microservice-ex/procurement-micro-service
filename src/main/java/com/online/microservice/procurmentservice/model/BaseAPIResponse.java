package com.online.microservice.procurmentservice.model;

import java.time.LocalDateTime;

public abstract class BaseAPIResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8253053567084975358L;

	private int code;

	private String status;

	private final LocalDateTime timeStamp;

	private String message;

	public BaseAPIResponse() {
		// TODO Auto-generated constructor stub
		this.timeStamp = LocalDateTime.now();
	}

	public BaseAPIResponse(int code, String status, String message) {
		this();
		this.code = code;
		this.status = status;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

}
