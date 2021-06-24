package com.tsc.test.listeners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;
import com.tsc.test.base.BaseTest;

import extentreport.ExtentTestManager;

public class Retry implements IRetryAnalyzer {

	private int count = 0;
	private static int maxTry = 1; // Run the failed test 2 times


	@Override
	public boolean retry(ITestResult iTestResult) {
		if (!iTestResult.isSuccess()) { // Check if test not succeed
			if (count < maxTry) { // Check if maxtry count is reached
				iTestResult.setStatus(ITestResult.SKIP); // Mark test as failed
				// extendReportsFailOperations(iTestResult);
				count++; // Increase the maxTry count by 1
				return true; // Tells TestNG to re-run the test
			}
		} else {
			iTestResult.setStatus(ITestResult.SUCCESS); // If test passes, TestNG marks it as passed
		}
		return false;
	}

	public void extendReportsFailOperations(ITestResult iTestResult) {
		Object testClass = iTestResult.getInstance();
		WebDriver webDriver = ((BaseTest) testClass).getDriver();
		String base64Screenshot = "data:image/png;base64,"
				+ ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BASE64);
		ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Failed",
				ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot)
						+ iTestResult.getThrowable().getMessage().split("Build")[0].replace("<", "&lt;") + " "
						+ Thread.currentThread().getStackTrace()[2].getMethodName() + "\"" + " action method");
	}
}