package api.urls;




public class Constants {
	
	/** System */
	public static final String FILE_SEPARATOR = System.getProperty("file.separator");
    public static final String WORK_DIR = System.getProperty("user.dir");
    public static final String OS_NAME = System.getProperty("os.name");
    
    /** Path */
    public static final String PATH_TO_EXTENTREPORT = WORK_DIR + FILE_SEPARATOR + "output" + FILE_SEPARATOR + "reports" + FILE_SEPARATOR;
    public static final String PATH_TO_EXCEL = WORK_DIR + FILE_SEPARATOR + "datasheets" + FILE_SEPARATOR;
    public static final String PATH_TO_PAYLOAD = WORK_DIR + FILE_SEPARATOR +"src/test/resources/Payloads/enrollmentPayload.json";
    public static final String SW_PATH_TO_PAYLOAD = WORK_DIR + FILE_SEPARATOR +"src/test/resources/SwaggerPayload/addPetPayload.json";
    
    /** Excel Name */
    public static final String TESTCASE_EXCEL_NAME = "TestcaseExcel.xlsx";
    public static final String TESTDATA_EXCEL_NAME = "TestdataExcel.xlsx";
    
    /** Sheet Name */
    
    public static final String URL_SHEET = "Url";
    public static final String TESTCASE_SHEET = "Testcase";
    
    /** Credentials */
    public static final String GRANT_TYPE = "client_credentials";
    public static final String CLIENT_ID = "mtn-client";
    public static final String CLIENT_SECRET = "2adf4714-cb7c-4642-a592-4db355091742";

}
