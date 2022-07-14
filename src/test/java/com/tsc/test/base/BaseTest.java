package com.tsc.test.base;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.TimeUnit;
import com.fasterxml.jackson.core.type.TypeReference;
import com.tsc.api.apiBuilder.AccountAPI;
import com.tsc.api.apiBuilder.ApiResponse;
import com.tsc.api.apiBuilder.CartAPI;
import com.tsc.api.apiBuilder.OrderAPI;
import com.tsc.api.pojo.CartResponse;
import com.tsc.api.pojo.GetOrderListResponse;
import com.tsc.api.util.DataConverter;
import com.tsc.api.util.JsonParser;
import com.tsc.data.pojos.ConstantData;
import com.tsc.pages.*;
import extentreport.ExtentListener;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import com.tsc.data.Handler.TestDataHandler;
import extentreport.ExtentTestManager;
import org.testng.annotations.Optional;
import utils.BrowserDrivers;
import utils.Reporter;
import static java.time.temporal.ChronoUnit.DAYS;

public class BaseTest {

	protected static Reporter reporter;
	protected HashMap<String, String> xmlTestParameters;
	Map<String, String> sauceParameters;
	protected BrowserDrivers browserDrivers;
	private Map<String, String> RunParameters;
	protected static JSONObject apiUserSessionData = null;
	protected static JSONObject apiAppSessionData = null;
	protected static boolean placeOrderValue = false;

	protected static final ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();
	protected static final ThreadLocal<GlobalHeaderPage> globalHeaderPageThreadLocal = new ThreadLocal<>();
	protected static final ThreadLocal<HomePage> homePageThreadLocal = new ThreadLocal<>();
	protected static final ThreadLocal<GlobalFooterPage> globalFooterPageThreadLocal = new ThreadLocal<>();
	protected static final ThreadLocal<ProductResultsPage> productResultsPageThreadLocal = new ThreadLocal<>();
	protected static final ThreadLocal<ProductDetailPage> productDetailPageThreadLocal = new ThreadLocal<>();
	protected static final ThreadLocal<SignInPage> loginPageThreadLocal = new ThreadLocal<>();
	protected static final ThreadLocal<String> TestDeviceThreadLocal = new ThreadLocal<>();
	protected static final ThreadLocal<ApiResponse> apiResponseThreadLocal = new ThreadLocal<>();
	protected static final ThreadLocal<ShoppingCartPage> shoppingCartThreadLocal = new ThreadLocal<>();
	protected static final ThreadLocal<JSONObject> apiUserSessionDataMapThreadLocal = new ThreadLocal<>();
	protected static final ThreadLocal<JSONObject> apiAppSessionDataMapThreadLocal = new ThreadLocal<>();
	protected static final ThreadLocal<MyAccount> myAccountPageThreadLocal = new ThreadLocal<>();

	public BaseTest() {
		browserDrivers = new BrowserDrivers();
	}

	/**
	 * @return the reporter
	 */
	public static Reporter getReporter() {
		return reporter;
	}

	//@return shoppingCartThreadLocal
	public static ShoppingCartPage getShoppingCartThreadLocal() {return shoppingCartThreadLocal.get();}

	//@return apiResponseThreadLocal
	public static ApiResponse getApiResponseThreadLocal() {return apiResponseThreadLocal.get();}

	// @return the globalheaderPageThreadLocal
	protected static GlobalHeaderPage getglobalheaderPageThreadLocal() {return globalHeaderPageThreadLocal.get();	}

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

	protected static ProductDetailPage getProductDetailPageThreadLocal() {
		return productDetailPageThreadLocal.get();
	}
	
	protected static SignInPage getGlobalLoginPageThreadLocal() {
		return loginPageThreadLocal.get();
	}

	//@return the ProductResultsPageThreadLocal
	protected static String getTestDeviceThreadLocal () {
		return TestDeviceThreadLocal.get();
	}

