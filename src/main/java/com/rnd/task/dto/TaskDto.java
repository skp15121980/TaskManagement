package com.rnd.task.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Skpandey
 *
 */
public class TaskDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("taskId")
	private UUID taskId;

	@JsonProperty("taskType")
	private String taskType;

	@JsonProperty("taskStatus")
	private TaskStatus taskStatus;

	@JsonProperty("createdTimestamp")
	private Date createdTimestamp;

	@JsonProperty("createdUserId")
	private String createdUserId;

	@JsonProperty("actionMenu")
	private List<ActionMenuDto> actionMenu;

	@JsonProperty("bussinessAttributes")
	private Map<String ,Object > bussinessAttributes;
	
	
	public TaskDto(UUID taskId, String taskType, TaskStatus taskStatus, Date createdTimestamp, String createdUserId,
			List<ActionMenuDto> actionMenu, Map<String, Object> bussinessAttributes) {
		super();
		this.taskId = taskId;
		this.taskType = taskType;
		this.taskStatus = taskStatus;
		this.createdTimestamp = createdTimestamp;
		this.createdUserId = createdUserId;
		this.actionMenu = actionMenu;
		this.bussinessAttributes = bussinessAttributes;
	}

	public TaskDto() {
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

	public List<ActionMenuDto> getActionMenu() {
		return actionMenu;
	}

	public void setActionMenu(List<ActionMenuDto> actionMenu) {
		this.actionMenu = actionMenu;
	}

	public Map<String, Object> getBussinessAttributes() {
		return bussinessAttributes;
	}

	public void setBussinessAttributes(Map<String, Object> bussinessAttributes) {
		this.bussinessAttributes = bussinessAttributes;
	}
}
