package com.rnd.task.config;

import org.perf4j.slf4j.aop.TimingAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author Skpandey
 *
 */
@Configuration
@EnableAspectJAutoProxy
public class PerformanceConfig {
    @Bean
    public TimingAspect timingAspect() {
        return new TimingAspect();
    }
}
