package com.rnd.task.dao;

import java.util.List;

import com.rnd.task.entity.LTMAttributeEntity;

/**
 * @author Skpandey
 *
 */
public interface TaskMetaDataDao {
	List<LTMAttributeEntity> getTaskTypeMetaData(String taskType);
	List<LTMAttributeEntity> getAttributesMetaData();
}
