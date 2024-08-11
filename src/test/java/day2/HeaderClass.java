package day2;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class HeaderClass {

	@Test
	public void validateHeader() {
		
		when()
			.get("https://www.google.com/")
			
		.then()
			.log().all()
			.header("Content-Type","text/html; charset=ISO-8859-1")
			.and()
			.header("Content-Encoding", "gzip");

	}
	
	@Test
	public void getHeaderInfo() {
		
		Response res = when()
			.get("https://www.google.com/");
		
//		String header = res.getHeader("Content-Type");
//		System.out.println(header);
		
		Headers headers = res.getHeaders();
		for(Header header1 : headers) {
			System.out.println("Header name : "+ header1.getName());
			System.out.println("Header value : " +header1.getValue());
		}
	}
	
	
}
