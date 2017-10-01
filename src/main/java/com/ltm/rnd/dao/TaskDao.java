package com.ltm.rnd.dao;

import com.ltm.rnd.dto.TaskDto;

public interface TaskDao {
	/**
     * Create a task by a task object.
     * @param task
     * @return the created task
     * @throws NotAuthorizedException
     */
    TaskDto create(TaskDto taskDto);
}
