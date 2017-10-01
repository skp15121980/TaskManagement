package com.ltm.rnd.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ltm.rnd.dto.TaskDto;

/**
 * @author Skpandey
 *
 */
@Service
public interface TaskService {
	/**
     * Create a task by a task object.
     * @param task
     * @return the created task
     * @throws NotAuthorizedException
     */
    TaskDto create(TaskDto taskDto);
    /**
     * Create a task by a task object.
     * @param task
     * @return the created task
     * @throws NotAuthorizedException
     */
    List<String> getByUserId(String userId);
}
