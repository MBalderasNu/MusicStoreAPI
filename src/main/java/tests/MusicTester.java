package tests;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.restassured.http.ContentType;
import restlabpackage.Music;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.sql.Driver;
import java.util.HashMap;
import java.util.Map;


public class MusicTester extends FunctionalTest {

	

	  @Test
	    public void TestMusicPost() {
	        Music artist = new Music();
	        artist.setAlbumname("My Thoughts on You");
	        artist.setArtist("The Band Camino");
	        artist.setReleasedate("4/1/2016");
	        artist.setLabel("N/A");
	        artist.setRating(4.0);
	        artist.setDescription("greatness");
	        artist.setGenre(null);
	        
	        
	        given().pathParam("genreid", 1)
	        .contentType(ContentType.JSON)
	        .body(artist)
	        .when().get("/api/music/{genreid}")
	        .then().statusCode(200);
	    }
	  
	  @Test
	    public void TestMusicPut() {
		  Music artist = new Music();
	        artist.setAlbumname("My Thoughts on You");
	        artist.setArtist("The Band Camino");
	        artist.setReleasedate("4/1/2016");
	        artist.setLabel("N/A");
	        artist.setRating(4.0);
	        artist.setDescription("greatness");
	        
	        

	        given().pathParam("genreid", 1)
	        .contentType(ContentType.JSON)
	        .body(artist)
	        .when().get("/api/music/{genreid}")
	        .then().statusCode(200);
		
	    }
	  
	  
	  @Test
		 public void TestGetMusic() { 
			  given().pathParam("id", 1)
		        .when().get("/api/music/{id}")
		        .then().statusCode(200);
		 }
		 
		 @Test
		 public void TestGetAllMusic() { 
			  given()
		        .when().get("/api/music")
		        .then().statusCode(200);
		 }
		 
	  
	  
//	  @Test
//	    public void TestMusicDelete() {
//	        given().pathParam("id", 1)
//	        .when().delete("/api/music/{id}")
//	        .then().statusCode(200);
//
//	    }
//	  
	  
	  
	  
	  
	  
}
