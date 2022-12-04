package tests;

//import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
//import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

//import pages.AddToBasket;

public class RegistrationTest extends BaseTest {
	@Test
	public void register() throws InterruptedException {
		home_page.selectEnglish();
		appleBrandPage = home_page.clickOnApple();
		addToBasket = appleBrandPage.selectAppleDevice();
		proceedToCheckout = addToBasket.clickOnAddToBasket();
		checkout = proceedToCheckout.clickOnProceedToCheckout();
		checkout.selectCheckoutDelivery();
		checkout.clickOnDeliver();
		checkout.fillAddress("123 Test St.", 100, 3, 12, "Test Address");
		checkout.clickOnContinue();
		checkout.clickOnPersonalInfoContinue();
		Assert.assertEquals(checkout.getInvalidNameError(), "Please enter a valid name");
		//homepage.scroll();
	}
	
//	@Test
//	public void scrollwithJS() {
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("scrollBy(0,1000)");
//		
////		Assert.assertTrue(.isDisplayed());
//	}
	
//	@Test(priority = 1, dependsOnMethods = {"clickOnEnglish"})
//	public void clickOnApple() {
//		homepage.clickOnApple();
//		//homepage.clickOndevice();
//	}

}
