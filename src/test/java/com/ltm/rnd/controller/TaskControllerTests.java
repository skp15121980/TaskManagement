package com.ltm.rnd.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rnd.task.controller.TaskController;
import com.rnd.task.dto.ActionMenuDto;
import com.rnd.task.dto.TaskDto;
import com.rnd.task.dto.TaskStatus;
import com.rnd.task.service.TaskService;

/**
 * @author Skpandey
 *
 */
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@WebMvcTest(TaskController.class)
public class TaskControllerTests {

	@Inject
	private MockMvc mockMvc;

	@Inject
	private WebApplicationContext context;

	@MockBean
	private TaskService taskService;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).defaultRequest(get("/")).build();
	}

	@Test
	public void createTask() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		TaskDto taskDto = new TaskDto();
		taskDto.setTaskId(UUID.randomUUID());
		taskDto.setTaskType("Test");
		taskDto.setTaskStatus(TaskStatus.OPEN);
		taskDto.setCreatedTimestamp(new java.sql.Timestamp(Calendar.getInstance().getTimeInMillis()));
		taskDto.setCreatedUserId("Sunil");
		List<ActionMenuDto> actionMenu = new ArrayList<ActionMenuDto>();
		ActionMenuDto actionMenuDto = new ActionMenuDto();
		actionMenuDto.setLeftClick("LeftClick");
		actionMenuDto.setLeftClick("RightClick");
		actionMenu.add(actionMenuDto);
		taskDto.setActionMenu(actionMenu);
		String jsonInString = mapper.writeValueAsString(taskDto);
		mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/tasks/create").contentType(MediaType.APPLICATION_JSON).content(jsonInString)).andExpect(status().isCreated());

	}
}
