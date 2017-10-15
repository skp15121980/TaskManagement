package com.rnd.task.service;

import java.util.List;

import com.rnd.task.dto.LtmAttributeDto;
import com.rnd.task.response.ServiceResponse;

public interface TaskMetaDataService {

	ServiceResponse<List<LtmAttributeDto>> getTaskTypeMetaData(String taskType);
	ServiceResponse<List<LtmAttributeDto>> getAttributesMetaData();
}
