package com.srk.moviecatalogue.exception;

import java.util.Date;

public class DefaultErrorMessage {

	
	private String details;
	
	
	private String message;
	
	
	private Date timestamp;


	public String getDetails() {
		return details;
	}


	public void setDetails(String details) {
		this.details = details;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public Date getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}


	public DefaultErrorMessage(String details, String message, Date timestamp) {
		super();
		this.details = details;
		this.message = message;
		this.timestamp = timestamp;
	}
	public DefaultErrorMessage()
	{
		
	}

	
}
