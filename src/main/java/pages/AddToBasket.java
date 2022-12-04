package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddToBasket extends BasePage {
	//page URL -> https://eshop.vodafone.com.eg/shop/productDetails/Watch-Series-7-GPS-45mm-Green
	
	public AddToBasket(WebDriver driver) {
		// constructor
		super(driver);
	}
	
	//variables
	private By addToBasketBtn = By.xpath("//div[@class=\"addToBasket-btn\"]/button[text()=\"Add to basket\"]");
	
	
	//click on AddToBasket button
	public ProceedToCheckout clickOnAddToBasket() throws InterruptedException {
		//Thread.sleep(10000);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(addToBasketBtn));
		driver.findElement(addToBasketBtn).click();
		return new ProceedToCheckout(driver);
	}
}
