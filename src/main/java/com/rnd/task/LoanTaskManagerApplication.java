package com.rnd.task;

import org.perf4j.StopWatch;
import org.perf4j.aop.Profiled;
import org.apache.log4j.Logger;
import org.perf4j.log4j.Log4JStopWatch;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author Skpandey
 *
 */
@EnableCaching
@SpringBootApplication
public class LoanTaskManagerApplication {
	 private static final Logger logger = Logger.getLogger(LoanTaskManagerApplication.class);
	@Profiled(tag = "LoanTaskManagerApplication.main")
	public static void main(String[] args) {
		SpringApplication.run(LoanTaskManagerApplication.class, args);
		  logger.info("main");
	}
}
