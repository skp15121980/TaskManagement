package com.ltm.rnd.service;

import com.ltm.rnd.dto.Person;

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
