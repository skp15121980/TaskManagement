package com.ltm.rnd.dao;

import java.util.List;
import java.util.UUID;

import com.ltm.rnd.dto.TaskDto;

public interface TaskDao {
	/**
     * Create a task by a task object.
     * @param task
     * @return the created task
     * @throws NotAuthorizedException
     */
    TaskDto create(TaskDto taskDto);
    /**
     * Create a task by a task object.
     * @param taskId
     * @return the TaskDto Object
     */
	List<String> getTaskById(String userId);
}
