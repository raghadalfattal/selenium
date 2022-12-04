package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	//variables
	WebDriver driver;
	WebDriverWait wait;
	//Actions action;
	
	//constructor
	BasePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver,20);
		//this.action = new Actions(driver);
	}
	
	

}
