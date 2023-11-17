package example.example.tests;

import example.example.context.WebDriverContext;
import example.example.listeners.LogListener;
import example.example.listeners.ReportListener;
import example.example.util.LoggerUtil;
import example.example.util.TestProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.time.Duration;

@Listeners({ ReportListener.class, LogListener.class })
public class BaseTest {

	/** The driver. */
	protected WebDriver driver;

	public boolean isClicked(WebElement element)
    {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            return true;
        } catch(Exception e){
            return false;
        }
	}

	/**
	 * Global setup.
	 */
	@BeforeSuite(alwaysRun = true)
	public void globalSetup() {

		LoggerUtil.log("************************** Test Execution Started ************************************");
		TestProperties.loadAllPropertie();
	}

	/**
	 * Wrap all up.
	 *
	 * @param context the context
	 */
	@AfterSuite(alwaysRun = true)
	public void wrapAllUp(ITestContext context) {
		int total = context.getAllTestMethods().length;
		int passed = context.getPassedTests().size();
		int failed = context.getFailedTests().size();
		int skipped = context.getSkippedTests().size();
		LoggerUtil.log("Total number of testcases : " + total);
		LoggerUtil.log("Number of testcases Passed : " + passed);
		LoggerUtil.log("Number of testcases Failed : " + failed);
		LoggerUtil.log("Number of testcases Skipped  : " + skipped);
		LoggerUtil.log("************************** Test Execution Finished ************************************");
	}

	/**
	 * Setup.
	 */
	@BeforeClass
	protected void setup() {

//		//chrome
//		System.setProperty("webdriver.fd.driver", Constants.CHROME_DRIVER_PATH);
//
//
//        ChromeOptions ops = new ChromeOptions();
//		ops.addArguments("disable-infobars");
//		driver = new ChromeDriver(ops);
//		driver.manage().window().maximize();
//		WebDriverContext.setDriver(driver);



		// Set the path of GeckoDriver
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\Administrator\\IdeaProjects\\selenium-testng-framework\\src\\test\\resources\\drivers\\geckodriver.exe");

		// Create an object of Firefox Options class
		FirefoxOptions options = new FirefoxOptions();



		// Create an object of WebDriver class and pass the Firefox Options object
		// as an argument
		driver = new FirefoxDriver(options);
				driver.manage().window().maximize();

		WebDriverContext.setDriver(driver);



	}
//	}

	/**
	 * Wrap up.
	 */
	@AfterClass
	public void wrapUp() {
		if (driver != null) {
			driver.close();
		}
	}
}
