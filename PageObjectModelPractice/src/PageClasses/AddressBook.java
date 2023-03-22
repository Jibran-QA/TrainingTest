package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;


public class AddressBook {


	WebDriver driver;
	WebDriverWait wait;


	public AddressBook(WebDriver driver)  {
		this.driver=driver;

	}

	//	By AddressDelBtn=By.xpath("/html/body/div[2]/main/div/div[2]/div/section/div[3]/div/div[1]/div/div/div/div[2]/button");
	//	By ConfirmDeleteBtn=By.xpath("//*[@id=\"deleteAddressModal\"]/div/div/div[3]/button[2]");
	By AddNewAddressBtnIfAlreadyAdded=By.xpath("/html/body/div[2]/main/div/div[2]/div/section/div[3]/div/a");
	By EmptyListHeading=By.xpath("/html/body/div[2]/main/div/div[2]/div/section/div[3]/div/div/div/h2");
	By EmptyListText=By.xpath("/html/body/div[2]/main/div/div[2]/div/section/div[3]/div/div/div/p");
	By AddNewAddressBtn=By.xpath("/html/body/div[2]/main/div/div[2]/div/section/div[3]/div/div/div/a");
	By MapAddressSearch=By.xpath("/html/body/div[2]/div[2]/div/div/div[2]/div[3]/div/div/div/div[5]/input");
	By MapConfirmBtn=By.xpath("/html/body/div[2]/div[2]/div/div/div[3]/button");
	By MapCloseBtn=By.xpath("/html/body/div[2]/div[2]/div/div/div[1]/button");
	By Salutaions=By.xpath("/html/body/div[2]/main/div/div[2]/div/section/div[3]/div/form/div[1]/div[2]/div[2]/div/div[1]/span/span[1]/span/span[1]");
	By Fname=By.xpath("/html/body/div[2]/main/div/div[2]/div/section/div[3]/div/form/div[1]/div[2]/div[2]/div/div[2]/input");
	By Lname=By.xpath("/html/body/div[2]/main/div/div[2]/div/section/div[3]/div/form/div[1]/div[2]/div[3]/div/input");
	By LocationInfo=By.xpath("/html/body/div[2]/main/div/div[2]/div/section/div[3]/div/form/div[1]/div[1]/h4");
	By MapBtn=By.xpath("/html/body/div[2]/main/div/div[2]/div/section/div[3]/div/form/div[1]/div[1]/div[1]/div[2]/button");
	By FLat_VillaNo=By.xpath("/html/body/div[2]/main/div/div[2]/div/section/div[3]/div/form/div[1]/div[1]/div[2]/div[1]/div[3]/div/input");
	By BuildingName=By.xpath("/html/body/div[2]/main/div/div[2]/div/section/div[3]/div/form/div[1]/div[1]/div[2]/div[2]/div/div/input");
	By AdditionalDetails=By.xpath("/html/body/div[2]/main/div/div[2]/div/section/div[3]/div/form/div[1]/div[1]/div[2]/div[3]");
	By AddressLabel=By.xpath("/html/body/div[2]/main/div/div[2]/div/section/div[3]/div/form/div[1]/div[1]/div[5]/div/div/div/input");
	By DefShippingChkbox=By.xpath("/html/body/div[2]/main/div/div[2]/div/section/div[3]/div/form/div[1]/div[1]/div[6]/div[1]");
	By DefbillingChkbox=By.xpath("/html/body/div[2]/main/div/div[2]/div/section/div[3]/div/form/div[1]/div[1]/div[6]/div[2]");
	By CancelBtn=By.xpath("/html/body/div[2]/main/div/div[2]/div/section/div[3]/div/form/div[2]/div/div[1]/div[2]/a");
	By SaveBtn=By.xpath("/html/body/div[2]/main/div/div[2]/div/section/div[3]/div/form/div[2]/div/div[2]/div/div/button");
	By savedAddress=By.xpath("/html/body/div[2]/main/div/div[2]/div/section/div[3]/div/div[1]/div");




	String ExpectedEmptyListHeading="Your Address Book is empty";
	String 	ExpectedEmptyListText="You have no saved shipping addresses. Please add an address to have a faster checkout experience.";
	String ActualEmptyListHeading;
	String ActualEmptyListText;
	String ActualsavedAddress;



	public void AddressbookWhenNoAddressAdded()
	{
		//		System.out.println(AddressDelBtn);
		//		if(driver.findElement(AddressDelBtn).isDisplayed())
		//		{
		//			driver.findElement(AddressDelBtn).click();
		//			driver.findElement(ConfirmDeleteBtn).click();
		//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//		}
		//		else if(driver.findElement(AddressDelBtn).isDisplayed()!=true)
		//		{
		ActualEmptyListHeading=driver.findElement(EmptyListHeading).getText();
		System.out.println(driver.findElement(EmptyListHeading).getText());
		ActualEmptyListText=driver.findElement(EmptyListText).getText();
		System.out.println(driver.findElement(EmptyListText).getText());

		assertEquals(ActualEmptyListHeading, ExpectedEmptyListHeading,"Empty List Heading not Present.");
		System.out.println("Empty List Heading Present.");
		assertEquals(ActualEmptyListText, ExpectedEmptyListText,"Empty List text not Present.");
		System.out.println("Empty List text Present.");

		driver.findElement(AddNewAddressBtn).isDisplayed();
		assertTrue(driver.findElement(AddNewAddressBtn).isDisplayed(),"AddNewAddressBtn Button is not displayed");
		System.out.println("AddNewAddressBtn Button is displayed");
		driver.findElement(AddNewAddressBtn).isEnabled();
		assertTrue(driver.findElement(AddNewAddressBtn).isEnabled(),"AddNewAddressBtn Button is not enabled");
		System.out.println("AddNewAddressBtn Button is enabled");	
	}

