package com.rnd.task.response;

import java.io.Serializable;
import java.util.Set;

import com.rnd.task.validation.TaskFieldError;

public class ServiceResult implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public enum Status{
		SUCCESS, DUPLICATE_ENTRY,EXCEPTION,ERROR,WARNING,NOT_FOUND
	};
	
	private Status status;
	private String responseCode;
	private String message;
	private Set<TaskFieldError> errors;
	
	public ServiceResult(Status status, String responseCode, String message, Set<TaskFieldError> errors) {
		this.status = status;
		this.responseCode = responseCode;
		this.message = message;
		this.errors = errors;
	}

	public ServiceResult(String responseCode, String message, Set<TaskFieldError> errors) {
		this.responseCode = responseCode;
		this.message = message;
		this.errors = errors;
	}

	public ServiceResult(String message, Set<TaskFieldError> errors) {
		this.message = message;
		this.errors = errors;
	}

	public ServiceResult() {
		super();
	}

	

	public ServiceResult(Status status, String responseCode, String message) {
		super();
		this.status = status;
		this.responseCode = responseCode;
		this.message = message;
	}

	public Status getStatus() {
		return status;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public String getMessage() {
		return message;
	}

	public Set<TaskFieldError> getErrors() {
		return errors;
	}

}
