package com.rnd.task.mapper;

import java.util.ArrayList;
import java.util.List;

import com.rnd.task.dto.ActionMenuDto;
import com.rnd.task.dto.TaskDto;
import com.rnd.task.entity.ActionMenuEntity;
import com.rnd.task.entity.TaskEntity;

public class TaskMapper {

	public static TaskEntity fromTaskDtoToTaskEntity(TaskDto dtos) {

		TaskEntity askEntity = new TaskEntity();
		askEntity.setTaskId(dtos.getTaskId());
		askEntity.setTaskType(dtos.getTaskType());
		askEntity.setTaskStatus(dtos.getTaskStatus());
		askEntity.setCreatedTimestamp(dtos.getCreatedTimestamp());
		askEntity.setCreatedUserId(dtos.getCreatedUserId());
		List<ActionMenuEntity> actionMenuDtoList = new ArrayList<>();
		for(int i=0; i<dtos.getActionMenu().size();i++) {
			ActionMenuEntity actionMenuEntity = new ActionMenuEntity();
			ActionMenuDto actionMenuDto= dtos.getActionMenu().get(i);
			actionMenuEntity.setLeftClick(actionMenuDto.getLeftClick());
			actionMenuEntity.setRightClick(actionMenuDto.getRightClick());
			actionMenuDtoList.add(actionMenuEntity);
		}
		askEntity.setActionMenu(actionMenuDtoList);
		askEntity.setBussinessAttributes(dtos.getBussinessAttributes());
		return askEntity;
	}

	public static TaskDto fromTaskEntityToTaskDto(TaskEntity entity) {
		TaskDto taskDto = new TaskDto();
		taskDto.setTaskId(entity.getTaskId());
		taskDto.setTaskType(entity.getTaskType());
		taskDto.setTaskStatus(entity.getTaskStatus());
		taskDto.setCreatedTimestamp(entity.getCreatedTimestamp());
		taskDto.setCreatedUserId(entity.getCreatedUserId());
		List<ActionMenuDto> actionMenuDtoList = new ArrayList<>();
		for(int i=0; i<entity.getActionMenu().size();i++) {
			ActionMenuDto actionMenuDto = new ActionMenuDto();
			ActionMenuEntity actionMenuEntity= entity.getActionMenu().get(i);
			actionMenuDto.setLeftClick(actionMenuEntity.getLeftClick());
			actionMenuDto.setRightClick(actionMenuEntity.getRightClick());
			actionMenuDtoList.add(actionMenuDto);
		}
		taskDto.setActionMenu(actionMenuDtoList);
		taskDto.setBussinessAttributes(entity.getBussinessAttributes());
		return taskDto;
	}

}
