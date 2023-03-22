package PageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;
import static io.restassured.RestAssured.*;

public class LoginPage {

	WebDriver driver;
//	ExtentTest test;

 
	public LoginPage(WebDriver driver)  {
		this.driver=driver;
//		this.test=test;
	}

	public By UserProfileBtn=By.xpath("/html/body/div[2]/header/div[1]/nav/div/div[2]/div[2]/div[1]/div[2]/div/div");//UserProfilebtn
	public By LoginBtn=By.xpath("/html/body/div[2]/header/div[1]/nav/div/div[2]/div[2]/div[1]/div[2]/div/div/a[2]");//Login Button
	public By SignInBtn=By.xpath("/html/body/div[2]/header/div[1]/nav/div/div[2]/div[2]/div[1]/div[2]/div/div/a[1]");// Sign in Button
	public By PopupWindow=By.xpath("/html/body/div[2]/header/div[3]/div/div/div/div");//Popup Window
	public By FBbtn=By.xpath("/html/body/div[2]/header/div[3]/div/div/div/div/section/form[1]/div[1]/a");//Continue with FB button
	public By Applebtn=By.xpath("//*[@id=\"loginModal\"]/div/div/div/div/section/form[1]/div[2]/a");//Continue with Apple button
	public By Googlebtn=By.xpath("//*[@id=\"loginModal\"]/div/div/div/div/section/form[1]/div[3]/a");//Continue with Google button
	public By EmailText=By.xpath("/html/body/div[2]/header/div[3]/div/div/div/div/section/form[2]/div[1]/div[1]/span");//Sign in with email address Text
	public By EmailField=By.xpath("//*[@id=\"registration-form-email\"]");
	public By PasswordField=By.xpath("//*[@id=\"login-form-password\"]");
	public By UseMobileNumberInsteadLink=By.xpath("//*[@id=\"loginModal\"]/div/div/div/div/section/form[2]/div[1]/div[1]/a");
	public By SignInwithMobileText=By.xpath("/html/body/div[2]/header/div[3]/div/div/div/div/section/form[2]/div[1]/div[2]/span");
	public By UseEmailInsteadLink=By.xpath("/html/body/div[2]/header/div[3]/div/div/div/div/section/form[2]/div[1]/div[2]/a");
	public By RememberMeCheckbox=By.xpath("//*[@id=\"loginModal\"]/div/div/div/div/section/form[2]/div[2]/div[1]/label");
	public By ForgotPasswordLink=By.xpath("//*[@id=\"loginModal\"]/div/div/div/div/section/form[2]/div[2]/div[2]/a");
	public By ContinueButton=By.xpath("//*[@id=\"loginModal\"]/div/div/div/div/section/form[2]/button");
	public By JoinNowLink=By.xpath("//*[@id=\"loginModal\"]/div/div/div/div/section/div[2]/a");
	public By UsrNameDsply=By.xpath("/html/body/div[2]/header/div[1]/nav/div/div[2]/div[2]/div[1]/div[2]/span");
	public By SSSMainLogo=By.xpath("/html/body/div[2]/header/div[1]/nav/div/div[1]/div[1]/a/img[1]");
	public By AccountIcon=By.xpath("/html/body/div[2]/header/div[1]/nav/div/div[2]/div[2]/div[1]/div[2]/div/button");
	public By AddressBook=By.xpath("/html/body/div[2]/main/div/div[2]/div/aside/div[2]/div[1]/nav/div/a[4]");
	
	public String TempSignInwithMobileText ;
	public String ExpectedSignInwithMobileText;
	public String ActualUserNameValue;
	public String actualUrl;
	public String expectedUrl;

	public void UsrPrf_LoginBtn_SignupBtn()
	{
//		baseURI="https://ov-dev-en-sa.sssports.com/";
//		given().
//			get("/home").
//		then().
//			statusCode(200).
//			log().all();
		
		driver.findElement(UserProfileBtn).click();

		driver.findElement(SignInBtn).isDisplayed();
		assertTrue(driver.findElement(SignInBtn).isDisplayed(), "SignUpBtn is not displayed");
		System.out.println("SignUpBtn is  displayed");

		driver.findElement(LoginBtn).isDisplayed();
		assertTrue(driver.findElement(LoginBtn).isDisplayed(), "LoginBtn is not displayed");
		System.out.println("LoginBtn is  displayed");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		if(driver.findElement(SignInBtn).isDisplayed()&& driver.findElement(LoginBtn).isDisplayed())
//		{
//			test.pass("UserProfileButton_Testcase");
//		}
//		else
//		{
//			test.fail("UserProfileButton_Testcase");
//		}
	}

