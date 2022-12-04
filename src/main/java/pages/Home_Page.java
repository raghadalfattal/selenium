package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Home_Page extends BasePage {

	//page URL -> https://eshop.vodafone.com.eg/shop/
	
	// constructor
	public Home_Page(WebDriver driver) {
		super(driver);
	}
	
	//variables
	//locator of English selection
	//private By englishSelection = By.xpath("//span[contains(text(), 'English')]");
	private By englishSelection = By.xpath("//span[text()= 'English']");
	//locator of Apple image
	private By appleSelection = By.xpath("//a[contains(@href, 'Apple')]");
	
	// Select "English"
	public void selectEnglish() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(englishSelection));
		driver.findElement(englishSelection).click();
	}
	
	//click on Apple image after explicit wait
	//it loads new path https://eshop.vodafone.com.eg/shop/shopByBrand/Apple
	public AppleBrandPage clickOnApple() {
		//wait until the Apple icon element is present in the DOM & visible with height & width
		wait.until(ExpectedConditions.visibilityOfElementLocated(appleSelection));
		driver.findElement(appleSelection).click();
		return new AppleBrandPage(driver);
	}
}
