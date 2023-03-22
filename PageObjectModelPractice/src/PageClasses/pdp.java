package PageClasses;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

public class pdp {
	
	WebDriver driver;
	WebDriverWait wait;

	public pdp(WebDriver driver)  {
		this.driver=driver;

	}

	By Image=By.xpath("//*[@id=\"slick-slide00\"]/div/picture/img");
	By Name=By.xpath("//*[@id=\"maincontent\"]/div[6]/div/div[3]/div/h1/span[2]");
	By Detail=By.xpath("//*[@id=\"maincontent\"]/div[6]/div/div[3]/div/div[15]/div/button");
	By Price=By.xpath("//*[@id=\"maincontent\"]/div[6]/div/div[3]/div/div[4]/div/span");
	By Reviews=By.xpath("//*[@id=\"maincontent\"]/div[6]/div/div[3]/div/div[18]/div/div/button");
	By Colour=By.xpath("//*[@id=\"maincontent\"]/div[6]/div/div[3]/div/div[9]/div[2]");
	By Size=By.xpath("//*[@id=\"maincontent\"]/div[6]/div/div[3]/div/div[10]/div/div/div");
	By Quantity=By.xpath("//*[@id=\"maincontent\"]/div[6]/div/div[3]/div/div[11]/div/div/div[1]/div/span[1]/span[1]/span");
	By SizeGuide=By.xpath("//*[@id=\"maincontent\"]/div[6]/div/div[3]/div/div[10]/div/div/div/span/a");
	By AddToWishLst=By.xpath("//*[@id=\"maincontent\"]/div[6]/div/div[3]/div/div[3]/div/div/a/span");
	By Sizes=By.xpath("//*[@id=\"maincontent\"]/div[6]/div/div[3]/div/div[10]/div/div/div/div[2]/div");
	By AddtobagButton=By.xpath("//*[@id=\"maincontent\"]/div[6]/div/div[3]/div/div[11]/div/div/div[2]/div/div/button[1]");
	By Size1=By.xpath("//*[@id=\"vendorSize-size\"]");
	

	
	String actualUrl;
	String expectedUrl;
	
	public void SelectProductFromPLP() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div[2]/div/div[1]/div[2]/div[2]/div/div[2]/div/div/div[1]/a[1]/picture[]/img")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(5000);
		actualUrl="https://ov-dev-en-sa.sssports.com/puma-mens-xtg-woven-jacket/PM59531001.html"; 
		expectedUrl= driver.getCurrentUrl(); 
		Assert.assertEquals(expectedUrl,actualUrl,"Didnot Land on PDP");

		//Validate image
		Boolean p = (Boolean) ((JavascriptExecutor)driver) .executeScript("return arguments[0].complete " + "&& typeof arguments[0].naturalWidth != \"undefined\" " + "&& arguments[0].naturalWidth > 0", driver.findElement(Image));
		if (p) {
			System.out.println("image present");
		} else {
			System.out.println("image not present"); 
		}
 
		assertTrue(driver.findElement(Name).isDisplayed());

		assertTrue(driver.findElement(Detail).isDisplayed());

		assertTrue(driver.findElement(Price).isDisplayed());

		assertTrue(driver.findElement(Reviews).isDisplayed());

		assertTrue(driver.findElement(Colour).isDisplayed());

		assertTrue(driver.findElement(Size).isDisplayed());

		assertTrue(driver.findElement(Quantity).isDisplayed());

		assertTrue(driver.findElement(SizeGuide).isDisplayed());

		assertTrue(driver.findElement(AddToWishLst).isDisplayed());

		assertTrue(driver.findElement(AddtobagButton).isDisplayed());

		driver.findElement(Sizes);
		js.executeScript("arguments[0].click();", driver.findElement(Size1));
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));    
		wait.until(ExpectedConditions.elementToBeClickable(AddtobagButton));	
		driver.findElement(AddtobagButton).click();
		Thread.sleep(3000);
	}
	
	
}
