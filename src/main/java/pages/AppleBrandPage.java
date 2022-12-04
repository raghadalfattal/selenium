package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AppleBrandPage extends BasePage{

	//page URL -> https://eshop.vodafone.com.eg/shop/shopByBrand/Apple
	
	//constructor
	public AppleBrandPage(WebDriver driver) {
		super(driver);
	}
	
	//variables
	private By appleDevice = By.xpath("//span[text()='Watch Series 7 GPS, 45mm Green'][1]");

	
	//select first Apple device after explicit wait
	public AddToBasket selectAppleDevice() throws InterruptedException {
		//wait until the Apple device element is present in the DOM & visible with height & width
		wait.until(ExpectedConditions.visibilityOfElementLocated(appleDevice));
		
		//Thread.sleep(10000);
		//wait.until(ExpectedConditions.elementToBeClickable(appleDevice));
		//wait.until(ExpectedConditions.presenceOfElementLocated(appleDevice));
		driver.findElement(appleDevice).click();
		return new AddToBasket(driver);
	}
}
