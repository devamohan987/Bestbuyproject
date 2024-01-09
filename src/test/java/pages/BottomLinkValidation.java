package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BottomLinkValidation {
	WebDriver driver;

	@FindBy(linkText = "Accessibility")
	WebElement link1;

	public BottomLinkValidation(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	public void navigateToBottomlink() {
		link1.click();
	}
}
