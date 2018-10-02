package tests;

import static io.restassured.RestAssured.given;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Base64;

import javax.imageio.ImageIO;

import org.junit.Test;



import io.restassured.http.ContentType;
import restlabpackage.Picture;

public class PictureTester extends FunctionalTest {
	
	@Test
	public void testPicturePost() {
		Picture picture = new Picture();
		picture.setName("Tester");
		
		
		try{ 
			BufferedImage image = ImageIO.read(new File("C:/Users/MatthewBalderas/eclipse-workspace/RestLab/src/main/resources/download.jpg")); 
			ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
			ImageIO.write(image, "jpg", baos); 
			byte[] res = baos.toByteArray(); 
			String encodedImage = Base64.getEncoder().encodeToString(res);
			picture.setSource(encodedImage);
			} 
		catch(Exception e) { 
			e.printStackTrace(); 
		}

		given().contentType(ContentType.JSON)
		.body(picture)
		.when()
		.post("/api/picture")
		.then().statusCode(200);
	}

//	@Test
//	public void testPicturePut() {
//		Picture picture = new Picture();
//		picture.setName("Tester");
//		picture.setSource("http://testcreative.co.uk/wp-content/uploads/2017/10/Test-Logo-Small-Black-transparent-1.png");
//
//		given().contentType(ContentType.JSON)
//		.body(picture)
//		.when()
//		.post("/api/picture")
//		.then().statusCode(200);
//
//	}

	@Test
	public void testPictureGet() {
		given().pathParam("id", "1")
		.when()
		.get("/api/picture/{id}")
		.then().statusCode(200);
	}

	@Test
	public void testPictureGetAll() {
		given()
		.when()
		.get("/api/picture")
		.then().statusCode(200);
	}

	// @Test
	// public void testGenreDelete() {
	// given().pathParam("id", 11)
	// .when().delete("/api/genre/{id}")
	// .then().statusCode(200);
	//
	// }
  

}
