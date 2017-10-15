package com.rnd.task.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.perf4j.StopWatch;
import org.perf4j.log4j.Log4JStopWatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rnd.task.dto.Person;
import com.rnd.task.service.PersonService;

/**
 * @author Skpandey
 *
 */
@RestController
@RequestMapping("/api/v1/persons")
public class PersonController {
	
	@Autowired
	PersonService personService;
	private static final Logger logger = Logger.getLogger(PersonController.class);
	@RequestMapping(value = "/getName", method = RequestMethod.GET)
	public ResponseEntity<?> getNameById(@RequestParam String userId) {
		  StopWatch stopWatch = new Log4JStopWatch("PersonController.getNameById");
		try {
			// StopWatch watchJdbcTemplate = new StopWatch();
			// watchJdbcTemplate.start();
			Person person = personService.getNameById(userId);
			// watchJdbcTemplate.stop();
			// System.out.println("watchJdbcTemplate: " +
			// watchJdbcTemplate.getTotalTimeMillis());
			 logger.info("LTMRestController.getTaskByUserId");
		        stopWatch.stop();
			return ResponseEntity.status(HttpStatus.OK).body(person);
		} catch (Exception e) {
			logger.error("Something went wrong: ", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

		}
	}
}
