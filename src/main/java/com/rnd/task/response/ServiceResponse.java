package com.rnd.task.response;

import java.io.Serializable;

public class ServiceResponse<T> implements Serializable{

	private static final long serialVersionUID = 1052756793726254870L;
	
	private ServiceResult result;
	private T data;
	private DebugInformation debugInformation;
	
	public ServiceResponse(ServiceResult result, T data, DebugInformation debugInformation) {
		super();
		this.result = result;
		this.data = data;
		this.debugInformation = debugInformation;
	}

	public ServiceResponse(ServiceResult result, T data) {
		super();
		this.result = result;
		this.data = data;
	}

	public ServiceResult getResult() {
		return result;
	}

	public T getData() {
		return data;
	}

	public DebugInformation getDebugInformation() {
		return debugInformation;
	}

	
}
