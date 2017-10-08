package com.ltm.rnd.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.perf4j.StopWatch;
import org.perf4j.aop.Profiled;
import org.perf4j.log4j.Log4JStopWatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ltm.rnd.dto.TaskDto;
import com.ltm.rnd.service.TaskService;

/**
 * @author Skpandey
 *
 */
@RestController
@RequestMapping("/api/v1/tasks")
public class LTMRestController {
	@Value("${server.port}")
	String accessPortFromProps;
	@Value("${spring.datasource.url}")
	String datasourceUrl;
	// Logger instance
	private static final Logger logger = Logger.getLogger(LTMRestController.class);

	@Autowired
	private TaskService taskService;
	@Profiled(tag ="LTMRestController.create" )
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<?> createTask(@RequestBody TaskDto taskDto) {
		logger.info("Server Port value from Properties file=      " + accessPortFromProps);
		logger.info("Spring.datasource value from Properties file= " + datasourceUrl);
		try {
			TaskDto createdTask = taskService.create(taskDto);
			logger.info("LTMRestController.create");
			return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
		} catch (Exception e) {
			logger.error("Something went wrong: ", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

		}
	}

	@RequestMapping(value = "/getTaskType", method = RequestMethod.GET)
	public ResponseEntity<?> getTaskByUserId(@RequestParam String userId) {
		logger.info("Server Port value from Properties file=      " + accessPortFromProps);
		logger.info("Spring.datasource value from Properties file= " + datasourceUrl);
		StopWatch stopWatch = new Log4JStopWatch("LTMRestController.getTaskByUserId");
		try {
			List<String> taskTypeList = taskService.getByUserId(userId);
			logger.info("LTMRestController.getTaskByUserId");
			stopWatch.stop();
			return ResponseEntity.status(HttpStatus.OK).body(taskTypeList);
		} catch (Exception e) {
			logger.error("Something went wrong: ", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

		}
	}
}
