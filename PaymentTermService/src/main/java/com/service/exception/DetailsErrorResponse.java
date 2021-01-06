package com.service.exception;

import java.util.Date;

public class DetailsErrorResponse {

	private int status;
	private String message;
	private Date timeStamp;
	private String details;

	public DetailsErrorResponse() {
		
	}

	public DetailsErrorResponse(int status, String message, Date timeStamp, String details) {
		super();
		this.status = status;
		this.message = message;
		this.timeStamp = timeStamp;
		this.details = details;
	}

	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	
	public void setMessage(String message) {
		this.message = message;
	}

	
	public Date getTimeStamp() {
		return timeStamp;
	}

	
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	
	public String getDetails() {
		return details;
	}

	
	public void setDetails(String details) {
		this.details = details;
	}

	

	

}
