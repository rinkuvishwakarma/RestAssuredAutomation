package api.testcases;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.IOException;

import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import api.urls.CommonFunctions;
import api.urls.Constants;
import api.urls.UrlsRoutes;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SwaggerPetTestCase extends CommonFunctions{
	
	ObjectMapper objectMapper;
	long petId;
	
	@Test(priority = 1)
	public void addPetTestCase_01() throws JsonParseException, JsonMappingException, IOException {
		String jsonFilePath = Constants.SW_PATH_TO_PAYLOAD;
		File jsonData = new File(jsonFilePath);
		String petName = generatePetName();
		String petPostURL = UrlsRoutes.addPetEndPoint;
		System.out.println("URL ==== "+petPostURL);
		
		objectMapper = new ObjectMapper();
		ObjectNode payloadBody = objectMapper.readValue(jsonData, ObjectNode.class);
		
		payloadBody.put("name", petName);
		payloadBody.with("category").put("name", petName);
		
		RequestSpecification request = given()
				.header("accept", "application/json")
				.header("Content-Type", "application/json")
				.body(payloadBody);
		
		Response response = request.
				when().
				post(petPostURL);
				
		response.then()
				.log().all();
		
		//Asserting status code
		Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
		
		JsonPath responseBody = response.jsonPath();
        String responseStatusDesc = responseBody.get("status");
        petId = responseBody.get("id");
        //Asserting response body value
        Assert.assertTrue(responseStatusDesc.equalsIgnoreCase("available"));
        
				
	}
	
	//String petId = "234";
	@Test(priority = 2, enabled = true)
	public void getPetByIdTestcase_02() {
		
		System.out.println("getPetByIdTestcase_02 start");
		
		RequestSpecification request = given()
				.header("accept", "application/json")
				.pathParam("petid", this.petId);
		
		Response response = request.
				when()
				.get(UrlsRoutes.getPetIdEndPoint);
				
		response.then()
				.log().all();
		
		
		Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
		
		
	}

}
