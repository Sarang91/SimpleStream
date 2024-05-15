package pages;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BaseClass;
import io.appium.java_client.android.AndroidDriver;

public class MyAccountsPage extends BaseClass
{
	public AndroidDriver driver;
	
	public MyAccountsPage(AndroidDriver driver) throws MalformedURLException
	{
		this.driver = driver;
	}
	
	By tabMyAccount = By.xpath("//span[contains(text(), 'My Account')]");

	public boolean isLoaded()
	{
		waitForElementToBeVisible(tabMyAccount);
		return driver.findElement(tabMyAccount).isDisplayed();
	}
}
