package ecom.testcase;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import ecom.pageobjects.Ecom_HomePage;
import ecom.pageobjects.Ecom_Registration_Page;

public class Ecom_TC001_HomePage extends Ecom_common_TestPage{
	
	
	@Test(priority=0, groups={"Functional","Sanity"})
	public void landingPage() {
		
		Ecom_HomePage home=new Ecom_HomePage(driver);
		home.displayApplogo();
		home.clickMyAccount();
		home.clickaccountRegister();
		
		Ecom_Registration_Page reg=new Ecom_Registration_Page(driver);
		reg.displayRegisterAccount();
		
		Assert.assertTrue(true);
		
	}
	
}
