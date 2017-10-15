package com.ltm.rnd;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import com.rnd.task.LoanTaskManagerApplication;
import com.rnd.task.dto.ActionMenuDto;
import com.rnd.task.dto.TaskDto;
import com.rnd.task.dto.TaskStatus;

/**
 * @author Skpandey
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = LoanTaskManagerApplication.class)
@AutoConfigureMockMvc
public class LoanTaskManagerApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private MockMvc mockMvc;
	

	@BeforeClass
	public static void initAll() {

	}

	String ltmTaskJson = "{\"taskId\":\"ef089fae-4df4-4ac8-8fae-b6eed732ce02\",\"taskType\":\"LTM\",\"taskStatus\":\"NEW\"}";

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
