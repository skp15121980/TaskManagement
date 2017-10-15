package com.rnd.task.util;

import static com.rnd.task.enums.TaskAttributeType.*;

import java.sql.SQLType;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.rnd.task.dto.LtmAttributeDto;
import com.rnd.task.dto.TaskDto;
public class DBUtil {

	public static Map<String, LtmAttributeDto> getBusinessAttributesByKey(List<LtmAttributeDto> metaDataDtos) {
		return metaDataDtos.stream().filter(metaDataDto -> BUSINESS.getNumericValue() == metaDataDto.getType()).
				collect(Collectors.toMap(LtmAttributeDto :: getKey, Function.identity()));
	}

	public static List<String> getSQLFieldNames(Map<String, LtmAttributeDto> businessAttributesMetada) {
		return businessAttributesMetada.values().stream().map(LtmAttributeDto :: getField).collect(Collectors.toList());
	}

	public static List<String> getSQLWildCards(final int count) {
		List<String> wildCardList = new ArrayList<String>(count);
		IntStream.range(0,count).forEach(i ->{wildCardList.add(i,"?");});
		return wildCardList;
	}

	public static Map<String, Object> buildDynamicFields(TaskDto taskDto,Map<String, LtmAttributeDto> businessAttributesMetada) {
		Map<String, Object> businessAttributesMap = taskDto.getBussinessAttributes();
		return null;
	}

	public static Integer getSqType(String dataType) {
		switch(dataType) {
		case "NUMBER" :
			return Types.NUMERIC;
		
		case "VARCHAR":
			return Types.VARCHAR;
		case "TIMESTAMP":
			return Types.TIMESTAMP;
			
		}
		return Types.VARCHAR;
	}

	
}