	public void ClickonSignIn()
	{
		driver.findElement(SignInBtn).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(PopupWindow).isEnabled();
		assertTrue(driver.findElement(PopupWindow).isEnabled(), "PopupWindow is not Enabled");
		System.out.println("PopupWindow is Enabled");

		driver.findElement(FBbtn).isDisplayed();
		assertTrue(driver.findElement(FBbtn).isDisplayed(), "FB btn is not displayed");
		System.out.println("FB btn is  displayed");

		driver.findElement(Applebtn).isDisplayed();
		assertTrue(driver.findElement(Applebtn).isDisplayed(), "Applebtn is not displayed");
		System.out.println("Applebtn is  displayed");

		driver.findElement(Googlebtn).isDisplayed();
		assertTrue(driver.findElement(Googlebtn).isDisplayed(), "Googlebtn is not displayed");
		System.out.println("Googlebtn is  displayed");

		driver.findElement(EmailText).isDisplayed();
		assertTrue(driver.findElement(EmailText).isDisplayed(), "EmailText is not displayed");
		System.out.println("EmailText is  displayed");

		driver.findElement(EmailField).isEnabled();
		assertTrue(driver.findElement(EmailField).isEnabled(), "EmailField is not Enabled");
		System.out.println("EmailField is  displayed");
 
		driver.findElement(PasswordField).isEnabled();
		assertTrue(driver.findElement(PasswordField).isEnabled(), "PasswordField is not Enabled");
		System.out.println("PasswordField is  Enabled");

		driver.findElement(LoginBtn).isDisplayed();
		assertTrue(driver.findElement(LoginBtn).isDisplayed(), "LoginBtn is not displayed");
		System.out.println("LoginBtn is  displayed");

		driver.findElement(UseMobileNumberInsteadLink).isDisplayed();
		assertTrue(driver.findElement(UseMobileNumberInsteadLink).isDisplayed(), "UseMobileNumberInsteadLink is not displayed");
		System.out.println("UseMobileNumberInsteadLink is  displayed");

		driver.findElement(UseMobileNumberInsteadLink).click();
		//Sign In with Mobile Text

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		assertTrue(driver.findElement(SignInwithMobileText).isDisplayed());
		driver.findElement(SignInwithMobileText).getText();

		TempSignInwithMobileText=driver.findElement(SignInwithMobileText).getText();
		System.out.println("This is "+TempSignInwithMobileText);

		ExpectedSignInwithMobileText="Sign in with mobile number";
		Assert.assertEquals(ExpectedSignInwithMobileText, TempSignInwithMobileText);

		driver.findElement(UseEmailInsteadLink).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(RememberMeCheckbox).isDisplayed();
		assertTrue(driver.findElement(RememberMeCheckbox).isDisplayed(), "RememberMeCheckbox is not displayed");
		System.out.println("RememberMeCheckbox is  displayed");

		driver.findElement(ContinueButton).isDisplayed();
		assertTrue(driver.findElement(ContinueButton).isDisplayed(), "Continue Button is not displayed");
		System.out.println("Continue Button is  displayed");

		driver.findElement(JoinNowLink).isDisplayed();
		assertTrue(driver.findElement(JoinNowLink).isDisplayed(), "JoinNowLink is not displayed");
		System.out.println("JoinNowLink is  displayed");
	
	}
	
	
	public void Enter_EmailAddressandPassword_ClickContinue()
	{
		driver.findElement(EmailField).sendKeys("jibran@werplay.com");
		driver.findElement(PasswordField).sendKeys("Asdfg@123");
		driver.findElement(ContinueButton).click();
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		actualUrl="https://ov-dev-en-sa.sssports.com/account?registration=false"; 
		expectedUrl= driver.getCurrentUrl(); 
		Assert.assertEquals(expectedUrl,actualUrl,"Login Unsuccessful");
		
		ActualUserNameValue=driver.findElement(UsrNameDsply).getText();
		System.out.println(ActualUserNameValue+" you are logged in Successfully");        
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	public void Click_AccountIcon()
	{
		driver.findElement(AccountIcon).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		ActualUserNameValue=driver.findElement(UsrNameDsply).getText();
		int count = 0;
		String[] exp = {ActualUserNameValue, "My Account", "My Orders", "Sign Out"};

		List<WebElement> ListItems = driver.findElements(By.xpath("//ul[@class='dropdown-menu custom-dropdown__content js-dropdown-content show']/li"));
		System.out.println("Dropdown Options are: ");
		//iterate through list
		for( WebElement we: ListItems){
			for (int i = 0; i < exp.length; i++) {

				if (we.getText().equals(exp[i])) {
					System.out.println(we.getText()+" matches "+exp[i]);
					count++;
				} 

			}
		}
		if (count == exp.length) {
			System.out.println("Dropdown options Matched.");
		} else {
			System.out.println("Dropdown options did not match");
		} 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(AccountIcon).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(AddressBook).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


	}

}