	//@return UserSessionDataThreadLocal
	protected static JSONObject getApiUserSessionDataMapThreadLocal () {		return apiUserSessionDataMapThreadLocal.get();	}

	//@return ApiAppSessionDataThreadLocal
	protected static JSONObject getApiAppSessionDataMapThreadLocal () {
		return apiAppSessionDataMapThreadLocal.get();
	}

	//@return ApiAppSessionDataThreadLocal
	protected static MyAccount getMyAccountPageThreadLocal () {
		return myAccountPageThreadLocal.get();
	}

	private void init() throws IOException {
		homePageThreadLocal.set(new HomePage(getDriver()));
		globalHeaderPageThreadLocal.set(new GlobalHeaderPage(getDriver()));
		globalFooterPageThreadLocal.set(new GlobalFooterPage(getDriver()));
		productResultsPageThreadLocal.set(new ProductResultsPage(getDriver()));
		globalFooterPageThreadLocal.set(new GlobalFooterPage(getDriver()));
		productDetailPageThreadLocal.set(new ProductDetailPage(getDriver()));
		loginPageThreadLocal.set(new SignInPage(getDriver()));
		reporter = new ExtentTestManager(getDriver());
		apiResponseThreadLocal.set(new ApiResponse());
		shoppingCartThreadLocal.set(new ShoppingCartPage(getDriver()));
		myAccountPageThreadLocal.set(new MyAccount(getDriver()));
	}

	private void init_Mobile() throws IOException {
		homePageThreadLocal.set(new HomePage(getDriver()));
		globalHeaderPageThreadLocal.set(new GlobalHeaderPage_Mobile(getDriver()));
		loginPageThreadLocal.set(new SignInPage_Mobile(getDriver()));
		globalFooterPageThreadLocal.set(new GlobalFooterPage_Mobile(getDriver()));
		productResultsPageThreadLocal.set(new ProductResultsPage_Mobile(getDriver()));
		productDetailPageThreadLocal.set(new ProductDetailPage_Mobile(getDriver()));
		reporter = new ExtentTestManager(getDriver());
		apiResponseThreadLocal.set(new ApiResponse());
		shoppingCartThreadLocal.set(new ShoppingCartPage_Mobile(getDriver()));
		myAccountPageThreadLocal.set(new MyAccount_Mobile(getDriver()));
	}

