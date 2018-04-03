package it.alfasoft.utils;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.alfasoft.dao.DaoYard;
import it.alfasoft.model.ModelloVeicolo;
import it.alfasoft.model.Yard;

public class ParserUtility implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(DaoYard.class.getName());

	public ParserUtility() {
		// TODO Auto-generated constructor stub
	}
	
	public static <T> T parseString(String jsonString, Class<T> classType) throws IOException, JsonParseException, JsonMappingException {
		ObjectMapper mapper = new ObjectMapper();
		T userClass = mapper.readValue(jsonString, classType);
		return userClass;
	}
	
	public static <T> String parseObject(T object) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString(object);
		return result.toString();
	}
	
	public static <T> String parseListObject(List<T> listaObject) throws JsonProcessingException {
		String result = "";
		String virgola = ",";
		for(T item : listaObject) { 
		    if(item instanceof Yard ) { 
		    	ObjectMapper mapper = new ObjectMapper();
		    	result = result+mapper.writeValueAsString(item)+virgola;
		    }
		    if(item instanceof ModelloVeicolo ) { 
		    	ObjectMapper mapper = new ObjectMapper();
		    	result = result+mapper.writeValueAsString(item)+virgola;
		    }
		} 
		result="["+result.substring(0, result.length()-1)+"]";
		LOGGER.info("result json--> "+result);
		return result.toString();
	}
}
