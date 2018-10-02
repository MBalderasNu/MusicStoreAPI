package tests;

import static io.restassured.RestAssured.given;

import org.junit.Test;

import io.restassured.http.ContentType;
import restlabpackage.User;

public class UserTester extends FunctionalTest {
	
	
	 @Test
	    public void TestUserPost() {
	        User user = new User();
	        user.setUsername("mbalderas");
	        user.setPassword("1234");
	       
	        given()
	        .contentType(ContentType.JSON)
	        .body(user)
	        .when().post("/api/users")
	        .then().statusCode(200);
	    }
	 
	 @Test
	    public void TestUserPut() {
		 	User user = new User();
	        user.setUsername("mbalderas");
	        user.setPassword("1234");
	       
	        given()
	        .contentType(ContentType.JSON)
	        .body(user)
	        .when().post("/api/users")
	        .then().statusCode(200);
	        
	    }
	 
	 
	 
	 @Test
	 public void TestGetUser() { 
		  given().pathParam("id", 1)
	        .when().get("/api/users/{id}")
	        .then().statusCode(200);
	 }
	 
	 @Test
	 public void TestGetAllUsers() { 
		  given()
	        .when().get("/api/users")
	        .then().statusCode(200);
	 }
	 
	 
	 
//	 @Test
//	    public void TestUserDelete() {
//	        given().pathParam("id", 1)
//	        .when().delete("/api/users/{id}")
//	        .then().statusCode(200);
//
//	    }
//	  

}
