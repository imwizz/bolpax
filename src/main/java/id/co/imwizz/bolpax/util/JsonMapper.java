package id.co.imwizz.bolpax.util;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;

/**
 * Helper to map json to java object or otherwise
 *
 * @author Sangbas
 */
public class JsonMapper<T> {
	
	protected Class<T> persistentClass;
	
	public JsonMapper() {
	}
	
	public JsonMapper (Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}
	
	public static <T> String fromObjectToJson(T object) {
		ObjectMapper mapper = new ObjectMapper();
		String json = null;
		try {
			json = mapper.writeValueAsString(object);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
		return json;
	}
	
	public static <T> String fromObjectListtoJsonArray(List<T> objects) {
		ObjectMapper mapper = new ObjectMapper();
		String jsonArray = null;
		try {
			jsonArray = mapper.writeValueAsString(objects);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
		return jsonArray;
	}
	
	public T fromJsonToObject(String jsonInput) {
		ObjectMapper mapper = new ObjectMapper();
		JavaType type = mapper.getTypeFactory().constructType(persistentClass);
		T myObjects = null;
		try {
			myObjects = mapper.readValue(jsonInput, type);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return myObjects;
	}
	
	public List<T> fromJsonArrayToObjectList(String jsonInput) {
		ObjectMapper mapper = new ObjectMapper();
		JavaType type = mapper.getTypeFactory().constructCollectionType(List.class, persistentClass);
		List<T> myObjects = null;
		try {
			myObjects = mapper.readValue(jsonInput, type);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return myObjects;
	}
	
	
//	public static void main(String[] args) {
//		TransactionReq trs = new TransactionReq();
//		trs.setAmount(2000.00);
//		trs.setMerchantId(2);
//		trs.setUserId(2);
//		trs.setProduct("sabun");
//		
//		System.out.println(fromObjectToJson(trs));
//	}
}
