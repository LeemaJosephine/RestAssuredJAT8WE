package day2;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;



public class PostRequest {

	/* 4 ways to create a request body
	 * 1) using HashMap
	 * 2) using org.json
	 * 3) using POJO class (Plain Java Old Object)
	 * 4) using external json file
	 */
	
	@Test
	public void postJson() {
		
		JSONObject data = new JSONObject();
		data.put("name", "Akash");
		data.put("job", "Mentor");
		
		given()
			.contentType("application/json")
			.body(data.toString())
			
		.when()
			.post("https://reqres.in/api/users")
			
		.then()
			.statusCode(201)
			.body("name", equalTo("Akash"))
			.log().all();
	}
	
	@Test 
	public void postPojo() {
		
		PojoClass obj = new PojoClass();
		obj.setName("Jo");
		obj.setJob("Clerk");
		
		given()
			.contentType("application/json")
			.body(obj)
			
		.when()
			.post("https://reqres.in/api/users")
			
			.then()
				.statusCode(201)
				.body("name", equalTo("Jo"))
				.log().all();
			
	}
	
	@Test
	public void postJsonFile() throws FileNotFoundException {
		
		FileReader fr  = new FileReader("C:\\Users\\Digital Suppliers\\eclipse-workspace\\RestAssuredTest\\src\\test\\java\\day2\\data.json");
		
		JSONTokener jt = new JSONTokener(fr);
		
		JSONObject data = new JSONObject(jt);
		
		given()
			.contentType("application/json")
			.body(data.toString())
			
		.when()
			.post("https://reqres.in/api/users")
			
		.then()
			.statusCode(201)
			.body("name", equalTo("Arun"))
			.log().all();
		
	}
}
