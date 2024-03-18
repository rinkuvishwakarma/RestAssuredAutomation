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
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SATestcase {
	
	@Test (enabled = true)
	public void getRates() {
		String getRateURL = "https://snap-dev-feed.ayo4u.com/api/1/rest/feed-master/queue/aYoDev/apim/zaf-mega"+UrlsRoutes.getRateURLEndPt;
		
		String tokenCheck = CommonFunctions.auth();
		RequestSpecification request = given()
				.header("x-ebao-tenant-id", "AYO-MTN-ZAF")
				.header("transactionId", CommonFunctions.uuid())
				.header("transactionDate", CommonFunctions.currentDate())
				.header("countryCode", "ZAF")
				.header("Authorization", "Bearer "+tokenCheck)
				.queryParam("coverPeriod", "6")
				.queryParam("productCode", "CARE365MYFAPH");
				
	Response response = request.when()
			.get(getRateURL);
	
	response.then().log().all();
	
	Assert.assertEquals(response.getStatusCode(),HttpStatus.SC_OK);
	
	}
	
	@Test(enabled = true)
	public void enroll() throws JsonParseException, JsonMappingException, IOException {
		
		String jsonFilePath = Constants.PATH_TO_PAYLOAD;
		File jsonData = new File(jsonFilePath);
		String clientMsisdn = CommonFunctions.generateMSISDN();
		String postEnrolURL = "https://snap-dev-feed.ayo4u.com/api/1/rest/feed-master/queue/aYoDev/apim/zaf-mega"+UrlsRoutes.postEnrolzEndPt;
		String tokenCheck = CommonFunctions.auth();
		
		ObjectMapper objectMapper = new ObjectMapper();
		ObjectNode objectNode = objectMapper.readValue(jsonData, ObjectNode.class);
		
		objectNode.with("policyHolder").put("msisdn", clientMsisdn);
		objectNode.with("policyHolder").put("idNumber", "1987-02-12");
		
		RequestSpecification request = given()
				.header("x-ebao-tenant-id","AYO-MTN-ZAF")
				.header("transactionId", CommonFunctions.uuid())
				.header("transactionDate", CommonFunctions.currentDate())
				.header("countryCode", "ZAF")
				.header("Authorization", "Bearer "+tokenCheck)
				.body(objectNode);
		
		System.out.println(request);
		  
		Response response = request.
				when().
				post(postEnrolURL);
				
		response.then()
				.log().all();
        
		
	}
	
	
	
	
	
	
	
	
	

}
