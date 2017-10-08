package com.ltm.rnd.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
	private List<ActionMenu> actionMenu;

	public TaskDto() {
		// TODO Auto-generated constructor stub
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

	public List<ActionMenu> getActionMenu() {
		return actionMenu;
	}

	public void setActionMenu(List<ActionMenu> actionMenu) {
		this.actionMenu = actionMenu;
	}

}
