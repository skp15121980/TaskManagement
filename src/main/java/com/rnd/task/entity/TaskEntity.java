package com.rnd.task.entity;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.rnd.task.dto.ActionMenuDto;
import com.rnd.task.dto.TaskStatus;

public class TaskEntity {
	private UUID taskId;

	private String taskType;

	private TaskStatus taskStatus;

	private Date createdTimestamp;

	private String createdUserId;

	private List<ActionMenuEntity> actionMenu;

	private Map<String ,Object > bussinessAttributes;

	
	public TaskEntity() {
	}

	public UUID getTaskId() {
		return taskId;
	}

	public void setTaskId(UUID taskId) {
		this.taskId = taskId;
	}

	public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	public TaskStatus getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(TaskStatus taskStatus) {
		this.taskStatus = taskStatus;
	}

	public Date getCreatedTimestamp() {
		return createdTimestamp;
	}

	public void setCreatedTimestamp(Date createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

	public String getCreatedUserId() {
		return createdUserId;
	}

	public void setCreatedUserId(String createdUserId) {
		this.createdUserId = createdUserId;
	}

	public List<ActionMenuEntity> getActionMenu() {
		return actionMenu;
	}

	public void setActionMenu(List<ActionMenuEntity> actionMenu) {
		this.actionMenu = actionMenu;
	}

	public Map<String, Object> getBussinessAttributes() {
		return bussinessAttributes;
	}

	public void setBussinessAttributes(Map<String, Object> bussinessAttributes) {
		this.bussinessAttributes = bussinessAttributes;
	}
	
}
