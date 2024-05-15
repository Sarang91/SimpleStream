package pages;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import base.BaseClass;
import io.appium.java_client.android.AndroidDriver;

public class LoginPage extends BaseClass
{	
	public AndroidDriver driver;

	public LoginPage(AndroidDriver driver) throws MalformedURLException
	{
		this.driver = driver;
	}
	
	By gotItPopup = By.xpath("//*[contains(text(), 'Got it')]");
	By txtUserName = By.xpath("//*[text()='Email Address']//following::input[@name='username'][1]");
	By txtPassword = By.xpath("//a[contains(text(),'Forgot password')]//following::input[@name='password'][1]");
	By btnSignIn = By.xpath("//button[text()='Sign in']");
	By formLogin = By.xpath("//div[@id='content']//form[@class='login']");
	public By errorMsg = By.xpath("//div[contains(@class, 'is-danger')]//li");
 	
	public boolean isLoaded()
	{
		return driver.findElement(formLogin).isDisplayed();
	}
	
	public LoginPage acceptPopup()
	{
		driver.findElement(gotItPopup).click();
		return this;
	}
	
	public LoginPage enterCredentials(String userName, String password)
	{
		driver.findElement(txtUserName).sendKeys(userName);
		driver.findElement(txtPassword).sendKeys(password);
		return this;
	}
	
	public boolean areCredFieldsPopulated(String expUN, String expPw)
	{
		return driver.findElement(txtUserName).getText().equals(expUN) &&
				driver.findElement(txtPassword).getText().equals(expPw);
	}
	
	public LoginPage signIn()
	{
		driver.findElement(btnSignIn).click();
		return this;
	}
	
	public MyAccountsPage signInForValidCred() throws MalformedURLException
	{
		driver.findElement(btnSignIn).click();
		return new MyAccountsPage(driver);
	}
	
//	public MyAccountsPage loginWithValidCred(String userName, String password) throws MalformedURLException
//	{
//		driver.findElement(txtUserName).sendKeys(userName);
//		driver.findElement(txtPassword).sendKeys(password);
//		driver.findElement(btnSignIn).click();
//		return new MyAccountsPage(driver);
//	}
	
	public String getErrorMsg()
	{
		waitForElementToBeVisible(errorMsg);
		return driver.findElement(errorMsg).getText();
	}
}
