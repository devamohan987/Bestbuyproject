package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuTitles {

	@FindBy(linkText = "Deal of the Day")
	WebElement dealoftheday;

	@FindBy(linkText = "Black Friday Deals")
	WebElement blackfriday;

	@FindBy(linkText = "My Best Buy Memberships")
	WebElement mybestbuy;

	@FindBy(linkText = "Credit Cards")
	WebElement creditcard;

	public MenuTitles(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void navigateToMenu1() {
		dealoftheday.click();
	}

	public void navigateToMenu4() {
		creditcard.click();
	}

	public void navigateToMenu2() {
		blackfriday.click();
	}

	public void navigateToMenu3() {
		mybestbuy.click();
	}
	
}
