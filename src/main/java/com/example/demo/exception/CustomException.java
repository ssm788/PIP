package com.example.demo.exception;

import org.springframework.http.HttpStatus;

public class CustomException extends BaseException {
	private static final long serialVersionUID = 1L;
	HttpStatus httpStatus;
	private Object o;

	public CustomException() {
		super("Custom exceptions");
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public Object getO() {
		return o;
	}

	public void setO(Object o) {
		this.o = o;
	}

	public CustomException(String message) {
		super(message);
	}

	public CustomException(String type, boolean status, String statuscode, String message, String st,Object obj) {
		super(type, status, statuscode, message);
		httpStatus = HttpStatus.valueOf(Integer.parseInt(st));
		o=obj;
	}
	public CustomException(String type, boolean status, String statuscode, String message, String st) {
		super(type, status, statuscode, message);
		httpStatus = HttpStatus.valueOf(Integer.parseInt(st));
		
	}
	/*
	 * public CustomException(HttpStatus httpStatus, String errorReason, String
	 * message) { super(errorReason + message); }
	 * 
	 * public CustomException(HttpStatus httpStatus, String type, boolean status,
	 * String statuscode, String message) { super(type, status, statuscode,
	 * message); httpStatus = httpStatus; }
	 */
}