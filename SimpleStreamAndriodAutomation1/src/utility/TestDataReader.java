package utility;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class TestDataReader 
{
	public static String invalidUserName1;
	public static String invalidPassword1;
	public static String invalidUserName2;
	public static String invalidPassword2;
	public static String validUserName1;
	public static String validPassword1;
	public static String loginErrorMsg;
	public static String invalidUserName3;
	public static String invalidPassword3;
	public static String loginErrorMsg3;
	public static String siteUrl;

	public static void readTestData() throws IOException
	{
		String path = System.getProperty("user.dir");
		String propertiesPath = path+ "\\src\\utility\\TestData.properties";
		FileReader fr = new FileReader(propertiesPath);
		Properties p = new Properties();
		p.load(fr);
		
		invalidUserName1 = p.getProperty("invalidUserName1");
		invalidPassword1 = p.getProperty("invalidPassword1");
		invalidUserName2 = p.getProperty("invalidUserName2");
		invalidPassword2 = p.getProperty("invalidPassword2");
		validUserName1 = p.getProperty("validUserName1");
		validPassword1 = p.getProperty("validPassword1");	
		loginErrorMsg = p.getProperty("loginErrorMsg");
		invalidUserName3 = p.getProperty("invalidUsername3");
		invalidPassword3 = p.getProperty("invalidPassword3");
		loginErrorMsg3 = p.getProperty("loginErrorMsg3");
		siteUrl = p.getProperty("siteUrl");
	}
}
