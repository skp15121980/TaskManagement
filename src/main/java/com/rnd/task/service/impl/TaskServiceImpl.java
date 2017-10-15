package com.rnd.task.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.rnd.task.dao.TaskDao;
import com.rnd.task.dto.LtmAttributeDto;
import com.rnd.task.dto.Person;
import com.rnd.task.dto.TaskDto;
import com.rnd.task.entity.TaskEntity;
import com.rnd.task.mapper.TaskMapper;
import com.rnd.task.response.ServiceResponse;
import com.rnd.task.service.PersonService;
import com.rnd.task.service.TaskMetaDataService;
import com.rnd.task.service.TaskService;
import com.rnd.task.util.DBUtil;

/**
 * @author Skpandey
 *
 */
@Service
@CacheConfig(cacheNames = "taskCache")
public class TaskServiceImpl implements TaskService {

	@Autowired
	TaskDao taskDao;
	
	@Autowired
	TaskMetaDataService taskMetaDataService;
	
	@Autowired
	PersonService personService;
	
	@Profiled(tag="TaskServiceImpl.create")
	@Cacheable
	@Override
	public TaskDto create(TaskDto taskDto){
		
		ServiceResponse<List<LtmAttributeDto>> ltmAttributeDtoResponse = taskMetaDataService.getTaskTypeMetaData(taskDto.getTaskType());
		
		List<LtmAttributeDto> metaDataDto = ltmAttributeDtoResponse.getData();
		if(CollectionUtils.isEmpty(metaDataDto)) {
			
		}
		Map<String , LtmAttributeDto> businessAttributesMetada = DBUtil.getBusinessAttributesByKey(metaDataDto);
		Map<String,Object> businessAttributes = taskDto.getBussinessAttributes();
		Map<String,LtmAttributeDto> validBusinessAttributes = new HashMap<>();
		for(String uiKey : businessAttributes.keySet()) {
			if(businessAttributesMetada.get(uiKey) == businessAttributes.get(uiKey)) {
				validBusinessAttributes.getOrDefault(uiKey, businessAttributesMetada.get(uiKey));
			}
		}
		TaskEntity taskEntity = TaskMapper.fromTaskDtoToTaskEntity(taskDto);
		TaskEntity tasSavedkEntity =taskDao.create(taskEntity,validBusinessAttributes);
		TaskDto mappedTaskDto = TaskMapper.fromTaskEntityToTaskDto(tasSavedkEntity);
		
		return mappedTaskDto;
	}
	@Cacheable
	@Override
	public List<String> getByUserId(String userId) {
		Person person =personService.getNameById(userId);
		System.out.println(person.getName());
		System.out.println(userId);
		return taskDao.getTaskById(userId);
	}

}
