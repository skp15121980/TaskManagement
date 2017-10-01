package com.ltm.rnd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ltm.rnd.dao.TaskDao;
import com.ltm.rnd.dto.TaskDto;
import com.ltm.rnd.service.TaskService;

/**
 * @author Skpandey
 *
 */
@Service
@CacheConfig(cacheNames = "taskCache")
public class TaskServiceImpl implements TaskService {

	@Autowired
	TaskDao taskDao;
	@Cacheable
	@Override
	public TaskDto create(TaskDto taskDto){
		return taskDao.create(taskDto);
	}
	@Cacheable
	@Override
	public List<String> getByUserId(String userId) {
		System.out.println(userId);
		return taskDao.getTaskById(userId);
	}

}