	public void AddNewAddress() throws InterruptedException
	{
		driver.findElement(AddNewAddressBtn).click();
		driver.findElement(MapAddressSearch).sendKeys("Abha Al Jadidah");
		driver.findElement(MapAddressSearch).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(MapAddressSearch).sendKeys(Keys.ENTER); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(5000);
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(MapAddressSearch).clear();
		driver.findElement(MapAddressSearch).sendKeys("Abha Al Jadidah");
		driver.findElement(MapAddressSearch).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(MapAddressSearch).sendKeys(Keys.ENTER); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		////		WebElement locator=driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div[2]/div[1]/div/span"));
		//		WebElement locator= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[2]/div/div/div[2]/div[1]/div/span")));
		//        if(locator.isDisplayed()) 
		//		
		

		// Expected code chunk
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(MapConfirmBtn)));
		driver.findElement(MapConfirmBtn).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	


		//Validations of AddressBok
		driver.findElement(Salutaions).isDisplayed();
		driver.findElement(Salutaions).isEnabled();
		assertTrue(driver.findElement(Salutaions).isDisplayed(),"Salutaions false");
		assertTrue(driver.findElement(Salutaions).isEnabled());
		System.out.println("Salutaions True");

		driver.findElement(Fname).isEnabled();
		assertTrue(driver.findElement(Fname).isEnabled());
		System.out.println("Fname True");

		driver.findElement(Lname).isEnabled();
		assertTrue(driver.findElement(Lname).isEnabled());
		System.out.println("Lname True");

		driver.findElement(LocationInfo).isDisplayed();
		assertTrue(driver.findElement(LocationInfo).isDisplayed());
		System.out.println("LocationInfo True");

		driver.findElement(MapBtn).isDisplayed();
		assertTrue(driver.findElement(MapBtn).isDisplayed());
		System.out.println("MapBtn True");


		driver.findElement(FLat_VillaNo).isEnabled();
		assertTrue(driver.findElement(FLat_VillaNo).isEnabled());
		System.out.println("FLat_VillaNo True");

		driver.findElement(BuildingName).isEnabled();
		assertTrue(driver.findElement(BuildingName).isEnabled());
		System.out.println("BuildingName True");
 

		driver.findElement(AdditionalDetails).isEnabled();
		assertTrue(driver.findElement(AdditionalDetails).isEnabled());
		System.out.println("AdditionalDetails True");

		driver.findElement(AddressLabel).isEnabled();
		assertTrue(driver.findElement(AddressLabel).isEnabled());
		System.out.println("AddressLabel True");


		driver.findElement(DefShippingChkbox).isDisplayed();
		assertTrue(driver.findElement(DefShippingChkbox).isDisplayed());
		driver.findElement(DefShippingChkbox).isEnabled();
		assertTrue(driver.findElement(DefShippingChkbox).isEnabled());
		System.out.println("DefShippingChkbox True");

		driver.findElement(DefbillingChkbox).isDisplayed();
		assertTrue(driver.findElement(DefbillingChkbox).isDisplayed());
		driver.findElement(DefbillingChkbox).isEnabled();
		assertTrue(driver.findElement(DefbillingChkbox).isEnabled());
		System.out.println("DefbillingChkbox True");


		driver.findElement(CancelBtn).isEnabled();
		assertTrue(driver.findElement(CancelBtn).isEnabled());
		System.out.println("CancelBtn True");

		driver.findElement(SaveBtn).isDisplayed();
		driver.findElement(SaveBtn).isEnabled();
		assertTrue(driver.findElement(SaveBtn).isEnabled());
		System.out.println("SaveBtn True");

		System.out.println("All assertions are correct");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	

	}

	public void SaveandVerifyAddress() throws InterruptedException 
	{	


		driver.findElement(FLat_VillaNo).click();	
		driver.findElement(FLat_VillaNo).sendKeys("12345");


		driver.findElement(BuildingName).click();
		driver.findElement(BuildingName).sendKeys("qwerty");
		//		js.executeScript("arguments[0].click();", driver.findElement(BuildingName));
		//		js.executeScript("arguments[0].value='qwerty';", driver.findElement(BuildingName));
		//
		//		
		driver.findElement(AddressLabel).click();
		driver.findElement(AddressLabel).clear();
		driver.findElement(AddressLabel).sendKeys("Home");
		//		js.executeScript("arguments[0].click();", driver.findElement(AddressLabel));
		//		js.executeScript("arguments[0].value='Home';", driver.findElement(AddressLabel));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Thread.sleep(2000);
		driver.findElement(SaveBtn).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		 	

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));    
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(savedAddress)));

		ActualsavedAddress=driver.findElement(savedAddress).getText();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//		driver.navigate().to("https://ov-dev-en-ae.sssports.com/addressbook");
		assertTrue(ActualsavedAddress.contains("12345")&&ActualsavedAddress.contains("qwerty")&&ActualsavedAddress.contains("Home"));	
	}



}
