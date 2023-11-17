package example.example.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePage extends BasePage {


	/** The searchinput. */
	@FindBy(name = "q")
	public WebElement searchinput;

	@FindBy(xpath = "//*[@id='L2AGLb']")
	private WebElement acceptBut;


	/**
	 * Instantiates a new google page.
	 *
	 * @param driver the driver
	 */
	public GooglePage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Searches the given text.
	 *
	 * @param key the key
	 */


	public void searchText(String key) {
		searchinput.sendKeys(key + Keys.ENTER);
	}

	public void clickOnAcceptButton() {
		acceptBut.click();
	}

}
