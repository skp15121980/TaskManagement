package com.rnd.task.response;

import java.io.Serializable;
import java.sql.Date;

public class DebugInformation implements Serializable{

	private String responseId;
	private String requestId;
	private String servicedBy;
	private Date servicedDate;
	private long responseTime;
	
	public DebugInformation(String responseId, String requestId, String servicedBy, Date servicedDate,
			long responseTime) {
		super();
		this.responseId = responseId;
		this.requestId = requestId;
		this.servicedBy = servicedBy;
		this.servicedDate = servicedDate;
		this.responseTime = responseTime;
	}

	public String getResponseId() {
		return responseId;
	}

	public void setResponseId(String responseId) {
		this.responseId = responseId;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getServicedBy() {
		return servicedBy;
	}

	public void setServicedBy(String servicedBy) {
		this.servicedBy = servicedBy;
	}

	public Date getServicedDate() {
		return servicedDate;
	}

	public void setServicedDate(Date servicedDate) {
		this.servicedDate = servicedDate;
	}

	public long getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(long responseTime) {
		this.responseTime = responseTime;
	}
	
	
}
