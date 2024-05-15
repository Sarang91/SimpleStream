package utility;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

/* ExtentReportSS Class - Instantiates ExtentReports and flushes it,
/  has before suite and after suite tags/methods for extent report related settings
*/
public class ExtentReportSS 
{
	ExtentSparkReporter sparkReporter;
	protected ExtentReports extent;
	
	//Runs before suite, does initial setup needed for extent report
	@BeforeSuite
	public void reportSetUp() 
	{
		sparkReporter = new ExtentSparkReporter("Report.html");
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
	}
	
	//Runs after suite execution, does flush
	@AfterSuite
	public void reportTearDown() 
	{
		extent.flush();
	}
}
