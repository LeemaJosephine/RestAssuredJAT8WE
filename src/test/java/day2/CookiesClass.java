package day2;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;


public class CookiesClass {

	@Test
	public void getCookie() {
		
		Response res = when()
		//when()
			.get("https://www.google.com/");
		
		String cookie = res.getCookie("AEC"); // return a string -> to extract a specific cookie information
			System.out.println("The value for AEC cookie is: " +cookie);
			
			Map<String, String> cookies = res.getCookies(); // to extract list of cookies and it's value
			for(String cookie1 : cookies.keySet()) {
				System.out.println(cookie1+" "+res.getCookie(cookie1));
			}
			
			
//		.then()
//			.log().cookies()
//			.cookie("AEC", "AVYB7crYVixEEK5QMQQWfoWWQ0nLIxuzeIMaVy9HbVpC27wEN2eVJcJFEYM");
//			
		
	}
}
