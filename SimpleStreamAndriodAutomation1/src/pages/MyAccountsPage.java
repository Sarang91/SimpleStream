package pages;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BaseClass;
import io.appium.java_client.android.AndroidDriver;

//My Accounts Page/HomePage - Appears after login is successful
public class MyAccountsPage extends BaseClass
{
	public AndroidDriver driver;
	
	//Constructor of login page - assigns passed driver instance to this class's driver variable
	public MyAccountsPage(AndroidDriver driver) throws MalformedURLException
	{
		this.driver = driver;
	}
	
	By tabMyAccount = By.xpath("//span[contains(text(), 'My Account')]");

	//Checks if 'My Account' tab is displayed and returns bool accordingly
	public boolean isLoaded()
	{
		waitForElementToBeVisible(tabMyAccount);
		return driver.findElement(tabMyAccount).isDisplayed();
	}
}
