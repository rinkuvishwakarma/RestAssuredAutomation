package api.urls;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import com.github.javafaker.Faker;


public class CommonFunctions {
	
	public String generatePetName() {
		Faker random = new Faker();
		String petName = random.name().firstName();
		return petName;
	}
	
	public static String generateMSISDN() {
		
		StringBuffer clientMSISDN = new StringBuffer();
		Random random = new Random();
    	long numbers = 100000000L + (long)(random.nextDouble() * 99999999L);
    	clientMSISDN.append("27");
    	String nineNumber = String.valueOf(numbers);
    	clientMSISDN.append(nineNumber);
    	return clientMSISDN.toString();
	}
	
	public static String uuid() {
		UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();
        return uuidAsString;
	}
	
	public static String currentDate() {
		 String CurrDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
		 return CurrDate;
	}
	
	public static String sAIdNumber(String dob) {
		
        String dobString = dob.replaceAll("[\\s\\-()]", "").substring(2);
        StringBuffer sb = new StringBuffer();
        Random r = new Random();  
    	long sevenNumber = 10000000L + (long)(r.nextDouble() * 999999L);
    	sb.append(dobString);
    	sb.append(sevenNumber);
    	
    	String strIdNumber = sb.toString();
    	
		return strIdNumber;
		
	}
	
	public static String auth() {
		String token = "";
		
				Response response = given()
				.baseUri(UrlsRoutes.authBaseUrl)
                .contentType("application/x-www-form-urlencoded")
                .formParam("grant_type", "client_credentials")
                .formParam("client_id", "mtnttng-client")
                .formParam("client_secret", "2adf4723314-cb7c-4642-a592-4db355066491742")
				
				.when()
				.post(UrlsRoutes.authURLEndPt);
		
		 token = response.jsonPath().getString("access_token");
		 return token;
	}
	
	
	

}
