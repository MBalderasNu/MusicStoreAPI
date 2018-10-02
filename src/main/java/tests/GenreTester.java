package tests;

import static io.restassured.RestAssured.given;

import org.junit.Test;

import io.restassured.http.ContentType;
import restlabpackage.Genre;



public class GenreTester extends FunctionalTest {

	
	 @Test
	    public void testGenrePost() {
	        Genre genre = new Genre();
	        genre.setName("rock");

	        given()
	        .contentType(ContentType.JSON)
	        .body(genre)
	        .when().post("/api/genre")
	        .then().statusCode(200);
	    }
	 
	 
	 @Test
	    public void testGenrePut() {
		 Genre genre = new Genre();
	        genre.setName("indie");

	        given()
	        .contentType(ContentType.JSON)
	        .body(genre)
	        .when().post("/api/genre")
	        .then().statusCode(200);
	        
	    }
	 

	 @Test
	 public void testGenreGet() { 
		  given().pathParam("id", 1)
	        .when().get("/api/genre/{id}")
	        .then().statusCode(200);
	 }
	 
	 @Test
	 public void testGenreGetAll() { 
		  given()
	        .when().get("/api/genre")
	        .then().statusCode(200);
	 }
	 

//	 @Test
//	    public void testGenreDelete() {
//	        given().pathParam("id", 11)
//	        .when().delete("/api/genre/{id}")
//	        .then().statusCode(200);
//
//	    }
	  
	 
}
