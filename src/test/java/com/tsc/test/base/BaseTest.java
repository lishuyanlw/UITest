package com.tsc.test.base;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.http.client.ClientProtocolException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Cookie;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.GlobalheaderPage;
import com.tsc.pages.HomePage;
import com.tsc.pages.GlobalFooterPage;

import extentreport.ExtentTestManager;
import utils.BrowserDrivers;
import utils.Reporter;

public class BaseTest {

	protected static Reporter reporter;
	//protected HashMap<String, String> xmlTestParameters;
	Map<String, String> sauceParameters;
	protected BrowserDrivers browserDrivers;
	protected String suiteName;
	private Map<String, String> RunParameters;

	protected static final ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();
	protected static final ThreadLocal<GlobalheaderPage> globalheaderPageThreadLocal = new ThreadLocal<>();
	protected static final ThreadLocal<HomePage> homePageThreadLocal = new ThreadLocal<>();
	protected static final ThreadLocal<GlobalFooterPage> globalFooterPageThreadLocal = new ThreadLocal<>();

	public BaseTest() {
		browserDrivers = new BrowserDrivers();
	}

	/**
	 * @return the reporter
	 */
	public static Reporter getReporter() {
		return reporter;
	}

	
	// @return the globalheaderPageThreadLocal
	
	protected static GlobalheaderPage getglobalheaderPageThreadLocal() {
		return globalheaderPageThreadLocal.get();
	}
	
	//// @return the homePageThreadLocal
	protected static HomePage homePageThreadLocal() {
		return homePageThreadLocal.get();
	}
//

	protected static GlobalFooterPage getGlobalFooterPageThreadLocal() {
		return globalFooterPageThreadLocal.get();
	}

	private void init() {
		
		homePageThreadLocal.set(new HomePage(getDriver()));
		globalheaderPageThreadLocal.set(new GlobalheaderPage(getDriver()));
		globalFooterPageThreadLocal.set(new GlobalFooterPage(getDriver()));
		reporter = new ExtentTestManager(getDriver());
	}

	public WebDriver getDriver() {
		return webDriverThreadLocal.get();
	}

	public void setDriver(WebDriver driver) {
		webDriverThreadLocal.set(driver);
	}

	public void closeSession() {
		getDriver().quit();
	}

	public void setImplictWait(WebDriver driver, long seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}

	public void startSession(String strUrl, String strBrowser, String strLanguage, Method currentTestMethodName,
			boolean bypassCaptcha) throws ClientProtocolException, IOException {
		RunParameters = getExecutionParameters(strBrowser, strLanguage);
		strBrowser = RunParameters.get("Browser").toLowerCase();
		strLanguage = RunParameters.get("Language").toLowerCase();

		if (strBrowser.toLowerCase().contains("sauce")) { 
			sauceParameters =	initializeSauceParamsMap(strBrowser); 
			}
		
		webDriverThreadLocal.set(browserDrivers.driverInit(strBrowser, sauceParameters, currentTestMethodName, ""));
		getDriver().get(strUrl);
		if (!strBrowser.toLowerCase().contains("android") && !strBrowser.toLowerCase().contains("ios")
				&& !strBrowser.toLowerCase().contains("mobile")) {
			getDriver().manage().window().maximize();
		}
		setImplictWait(getDriver(), 60);
		//setSessionStorage(strUrl);
		init();
	}

	
	/**
	 * To get parameters from XML file, it is called in TestListener.
	 *
	 * @return HashMap of test parameters
	 **/
	/*
	public HashMap<String, String> getXMLParameters() {
		return xmlTestParameters;
	}
	*/

	/**
	 * Declare the sauce capabilities as ENUM type
	 *
	 */
	public enum SauceCapabilities {
		seleniumVersion, maxDuration, commandTimeout, idleTimeout, build, browserVersion, appiumVersion, deviceName,
		deviceOrientation, platformVersion, platformName
	}

	/**
	 * To start a session using given url, browser, language and test case group
	 * name.
	 *
	 * @param strLanguage string of test Language
	 * @param strBrowser  string of browser name
	 * @return HashMap of test TestParameters
	 */
	public static HashMap<String, String> getExecutionParameters(String strBrowser, String strLanguage) {
		if (System.getProperty("Browser") == null || System.getProperty("Browser").isEmpty()) {
			System.setProperty("Browser", strBrowser);
		}
		if (System.getProperty("Language") == null || System.getProperty("Language").isEmpty()) {
			System.setProperty("Language", strLanguage);
		}
		if (System.getProperty("Browser").equals("") && strBrowser.isEmpty()) {
			System.setProperty("Browser", "chrome");
		}
		if (System.getProperty("Language").equals("") && strLanguage.isEmpty()) {
			System.setProperty("Language", "en");
		}
		strBrowser = System.getProperty("Browser");
		strLanguage = System.getProperty("Language");
		HashMap<String, String> TestParameters = new HashMap<>();
		TestParameters.put("Browser", strBrowser);
		TestParameters.put("Language", strLanguage);
		return TestParameters;
	}

	@BeforeSuite(alwaysRun = true)
	public void beforeSuite() throws FileNotFoundException {
		TestDataHandler.dataInit();
		System.out.println("Data File initialized at before Suite");
	}

