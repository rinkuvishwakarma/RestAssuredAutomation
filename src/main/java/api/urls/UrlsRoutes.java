package api.urls;

public class UrlsRoutes {
	
	// SA 
	public static String baseUrl;
	public static String authBaseUrl = "https://auth-dev.ayo4u.com/auth/realms/AYO_ZAF/protocol/openid-connect";
	
	//End point URL
	public static String authURLEndPt = "/token";
	public static String getRateURLEndPt = "/dev/getRates_Ultra";
	public static String postEnrolzEndPt = "/dev/enrollCustomer_Ultra";
	
	//Swagger
	public static String baseURLSwagger = "https://petstore.swagger.io/v2";
	
	public static String createUserEndPoint = baseURLSwagger + "/user";
	public static String getUserEndPoint = baseURLSwagger + "/user/{username}";
	public static String updateUserEndPoint = baseURLSwagger + "/user/{username}";
	public static String deleteUserEndPoint = baseURLSwagger + "/user/{username}";
	public static String addPetEndPoint = baseURLSwagger + "/pet";
	public static String getPetIdEndPoint = baseURLSwagger + "/pet/{petid}";
	
	
	
	public static void envSelection(String environment) {
		
		switch (environment) {
		case "DEV":
			baseUrl = "https://snap-dev-feed.ayo4u.com/api/1/rest/feed-master/queue/aYoDev/apim/zaf-mega";
			break;
			
		case "TEST":
			baseUrl = "https://auth-tst.ayo4u.com";
			break;
		default:
			baseUrl = "https://snap-dev-feed.ayo4u.com/api/1/rest/feed-master/queue/aYoDev/apim/zaf-mega";
			
		}
	}

}
