package ecom.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Ecom_Landing_Page extends Ecom_common_BasePage {

	public Ecom_Landing_Page(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h2[contains(text(),'My Account')]")
	WebElement MyAccount_label;
	
	@FindBy(xpath="//aside[@id='column-right']//a[contains(text(),normalize-space('Logout'))]")
	WebElement logout_btn;
	
	public boolean myAccountDisplayed() {
		boolean myacclabel=MyAccount_label.isDisplayed();
		return myacclabel;
	}
	public void displayedMyAccount() {
		MyAccount_label.isDisplayed();
	}
	
	 public boolean displayLogout() {
			boolean logoutButton=logout_btn.isDisplayed();
			return logoutButton;
		}
	
	public void clickLogout() {
		logout_btn.click();	
	}
}
