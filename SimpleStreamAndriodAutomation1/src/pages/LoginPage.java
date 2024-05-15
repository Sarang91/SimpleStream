package pages;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import base.BaseClass;
import io.appium.java_client.android.AndroidDriver;

//LoginPage - The first page that appears after hitting the URL
public class LoginPage extends BaseClass
{	
	public AndroidDriver driver;

	//Constructor of login page - assigns passed driver instance to this class's driver variable
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
 	
	//Checks if the login form is displayed and returns boolean accordingly
	public boolean isLoaded()
	{
		return driver.findElement(formLogin).isDisplayed();
	}
	
	//Clicks on 'Got it' pop-up and returns loginPage class object
	public LoginPage acceptPopup()
	{
		driver.findElement(gotItPopup).click();
		return this;
	}
	
	//Method to enter given credentials in respective text fields
	public LoginPage enterCredentials(String userName, String password)
	{
		driver.findElement(txtUserName).sendKeys(userName);
		driver.findElement(txtPassword).sendKeys(password);
		return this;
	}
	
	//Checks if the expected/entered credentials are populated correctly in username/password fields
	public boolean areCredFieldsPopulated(String expUN, String expPw)
	{
		return driver.findElement(txtUserName).getText().equals(expUN) &&
				driver.findElement(txtPassword).getText().equals(expPw);
	}
	
	//Clicks on 'Sign In' button and returns loginPage class object
	public LoginPage signIn()
	{
		driver.findElement(btnSignIn).click();
		return this;
	}
	
	//Clicks on 'Sign In' and returns MyAccounts page class object
	public MyAccountsPage signInForValidCred() throws MalformedURLException
	{
		driver.findElement(btnSignIn).click();
		return new MyAccountsPage(driver);
	}
	
	//Gets and returns the error message text
	public String getErrorMsg()
	{
		waitForElementToBeVisible(errorMsg);
		return driver.findElement(errorMsg).getText();
	}
}
