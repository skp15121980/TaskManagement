package com.rnd.task.dao.impl;

import static com.rnd.task.util.LTMSqlQueries.CREATE_MENDATE_SQL;
import static com.rnd.task.util.LTMSqlQueries.CREATE_SQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;
import org.perf4j.StopWatch;
import org.perf4j.aop.Profiled;
import org.perf4j.log4j.Log4JStopWatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rnd.task.dao.TaskDao;
import com.rnd.task.dto.LtmAttributeDto;
import com.rnd.task.dto.TaskDto;
import com.rnd.task.entity.TaskEntity;
import com.rnd.task.util.DBUtil;
/**
 * @author Skpandey
 *
 */
@Repository
public class TaskDaoImpl implements TaskDao {
	protected static String createSql = null;
	
	ObjectMapper objectMapper = new ObjectMapper();
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Profiled(tag="TaskDaoImpl.create")
	@Override
	public TaskEntity create(TaskEntity taskEntity , Map<String, LtmAttributeDto> businessAttributesMetada) {
		 StopWatch stopWatch = new Log4JStopWatch("TaskDaoImpl.create");
		 List<String> substitutedFields = DBUtil.getSQLFieldNames(businessAttributesMetada);
		 List<String> substitutedWildCards = DBUtil.getSQLWildCards(businessAttributesMetada.size());
		 
	
		 
		if(substitutedFields.size() != 0) {
			String sqlWithBusinessAttributes = CREATE_SQL.replace("{FIELDS}", ", " + StringUtils.join(substitutedFields, ", ")).replace("{WILDCARDS}" ,
					", "+ StringUtils.join(substitutedWildCards, ","));
			createSql = CollectionUtils.isEmpty(substitutedFields) ? CREATE_SQL : sqlWithBusinessAttributes;
		}else {
			createSql = CREATE_MENDATE_SQL;
		}
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(createSql,  new String[]{"ID"});
                ps.setString(1, taskEntity.getTaskId().toString());
                ps.setString(2, taskEntity.getTaskType());
                ps.setInt(3, taskEntity.getTaskStatus().getNumericValue());
                ps.setTimestamp(4, new java.sql.Timestamp(Calendar.getInstance().getTimeInMillis()));
                ps.setString(5, taskEntity.getCreatedUserId());
                try {
                	if(taskEntity.getActionMenu() !=null) {
                		ps.setString(6,  objectMapper.writeValueAsString(taskEntity.getActionMenu()));
                	}else {
                		ps.setNull(6, Types.NULL);
                	}
					
				} catch (JsonProcessingException e) {
					e.printStackTrace();
				}
               
                if(businessAttributesMetada.size() !=0) {
                	List<LtmAttributeDto> businessAttributes = businessAttributesMetada.values().stream().collect(Collectors.toList());
                	int index=7;
                	for(LtmAttributeDto metaData : businessAttributes) {
                		ps.setObject(index, businessAttributesMetada.get(metaData.getKey()),DBUtil.getSqType(metaData.getDataType()));
                	}
}
                return ps;
            }
        }, holder);
 
        Number taskId = holder.getKey();
        int generatedID = taskId.intValue();
        System.out.println();
        stopWatch.stop("generatedID : "+generatedID);
        return taskEntity;
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