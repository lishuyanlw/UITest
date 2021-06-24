package com.tsc.test.listeners;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.mail.MessagingException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.internal.TestResult;

import com.relevantcodes.extentreports.LogStatus;
import com.tsc.test.base.BaseTest;

import extentreport.ExtentManager;
import extentreport.ExtentTestManager;
import extentreport.FileUpload;
import extentreport.SendEmail;
import utils.SauceLabsUtils;

//import java.net.URISyntaxException;

public class TestListener extends BaseTest implements ITestListener , ISuiteListener, IInvokedMethodListener {
	private String strBrowser=System.getProperty("Browser");
	private String strLanguage=System.getProperty("Language");
	private List<ITestResult> extentTests = new ArrayList<ITestResult>();

	private static String getTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	} 

	//Before starting all tests, below method runs.
	
	@Override
	public void onStart(ITestContext iTestContext) {
		System.out.println(" in onStart test " + iTestContext.getName());
		iTestContext.setAttribute("WebDriver", this.getDriver());
	}

	// After ending all tests, below method runs.
	@Override
	public void onFinish(ITestContext iTestContext) {
		System.out.println(" in onFinish method " + iTestContext.getName());
		// Do tier down operations for extentreports reporting!	
		ExtentTestManager.endTest();				
		ExtentManager.getReporter().flush();
	} 

	@Override
	public void onTestStart(ITestResult iTestResult) {
		String sauceSessionId;
		int dataIteratorIndex = ((TestResult) iTestResult).getParameterIndex();
		Object[] dataParam = iTestResult.getParameters();
		System.out.println(" in onTestStart method " +  getTestMethodName(iTestResult) + "-" + dataIteratorIndex + " start");
		//Start operation for extentreports.
		String fullTestClassName[] = iTestResult.getMethod().getTestClass().getName().split("\\.");
		String testClassName = fullTestClassName[fullTestClassName.length-1] +"_" + strBrowser +"_" + strLanguage.toUpperCase();
		if(dataIteratorIndex!=0) {
			testClassName = testClassName + "_DataSet-" + (dataIteratorIndex+1);
		}
		ExtentTestManager.startTest(testClassName,iTestResult.getName());
		extentTests.add(iTestResult);
		Object testClass = iTestResult.getInstance();
		WebDriver driver = ((BaseTest) testClass).getDriver();
		if(dataParam.length!=0) {
			String[] stringArray = Arrays.copyOf(((String[]) dataParam[0]), ((String[]) dataParam[0]).length, String[].class);
			ExtentTestManager.getTest().log(LogStatus.INFO,"Test Data", Arrays.toString(stringArray));
		}
		if(strBrowser.contains("sauce")) {
			sauceSessionId = (((RemoteWebDriver) driver).getSessionId()).toString();
			String[] strLinks = SauceLabsUtils.getSauceJobLinks(sauceSessionId);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Video Started", "<iframe width=\"597\" height=\"448\" src=\""+ strLinks[0] +"&width=597&height=448\">\r\n" + 
					"</iframe>");
			ExtentTestManager.getTest().log(LogStatus.INFO, "", "<a href='"+ strLinks[1] +"' target='_blank'>Click here for Detailed SauceLabs report</a>");
		}
	}

	@Override
	public void onTestSuccess(ITestResult iTestResult) {
		try {
			System.out.println(" in onTestSuccess method " +  getTestMethodName(iTestResult) + " succeed");
			//Extentreports log operation for passed tests.
			Object testClass = iTestResult.getInstance();
			WebDriver driver = ((BaseTest) testClass).getDriver();
			if(strBrowser.contains("sauce")) {
				((JavascriptExecutor) driver).executeScript("sauce:job-result=" + "passed");
				((JavascriptExecutor)driver).executeScript("sauce:job-name="+getTestMethodName(iTestResult));
				String sauceSessionId = (((RemoteWebDriver) driver).getSessionId()).toString();
				String message = String.format("SauceOnDemandSessionID=%1$s job-name=%2$s", sauceSessionId, getTestMethodName(iTestResult));
				System.out.println(message);
			}
		} finally {				//Added finally block So that it will update the extent report without any issues irrespective of the whether the try block will execute with any exception or not
			ExtentTestManager.getTest().log(LogStatus.PASS, "Test passed");
		}
	}

	@Override
	public void onTestFailure(ITestResult iTestResult) {
		System.out.println(" in onTestFailure method " +  getTestMethodName(iTestResult) + " failed");

		if(!extentTests.contains(iTestResult)) {
			int dataIteratorIndex = ((TestResult) iTestResult).getParameterIndex();
			Object[] dataParam = iTestResult.getParameters();
			System.out.println(" in onTestStart method " +  getTestMethodName(iTestResult) + "-" + dataIteratorIndex + " start");
			//Start operation for extentreports.
			String fullTestClassName[] = iTestResult.getMethod().getTestClass().getName().split("\\.");
			String testClassName = fullTestClassName[fullTestClassName.length-1] +"_" + strBrowser +"_" + strLanguage.toUpperCase();
			if(dataIteratorIndex!=0) {
				testClassName = testClassName + "_DataSet-" + (dataIteratorIndex+1);
			}
			ExtentTestManager.startTest(testClassName,iTestResult.getName());
			extentTests.add(iTestResult);
		}

		//Get driver from BaseTest and assign to local webdriver variable.
		Object testClass = iTestResult.getInstance();
		String base64Screenshot="";
		WebDriver webDriver = null;
		try {       
			webDriver = ((BaseTest) testClass).getDriver();
			if(strBrowser.contains("sauce")) {
				((JavascriptExecutor) webDriver).executeScript("sauce:job-result=" + "failed");
				((JavascriptExecutor)webDriver).executeScript("sauce:job-name="+getTestMethodName(iTestResult));
				String sauceSessionId = (((RemoteWebDriver) webDriver).getSessionId()).toString();
				String message = String.format("SauceOnDemandSessionID=%1$s job-name=%2$s", sauceSessionId, getTestMethodName(iTestResult));
				System.out.println(message);
			}
			//Take base64Screenshot screenshot.
			base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)webDriver).getScreenshotAs(OutputType.BASE64);
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally{	//Added finally block So that it will update the extent report without any issues irrespective of the whether the try block will execute with any exception or not
			if(!base64Screenshot.isEmpty()) {
				if(iTestResult.getThrowable().getMessage().startsWith("Custom Exception")) {
					//Extentreports log and screenshot operations for failed tests.
					ExtentTestManager.getTest().log(LogStatus.FAIL,"Test Failed : " + iTestResult.getName(),
							ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot)
							+ iTestResult.getThrowable().getMessage().split("Build")[0].replace("<", "&lt;")+"\"");
				}else {
					ExtentTestManager.getTest().log(LogStatus.FAIL,"Test Failed : " + iTestResult.getName(),
							ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot)
							+ "Exception occured: " + iTestResult.getThrowable().getMessage().split("Build")[0].replace("<", "&lt;").replace("\"", ""));
				}
			}else {
				if(iTestResult.getThrowable().getMessage().startsWith("Custom Exception")) {
					ExtentTestManager.getTest().log(LogStatus.FAIL,"Test Failed : " + iTestResult.getName(),
							iTestResult.getThrowable().getMessage().split("Build")[0].replace("<", "&lt;")+"\"");
				}else {
					ExtentTestManager.getTest().log(LogStatus.FAIL,"Test Failed : " + iTestResult.getName(),
							"Exception occured: " + iTestResult.getThrowable().getMessage().split("Build")[0].replace("<", "&lt;").replace("\"", ""));
				}
			}
		}
	}

	@Override
	public void onTestSkipped(ITestResult iTestResult) {   
		System.out.println(" in onTestSkipped method " + getTestMethodName(iTestResult) + " skipped");
		if(!extentTests.contains(iTestResult)) {
			int dataIteratorIndex = ((TestResult) iTestResult).getParameterIndex();
			Object[] dataParam = iTestResult.getParameters();
			System.out.println(" in onTestStart method " +  getTestMethodName(iTestResult) + "-" + dataIteratorIndex + " start");
			//Start operation for extentreports.
			String fullTestClassName[] = iTestResult.getMethod().getTestClass().getName().split("\\.");
			String testClassName = fullTestClassName[fullTestClassName.length-1] +"_" + strBrowser +"_" + strLanguage.toUpperCase();
			if(dataIteratorIndex!=0) {
				testClassName = testClassName + "_DataSet-" + (dataIteratorIndex+1);
			}
			ExtentTestManager.startTest(testClassName,iTestResult.getName());
			extentTests.add(iTestResult);
		}

		// Get driver from BaseTest and assign to local webdriver variable.
		Object testClass = iTestResult.getInstance();		
		WebDriver webDriver = null; 
		String base64Screenshot = "";
		try {
			webDriver = ((BaseTest) testClass).getDriver();
			if(strBrowser.contains("sauce")) {
				((JavascriptExecutor) webDriver).executeScript("sauce:job-result=" + "skipped");				
				((JavascriptExecutor)webDriver).executeScript("sauce:job-name="+getTestMethodName(iTestResult));
				String sauceSessionId = (((RemoteWebDriver) webDriver).getSessionId()).toString();
				String message = String.format("SauceOnDemandSessionID=%1$s job-name=%2$s", sauceSessionId, getTestMethodName(iTestResult));
				System.out.println(message);
			}
			// Take base64Screenshot screenshot.
			base64Screenshot = "data:image/png;base64,"+ ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BASE64);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {		//Added finally block So that it will update the extent report without any issues irrespective of the whether the try block will execute with any exception or not
			if(!base64Screenshot.isEmpty()) {
				// Extentreports log operation for skipped tests.
				if(iTestResult.getThrowable().getMessage().startsWith("Custom Exception")) {
					ExtentTestManager.getTest().log(LogStatus.SKIP,"Test Case " + "\""+  iTestResult.getName()+"\"" + " has Skipped for re-execution" ,
							ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot)
							+ iTestResult.getThrowable().getMessage().split("Build")[0].replace("<", "&lt;")+"\"");
				}else {
					ExtentTestManager.getTest().log(LogStatus.SKIP,"Test Case " + "\""+  iTestResult.getName()+"\"" + " has Skipped for re-execution" ,
							ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot)
							+ "Exception occured: " + iTestResult.getThrowable().getMessage().split("Build")[0].replace("<", "&lt;").replace("\"", ""));
				}
			}else {
				if(iTestResult.getThrowable().getMessage().startsWith("Custom Exception")) {
					ExtentTestManager.getTest().log(LogStatus.SKIP,"Test Case " + "\""+  iTestResult.getName()+"\"" + " has Skipped for re-execution" ,
							iTestResult.getThrowable().getMessage().split("Build")[0].replace("<", "&lt;")+"\"");
				}else {
					ExtentTestManager.getTest().log(LogStatus.SKIP,"Test Case " + "\""+  iTestResult.getName()+"\"" + " has Skipped for re-execution" ,
							"Exception occured: " + iTestResult.getThrowable().getMessage().split("Build")[0].replace("<", "&lt;").replace("\"", ""));
				}
			}
		}
	} 

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
		System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
	}

	/**
	 * This listener method is invoked before a method is invoked by TestNG
	 */
	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		// TODO Auto-generated method stub
	}

	/**
	 * This listener method is invoked after a method is invoked by TestNG
	 */
	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		if(testResult.getMethod().isTest()) {
			if(testResult.getStatus() == ITestResult.SUCCESS) {
				if(ExtentTestManager.getFailFlag()) {
					Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
					Reporter.getCurrentTestResult().setThrowable(new AssertionError("Assertion Failed"));
				}
			}
		}
	}


	@Override
	public void onStart(ISuite suite)  {

		System.out.println("Data File Initialized");
	}

	/**
	 * This listener is invoked at the end of suite
	 */
	@Override
	public void onFinish(ISuite suite) {

		try {
			/**
			 * The if block will get executed if the test run is triggered from local machine or any machine
			 * where BUILD_TIMESTAMP is not setup. BUILD_TIMESTAMP env variable is set by Jenkins job.
 			 */
			if((System.getenv("BUILD_TIMESTAMP")==null) || System.getenv("BUILD_TIMESTAMP").equals("")) {
				String strResPath= FileUpload.extentReportsUpload();
				SendEmail.sendEmail(suite.getName(), strResPath);
			}
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
