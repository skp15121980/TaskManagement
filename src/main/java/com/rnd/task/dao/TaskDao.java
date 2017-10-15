package com.rnd.task.dao;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.rnd.task.dto.LtmAttributeDto;
import com.rnd.task.dto.TaskDto;
import com.rnd.task.entity.TaskEntity;

/**
 * @author Skpandey
 *
 */
public interface TaskDao {
	/**
     * Create a task by a task object.
	 * @param businessAttributesMetada 
     * @param task
     * @return the created task
     * @throws NotAuthorizedException
     */
	TaskEntity create(TaskEntity taskEntity, Map<String, LtmAttributeDto> businessAttributesMetada);
    /**
     * Create a task by a task object.
     * @param taskId
     * @return the TaskDto Object
     */
	List<String> getTaskById(String userId);
}
