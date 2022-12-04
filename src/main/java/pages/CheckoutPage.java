package pages;

import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage {
	//page URL -> https://eshop.vodafone.com.eg/shop/checkout

	//constructor
	public CheckoutPage(WebDriver driver) {
		super(driver);
	}
	
	//variables
	//private By citySelect = By.xpath("//select[@class=\"btn dropdown-toggle checkout-dropdown border-radius_Style checkoutDeliveryFamilyFont\"]");
	private By citySelect = By.xpath("//div[contains(@class,'checkout-dropdownCity')]/select");
	//private By districtSelect = By.xpath("//select[@class=\"btn dropdown-toggle checkout-dropdown border-radius_Style checkoutDeliveryFamilyFont ng-pristine ng-valid ng-touched\"]");
	//div[contains(@class,'checkout-dropdownCity')]//following-sibling::div/select
	private By districtSelect = By.xpath("//div[contains(@class,'checkout-dropdownCity')]//following-sibling::div/select");
	Select selectList;
	Select selectDistList;
	String distrcitName= "عين شمس";
	private By DeliverBtn = By.xpath("//div[contains(@class,'checkout-DelivaryToAddress')]");
	//address fields
	private By streetName = By.xpath("//input[@formcontrolname='address1']");
	private By buildingNo = By.xpath("//input[@formcontrolname='buildingNumber']");
	private By floorNo = By.xpath("//input[@formcontrolname='floorNumber']");
	private By appartmentNo = By.xpath("//input[@formcontrolname='appartmentNumber']");
	private By addressName = By.xpath("//input[@formcontrolname='addressName']");
	private By addContinueBtn = By.xpath("//div[@class='checkout-addressBtn']/button[text()='Continue']");
	private By personalInfoContinue = By.xpath("//button[@id=\"shippingAddressContinue\"]");
	private By invalidNameError = By.xpath("//div[text()=\" Please enter a valid name\"]");
	
	//select checkout delivery city & district
	public void selectCheckoutDelivery() throws InterruptedException {
		Thread.sleep(10000);
		//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(citySelect));
		
		//System.out.println(citySelect);
		//WebElement selectElement = driver.findElement(citySelect);
		//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(citySelect));
		wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(citySelect, By.tagName("option")));

		//System.out.println(selectElement);
		selectList = new Select (driver.findElement(citySelect));
		//System.out.println(selectList);
		//Assert.assertFalse(selectList.isMultiple());
		selectList.selectByValue("0");
		//selectList.selectByVisibleText("القاهرة"); 
		//selectList.selectByVisibleText("Cairo"); 
		//عين شمس
		Thread.sleep(10000);
		selectDistList = new Select(driver.findElement(districtSelect));
		selectDistList.selectByVisibleText(distrcitName);
		//selectDistList.selectByVisibleText("Ain Shams");
	}
	
	//click on deliver to my address button
	public void clickOnDeliver() {
		wait.until(ExpectedConditions.elementToBeClickable(DeliverBtn));
		driver.findElement(DeliverBtn).click();
	}
	
	//fill in address details
	public void fillAddress(String street,int building, int floor, int appartment, String addressN) {
		driver.findElement(streetName).sendKeys(street);
		driver.findElement(buildingNo).sendKeys(String.valueOf(building));
		driver.findElement(floorNo).sendKeys(String.valueOf(floor));
		driver.findElement(appartmentNo).sendKeys(String.valueOf(appartment));
		driver.findElement(addressName).sendKeys(addressN);

	}
	
	//click on Continue
	public void clickOnContinue() throws InterruptedException {
		Thread.sleep(7000);
		wait.until(ExpectedConditions.elementToBeClickable(addContinueBtn));
		//action.moveToElement(driver.findElement(addContinueBtn)).click().perform();
		//close the cookies bar
		driver.findElement(By.xpath("//i[@class='fas fa-times']")).click();
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.className("checkout-addressBtn")));
		driver.findElement(addContinueBtn).click();

	}
	
	//click on personal info continue
	public void clickOnPersonalInfoContinue() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(personalInfoContinue));
		//driver.findElement(personalInfoContinue).click();
		driver.findElement(personalInfoContinue).submit();
	}
	
	//get error message
	public String getInvalidNameError() {
		return driver.findElement(invalidNameError).getText();
	}
}
