package com.rnd.task.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.rnd.task.dao.TaskMetaDataDao;
import com.rnd.task.entity.LTMAttributeEntity;
import com.rnd.task.util.LTMSqlQueries;

/**
 * @author Skpandey
 *
 */
@Repository
public class TaskMetaDataDaoImpl implements TaskMetaDataDao {

	@Autowired
	private JdbcTemplate jdbcTempalte;
	@Override
	public List<LTMAttributeEntity> getTaskTypeMetaData(String taskType) {
		return jdbcTempalte.query(LTMSqlQueries.SELECT_TASK_TYPE, new String[] {taskType,taskType},new MetaDataRowMapper());
	}

	class MetaDataRowMapper implements RowMapper<LTMAttributeEntity>{

		@Override
		public LTMAttributeEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
			LTMAttributeEntity entity = new LTMAttributeEntity();
			entity.setId(rs.getInt("ID")); 
			entity.setKey(rs.getString("UI_KEY"));
			entity.setType(rs.getInt("ATTRIBUTE_TYPE"));
			entity.setField(rs.getString("DB_COLUMN"));
			entity.setLabel(rs.getString("UI_LABEL"));
			entity.setDataType(rs.getString("DATA_TYPE"));
			return entity;
		}
	}

	@Override
	public List<LTMAttributeEntity> getAttributesMetaData() {
		return jdbcTempalte.query(LTMSqlQueries.GET_ATTRIBUTE_SQL, new MetaDataRowMapper());
	}

}
