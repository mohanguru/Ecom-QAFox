package ecom.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Ecom_Login_Page extends Ecom_common_BasePage{

	public Ecom_Login_Page(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//div[@id='account-login']//ul//a[contains(text(),normalize-space('Login'))]")
	WebElement login_Label;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement email_txtbx;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement password_txtbx;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement login_btn;
	

	public void loginLabel() {
		login_Label.isDisplayed();
	}
	
	public void enterEmail(String email) {
		email_txtbx.clear();
		email_txtbx.sendKeys(email);
	}
	
	public void enterPassword(String password) {
		password_txtbx.clear();
		password_txtbx.sendKeys(password);	
	}
	
	public void clickLogin() {
		login_btn.click();
	}
	
	
	 
	
}
