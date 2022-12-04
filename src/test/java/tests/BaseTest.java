package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.AddToBasket;
import pages.AppleBrandPage;
import pages.CheckoutPage;
//import pages.HomePage;
import pages.Home_Page;
import pages.ProceedToCheckout;

public class BaseTest {
	//variables
	WebDriver driver;
	Home_Page home_page;
	AppleBrandPage appleBrandPage;
	AddToBasket addToBasket;
	ProceedToCheckout proceedToCheckout;
	CheckoutPage checkout;

	@BeforeClass
	public void Start() {
		String path = "resources/chromedriver.exe";
		String url = "https://eshop.vodafone.com.eg/shop/";
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		home_page = new Home_Page(driver);
	}

	@AfterClass
	public void close() {
		driver.quit();
	}

}
