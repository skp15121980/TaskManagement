package com.rnd.task.service.impl;

import static com.rnd.task.common.GlobalMessageCode.LTM3100;
import static com.rnd.task.common.GlobalMessageCode.LTM3200;

import java.util.List;

import javax.cache.annotation.CacheDefaults;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rnd.task.dao.TaskMetaDataDao;
import com.rnd.task.dto.LtmAttributeDto;
import com.rnd.task.entity.LTMAttributeEntity;
import com.rnd.task.mapper.TaskMetaDataMapper;
import com.rnd.task.response.ServiceResponse;
import com.rnd.task.response.ServiceResult;
import com.rnd.task.response.ServiceResult.Status;
import com.rnd.task.service.TaskMetaDataService;

@Service
@Transactional
@CacheDefaults(cacheName = "")
public class TaskMetaDataServiceImpl implements TaskMetaDataService{

	@Autowired
	private TaskMetaDataDao taskMetaDataDao;
	@Override
	public ServiceResponse<List<LtmAttributeDto>> getTaskTypeMetaData(String taskType) {
		List<LTMAttributeEntity> metadataList = taskMetaDataDao.getTaskTypeMetaData(taskType);
		List<LtmAttributeDto> attributesDto = TaskMetaDataMapper.getAttributeDtoList(metadataList);
		ServiceResult serviceResult = new ServiceResult(Status.SUCCESS, LTM3100.name(), LTM3100.getMessage());
		return new ServiceResponse<List<LtmAttributeDto>>(serviceResult,attributesDto);
	}

	@Override
	public ServiceResponse<List<LtmAttributeDto>> getAttributesMetaData() {
		ServiceResult serviceResult=null;
		List<LTMAttributeEntity> attributeEntities = taskMetaDataDao.getAttributesMetaData();
		List<LtmAttributeDto> attributeDtos =TaskMetaDataMapper.getAttributeDtoList(attributeEntities);
		if(CollectionUtils.isEmpty(attributeDtos)) {
			serviceResult = new ServiceResult(Status.NOT_FOUND,LTM3200.name(),LTM3200.getMessage());
		}else {
			serviceResult = new ServiceResult(Status.NOT_FOUND,LTM3200.name(),LTM3200.getMessage());
		}
		return new ServiceResponse<List<LtmAttributeDto>> (serviceResult,attributeDtos);
	}

}
