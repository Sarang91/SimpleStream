package utility;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

//Class for reading data for properties file and saving it in its static variables
public class TestDataReader 
{
	public static String invalidUserName1;
	public static String invalidPassword1;
	public static String invalidUserName2;
	public static String invalidPassword2;
	public static String validUserName;
	public static String validPassword;
	public static String loginErrorMsg;
	public static String loginErrorMsg2;
	public static String siteUrl;

	//Reads data from the properties file and assigns values to the static variables
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
		validUserName = p.getProperty("validUserName");
		validPassword = p.getProperty("validPassword");	
		loginErrorMsg = p.getProperty("loginErrorMsg");
		loginErrorMsg2 = p.getProperty("loginErrorMsg2");
		siteUrl = p.getProperty("siteUrl");
	}
}
