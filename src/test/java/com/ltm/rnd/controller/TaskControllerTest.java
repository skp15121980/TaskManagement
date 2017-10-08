package com.ltm.rnd.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ltm.rnd.dto.ActionMenu;
import com.ltm.rnd.dto.TaskDto;
import com.ltm.rnd.dto.TaskStatus;
import com.ltm.rnd.service.TaskService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = LTMRestController.class, secure = false)
public class TaskControllerTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(TaskControllerTest.class);

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TaskService taskService;
    
	@Test
	public void createTask() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
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
		String jsonInString = mapper.writeValueAsString(taskDto);
		mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/tasks/create").contentType(MediaType.APPLICATION_JSON).content(jsonInString)).andExpect(status().isCreated());

	}
}
