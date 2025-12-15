package ecom.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Ecom_common_BasePage {
	
	WebDriver driver;
	
	public Ecom_common_BasePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}
