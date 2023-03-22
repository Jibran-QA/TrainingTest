package POM;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
 
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.qa.ExtentReportListener.ExtentReporterNG;
import com.relevantcodes.extentreports.LogStatus;

import PageClasses.AddressBook;
import PageClasses.LoginPage;
import PageClasses.PLP;
import PageClasses.pdp;

public class MainRunnerClass {
	public static WebDriver driver;
	ExtentReports extent;
	ExtentTest logger;
//	public ExtentHtmlReporter htmlReporter;
//	public ExtentReports extent;
//	public ExtentTest test;
	LoginPage obj_LP;
	AddressBook obj_AB;
	PLP obj_PLP;
	pdp obj_pdp;
	
//	@BeforeSuite
//	public void extentReportSetup()
//	{
//		htmlReporter = new ExtentHtmlReporter("1st Extent Report.html");
//		extent = new ExtentReports();
//		extent.attachReporter(htmlReporter);
//		test = extent.createTest("MyFirstTest");
//
//	}

	@BeforeTest
	public void setup()
	{

		System.setProperty("webdriver.chrome.driver", "/Users/mac/Desktop/Automation/chromedriver");
		driver = new ChromeDriver(); 
		obj_LP=new LoginPage(driver);
		obj_AB=new AddressBook(driver);
		obj_PLP=new PLP(driver);
		obj_pdp=new pdp(driver);
		driver.manage().window().maximize();
		driver.get("https://ov-dev-en-ae.sssports.com/home");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.cssSelector("#optiRealclosePopupImage")).click();
		driver.findElement(By.cssSelector(".affirm.btn.btn-primary.btn--affirm.js-consent-submit")).click();
		driver.findElement(By.xpath("//*[contains(text(),'KSA')]")).click();// Selected KSA
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.cssSelector("#optiRealclosePopupImage")).click();//Closed ad again
		driver.findElement(By.cssSelector(".affirm.btn.btn-primary.btn--affirm.js-consent-submit")).click();//Click I agree again
		driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div[2]/div/div[2]/div[2]/div[2]/a")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.cssSelector("#optiRealclosePopupImage")).click();//Closed ad again
		driver.findElement(By.cssSelector("div[class='header__links'] span[class='user__icon icon icon-user']")).click(); //  Click Account Icon 
	}	

	@Test(priority=1)

	public void UserProfileButton_Testcase()
	{
		
		obj_LP.UsrPrf_LoginBtn_SignupBtn();
	

	}

	@Test(priority=2)

	public void ClickonSignIn_Testcase()
	{
		obj_LP.ClickonSignIn();
		System.out.println("Pop-up Window is correct");
//		test.pass("ClickonSignIn_Testcase");
	}

	@Test(priority=3)

	public void Enter_EmailAddressandPassword_ClickContinue_Testcase()
	{
		
		obj_LP.Enter_EmailAddressandPassword_ClickContinue();
//		test.pass("Enter_EmailAddressandPassword_ClickContinue_Testcase");

	}

	@Test(priority=4)

	public void Click_AccountIcon_Testcase()
	{
		
		obj_LP.Click_AccountIcon();	
//		test.pass("Click_AccountIcon_Testcase");

	}

	@Test(priority=5)

	public void AddressbookWhenNoAddressAdded_Testcase()
	{
		
		obj_AB.AddressbookWhenNoAddressAdded();
//		test.pass("AddressbookWhenNoAddressAdded_Testcase");

	}

	@Test(priority=6)

	public void AddNewAddress_Testcase() throws InterruptedException
	{
		
		obj_AB.AddNewAddress();
//		test.pass("AddNewAddress_Testcase");

	}

	@Test(priority=7)

	public void SaveandVerifyAddress_Testcase() throws InterruptedException
	{
		
		obj_AB.SaveandVerifyAddress();
		System.out.println("Address Saved and Verified Successfully"); 
//		test.pass("SaveandVerifyAddress_Testcase");

	}

	@Test(priority=8)

	public void SearchIcon_TestCase()
	{
		obj_PLP.Search();
		System.out.println("PLP Verified"); 
//		test.pass("SearchIcon_TestCase");

	}

	@Test(priority=9)  

	public void SelectProductFromPLP_TestCase() throws InterruptedException
	{
		
		obj_pdp.SelectProductFromPLP();
//		test.pass("SelectProductFromPLP_TestCase");

	}
//	 public static String getScreenshot(WebDriver driver, String screenshotName) throws Exception {
//			String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
//			TakesScreenshot ts = (TakesScreenshot) driver;
//			File source = ts.getScreenshotAs(OutputType.FILE);
//	                //after execution, you could see a folder "FailedTestsScreenshots" under src folder
//			String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/"+screenshotName+dateName+".png";
//			File finalDestination = new File(destination);
//			FileUtils.copyFile(source, finalDestination);
//			return destination;
//		}
	 

	 

	@AfterTest
	public void teardown()
	{
		driver.close();
		driver.quit();
		System.out.println("Test Completed...!!!");
	}
		
//	@AfterSuite
//	public void teardownExtentReport()
//	{
//		extent.flush();
//	}
}


