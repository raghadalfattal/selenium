package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//subclass
public class HomePage extends BasePage {
	//variables
	private By languageSelection = By.xpath("//span[contains(text(), 'English')]");
	//h2 text "Shop by brand"
	//a id shopByBrandCard
	//ul class brandContainer-brands-list utag--brands
	private By appleSelection = By.xpath("//a[contains(@href, 'Apple')]");
	private By shopByBrandScroll = By.xpath("//h2[contains(text(), 'Shop by brand')]");
	//class="backgroundMobile brandContainer-brands margin-btm container"
	private By divLocation = By.xpath("//div[@class='backgroundMobile brandContainer-brands margin-btm container']");
	private By appleDevice = By.xpath("//a[@sec_uuid= '267ff7478631']");
	//span[text()='Watch Series 7 GPS, 45mm Green'][1]

	//constructor
	public HomePage(WebDriver driver) {
		super(driver);
	}
	

	//Select English language for the website
	public void selectLanguage() {
		driver.findElement(languageSelection).click();
	}
	
	//scroll homepage
	// in js function has arguments which is array of object
	//arguments[0] is the first item of the object
	public void scroll() {
		WebElement applePlace = driver.findElement(divLocation);
		//JavascriptExecutor js = (JavascriptExecutor) driver;
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", applePlace);
		//String script = "arguments[0].scrollIntoView(true); window.scrollBy(0, -30);";
		//js.executeScript(script, applePlace);			
	}
	
	//Click on Apple image
	public void clickOnApple() {
		driver.findElement(appleSelection).click();
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(appleDevice)));
	}
	
	//click on apple device
//	public void clickOndevice() {
//		
//		driver.findElement(appleDevice).click();
//	}
}
