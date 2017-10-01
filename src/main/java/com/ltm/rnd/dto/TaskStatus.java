package com.ltm.rnd.dto;

public enum TaskStatus {
	NEW(1),WIP(2),COMPLETED(3);
	
	 private final int value;

	TaskStatus(final int newValue) {
        value = newValue;
    }

    public int getValue() { return value; }
}

