package example.example.tests;

import example.example.factory.PageinstancesFactory;
import example.example.pages.FacebookLoginPage;
import org.testng.annotations.Test;

@Test(testName = "Facebook login test", description = "Facebook login test")
public class FaceBookLoginTest extends BaseTest {

	@Test
	public void facebookLoginTest() {
		driver.get("https://www.facebook.com/");
		FacebookLoginPage facebookLoginPage = PageinstancesFactory.getInstance(FacebookLoginPage.class);
		facebookLoginPage.clickAcceptcookieButton();

		facebookLoginPage.enterEmail("testrrrr").enterPassword("testcccc").clickSignIn();
	}
}
