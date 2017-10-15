package com.rnd.task.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.rnd.task.dao.PersonDao;
import com.rnd.task.dto.Person;

/**
 * @author Skpandey
 *
 */
@Repository
public class PersonDaoImpl implements PersonDao {

	 @Autowired  
	 JdbcTemplate jdbcTemplate;
	 
	
	@Override
	public Person getNameById(String userId) {
		String sql = "SELECT * FROM PERSON where USER_ID = ?";
		Person person = null;
		try {
			person = jdbcTemplate.queryForObject(sql, new Object[]{userId}, new PersonRowMapper());
			System.out.println(person);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		/*Person person = new Person();
		person.setName("Sunil");*/
		return person;
	}

}
 class PersonRowMapper implements RowMapper<Person> {

	@Override
	public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
		Person person = new Person();
		
		person.setName(rs.getString("NAME"));
		person.setUserId(rs.getString("USER_ID"));
		person.setDob(rs.getDate("DOB"));
		person.setDobPlace(rs.getString("DOB_PLACE"));
		return person;
	}

}