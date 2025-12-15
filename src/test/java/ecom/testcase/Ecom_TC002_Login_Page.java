package ecom.testcase;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import ecom.pageobjects.Ecom_HomePage;
import ecom.pageobjects.Ecom_Landing_Page;
import ecom.pageobjects.Ecom_Login_Page;

public class Ecom_TC002_Login_Page extends Ecom_common_TestPage {

	@Test(priority = 0, groups = { "Functional", "Regression" })
	public void login() {

		Ecom_HomePage home = new Ecom_HomePage(driver);
		home.clickMyAccount();
		home.clickaccountLogin();

		Ecom_Login_Page log = new Ecom_Login_Page(driver);
		log.enterEmail("mohanguru@gmail.com");
		log.enterPassword("qafox@7mg");

		//screenShot("Before Login");        
		log.clickLogin();

	}
	
	@Test(priority=1, dependsOnMethods="login",groups = { "Functional", "Regression" })
	public void Logout() {
		Ecom_Landing_Page land = new Ecom_Landing_Page(driver);
		land.displayedMyAccount();
		//screenShot("After Login");
		land.clickLogout();
	}

}
