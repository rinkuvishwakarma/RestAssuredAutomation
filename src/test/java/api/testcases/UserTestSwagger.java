package api.testcases;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.payload.UserPayload;
import api.urls.UrlsRoutes;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class UserTestSwagger {
	
	Faker fakeData;
	UserPayload userPayload;
	
	@BeforeClass
	public void generateTestData() {
		fakeData = new Faker();
		userPayload = new UserPayload();
		
		userPayload.setId(fakeData.idNumber().hashCode());
		userPayload.setUsername(fakeData.name().username());
		userPayload.setFirstName(fakeData.name().firstName());
		userPayload.setLastName(fakeData.name().lastName());
		userPayload.setEmail(fakeData.internet().safeEmailAddress());
		userPayload.setPassword(fakeData.internet().password(5,10));
		userPayload.setPhone(fakeData.phoneNumber().cellPhone());
	}
	
	@Test(enabled = true, priority = 1)
	public void testCreateUser() {
		
		Response response = given()
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.body(userPayload)
				
				.when()
				.post(UrlsRoutes.createUserEndPoint);
		
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(enabled = true, priority = 2)
	public void testGetUser() {
		
		
		Response response = given()
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.pathParam("username", this.userPayload.getUsername())
				
				.when()
				.get(UrlsRoutes.getUserEndPoint);
		
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(enabled = true, priority = 3)
	public void testUpdateUser(){
		userPayload.setFirstName(fakeData.name().firstName());

		Response response = given()
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.pathParam("username", this.userPayload.getUsername())
				.body(userPayload)
				
				
				.when()
				.put(UrlsRoutes.updateUserEndPoint);
		//log response
		response.then().log().all();

		//validation
		Assert.assertEquals(response.getStatusCode(),200);

		//Read User data to check if first name is updated 
		Response responsePostUpdate = given()
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.pathParam("username", this.userPayload.getUsername())
				
				.when()
				.get(UrlsRoutes.getUserEndPoint);

		System.out.println("After Update User Data.");
		responsePostUpdate.then().log().all();

	}
	
	@Test(enabled = true, priority = 4)
	public void testDeleteUser(){

		System.out.println("Delete User Data "+this.userPayload.getUsername());
		
		Response response = given()
				.accept(ContentType.JSON)
				.pathParam("username", this.userPayload.getUsername())
					
				
				.when()
				.delete(UrlsRoutes.deleteUserEndPoint);

		//log response
		response.then().log().all();

		//validation
		Assert.assertEquals(response.getStatusCode(),200);
		
	}
	
}
