package ecom.testcase;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.io.Files;

public class Ecom_common_TestPage {

	public WebDriver driver;

	@BeforeClass(groups= {"Functional","Sanity","Regression"})
	public void launchBrowser() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
	}

	@AfterClass(alwaysRun=true)
	public void closeBrowser() {
		driver.quit();
	}
	
	public String captureScreenshot(String tname) {
		
		SimpleDateFormat df=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
	    Date dates=new Date();
	    String timeStamp=df.format(dates);
	    
	    TakesScreenshot takescreenshot=(TakesScreenshot) driver;
	    File srcFile=takescreenshot.getScreenshotAs(OutputType.FILE);
	    
	    String FilePath=System.getProperty("user.dir")+"\\ecom.screenshots\\"+"Ecom-"+tname+"-"+timeStamp+".png";
	   // System.getProperty("user.dir") + "\\ecom.screenshots\\"+"Ecom"+timeStamp+".png"
	    File destFile=new File(FilePath);
	    
	    try {
            java.nio.file.Files.copy(srcFile.toPath(), destFile.toPath());
        } catch (Exception e) {
            e.printStackTrace();
        }
	    
	    return FilePath;
	}

	/*
	public void screenShot(String str) {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        
        SimpleDateFormat df=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
	    Date date=new Date();
	    String timeStamp=df.format(date);

        String filePath = System.getProperty("user.dir") + "\\ecom.screenshots\\"+"Ecom-"+str+"-"+timeStamp+".png";
        File dest = new File(filePath);

        src.renameTo(dest);
     
		*/
	}

