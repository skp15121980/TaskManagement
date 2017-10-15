package com.rnd.task.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rnd.task.dao.PersonDao;
import com.rnd.task.dto.Person;
import com.rnd.task.service.PersonService;

/**
 * @author Skpandey
 *
 */
@Service
public class PersonServiceImpl implements PersonService{
	
 @Autowired
 PersonDao personDao;
 
	@Override
	public Person getNameById(String userId) {
		Person person=personDao.getNameById(userId);
		return person;
	}

}
