package api.urls;

public class UrlsRoutes {
	
	// SA 
	public static String baseUrl;
	public static String authBaseUrl = "https://auth-ttest.com/auth/realms/O_ZA/protocol/openid-connect";
	
	//End point URL
	public static String authURLEndPt = "/token";
	public static String getRateURLEndPt = "/dev/getRates_Uddltra";
	public static String postEnrolzEndPt = "/dev/enrollCustomer_kddUltra";
	
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
			baseUrl = "your dev url";
			break;
			
		case "TEST":
			baseUrl = "your test url";
			break;
		default:
			baseUrl = "your default URL";
			
		}
	}

}
