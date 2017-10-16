package com.ltm.rnd.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

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
@SpringBootTest(classes = TaskController.class)
//@WebMvcTest(value = TaskController.class, secure=false)
@AutoConfigureMockMvc
@EnableWebMvc
public class TaskControllerTests {

	  private static final String baseUrlTemplate = "/api/v1/tasks";
	@Autowired
	private MockMvc mockMvc;
	String exampleCourseJson = "{\"taskId\":\"46d5471f-9b93-4799-80e5-7a6e372bb8e9\",\"taskType\":\"LTM\",\"taskStatus\":\1,\"createdTimestamp\":\"null\",\"createdUserId\":\"N664895\",\n" + 
			"\"actionMenu\":[{\"rightClick\":\"rightClick\",\"leftClick\":\"leftClick\"}]}";
	/*@Inject
	private WebApplicationContext context;*/

	@MockBean	
	private TaskService taskService;

	@Before
	public void setup() {
		//mockMvc = MockMvcBuilders.webAppContextSetup(context).defaultRequest(get("/")).build();
	}
	 private HttpMessageConverter httpMessageConverter;

	  /*  @Autowired
	    void setupConverter(HttpMessageConverter<?>[] converters) {
	        httpMessageConverter = Arrays.asList(converters).stream()
	                .filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter)
	                .findAny()
	                .orElse(null);
	        assertNotNull(httpMessageConverter);
	    }*/
	@Test
	public void createTask() throws Exception {
		MediaType MEDIA_TYPE_JSON_UTF8 = new MediaType("application", "json", java.nio.charset.Charset.forName("UTF-8"));
		List<ActionMenuDto> actionMenu = new ArrayList<ActionMenuDto>();
		ActionMenuDto actionMenuDto = new ActionMenuDto();
		actionMenuDto.setLeftClick("LeftClick");
		actionMenuDto.setRightClick("RightClick");
		actionMenu.add(actionMenuDto);
		Map<String ,Object > bussinessAttributes= new HashMap<>();
		bussinessAttributes.put("lob", "lob");
		bussinessAttributes.put("collateral", "collateral");
		TaskDto mockTaskDto = new TaskDto(UUID.randomUUID(), "LTM", TaskStatus.OPEN, new Date(), "N664895",
				actionMenu, bussinessAttributes) ;
		Mockito.when(
				taskService.create(
						Mockito.any(TaskDto.class))).thenReturn(mockTaskDto);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/api/v1/tasks/create")
				.accept(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(mockTaskDto))
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.CREATED.value(), response.getStatus());
		/*
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

	*/}
}
