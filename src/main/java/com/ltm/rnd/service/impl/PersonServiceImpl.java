package com.ltm.rnd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltm.rnd.dao.PersonDao;
import com.ltm.rnd.dto.Person;
import com.ltm.rnd.service.PersonService;

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
