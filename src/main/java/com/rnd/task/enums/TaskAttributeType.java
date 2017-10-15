package com.rnd.task.enums;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TaskAttributeType {

	COMMON(1,"Task"),BUSINESS(2,"Business"),HELPER(3,"Helper");
	
	private int key;
	private String value;
	
	private TaskAttributeType(int key, String value) {
		this.key = key;
		this.value = value;
	}
	
	@JsonAnyGetter
	public static TaskAttributeType fromString(String key) {
		Integer theKey = Integer.valueOf(key);
		for(TaskAttributeType taskAttributeType : values()) {
			if(taskAttributeType.key == theKey) {
				return taskAttributeType;
			}
		}
		return null;
	}
	
	@JsonValue
	public int getNumericValue() {
		return key;
	}
	
	@JsonValue
	public String getStringValue() {
		return value;
	}
}
