package com.ltm.rnd.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rnd.task.dao.TaskDao;
import com.rnd.task.dao.TaskMetaDataDao;
import com.rnd.task.dto.ActionMenuDto;
import com.rnd.task.dto.LtmAttributeDto;
import com.rnd.task.dto.TaskDto;
import com.rnd.task.dto.TaskStatus;
import com.rnd.task.entity.TaskEntity;
import com.rnd.task.mapper.TaskMapper;
import com.rnd.task.service.TaskMetaDataService;
import com.rnd.task.service.impl.TaskMetaDataServiceImpl;
import com.rnd.task.service.impl.TaskServiceImpl;
import com.rnd.task.util.DBUtil;


/**
 * @author Skpandey
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class TaskServiceTest {

	@Mock
	private TaskDao taskDao;
	
	@Mock
	private TaskMetaDataDao taskMetaDataDao;
	
	@InjectMocks
	private TaskServiceImpl taskService;
	
	@InjectMocks
	private TaskMetaDataServiceImpl taskMetaDataServiceImpl;
	
	@Mock
	TaskMetaDataService taskMetaDataService;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	
	@Test
	public void saveTask(){
		TaskDto taskDto = new TaskDto();
		taskDto.setTaskId(UUID.randomUUID());
		taskDto.setTaskType("LTM");
		taskDto.setTaskStatus(TaskStatus.OPEN);
		taskDto.setCreatedTimestamp(new java.sql.Timestamp(Calendar.getInstance().getTimeInMillis()));
		taskDto.setCreatedUserId("Sunil");
		List<ActionMenuDto> actionMenu = new ArrayList<ActionMenuDto>();
		ActionMenuDto actionMenuDto = new ActionMenuDto();
		actionMenuDto.setLeftClick("LeftClick");
		actionMenuDto.setLeftClick("RightClick");
		actionMenu.add(actionMenuDto);
		taskDto.setActionMenu(actionMenu);
		//List<LtmAttributeDto> metaDataDto = taskMetaDataServiceImpl.getTaskTypeMetaData(taskDto.getTaskType()).getData();
		
		List<LtmAttributeDto> metaDataDto = new ArrayList<>();
		LtmAttributeDto ltmAttributeDto = new LtmAttributeDto();
		ltmAttributeDto.setId(7);
		ltmAttributeDto.setType(2);
		ltmAttributeDto.setKey("Lob");
		ltmAttributeDto.setField("LOB");
		ltmAttributeDto.setLabel("Lob");
		ltmAttributeDto.setDataType("VARCHAR");
		metaDataDto.add(ltmAttributeDto);
		Map<String , LtmAttributeDto> businessAttributesMetada = DBUtil.getBusinessAttributesByKey(metaDataDto);
		TaskEntity taskEntity = TaskMapper.fromTaskDtoToTaskEntity(taskDto);
		when(taskDao.create(taskEntity,businessAttributesMetada)).thenReturn(taskEntity);
		TaskDto result = taskService.create(taskDto);
		//assertEquals(8, result.getId());
		assertEquals("Test", result.getTaskType());
		assertEquals("Sunil", result.getCreatedUserId());
	}
}
