package com.rnd.task.service;

import com.rnd.task.dto.Person;

/**
 * @author Skpandey
 *
 */
public interface PersonService {
 /**
 * @param userId
 * @return
 */
public Person getNameById(String userId);
}