	private void init_Tablet() throws IOException {
		productResultsPageThreadLocal.set(new ProductResultsPage_Tablet(getDriver()));

		if(System.getProperty("Browser").equalsIgnoreCase("chromemobile")){
			globalFooterPageThreadLocal.set(new GlobalFooterPage_Tablet_IOS(getDriver()));
		}
		else{
			if(System.getProperty("Browser").contains("android")){
				globalFooterPageThreadLocal.set(new GlobalFooterPage_Tablet_Android(getDriver()));
			}
			else{
				globalFooterPageThreadLocal.set(new GlobalFooterPage_Tablet_IOS(getDriver()));
			}
		}

		if(System.getProperty("Browser").contains("android") ||
				(System.getProperty("chromeMobileDevice")!=null
						&& (!System.getProperty("chromeMobileDevice").contains("iPad")))) {
			productDetailPageThreadLocal.set(new ProductDetailPage_Mobile(getDriver()));
			//globalFooterPageThreadLocal.set(new GlobalFooterPage_Mobile(getDriver()));
			globalHeaderPageThreadLocal.set(new GlobalHeaderPage_Mobile(getDriver()));
			productDetailPageThreadLocal.set(new ProductDetailPage_Mobile(getDriver()));
		}else {
			globalHeaderPageThreadLocal.set(new GlobalHeaderPage_Tablet(getDriver()));
			productDetailPageThreadLocal.set(new ProductDetailPage_Tablet(getDriver()));
		}

		if(System.getProperty("Browser").contains("ios") ||
				(System.getProperty("chromeMobileDevice")!=null
						&& (!System.getProperty("chromeMobileDevice").contains("iPad")))) {
			loginPageThreadLocal.set(new SignInPage(getDriver()));
			myAccountPageThreadLocal.set(new MyAccount(getDriver()));
		}
		else{
			loginPageThreadLocal.set(new SignInPage_Mobile(getDriver()));
			myAccountPageThreadLocal.set(new MyAccount_Mobile(getDriver()));
		}

		reporter = new ExtentTestManager(getDriver());
		apiResponseThreadLocal.set(new ApiResponse());
		if(System.getProperty("Browser").contains("ios") ||
				(System.getProperty("chromeMobileDevice")!=null
						&& (System.getProperty("chromeMobileDevice").contains("iPad")))) {
			shoppingCartThreadLocal.set(new ShoppingCartPage(getDriver()));
		}
		else{
			shoppingCartThreadLocal.set(new ShoppingCartPage_Mobile(getDriver()));
		}

		homePageThreadLocal.set(new HomePage(getDriver()));
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
							  boolean bypassCaptcha) throws IOException {
		RunParameters = getExecutionParameters(strBrowser, strLanguage);
		strBrowser = RunParameters.get("Browser").toLowerCase();
		strLanguage = RunParameters.get("Language").toLowerCase();

		if (strBrowser.toLowerCase().contains("sauce")) {
			sauceParameters = initializeSauceParamsMap(strBrowser);
		}

		//Setting browser version for Sauce Execution
		List<String> testNames = TestDataHandler.constantData.getLstTestName();
		if(runningTestName(testNames,currentTestMethodName.getName()) &&
				System.getProperty("Device").equalsIgnoreCase("Desktop") &&
				System.getProperty("Browser").equalsIgnoreCase("saucechrome"))
			sauceParameters.put("browserVersion",TestDataHandler.constantData.getLblChromeBrowserVersion());

		//webDriverThreadLocal.set(browserDrivers.driverInit(strBrowser, sauceParameters, currentTestMethodName, ""));
		webDriverThreadLocal.set(browserDrivers.driverInit(strBrowser, sauceParameters, currentTestMethodName, ""));
		ExtentListener.setDriver(getDriver());
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
		//if(!System.getProperty("Browser").toLowerCase().contains("safari"))
		//getDriver().navigate().refresh();
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
			ITestContext testContext, Method method) throws IOException, ParseException {
		startSession(System.getProperty("QaUrl"), strBrowser, strLanguage, method, false);
		getglobalheaderPageThreadLocal().waitForPageLoad();

		//Getting api key to be used in api calls
		//To get user token
		if(apiUserSessionData == null) {
			ConstantData.APIUserSessionParams apiUserSessionParams = TestDataHandler.constantData.getApiUserSessionParams();
			apiUserSessionData = apiResponseThreadLocal.get().getApiUserSessionData(apiUserSessionParams.getLbl_username(),apiUserSessionParams.getLbl_password(),apiUserSessionParams.getLbl_grantType(),apiUserSessionParams.getLbl_apiKey());
		}

		//To get app token
		if(apiAppSessionData == null) {
			ConstantData.APIAppSessionParams apiAppSessionParams = TestDataHandler.constantData.getApiAppSessionParams();
			apiAppSessionData = apiResponseThreadLocal.get().getApiAppSessionData(apiAppSessionParams.getLbl_username(),apiAppSessionParams.getLbl_password(),apiAppSessionParams.getLbl_grantType(),apiUserSessionData.get("access_token").toString());
		}

		long apiSessionKeyValidTime = DataConverter.getTimeFromDate(apiUserSessionData.getString("expiration_time"),null);
		long currentSystemTime = DataConverter.getLocalTimeInGMT();
		//Will get new token every 51st minutes so that we have valid session token for all method execution
		if((apiSessionKeyValidTime-currentSystemTime)>10*60*1000 ) {}
		else{
			ConstantData.APIUserSessionParams apiUserSessionParams = TestDataHandler.constantData.getApiUserSessionParams();
			apiUserSessionData = apiResponseThreadLocal.get().getApiUserSessionData(apiUserSessionParams.getLbl_username(),apiUserSessionParams.getLbl_password(),apiUserSessionParams.getLbl_grantType(),apiUserSessionParams.getLbl_apiKey());

			ConstantData.APIAppSessionParams apiAppSessionParams = TestDataHandler.constantData.getApiAppSessionParams();
			apiAppSessionData = apiResponseThreadLocal.get().getApiAppSessionData(apiAppSessionParams.getLbl_username(),apiAppSessionParams.getLbl_password(),apiAppSessionParams.getLbl_grantType(),apiUserSessionData.get("access_token").toString());
		}
		apiUserSessionDataMapThreadLocal.set(apiUserSessionData);
		apiAppSessionDataMapThreadLocal.set(apiAppSessionData);

		// getHomePageThreadLocal().waitforOverlayLoadingSpinnerToDisapper();
		// reporter.hardAssert(getHomePageThreadLocal().validateLogoRogers(), "Home Page
		// Loaded", "Home Page Not Loaded");
		//getglobalheaderPageThreadLocal().setLanguage(System.getProperty("Language"));
		//(new BasePage(this.getDriver())).setSessionStorage(System.getProperty("QaUrl"));
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() throws IOException, InterruptedException{
		if (getDriver() != null && !placeOrderValue) {
			addPlaceOrder();
		}
		closeSession();
	}

	public void validateText(String strActualText, List<String> listExpectedText, String validationMsg) {
		if(listExpectedText.equals(strActualText)){
			reporter.reportLogPass(validationMsg + ":" + " Expected=" + listExpectedText +  " ; Actual="+ strActualText);
		}
		else{
			reporter.reportLogFailWithScreenshot(validationMsg + " expected=" + listExpectedText +  "; actual="+ strActualText);
		}
	}

	//Method to validate content of Link and button
	public void validateText(String strActualText, String strExpectedText, String validationMsg) {
		if(strExpectedText.trim().equals(strActualText.trim())){
			reporter.reportLogPass(validationMsg + ":" + " Expected=" + strExpectedText +  " ; Actual="+ strActualText);
		}
		else{
			reporter.reportLogFailWithScreenshot(validationMsg + " expected=" + strExpectedText +  "; actual="+ strActualText);
		}
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
			case "sauceiossafari":
				if(System.getProperty("Device").equalsIgnoreCase("Tablet")){
					sauceOptions.put(SauceCapabilities.appiumVersion.toString(), TestDataHandler.sauceSettings.getIosSafariCapabilitiesTablet().getAppiumVersion());
					sauceOptions.put(SauceCapabilities.deviceName.toString(), TestDataHandler.sauceSettings.getIosSafariCapabilitiesTablet().getDeviceName());
					sauceOptions.put(SauceCapabilities.deviceOrientation.toString(), TestDataHandler.sauceSettings.getIosSafariCapabilitiesTablet().getDeviceOrientation());
					sauceOptions.put(SauceCapabilities.platformVersion.toString(), TestDataHandler.sauceSettings.getIosSafariCapabilitiesTablet().getPlatformVersion());
					sauceOptions.put(SauceCapabilities.platformName.toString(), TestDataHandler.sauceSettings.getIosSafariCapabilitiesTablet().getPlatformName());
				}else{
					sauceOptions.put(SauceCapabilities.appiumVersion.toString(), TestDataHandler.sauceSettings.getIosSafariCapabilities().getAppiumVersion());
					sauceOptions.put(SauceCapabilities.deviceName.toString(), TestDataHandler.sauceSettings.getIosSafariCapabilities().getDeviceName());
					sauceOptions.put(SauceCapabilities.deviceOrientation.toString(), TestDataHandler.sauceSettings.getIosSafariCapabilities().getDeviceOrientation());
					sauceOptions.put(SauceCapabilities.platformVersion.toString(), TestDataHandler.sauceSettings.getIosSafariCapabilities().getPlatformVersion());
					sauceOptions.put(SauceCapabilities.platformName.toString(), TestDataHandler.sauceSettings.getIosSafariCapabilities().getPlatformName());
				}
				break;
		}

		return sauceOptions;
	}

