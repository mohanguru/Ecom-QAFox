package ecom.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Ecom_HomePage extends Ecom_common_BasePage {

	
	public Ecom_HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[contains(text(),normalize-space('Qafox.com'))]")
	WebElement headerApp_logo;

	@FindBy(xpath = "//span[contains(text(),normalize-space('My Account'))]")
	WebElement accountDropdown_btn;

	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[contains(text(),normalize-space('Register'))]")
	WebElement account_Register_btn;

	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[contains(text(),normalize-space('Login'))]")
	WebElement account_Login_btn;

	public void displayApplogo() {
		headerApp_logo.isDisplayed();
	}

	public void clickMyAccount() {
		accountDropdown_btn.click();
	}

	public void clickaccountRegister() {
		account_Register_btn.click();
	}

	public void clickaccountLogin() {
		account_Login_btn.click();
	}

}
