package ecom.testcase;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ecom.pageobjects.Ecom_HomePage;
import ecom.pageobjects.Ecom_Landing_Page;
import ecom.pageobjects.Ecom_Login_Page;

public class Ecom_TC003_Login_DDT extends Ecom_common_TestPage {

	@Test(priority=0,dataProvider="xlsxdata",groups={"DDT"})
	public void LoginDDT(String email,String pwd,String res) {

		Ecom_HomePage home = new Ecom_HomePage(driver);
		home.clickMyAccount();
		home.clickaccountLogin();

		Ecom_Login_Page log = new Ecom_Login_Page(driver);
		log.enterEmail(email);
		log.enterPassword(pwd);
		log.clickLogin();

		Ecom_Landing_Page land = new Ecom_Landing_Page(driver);

		boolean accountlabel = false;

		try {
			accountlabel = land.myAccountDisplayed();
		} catch (Exception e) {
			accountlabel = false;
		}

		if (accountlabel) {
			land.clickLogout();
			System.out.println("Login Successfull...");
			Assert.assertTrue(accountlabel);

		} else {
			System.out.println("Login Failed...");
			Assert.fail("Login Failed - My Account not displayed...");
		}

	}

	/*@DataProvider(name = "manualdata")
	public Object manualdataprovide() {
		Object manualdata[][] = { { "mohanguru@gmail.com", "qafox@7mg" }, { "mohan@gmail", "Test2123" } };
		return manualdata;
	}
	*/

	@DataProvider(name="xlsxdata")
	public Object xlsxdataprovide() throws IOException {
		
		String excelPath = System.getProperty("user.dir")
		        + "/src/test/resources/testData/dataProvider/loginData_DP.xlsx";
		FileInputStream file=new FileInputStream(excelPath);
		XSSFWorkbook wb=new XSSFWorkbook(file);
		XSSFSheet ws=wb.getSheetAt(0);
		int row=ws.getLastRowNum();
		int col=ws.getRow(0).getLastCellNum();
		Object xlsxData[][] = new Object[row][col];
		
		for(int r=1;r<=row;r++) {
			XSSFRow curRow=ws.getRow(r);
			for(int c=0;c<col;c++) {
			XSSFCell curCell=curRow.getCell(c);
			String xlval=curCell.toString();
			xlsxData[r-1][c]=xlval;
			}
		}
		
		//System.out.println(xlsxData);
		wb.close();
		file.close();
		return xlsxData;
	}
	
}

