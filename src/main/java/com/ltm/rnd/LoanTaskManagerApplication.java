package com.ltm.rnd;

import org.perf4j.StopWatch;
import org.perf4j.aop.Profiled;
import org.apache.log4j.Logger;
import org.perf4j.log4j.Log4JStopWatch;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class LoanTaskManagerApplication {
	 private static final Logger logger = Logger.getLogger(LoanTaskManagerApplication.class);
	@Profiled
	public static void main(String[] args) {
		   StopWatch stopWatch = new Log4JStopWatch("main");
		SpringApplication.run(LoanTaskManagerApplication.class, args);
		  logger.info("main");
	        stopWatch.stop();
	}
}
