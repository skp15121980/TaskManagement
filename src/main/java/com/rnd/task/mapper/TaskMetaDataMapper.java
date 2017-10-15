package com.rnd.task.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

import com.rnd.task.dto.LtmAttributeDto;
import com.rnd.task.entity.LTMAttributeEntity;

public class TaskMetaDataMapper {
	public static List<LtmAttributeDto> getAttributeDtoList(List<LTMAttributeEntity> metadataList) {
		List<LtmAttributeDto> attributesDto = new ArrayList<>();
		if(CollectionUtils.isEmpty(metadataList)) {
			return null;
		}
		metadataList.forEach(entity -> {
			LtmAttributeDto dto = new LtmAttributeDto();
			dto.setId(entity.getId());
			attributesDto.add(dto);
		});
		return attributesDto;
	}
}
