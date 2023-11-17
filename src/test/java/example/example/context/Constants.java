package example.example.context;

public class Constants {

	/** The Constant WORKING_DIRECTORY. */
	public static final String WORKING_DIRECTORY = System.getProperty("user.dir");

	/** The Constant REPORT_DIRECTORY. */
	public final static String REPORT_DIRECTORY = WORKING_DIRECTORY + "/ExtentReports/AutomationResult.html";

	/** The Constant PROJECT_NAME. */
	public final static String PROJECT_NAME = "My project";

	/** The Constant EXTENT_CONFIG_PATH. */
	public final static String EXTENT_CONFIG_PATH = WORKING_DIRECTORY + "/src/test/resources/config/extent-config.xml";

	/** The Constant CHROME_DRIVER_PATH. */
	public final static String CHROME_DRIVER_PATH = WORKING_DIRECTORY + "/src/test/resources/drivers/chromedriver.exe";

	/** The Constant FIREFOX_DRIVER_PATH. */
	public final static String FIREFOX_DRIVER_PATH = WORKING_DIRECTORY + "/src/test/resources/drivers/geckodriver.exe";

	/** The Constant PROPERTY_FILE_PATH. */
	public final static String PROPERTY_FILE_PATH = WORKING_DIRECTORY + "/src/test/resources/config/test.properties";
}
