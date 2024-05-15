package test;

import java.io.IOException;
import java.net.MalformedURLException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import base.BaseClass;
import io.appium.java_client.android.AndroidDriver;
import pages.*;
import utility.TestDataReader;

public class TestLoginWithCreds extends BaseClass
{
	private static AndroidDriver driver;
	ExtentTest test1;
	ExtentTest test2;
	ExtentTest test3;
	
	@BeforeTest
	public void beforeTest() throws IOException
	{
		readTestData();
	}

	@BeforeMethod
	public void before() throws MalformedURLException  
	{
		driver = instantiateDriver();
		driver.get(TestDataReader.siteUrl);
	}
	
	@AfterMethod
	public void afterTest() throws IOException 
	{
		driver.close();
	}
	
	@Test
	public void test_Invalid_Creds() throws MalformedURLException 
	{
		test1 = extent.createTest("Test one","Test Invalid Creds");		
		test1.log(Status.INFO, "Test One Started");
		
		LoginPage loginPage = new LoginPage(driver).acceptPopup();
		new SoftAssert().assertTrue(loginPage.isLoaded(), "The login page is loaded successfully.");
		test1.log(Status.INFO, "The login page is loaded successfully.");
		loginPage.enterCredentials(TestDataReader.invalidUserName1, TestDataReader.invalidPassword1);
		new SoftAssert().assertTrue(loginPage.areCredFieldsPopulated(TestDataReader.invalidUserName1, TestDataReader.invalidPassword1),
				"username and password fields are populated correctly.");
		test1.log(Status.INFO, "Username and password fields are populated correctly.");
		loginPage.signIn();
		test1.log(Status.INFO, "User Navigated to Page + Clicked on popup button + Entered Creds+Clicked on Sign in Button");
		Assert.assertEquals(loginPage.getErrorMsg(), TestDataReader.loginErrorMsg);
		test1.log(Status.PASS, "Successfully Entered Invalid Creds and validated the error msg");
	
		
	}
	
	@Test
	public void test_Valid_Creds() throws MalformedURLException 
	{
		test2 = extent.createTest("Test two","Test Valid Creds");		
		test2.log(Status.INFO, "Test two Started");
		LoginPage loginPage = new LoginPage(driver).acceptPopup();
		new SoftAssert().assertTrue(loginPage.isLoaded(), "The login page is loaded successfully.");
		test2.log(Status.INFO, "The login page is loaded successfully.");
		loginPage.enterCredentials(TestDataReader.validUserName1, TestDataReader.validPassword1);
		new SoftAssert().assertTrue(loginPage.areCredFieldsPopulated(TestDataReader.validUserName1, TestDataReader.validPassword1),
				"username and password fields are populated correctly.");
		test2.log(Status.INFO, "Username and password fields are populated correctly.");

		MyAccountsPage myAcntPage = loginPage.signInForValidCred();
		Assert.assertTrue(myAcntPage.isLoaded(), "Login successful!");
		test2.log(Status.PASS, "Successfully Logged in");
		
	}
			
	@Test
	public void test_Invalid_Email() throws MalformedURLException 
	{
		test3 = extent.createTest("Test Three","Test Invalid Email");		
		test3.log(Status.INFO, "Test Three Started");
		LoginPage loginPage = new LoginPage(driver).acceptPopup();
		new SoftAssert().assertTrue(loginPage.isLoaded(), "The login page is loaded successfully.");
		test3.log(Status.INFO, "The login page is loaded successfully.");
		loginPage.enterCredentials(TestDataReader.invalidUserName3, TestDataReader.invalidPassword3);
		new SoftAssert().assertTrue(loginPage.areCredFieldsPopulated(TestDataReader.invalidUserName3, TestDataReader.invalidPassword3),
				"username and password fields are populated correctly.");
		test3.log(Status.INFO, "Username and password fields are populated correctly.");
		boolean isErrorMsgDisplayed = loginPage.signIn().getErrorMsg().contains(TestDataReader.loginErrorMsg3);
		test3.log(Status.INFO, "Correct Error Message Displayed");
		Assert.assertTrue(isErrorMsgDisplayed, "The error message for invalid credentials is displayed correctly.");
		test3.log(Status.PASS, "Successfully Checked Invalid Email");

	}
}
