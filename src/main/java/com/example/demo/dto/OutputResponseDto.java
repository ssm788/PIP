package com.example.demo.dto;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class OutputResponseDto {
	private boolean status;
	private Object data;
	private String message;
	private String statusCode;
	private UUID traceId;
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public UUID getTraceId() {
		return traceId;
	}
	public void setTraceId(UUID traceId) {
		this.traceId = traceId;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public OutputResponseDto(boolean status, Object data, String message, String statusCode,UUID traceId) {
		super();
		this.status = status;
		this.data = data;
		this.message = message;
		this.statusCode = statusCode;
		this.traceId = traceId;
	}
	
	
	public OutputResponseDto() {
		// TODO Auto-generated constructor stub
	}

}
