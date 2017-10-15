package com.ltm.rnd.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import com.rnd.task.controller.TaskController;
import com.rnd.task.dto.ActionMenuDto;
import com.rnd.task.dto.TaskDto;
import com.rnd.task.dto.TaskStatus;
import com.rnd.task.service.TaskService;


@RunWith(SpringRunner.class)
@WebMvcTest(value = TaskController.class, secure = false)
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
		taskDto.setTaskType("LTM");
		taskDto.setTaskStatus(TaskStatus.OPEN);
		taskDto.setCreatedTimestamp(new java.sql.Timestamp(Calendar.getInstance().getTimeInMillis()));
		taskDto.setCreatedUserId("Sunil");
		List<ActionMenuDto> actionMenu = new ArrayList<ActionMenuDto>();
		ActionMenuDto actionMenuDto = new ActionMenuDto();
		actionMenuDto.setLeftClick("LeftClick");
		actionMenuDto.setRightClick("RightClick");
		actionMenu.add(actionMenuDto);
		taskDto.setActionMenu(actionMenu);
		Map<String ,Object > bussinessAttributes= new HashMap<>();
		bussinessAttributes.put("lob", "lob");
		bussinessAttributes.put("collateral", "collateral");
		taskDto.setBussinessAttributes(bussinessAttributes);
		String jsonInString = mapper.writeValueAsString(taskDto);
		mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/tasks/create").contentType(MediaType.APPLICATION_JSON).content(jsonInString)).andExpect(status().isCreated());

	}
}