	/**
	 * To add place order once no order within 75 days
	 */
	public void addPlaceOrder() throws IOException,InterruptedException {
		String lblUserName = TestDataHandler.constantData.getApiUserSessionParams().getLbl_username();
		String lblPassword = TestDataHandler.constantData.getApiUserSessionParams().getLbl_password();

		ConstantData.APIUserSessionParams apiUserSessionParams = TestDataHandler.constantData.getApiUserSessionParams();
		apiUserSessionData = apiResponseThreadLocal.get().getApiUserSessionData(lblUserName,lblPassword,apiUserSessionParams.getLbl_grantType(),apiUserSessionParams.getLbl_apiKey());
		String access_token = apiUserSessionData.get("access_token").toString();
		String customerEDP = apiUserSessionData.get("customerEDP").toString();

		AccountAPI accountAPI=new AccountAPI();
		CartAPI cartAPI=new CartAPI();
		OrderAPI orderAPI=new OrderAPI();

		Response responseOrder=orderAPI.getOrderList(customerEDP,access_token);
		GetOrderListResponse getOrderListResponse = JsonParser.getResponseObject(responseOrder.asString(), new TypeReference<GetOrderListResponse>() {});
		List<GetOrderListResponse.OrderSummary> orderSummaryList=getOrderListResponse.getOrderSummary();
		String lsDate;
		LocalDate now = LocalDate.from(LocalDateTime.now());
		LocalDate ldOrderDate;
		long noOfDaysBetween;
		for(GetOrderListResponse.OrderSummary orderSummary:orderSummaryList){
			lsDate=orderSummary.getOrderDateTime().substring(0,10);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
			ldOrderDate = LocalDate.parse(lsDate, formatter);
			noOfDaysBetween = DAYS.between(ldOrderDate,now);
			if( noOfDaysBetween<=75){
				placeOrderValue = true;
				return;
			}
		}

		org.json.simple.JSONObject creditCardDetails = DataConverter.readJsonFileIntoJSONObject("test-data/CreditCard.json");
		accountAPI.addCreditCardToUser((org.json.simple.JSONObject) creditCardDetails.get("tsc"),customerEDP,access_token);

		Response responseInitial=cartAPI.getAccountCartContentWithCustomerEDP(customerEDP,access_token);
		CartResponse accountCartInitial = JsonParser.getResponseObject(responseInitial.asString(), new TypeReference<CartResponse>() {});
		String GuidId=accountCartInitial.getCartGuid();
		/**
		Response responseDelete=cartAPI.deleteCartItemWithGuid(access_token, GuidId,4);
		reporter.reportLog("responseDelete: "+responseDelete.asString());

		//ProductEDP Number that will be added to cart for user
		Map<String,Object> map=cartAPI.addItemsInExistingCart(Integer.parseInt(customerEDP), access_token, GuidId,null);
		Response userCartResponse=(Response)map.get("Response");
		*/
		Response responseReview=orderAPI.getOrderReview(customerEDP,access_token);
		CartResponse accountCartReview = JsonParser.getResponseObject(responseReview.asString(), new TypeReference<CartResponse>() {});
		//reporter.reportLog("Review: "+responseReview.asString());
		List<Long> relatedCartIdsList=accountCartReview.getRelatedCartIds();

		Thread.sleep(2000);

		orderAPI.placeOrder(GuidId,customerEDP,access_token,relatedCartIdsList);
		placeOrderValue = true;
	}

	private boolean runningTestName(List<String> lstTestName,String currentTestMethodName){
		for(String lsTestName:lstTestName){
			if(currentTestMethodName.equalsIgnoreCase(lsTestName)||currentTestMethodName.toLowerCase().contains(lsTestName.toLowerCase())){
				return true;
			}
		}
		return false;
	}
	
}
