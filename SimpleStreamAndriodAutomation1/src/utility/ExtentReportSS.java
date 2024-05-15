package utility;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportSS {
	ExtentSparkReporter sparkReporter;
	protected ExtentReports extent;
	@BeforeSuite
	public void reportSetUp() {
		sparkReporter = new ExtentSparkReporter("Report.html");
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		
	}
	@AfterSuite
	public void reportTearDown() {
		extent.flush();
	}
}
