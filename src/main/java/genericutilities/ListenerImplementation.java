package genericutilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener,ISuiteListener {

	public ExtentReports report;
	public ExtentTest test;
	
	@Override
	public void onStart(ISuite suite)
	{
		System.out.println("Report Configuration");
		JavaUtility jLib=new JavaUtility();
		
		ExtentSparkReporter spark=new ExtentSparkReporter("./ExtentReports/report_"+jLib.getCurrentDateAndTime()+"html");
		spark.config().setDocumentTitle("CRM Reports");
		spark.config().setReportName("NINZA_CRM Report");
		spark.config().setTheme(Theme.DARK);
		
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("Browser", "Chrome");
	}
	
	@Override
	public void onFinish(ISuite suite)
	{
		System.out.println("Report Backup");
		report.flush();
	}
	
	@Override
	public void onTestStart(ITestResult result)
	{
		String testCaseName=result.getMethod().getMethodName();
		//System.out.println(testCaseName+" Execution started");
		test=report.createTest(testCaseName);
		test.log(Status.INFO, testCaseName+" Execution started");
	}
	
	@Override
	public void onTestSuccess(ITestResult result)
	{
		String testCaseName=result.getMethod().getMethodName();
		//System.out.println(testCaseName+" Execution success");
		test.log(Status.PASS, testCaseName+" Execution success");
	}
	
	@Override
	public void onTestFailure(ITestResult result)
	{
		String testCaseName=result.getMethod().getMethodName();
		//System.out.println(testCaseName+" Execution failed");
		//JavaUtility jLib=new JavaUtility();
		test.log(Status.FAIL, testCaseName+" Execution failed");
		TakesScreenshot ts=(TakesScreenshot)BaseClass.sdriver;
		//File src=ts.getScreenshotAs(OutputType.FILE);
		String src=ts.getScreenshotAs(OutputType.BASE64);
		/*File dest=new File("./Errorshots/"+testCaseName+jLib.getCurrentDateAndTime()+".png");
		try
		{
			FileHandler.copy(src, dest);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}*/
		test.addScreenCaptureFromBase64String(src);
	}
	
	@Override
	public void onTestSkipped(ITestResult result)
	{
		String testCaseName=result.getMethod().getMethodName();
		//System.out.println(testCaseName+" Execution skipped");
		test.log(Status.SKIP, testCaseName+" Execution skipped");
	}
}
