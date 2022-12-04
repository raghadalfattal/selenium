package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProceedToCheckout extends BasePage {
	//page URL -> https://eshop.vodafone.com.eg/shop/Shopping-Cart/491
	
	public ProceedToCheckout(WebDriver driver) {
		// constructor stub
		super(driver);
	}
	
	//variables
	private By proceedToCheckoutBtn = By.xpath("//button[text()=\"Proceed to Checkout \"]");
	
	//click on proceedtocheckout button
	public CheckoutPage clickOnProceedToCheckout() throws InterruptedException {
		//Thread.sleep(10000);
		//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(proceedToCheckoutBtn));
		wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutBtn));
		driver.findElement(proceedToCheckoutBtn).click();
		return new CheckoutPage(driver);
	}
	
}
