package com.ltm.rnd;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ltm.rnd.dao.TaskDao;
import com.ltm.rnd.dto.ActionMenu;
import com.ltm.rnd.dto.TaskDto;
import com.ltm.rnd.dto.TaskStatus;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LoanTaskManagerApplication.class)
@AutoConfigureMockMvc
public class LoanTaskManagerApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private MockMvc mockMvc;
	@Autowired
	TaskDao taskDao;

	@BeforeClass
	public static void initAll() {

	}

	String ltmTaskJson = "{\"taskId\":\"ef089fae-4df4-4ac8-8fae-b6eed732ce02\",\"taskType\":\"LTM\",\"taskStatus\":\"NEW\"}";

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
