package com.rnd.task.common;

/**
 * @author Skpandey
 *
 */
public enum GlobalMessageCode {

	LTM3100("Task type metadata fetched successfully"),
	LTM3200("No data found for this %s task Type %s");

	private String message;

	private GlobalMessageCode(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
