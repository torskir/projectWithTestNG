package example.example.tests;

import example.example.factory.PageinstancesFactory;
import example.example.pages.GooglePage;
import org.testng.annotations.Test;


@Test(testName = "Google search test", description = "Test description")
public class GoogleSearchTest extends BaseTest {


	/**
	 * Google search test.
	 */
	@Test
	public void googleSearchTest() {
		driver.get("https://www.google.co.in/");
		GooglePage googlePage = PageinstancesFactory.getInstance(GooglePage.class);
		googlePage.clickOnAcceptButton();
		googlePage.searchText("abc");
	}
}
