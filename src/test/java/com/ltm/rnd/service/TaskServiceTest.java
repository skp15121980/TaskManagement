package com.ltm.rnd.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ltm.rnd.dao.TaskDao;
import com.ltm.rnd.dto.ActionMenu;
import com.ltm.rnd.dto.TaskDto;
import com.ltm.rnd.dto.TaskStatus;
import com.ltm.rnd.service.impl.TaskServiceImpl;


/**
 * @author Skpandey
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class TaskServiceTest {

	@Mock
	private TaskDao taskDao;
	
	@InjectMocks
	private TaskServiceImpl taskService;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void saveTask(){
		TaskDto taskDto = new TaskDto();
		taskDto.setTaskId(UUID.randomUUID());
		taskDto.setTaskType("Test");
		taskDto.setTaskStatus(TaskStatus.NEW);
		taskDto.setCreatedTimestamp(new java.sql.Timestamp(Calendar.getInstance().getTimeInMillis()));
		taskDto.setCreatedUserId("Sunil");
		List<ActionMenu> actionMenu = new ArrayList<ActionMenu>();
		ActionMenu actionMenuDto = new ActionMenu();
		actionMenuDto.setLeftClick("LeftClick");
		actionMenuDto.setLeftClick("RightClick");
		actionMenu.add(actionMenuDto);
		taskDto.setActionMenu(actionMenu);
		when(taskDao.create(taskDto)).thenReturn(taskDto);
		TaskDto result = taskService.create(taskDto);
		//assertEquals(8, result.getId());
		assertEquals("Test", result.getTaskType());
		assertEquals("Sunil", result.getCreatedUserId());
	}
}
