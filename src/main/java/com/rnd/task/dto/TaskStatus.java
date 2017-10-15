package com.rnd.task.dto;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum TaskStatus {
	OPEN(1),LOCKED(2),CLOSE(3);
	
	 private int key;

	TaskStatus(int newValue) {
        this.key = newValue;
    }

   @JsonCreator
   public static TaskStatus fromString(String key) {
	   Integer theKey=Integer.valueOf(key);
	   for(TaskStatus status:values()) {
		   if(status.key==theKey) {
			   return status;
		   }
	   }
	   return null;
   }
   public int getNumericValue() {
	   return key;
   }
}

