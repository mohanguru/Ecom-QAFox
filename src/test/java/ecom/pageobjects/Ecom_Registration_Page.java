package ecom.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Ecom_Registration_Page extends Ecom_common_BasePage{
	
	public Ecom_Registration_Page(WebDriver driver) {
		super(driver);
	} 
	
	@FindBy(xpath = "//h1[contains(text(),normalize-space('Register Account'))]")
	WebElement register_account_label;

	@FindBy(xpath = "//input[@placeholder=normalize-space('First Name')]")
	WebElement first_Name_txtbx;

	@FindBy(xpath = "//input[@placeholder=normalize-space('Last Name')]")
	WebElement last_Name_txtbx;

	@FindBy(xpath = "//input[@placeholder=normalize-space('E-Mail')]")
	WebElement email_txtbx;

	@FindBy(xpath = "//input[@placeholder=normalize-space('Telephone')]")
	WebElement telephone_txtbx;

	@FindBy(xpath = "//input[@placeholder=normalize-space('Password')]")
	WebElement password_txtbx;

	@FindBy(xpath = "//input[@placeholder=normalize-space('Password Confirm')]")
	WebElement cnfrmPassword_txtbx;

	@FindBy(xpath = "//input[@name=normalize-space('agree')]")
	WebElement policyAgree_checkbx;

	@FindBy(xpath = "//input[@value=normalize-space('Continue')]")
	WebElement continue_btn;

	@FindBy(xpath = "//h1[contains(text(),'Your Account Has Been Created!')]")
	WebElement account_Created_info;

	public void displayRegisterAccount() {
		register_account_label.isDisplayed();
	}

	public void setFirstName(String firstName) {
		first_Name_txtbx.sendKeys(firstName);
	}

	public void setLastName(String lastName) {
		last_Name_txtbx.sendKeys(lastName);
	}

	public void setEmail(String email) {
		email_txtbx.sendKeys(email);
	}

	public void setTelephone(String telePhone) {
		telephone_txtbx.sendKeys(telePhone);
	}

	public void setPassword(String password) {
		password_txtbx.sendKeys(password);
	}

	public void setCnfrmPassword(String password) {
		cnfrmPassword_txtbx.sendKeys(password);
	}

	public void clickAgree() {
		policyAgree_checkbx.click();
	}

	public void clickContinue() {
		continue_btn.click();
	}

	public String getInfoAccountCreated() {
		String successInfo = account_Created_info.getText();
		try {
			return successInfo;
		} catch (Exception e) {
			return e.getMessage();
		}

	}

}
