package ecom.utilities;

import java.awt.Desktop;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import ecom.testcase.Ecom_common_TestPage;

public class Ecom_ExtentReportManager implements ITestListener{
	
	public ExtentSparkReporter sparkReporter; //UI of the report
	public ExtentReports extent; //populate common info on the report
	public ExtentTest test; //creating test case/new entries in report and update status of test method
	String reportName;
	
	public void onStart(ITestContext context) {
	    System.out.println("Listener - onStart");
	    
	    SimpleDateFormat df=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
	    Date date=new Date();
	    String currDate=df.format(date);
	    
	    reportName="Ecom-TestReport-"+currDate+".html";
	    sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/ecom.reports/"+reportName);

	    //sparkReporter=new ExtentSparkReporter(".\\ecom.reports\\"+DynName);

	    
	    sparkReporter.config().setDocumentTitle("Ecom Automation Report");
	    sparkReporter.config().setReportName("Functional Testing");
	    sparkReporter.config().setTheme(Theme.DARK);
	    
	    extent=new ExtentReports();
	    extent.attachReporter(sparkReporter);
	    
	    /*//Either assign directly
	    extent.setSystemInfo("Project", "Ecom");
	    extent.setSystemInfo("Computer Name", "Local");
	    extent.setSystemInfo("OS", "Windows");
	    extent.setSystemInfo("Browser", "Chrome");
	    extent.setSystemInfo("Tester Name", "Mohan");
	    */
	    
	    //get it from .xml file whichever is running using built in method
	    extent.setSystemInfo("Project", "Ecom");
	    
	    String os=context.getCurrentXmlTest().getParameter("os");
	    extent.setSystemInfo("os", os);
	    String browser=context.getCurrentXmlTest().getParameter("browser");
	    extent.setSystemInfo("Browser", browser);
	    extent.setSystemInfo("Tester Name", System.getProperty("user.name"));
	    
	    //To capture group names
	    List<String> includedGroup=context.getCurrentXmlTest().getIncludedGroups();
	    if (!includedGroup.isEmpty()){
	    	extent.setSystemInfo("Groups", includedGroup.toString());
	    }
	  }
	
	public void onTestStart(ITestResult result) {
		System.out.println("Listener - onTestStart");
		}

	 public void onTestSuccess(ITestResult result) {
		 System.out.println("Listener - onTestSuccess");
		 test=extent.createTest(result.getName());
		 test.log(Status.PASS, "Test Case Passed is:"+result.getName());
		 test.assignCategory(result.getMethod().getGroups());
	 }
	 
	 public void onTestFailure(ITestResult result) {
		 System.out.println("Listener - onTestFailure");
		 test=extent.createTest(result.getName());
		 test.log(Status.FAIL, "Test Case Failed is:"+result.getName());
		 test.log(Status.FAIL, "Test Case Failed due to:"+result.getThrowable().getMessage());
		 test.assignCategory(result.getMethod().getGroups());
		 
		 //whenever onTestFailed triggered it will call capture screenshot from common class 
		 try {
				String imgPath=new Ecom_common_TestPage().captureScreenshot(result.getName());
		 
		test.addScreenCaptureFromPath(imgPath); // added the screenshot image path in report
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		 
	 }
	 public void onTestSkipped(ITestResult result) {
		 System.out.println("Listener - onTestSkipped");
		 test=extent.createTest(result.getName());
		 test.log(Status.SKIP, "Test Case Skipped is:"+result.getName());
		 test.assignCategory(result.getMethod().getGroups());
		 
		  }
	 
	 public void onFinish(ITestContext context) {
		 System.out.println("Listener - onFinish");
		 extent.flush();
		  
		 //(Optional)To Open report automatically after the execution.
		 String pathOfExtentReport = System.getProperty("user.dir")+"/ecom.reports/"+reportName;
		 File extentReport = new File(pathOfExtentReport);
		 
		 try {
			 Desktop.getDesktop().browse(extentReport.toURI());
		 }
		 catch(Exception e1) {
			 e1.printStackTrace();
		 }
	 }
	
	

}
