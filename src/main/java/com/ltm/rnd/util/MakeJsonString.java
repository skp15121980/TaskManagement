package com.ltm.rnd.util;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObjectBuilder;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.junit.Ignore;

import com.ltm.rnd.dto.TaskStatus;


@Ignore
 public class MakeJsonString {
	public static void main(String[] args) {

		String prettyJsonString = null;
		ObjectMapper mapper = new ObjectMapper();
		ObjectWriter prettyPrinter = mapper.writerWithDefaultPrettyPrinter();

		try {
			JsonNode rootNode = mapper.readTree(makeJsonString());
			prettyJsonString = prettyPrinter.writeValueAsString(rootNode);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(makeJsonString());
		System.out.println(prettyJsonString);
	}

	public static String makeJsonString() {

		String resultString = null;

		try {
			Map<String, String> keyValueMap = new HashMap<String, String>();
			JsonBuilderFactory factory = Json.createBuilderFactory(keyValueMap);
			JsonObjectBuilder obj_1 = factory.createObjectBuilder();
			JsonObjectBuilder actionMenu = factory.createObjectBuilder();
			JsonObjectBuilder obj_3 = factory.createObjectBuilder();
			JsonObjectBuilder obj_4 = factory.createObjectBuilder();
			JsonArrayBuilder ab = factory.createArrayBuilder();
			//TimeZone timeZone = TimeZone.getTimeZone("UTC");
			TimeZone timeZone = TimeZone.getDefault();
			 Calendar tempCal = Calendar.getInstance(timeZone);
			 obj_1.add("taskId", UUID.randomUUID().toString());
			 obj_1.add("taskType", "LTM");
			 obj_1.add("taskStatus", TaskStatus.NEW.name());
			 obj_1.add("createdTimestamp", "null");
			 obj_1.add("createdUserId", "N664895");
			 actionMenu.add("rightClick", "rightClick");
			 actionMenu.add("leftClick", "leftClick");
			 ab.add(actionMenu);
			 obj_1.add("actionMenu", ab);
			 
			resultString = obj_1.build().toString();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return resultString;
	}
}