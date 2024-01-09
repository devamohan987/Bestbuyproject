package test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.BottomLinkValidation;
import pages.CheckOutPage;
import pages.HomePage;
import pages.MenuTitles;
import pages.PaymentPage;
import pages.ShoppingCart;
import pages.SigningPage;

public class TC001_BestBuy {

	public WebDriver driver;
	HomePage homePage;
	CheckOutPage checkoutPage;
	SigningPage signin;
	BottomLinkValidation bottomlink;
	MenuTitles menunavigation;
	ShoppingCart shoppingcart;
	CheckOutPage checkout;
	PaymentPage placeorder;

	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();

		// Initialize FirefoxDriver
		driver = new ChromeDriver();
		
		homePage = new HomePage(driver);
		signin = new SigningPage(driver);
		bottomlink = new BottomLinkValidation(driver);
		menunavigation = new MenuTitles(driver);
		shoppingcart = new ShoppingCart(driver);
		checkoutPage = new CheckOutPage(driver);
		placeorder = new PaymentPage(driver);

		// Maximize the browser window
		driver.manage().window().maximize();

		// Initialize WebDriverWait with a timeout of 30 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Test(priority = 1)
	public void openHomePage() {

		homePage.openHomePage("https://www.bestbuy.com/");

	}

	@Test(priority = 2)
	public void signUp() {
		signin.signUp("deva2007@gmail.com", "deva@2005_abc");

	}

	@Test(priority = 3)
	public void navigateToAllMenuAndValidateTitle() {

		menunavigation.navigateToMenu1();

		// Add validation logic for the title ofthe page
		assert driver.getTitle().contains("Deal of the Day: Electronics Deals - Best Buy")
				: "Title validation failed for Deal of the day page.";

		menunavigation.navigateToMenu4();
		assert driver.getTitle().contains("Best Buy Credit Card: Rewards & Financing")
				: "Title validation failed for page 4.";

		menunavigation.navigateToMenu2();
		assert driver.getTitle().contains("Best Buy Black Friday 2023 Deals") : "Title validation failed for page 2.";

		menunavigation.navigateToMenu3();
		assert driver.getTitle().contains("My Best Buy Memberships") : "Title validation failed for page 3.";

	}

	@Test(priority = 4)
	public void validateLink1() {
		bottomlink.navigateToBottomlink();

		// bottomlinkvalidation logic for the title of the page
		assert driver.getTitle().contains("Accessibility - Best Buy") : "BottomLink validation failed.";
	}

	@Test(priority = 5)
	public void SearchItem() {

		shoppingcart.searchAndAddToCart("smart watch Apple");
	}

	@Test(priority = 6)
	public void selectItemFromShopByDepartment() {

		shoppingcart.selectItemFromShopByDepartment();
	}

	@Test(priority = 7)
	public void selectItemFromBrands() {

		shoppingcart.selectItemFromBrands();
	}

	@Test(priority = 8)
	public void filloutchectoutpage() {
		checkoutPage.fillOutForm("Deva", " M", "mohan", "chennai", "600024");
		checkoutPage.scheduledelivery("devamohan2002@gmail.com", "6369942666");
	}

	@Test(priority = 9)
	public void VerifyOrderPlacement() {

		placeorder.placeyourorder("6978 5403 4327 9160");

		// the invalid card details message is displayed on the same page
		assert placeorder.getInvalidCardDetailsMessage().contains("Invalid card details")
				: "Invalid card details message not displayed.";
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
}
