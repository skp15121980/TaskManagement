package com.rnd.task.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LtmAttributeDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@JsonProperty("id")
	Integer id;
	
	@JsonProperty("type")
	Integer type;
	
	@JsonProperty("key")
	String key;
	
	@JsonProperty("field")
	String field;
	
	@JsonProperty("label")
	String label;

	@JsonProperty("dataType")
	String dataType;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	
	
}
