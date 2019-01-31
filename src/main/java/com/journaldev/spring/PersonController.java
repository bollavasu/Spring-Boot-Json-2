package com.journaldev.spring;

import java.io.File;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class PersonController {
	
	@RequestMapping("/")
	public String healthCheck() {
		javaToJson();
		javaToJsonPrettyPrint();
		javaToJsonFile();
		jsonToJava();
		return "Converted Successfully...";
	}
	
	public void javaToJson() {
		try {
			Person person = new Person();		
			person.setName("Peter");
			person.setSal("20000");
			person.setAge("25");
			person.setAddress("Hyderabad");
			person.setPhoneNumber("9000080000");
			
			ObjectMapper mapper = new ObjectMapper();
	
			String json = mapper.writeValueAsString(person);
			System.out.println("JSON String : " + json);
			
		}catch (Exception e) {
	        e.printStackTrace();
	    }	
	}
	
	public void javaToJsonPrettyPrint() {
		try {
			Person person = new Person();		
			person.setName("Peter");
			person.setSal("20000");
			person.setAge("25");
			person.setAddress("Hyderabad");
			person.setPhoneNumber("9000080000");
			
			ObjectMapper mapper = new ObjectMapper();
	
			String prettyPrinterJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(person);
			System.out.println("JSON Pretty Print : " + prettyPrinterJson);
			
		}catch (Exception e) {
	        e.printStackTrace();
	    }	
	}
	
	public void javaToJsonFile() {
		try {
			Person person = new Person();		
			person.setName("Peter");
			person.setSal("20000");
			person.setAge("25");
			person.setAddress("Hyderabad");
			person.setPhoneNumber("9000080000");
			
			ObjectMapper mapper = new ObjectMapper();
	
			mapper.writeValue(new File("C:\\Output\\Person.json"), person);
			
		}catch (Exception e) {
	        e.printStackTrace();
	    }	
	}
	
	public void jsonToJava() {
		try {
            String jsonStr = "{\"name\":\"Peter\",\"sal\":\"20000\",\"age\":\"25\",\"address\":\"Hyderabad\",\"phoneNumber\":\"9000080000\"}";	
            ObjectMapper mapper = new ObjectMapper();
            Person person = mapper.readValue(jsonStr, Person.class);
            System.out.println("Person POJO 1 : " + person);
 		}catch (Exception e) {
	        e.printStackTrace();
	    }	
	}
	
}
