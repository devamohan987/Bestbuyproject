package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;

	@FindBy(xpath = "//div[@lang='en']//img[@alt='United States']")
	WebElement country;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public HomePage openHomePage(String url) {
		driver.get(url);
		country.click();
		return this;
	}
	
}
