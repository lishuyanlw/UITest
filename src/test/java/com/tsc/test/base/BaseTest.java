package com.tsc.test.base;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.tsc.api.apiBuilder.ApiResponse;
import com.tsc.pages.*;
import org.apache.http.client.ClientProtocolException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.tsc.data.Handler.TestDataHandler;

import extentreport.ExtentTestManager;
import utils.BrowserDrivers;
import utils.Reporter;

public class BaseTest {

	protected static Reporter reporter;
	protected HashMap<String, String> xmlTestParameters;
	Map<String, String> sauceParameters;
	protected BrowserDrivers browserDrivers;
	protected String suiteName;
	private Map<String, String> RunParameters;

	protected static final ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();
	protected static final ThreadLocal<GlobalHeaderPage> globalheaderPageThreadLocal = new ThreadLocal<>();
	protected static final ThreadLocal<HomePage> homePageThreadLocal = new ThreadLocal<>();
	protected static final ThreadLocal<GlobalFooterPage> globalFooterPageThreadLocal = new ThreadLocal<>();
	protected static final ThreadLocal<ProductResultsPage> productResultsPageThreadLocal = new ThreadLocal<>();
	protected static final ThreadLocal<ProductDetailPage> productDetailPageThreadLocal = new ThreadLocal<>();
	protected static final ThreadLocal<ProductResultsPage_Mobile> productResultsPage_MobileThreadLocal = new ThreadLocal<>();
	protected static final ThreadLocal<LoginPage> loginPageThreadLocal = new ThreadLocal<>();
	protected static final ThreadLocal<String> TestDeviceThreadLocal = new ThreadLocal<>();
	protected static final ThreadLocal<ApiResponse> apiResponseThreadLocal = new ThreadLocal<>();

	public BaseTest() {
		browserDrivers = new BrowserDrivers();
	}

	/**
	 * @return the reporter
	 */
	public static Reporter getReporter() {
		return reporter;
	}

	//@return apiResponseThreadLocal
	public static ApiResponse getApiResponseThreadLocal() {return apiResponseThreadLocal.get();}

	// @return the globalheaderPageThreadLocal
	protected static GlobalHeaderPage getglobalheaderPageThreadLocal() {return globalheaderPageThreadLocal.get();	}

	// @return the homePageThreadLocal
	protected static HomePage homePageThreadLocal() {	return homePageThreadLocal.get();	}

	//@return the GlobalFooterThreadLocal
	protected static GlobalFooterPage getGlobalFooterPageThreadLocal() {
		return globalFooterPageThreadLocal.get();
	}

	//@return the ProductResultsPageThreadLocal
	protected static ProductResultsPage getProductResultsPageThreadLocal() {
		return productResultsPageThreadLocal.get();
	}

	//@return the ProductResultsPage_MobileThreadLocal
	protected static ProductResultsPage_Mobile getProductResultsPage_MobileThreadLocal() {
		return productResultsPage_MobileThreadLocal.get();
	}

	protected static ProductDetailPage getProductDetailPageThreadLocal() {
		return productDetailPageThreadLocal.get();
	}
	
	protected static LoginPage getGlobalLoginPageThreadLocal() {
		return loginPageThreadLocal.get();
	}

	protected static String getTestDeviceThreadLocal () {
		return TestDeviceThreadLocal.get();
	}

	private void init() throws IOException {
		homePageThreadLocal.set(new HomePage(getDriver()));
		globalheaderPageThreadLocal.set(new GlobalHeaderPage(getDriver()));
		globalFooterPageThreadLocal.set(new GlobalFooterPage(getDriver()));
		productResultsPageThreadLocal.set(new ProductResultsPage(getDriver()));
		globalFooterPageThreadLocal.set(new GlobalFooterPage(getDriver()));
		productDetailPageThreadLocal.set(new ProductDetailPage(getDriver()));
		loginPageThreadLocal.set(new LoginPage(getDriver()));
		reporter = new ExtentTestManager(getDriver());
		apiResponseThreadLocal.set(new ApiResponse());
	}

	private void init_Mobile() throws IOException {
		globalheaderPageThreadLocal.set(new GlobalHeaderPage_Mobile(getDriver()));
		loginPageThreadLocal.set(new LoginPage_Mobile(getDriver()));
		globalFooterPageThreadLocal.set(new GlobalFooterPage_Mobile(getDriver()));
		productResultsPageThreadLocal.set(new ProductResultsPage_Mobile(getDriver()));
		productDetailPageThreadLocal.set(new ProductDetailPage_Mobile(getDriver()));
		reporter = new ExtentTestManager(getDriver());
		apiResponseThreadLocal.set(new ApiResponse());
	}

