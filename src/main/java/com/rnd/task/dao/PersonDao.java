package com.rnd.task.dao;

import com.rnd.task.dto.Person;

/**
 * @author Skpandey
 *
 */
public interface PersonDao {
/**
 * @param userId
 * @return
 */
public Person getNameById(String userId);
}
