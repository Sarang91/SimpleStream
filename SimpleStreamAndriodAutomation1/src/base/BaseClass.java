package base;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import utility.ExtentReportSS;
import utility.TestDataReader;

public class BaseClass extends ExtentReportSS
{
	public static AndroidDriver<AndroidElement> driver;
	
	public static void readTestData() throws IOException
	{
		TestDataReader.readTestData();
	}
	
	public static AndroidDriver instantiateDriver() throws MalformedURLException 
	{	
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel7");
		desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		String path = System.getProperty("user.dir");
		String dpath = path+ "\\src\\utility\\chromedriver.exe";
		desiredCapabilities.setCapability("chromedriverExecutable",dpath);
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/"),desiredCapabilities);
		return driver;
	}
	
	public void waitForElementToBeVisible(By locator)
	{
		WebDriverWait wait = new WebDriverWait(this.driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
}