	private void init_Tablet() throws IOException {
		productResultsPageThreadLocal.set(new ProductResultsPage_Tablet(getDriver()));
		globalheaderPageThreadLocal.set(new GlobalHeaderPage_Mobile(getDriver()));

		if(System.getProperty("Browser").contains("android") ||
				(System.getProperty("chromeMobileDevice")!=null
						&& !System.getProperty("chromeMobileDevice").contains("iPad"))) {
			productDetailPageThreadLocal.set(new ProductDetailPage_Mobile(getDriver()));
			globalFooterPageThreadLocal.set(new GlobalFooterPage_Mobile(getDriver()));
		}else {
			productDetailPageThreadLocal.set(new ProductDetailPage_Tablet(getDriver()));
			globalFooterPageThreadLocal.set(new GlobalFooterPage_Tablet(getDriver()));
		}

		loginPageThreadLocal.set(new LoginPage_Mobile(getDriver()));
		reporter = new ExtentTestManager(getDriver());
		apiResponseThreadLocal.set(new ApiResponse());
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

	public void startSession (String strUrl, String strBrowser, String strLanguage, Method currentTestMethodName,
							  boolean bypassCaptcha) throws ClientProtocolException, IOException {
		RunParameters = getExecutionParameters(strBrowser, strLanguage);
		strBrowser = RunParameters.get("Browser").toLowerCase();
		strLanguage = RunParameters.get("Language").toLowerCase();

		if (strBrowser.toLowerCase().contains("sauce")) {
			sauceParameters = initializeSauceParamsMap(strBrowser);
		}

		webDriverThreadLocal.set(browserDrivers.driverInit(strBrowser, sauceParameters, currentTestMethodName, ""));
		getDriver().get(strUrl);

		String lsTestDevice = System.getProperty("Device").trim();
		TestDeviceThreadLocal.set(lsTestDevice);
		if (strBrowser.toLowerCase().contains("android") || strBrowser.toLowerCase().contains("ios")
				|| strBrowser.toLowerCase().contains("mobile")) {
			switch (lsTestDevice) {
				case "Tablet":
					init_Tablet();
					break;
				case "Mobile":
					init_Mobile();
					break;
			}
		} else {
			init();
		}
		/*if (!strBrowser.toLowerCase().contains("android") && !strBrowser.toLowerCase().contains("ios")
			&& !strBrowser.toLowerCase().contains("mobile")) {
		getDriver().manage().window().maximize();
	}*/
			setImplictWait(getDriver(), 60);
			//Refreshing browser so that Access Denied issue is resolved from Sauce Lab
			getglobalheaderPageThreadLocal().getReusableActionsInstance().staticWait(3000);
			getDriver().navigate().refresh();
	}

	
	/**
	 * To get parameters from XML file, it is called in TestListener.
	 *
	 * @return HashMap of test parameters
	 **/
	
	public HashMap<String, String> getXMLParameters() {
		return xmlTestParameters;
	}
	

	/**
	 * Declare the sauce capabilities as ENUM type
	 *
	 */
	public enum SauceCapabilities {
		seleniumVersion, maxDuration, commandTimeout, idleTimeout, build, screenResolution, browserVersion, appiumVersion, deviceName,
		deviceOrientation, platformVersion, platformName, deviceType
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

	
	public void validateText(String strActualText, List<String> listExpectedText, String validationMsg) {
		reporter.softAssert(listExpectedText.equals(strActualText), validationMsg + ":" + " Expected=" + listExpectedText +  " ; Actual="+ strActualText ,validationMsg + " expected=" + listExpectedText +  "; actual="+ strActualText);
		
	}
	//Method to validate content of Link and button
	public void validateText(String strActualText, String strExpectedText, String validationMsg) {
	reporter.softAssert(strExpectedText.trim().equals(strActualText.trim()), validationMsg + ":" + " Expected=" + strExpectedText +  " ; Actual="+ strActualText ,validationMsg + " expected=" + strExpectedText +  "; actual="+ strActualText);
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
		sauceOptions.put(SauceCapabilities.screenResolution.toString(),TestDataHandler.sauceSettings.getSauceOptions().getScreenResolution());

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
				if(System.getProperty("Device").equalsIgnoreCase("Tablet")){
					sauceOptions.put(SauceCapabilities.deviceType.toString(),TestDataHandler.sauceSettings.getAndroidChromeCapabilities().getDeviceType().toLowerCase());
				}
				break;
			case "sauceioschrome":
				sauceOptions.put(SauceCapabilities.appiumVersion.toString(), TestDataHandler.sauceSettings.getIosSafariCapabilities().getAppiumVersion());
				sauceOptions.put(SauceCapabilities.deviceName.toString(), TestDataHandler.sauceSettings.getIosSafariCapabilities().getDeviceName());
				sauceOptions.put(SauceCapabilities.deviceOrientation.toString(), TestDataHandler.sauceSettings.getIosSafariCapabilities().getDeviceOrientation());
				sauceOptions.put(SauceCapabilities.platformVersion.toString(), TestDataHandler.sauceSettings.getIosSafariCapabilities().getPlatformVersion());
				sauceOptions.put(SauceCapabilities.platformName.toString(), TestDataHandler.sauceSettings.getIosSafariCapabilities().getPlatformName());
				if(System.getProperty("Device").equalsIgnoreCase("Tablet")){
					sauceOptions.put(SauceCapabilities.deviceType.toString(),TestDataHandler.sauceSettings.getIosSafariCapabilities().getDeviceType().toLowerCase());
				}
				break;
		}

		return sauceOptions;
	}
	
	
}
