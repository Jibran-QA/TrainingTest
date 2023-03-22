package com.qa.ExtentReportListener;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Utility {

	public static String getScreenshot(WebDriver driver, String screenshotName) throws Exception {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/"+screenshotName+dateName+".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
}
}

//package com.qa.ExtentReportListener;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.InputStream;
//import java.util.Base64;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.List;
//import java.util.Map;
//import java.text.SimpleDateFormat;
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//
//import java.io.File;
//import java.util.Date;
//import java.text.SimpleDateFormat;
//
//import org.apache.commons.io.FileUtils;
//import org.apache.commons.io.IOUtils;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.testng.IReporter;
//import org.testng.IResultMap;
//import org.testng.ISuite;
//import org.testng.ISuiteResult;
//import org.testng.ITestContext;
//import org.testng.ITestResult;
//import org.testng.xml.XmlSuite;
//
//import com.aventstack.extentreports.MediaEntityBuilder;
//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;
//
//import POM.MainRunnerClass;
//
//public class ExtentReporterNG extends MainRunnerClass implements IReporter {
//	private ExtentReports extent;
//	static ExtentTest test;
//	static WebDriver driver;
//	static String dateName;
//
//	public ExtentReporterNG(WebDriver driver)  {
//		this.driver=driver;
//	}
//	public static String getScreenshot(WebDriver driver, String screenshotName) throws Exception {
//		 dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		File source = ts.getScreenshotAs(OutputType.FILE);
//		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/"+screenshotName+dateName+".png";
//		File finalDestination = new File(destination);
//		FileUtils.copyFile(source, finalDestination);
//		return destination;
//}
//
//		public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory, WebDriver driver) throws Exception 
//		{
//			extent = new ExtentReports(outputDirectory + File.separator + "JReport"+dateName+".html", true);
//
//			for (ISuite suite : suites) 
//			{
//				Map<String, ISuiteResult> result = suite.getResults();
//
//				for (ISuiteResult r : result.values()) {
//					ITestContext context = r.getTestContext();
//
//					buildTestNodes(context.getPassedTests(), LogStatus.PASS);
//					buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
//					if(((ITestResult) result).getStatus() == ITestResult.FAILURE){
//						test.log(LogStatus.FAIL, "Test Case Failed is "+context.getName());
//						test.log(LogStatus.FAIL, "Test Case Failed is "+((ITestResult) result).getThrowable());
//						//To capture screenshot path and store the path of the screenshot in the string "screenshotPath"
//			                        //We do pass the path captured by this mehtod in to the extent reports using "logger.addScreenCapture" method. 			
//			                        String screenshotPath = ExtentReporterNG.getScreenshot(driver, context.getName());
//						//To add it in the extent report 
//			                        test.log(LogStatus.FAIL, test.addScreenCapture(screenshotPath));
//					}else if(((ITestResult) result).getStatus() == ITestResult.SKIP){
//						test.log(LogStatus.SKIP, "Test Case Skipped is "+context.getName());
//					}
//					buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
//
//				}
//
//			}
//
//			extent.flush();
//			extent.close();
//		}
//
//
//
//		public void buildTestNodes(IResultMap tests, LogStatus status)  {
//
//
//
//			if (tests.size() > 0) {
//				for (ITestResult result : tests.getAllResults()) {
//					test = extent.startTest(result.getMethod().getMethodName());
//
//					test.setStartedTime(getTime(result.getStartMillis()));
//					test.setEndedTime(getTime(result.getEndMillis()));
//
//					for (String group : result.getMethod().getGroups())
//						test.assignCategory(group);
//
//					if (result.getThrowable() != null) {
//						test.log(status, result.getThrowable());
//
//
//					} else {
//						test.log(status, "Test " + status.toString().toLowerCase()
//								+ "ed");
//					}
//					extent.endTest(test);
//				}
//			}
//			//		if(test.log(fail, null)) {
//			//			test.log(LogStatus.FAIL, test.addScreenCapture(CaptureScreen(driver)));
//			//		}
//		}
//
//
//		private Date getTime(long millis) {
//			Calendar calendar = Calendar.getInstance();
//			calendar.setTimeInMillis(millis);
//			return calendar.getTime();
//		}
//
//
//	}
