package com.ltm.rnd.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.perf4j.StopWatch;
import org.perf4j.log4j.Log4JStopWatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ltm.rnd.dao.TaskDao;
import com.ltm.rnd.dto.TaskDto;

@Repository
public class TaskDaoImpl implements TaskDao {
	ObjectMapper objectMapper = new ObjectMapper();
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public TaskDto create(TaskDto taskDto) {
		 StopWatch stopWatch = new Log4JStopWatch("TaskDaoImpl.create");
		final String sql = "insert into LTM_TASK(ID,TASK_ID,TASK_TYPE,TASK_STATUS,CREATED_TIMESTAMP,CREATED_USERID,ACTION_MENU) "
				+ "values(LTM_TASK_SEQ.NEXTVAL,?,?,?,?,?,?)";
		 
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql,  new String[]{"TASK_ID"});
                ps.setString(1, taskDto.getTaskId().toString());
                ps.setString(2, taskDto.getTaskType());
                ps.setInt(3, taskDto.getTaskStatus().getValue());
                ps.setTimestamp(4, new java.sql.Timestamp(Calendar.getInstance().getTimeInMillis()));
                ps.setString(5, taskDto.getCreatedUserId());
                try {
                	if(taskDto.getActionMenu() !=null) {
                		ps.setString(6,  objectMapper.writeValueAsString(taskDto.getActionMenu()));
                	}else {
                		ps.setNull(6, Types.NULL);
                	}
					
				} catch (JsonProcessingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
               
                
                return ps;
            }
        }, holder);
 
        Map<String, Object> taskId = holder.getKeys();
        taskDto.setTaskId(UUID.fromString(taskId.get("TASK_ID").toString()));
        stopWatch.stop();
        return taskDto;
	}
	@Override
	public List<String> getTaskById(String userId) {
		String sql = "SELECT TASK_TYPE FROM Ltm_Task where CREATED_USERID = ?";
		List<String> taskDto  = jdbcTemplate.queryForList(sql, new Object[]{ userId}, String.class);
		return taskDto;
	}
}


/*public void insertBatch(List<SportsBetDimensionsDto> dtos) {  
	   jdbcTemplate.batchUpdate(SQL_INSERT, dtos.stream().map(BeanPropertySqlParameterSource::new).toArray(BeanPropertySqlParameterSource[]::new));  
	 }  */