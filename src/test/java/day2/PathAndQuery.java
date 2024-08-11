package day2;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class PathAndQuery {

	@Test
	public void pathAndQueryParm() {
		
		given()
			.pathParam("myPath", "users") // routing the url where it should go
			.queryParam("page", "2")  // filtering the data from the server
			
		.when()
			.get("https://reqres.in/api/{myPath}")
			
		.then()
			.statusCode(200)
			.log().all();
	}
}