	@BeforeMethod(alwaysRun = true)
	@Parameters({ "strBrowser", "strLanguage" })
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,
			ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("QaUrl"), strBrowser, strLanguage, method, false);
		getglobalheaderPageThreadLocal().waitForPageLoad();
		// getHomePageThreadLocal().waitforOverlayLoadingSpinnerToDisapper();
		// reporter.hardAssert(getHomePageThreadLocal().validateLogoRogers(), "Home Page
		// Loaded", "Home Page Not Loaded");
		//getglobalheaderPageThreadLocal().setLanguage(System.getProperty("Language"));
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		if (getDriver() != null) {
			//deleteSessionStorage();
			closeSession();
		}
	}

	//Method to validate content of Link and button
	public void validateText(String strActualText, String strExpectedText, String validationMsg) {
	reporter.softAssert(strExpectedText.equals(strActualText), validationMsg + ":" + " Expected=" + strExpectedText +  " ; Actual="+ strActualText ,validationMsg + " expected=" + strExpectedText +  "; actual="+ strActualText);
	}

	/**
	 * This method will initialize a hash map with the sauce parameters
	 *
	 * @param strBrowser string containing the browser name for sauce
	 * @return Hash map with sauce capabilities
	 * @author Mirza.Kamran
	 */
	
	private Map<String, String> initializeSauceParamsMap(String strBrowser) {
		Map<String, String> sauceOptions = new HashMap<>();
		sauceOptions.put(SauceCapabilities.seleniumVersion.toString(), TestDataHandler.sauceSettings.getSauceOptions().getSeleniumVersion());
		sauceOptions.put(SauceCapabilities.maxDuration.toString(), TestDataHandler.sauceSettings.getSauceOptions().getMaxDuration());
		sauceOptions.put(SauceCapabilities.commandTimeout.toString(), TestDataHandler.sauceSettings.getSauceOptions().getCommandTimeout());
		sauceOptions.put(SauceCapabilities.idleTimeout.toString(), TestDataHandler.sauceSettings.getSauceOptions().getIdleTimeout());
		sauceOptions.put(SauceCapabilities.build.toString(), TestDataHandler.sauceSettings.getSauceOptions().getBuild());

		switch (strBrowser.toLowerCase()) {
		case "saucechrome":
			sauceOptions.put(SauceCapabilities.platformName.toString(), TestDataHandler.sauceSettings.getMutableChromeCapabilities().getPlatformName());
			sauceOptions.put(SauceCapabilities.browserVersion.toString(), TestDataHandler.sauceSettings.getMutableChromeCapabilities().getBrowserVersion());
			break;
		case "saucefirefox":
			sauceOptions.put(SauceCapabilities.platformName.toString(), TestDataHandler.sauceSettings.getMutableFireFoxCapabilities().getPlatformName());
			sauceOptions.put(SauceCapabilities.browserVersion.toString(), TestDataHandler.sauceSettings.getMutableFireFoxCapabilities().getBrowserVersion());
			break;
		case "sauceedge":
			sauceOptions.put(SauceCapabilities.platformName.toString(), TestDataHandler.sauceSettings.getMutableEdgeCapabilities().getPlatformName());
			sauceOptions.put(SauceCapabilities.browserVersion.toString(), TestDataHandler.sauceSettings.getMutableEdgeCapabilities().getBrowserVersion());
			break;
		case "saucesafari":
			sauceOptions.put(SauceCapabilities.platformName.toString(), TestDataHandler.sauceSettings.getMutableSafariCapabilities().getPlatformName());
			sauceOptions.put(SauceCapabilities.browserVersion.toString(), TestDataHandler.sauceSettings.getMutableSafariCapabilities().getBrowserVersion());
			break;
		case "sauceandroidchrome":
			sauceOptions.put(SauceCapabilities.appiumVersion.toString(), TestDataHandler.sauceSettings.getAndroidChromeCapabilities().getAppiumVersion());
			sauceOptions.put(SauceCapabilities.deviceName.toString(), TestDataHandler.sauceSettings.getAndroidChromeCapabilities().getDeviceName());
			sauceOptions.put(SauceCapabilities.deviceOrientation.toString(), TestDataHandler.sauceSettings.getAndroidChromeCapabilities().getDeviceOrientation());
			sauceOptions.put(SauceCapabilities.platformVersion.toString(), TestDataHandler.sauceSettings.getAndroidChromeCapabilities().getPlatformVersion());
			sauceOptions.put(SauceCapabilities.platformName.toString(), TestDataHandler.sauceSettings.getAndroidChromeCapabilities().getPlatformName());
			break;
		case "sauceioschrome":
			sauceOptions.put(SauceCapabilities.appiumVersion.toString(), TestDataHandler.sauceSettings.getIosSafariCapabilities().getAppiumVersion());
			sauceOptions.put(SauceCapabilities.deviceName.toString(), TestDataHandler.sauceSettings.getIosSafariCapabilities().getDeviceName());
			sauceOptions.put(SauceCapabilities.deviceOrientation.toString(), TestDataHandler.sauceSettings.getIosSafariCapabilities().getDeviceOrientation());
			sauceOptions.put(SauceCapabilities.platformVersion.toString(), TestDataHandler.sauceSettings.getIosSafariCapabilities().getPlatformVersion());
			sauceOptions.put(SauceCapabilities.platformName.toString(), TestDataHandler.sauceSettings.getIosSafariCapabilities().getPlatformName());
			break;
		}

		return sauceOptions;
	}
	
	
}
