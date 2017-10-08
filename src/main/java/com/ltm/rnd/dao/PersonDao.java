package com.ltm.rnd.dao;

import com.ltm.rnd.dto.Person;

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
