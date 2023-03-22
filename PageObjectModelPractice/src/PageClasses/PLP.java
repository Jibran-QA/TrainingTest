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

public class PLP {
	 

	WebDriver driver;
	WebDriverWait wait;


	public PLP(WebDriver driver)  {
		this.driver=driver;

	}
	
	//PLP locators
		By SearchIconBtn=By.xpath("/html/body/div[2]/header/div[1]/nav/div/div[2]/div[1]/div/div/form/span/button[1]");
		By Filter=By.xpath("//*[@id=\"product-search-results\"]/div[1]/div[2]/div/div[2]/div/a[1]/span[2]");
		By Sorting=By.xpath("/html/body/div[2]/main/div[2]/div[2]/div/div[1]/div[1]/div[2]/div/div[2]/div/div/span/span[1]/span/span[1]");
		By Wishlist=By.xpath("/html/body/div[2]/main/div[2]/div[2]/div/div[1]/div[2]/div[2]/div/div[1]/div/div/div[1]/a[2]/span");
		By NoOfProducts=By.xpath("//*[@id=\"product-search-results\"]/div[2]/div[2]/div/div[49]/div[2]/span");
		

		String ActualFilter;
		String ActualSorting;
				
		public void Search()
		{
			driver.findElement(SearchIconBtn).click();
			String actualUrl="https://ov-dev-en-sa.sssports.com/search?q=&search-button=&lang=en_SA"; 
			String expectedUrl= driver.getCurrentUrl(); 
			Assert.assertEquals(expectedUrl,actualUrl,"Didnot land on PLP");

			ActualFilter=driver.findElement(Filter).getText();
			assertTrue(ActualFilter.contains("Filter"));	

			ActualSorting=driver.findElement(Sorting).getText();
			assertTrue(ActualSorting.contains("Featured"));

			driver.findElement(Wishlist).isDisplayed();
			assertTrue(driver.findElement(Wishlist).isDisplayed());

			driver.findElement(NoOfProducts).isDisplayed();
			assertTrue(driver.findElement(NoOfProducts).isDisplayed());
		}		
}
