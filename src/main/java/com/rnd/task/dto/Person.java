package com.rnd.task.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Skpandey
 *
 */
public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("name")
	private String name;
	
	@JsonProperty("userId")
	private String userId;
	
	@JsonProperty("dob")
	private Date dob;
	
	@JsonProperty("dobPlace")
	private String dobPlace;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getDobPlace() {
		return dobPlace;
	}

	public void setDobPlace(String dobPlace) {
		this.dobPlace = dobPlace;
	}
	
}
