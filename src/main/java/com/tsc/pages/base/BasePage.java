package com.tsc.pages.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Reporter;

import utils.ReusableActions;

	/**
	 * The type Base page class.
	 */
	public class BasePage {
		
	protected static Reporter reporter;
	/**
	 * The Wait.
	 */
	
	protected WebDriverWait wait;
	/**
	 * The Driver.
	 */
	private static final ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();
	/**
	 * The Action.
	 */
	TouchActions action;
	/**
	 * The Time out seconds.
	 */
	static final int TIME_OUT_SECONDS = 5;
	/**
	 * The Act.
	 */
	private static final ThreadLocal<Actions> actionsThreadLocal = new ThreadLocal<>();
	/**
	 * The Reusable actions.
	 */
	private static final ThreadLocal<ReusableActions> reusableActionsThreadLocal = new ThreadLocal<>();

	/**
	 * Instantiates a new Base page class.
	 *
	 * @param driver the driver
	 */
	public BasePage(WebDriver driver) {
		webDriverThreadLocal.set(driver);
		PageFactory.initElements(getDriver(), this);
		actionsThreadLocal.set(new Actions(getDriver()));
		reusableActionsThreadLocal.set(new ReusableActions(getDriver()));
	}

	/*
	@FindBy(xpath = "//div[@class='loading-spinner-bg']")
	WebElement overlayLoadingspinner;
	*/
	/**
	 * Gets default time out.
	 *
	 * @return the default time out
	 */
	protected long getDefaultTimeOut() {
		return TIME_OUT_SECONDS;
	}

	/**
	 * Gets driver url.
	 *
	 * @return the driver url
	 */
	protected String get_Driver_Url() {
		return getDriver().getCurrentUrl();
	}

	/**
	 * Gets driver.
	 *
	 * @return the driver
	 */
	protected WebDriver getDriver() {
		return webDriverThreadLocal.get();
	}

	/**
	 * This method returns the ReusableActions class instance from the ThreadLocal
	 */
	protected ReusableActions getReusableActionsInstance() {
		return reusableActionsThreadLocal.get();
	}

	/**
	 * This method return the Actions class instance from the ThreadLocal
	 */

	protected Actions getActionsInstance() {
		return actionsThreadLocal.get();
	}

	public void switchToMainWindow() {
		getReusableActionsInstance().switchToMainWindow();
	}

	public void closeWindow() {
		getDriver().close();
	}

	/**
	 * This method will validate current URL
	 *
	 * @param strExpectedUrl string containing URL
	 * @author Waji.Abbas
	 */
	public void validateCurrentUrl(String strExpectedUrl) throws IOException {
		waitForPageToLoad();
		reporter.softAssert(getDriver().getCurrentUrl().equalsIgnoreCase(strExpectedUrl),
				"Navigated Page URL Validation <br /> <b>Expected URL</b>: " + strExpectedUrl
						+ "<br /> <b>Actual URL</b>: " + getDriver().getCurrentUrl().toString(),
				"Navigated Page URL Validation <br /> <b>Expected URL</b>: " + strExpectedUrl
						+ "<br /> <b>Actual URL</b>: " + getDriver().getCurrentUrl().toString());
		reporter.softAssert(verifyLinks(), "Page loaded properly ", "Page is Broken");
	}

	/**
	 * This method will validate text in current URL
	 *
	 * @param strExpectedUrl string containing URL
	 * @author Waji.Abbas
	 */
	public void validateCurrentUrlContains(String strExpectedUrl) throws IOException {
		waitForPageToLoad();
		String strUrl = URLDecoder.decode(getDriver().getCurrentUrl(), StandardCharsets.UTF_8.name());
		reporter.softAssert(strUrl.contains(strExpectedUrl.trim()),
				"Navigated Page URL Validation <br /> <b>Expected URL</b>: " + strExpectedUrl
						+ "<br /> <b>Actual URL</b>: " + getDriver().getCurrentUrl().toString(),
				"Navigated Page URL Validation <br /> <b>Expected URL</b>: " + strExpectedUrl
						+ "<br /> <b>Actual URL</b>: " + getDriver().getCurrentUrl().toString());
		reporter.softAssert(verifyLinks(), "Page loaded properly ", "Page is Broken");
	}
	
	/**
	 * Verify that loaded page should return response code less 400
	 *
	 * @return false if response code greater than or equal to 400 else true
	 * @throws IOException
	 * @author Vedachalam.Vasudevan
	 */
	public boolean verifyLinks() throws IOException {
		HttpURLConnection httpURLConnect = null;
		int response;
		String responseMessage;
		waitForPageToLoad();
		System.out.println("URL: " + getDriver().getCurrentUrl());
		try {
			httpURLConnect = (HttpURLConnection) new URL(getDriver().getCurrentUrl()).openConnection();
			httpURLConnect.setConnectTimeout(10000);
			httpURLConnect.setReadTimeout(10000);
			httpURLConnect.connect();
			response = httpURLConnect.getResponseCode();
			responseMessage = httpURLConnect.getResponseMessage();
			httpURLConnect.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		System.out.println("Response Code: " + response);
		if (response >= 400) {
			System.out.println("ResponseMessage: " + responseMessage + " is a broken link");
			return false;
		}
		System.out.println("ResponseMessage: " + responseMessage + " is a link");
		return true;
	}

	public void refresh() {
		getDriver().navigate().refresh();
	}

	public void setSessionStorage(String strUrl) {
		String[][] cookieArrary = {{"QSI_SI_b9g8z16WXGGNzCd_intercept", "true"},
				{"QSI_Seen", "true"},
				{"Holiday2018_popup_clickedoutside", "true"},
				{"Holiday2018_popup_hide", "true"},
				{"Holiday2018_popup_notinterested", "true"},
				{"leadgen_popup_hide", "true"},
				{"nmShowMessage", "false"}};
		for (int row=0; row < cookieArrary.length; row++) {
			Cookie sessionStorage = new Cookie(cookieArrary[row][0], cookieArrary[row][1], ".tsc.ca", "", null);
			getDriver().manage().addCookie(sessionStorage);
		}
	}

	public void deleteSessionStorage() {
		getDriver().manage().deleteCookieNamed("Analytics_Test_Filter");
	}
	
	public String getCookieValue(String cookieName) {
		Cookie returnCoookie = getDriver().manage().getCookieNamed(cookieName);
		return returnCoookie.getValue();
	}
	
	public void waitForPageToLoad() {
		ExpectedCondition<Boolean> javascriptDone = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver d) {
				try {
					return ((JavascriptExecutor) getDriver()).executeScript("return document.readyState").equals("complete");
				} catch (Exception e) {
					return Boolean.FALSE;
				}
			}
		};
		WebDriverWait wait = new WebDriverWait(getDriver(), 40);
		wait.until(javascriptDone);
	}
	
	public void navigateBack() {
		waitForPageToLoad();
		getDriver().navigate().back();
		waitForPageToLoad();
	}
	
	public void navigateToURL(String strURL) {
		waitForPageToLoad();
		getDriver().navigate().to(System.getProperty("QaUrl"));
		waitForPageToLoad();

	}
	
	/**
	 * This method will implement explicit wait using Lambda function
	 *
	 * @param 
	 * 1. Function<WebDriver,Boolean> func: Lambda expression
	 * 2. int timeOutInMillis: wait time in millisecond
	 * @return true/false
	 * @author Wei.Li
	 */	
	public Boolean waitForCondition(Function<WebDriver,Boolean> func, int timeOutInMillis) {    		    
        return (new WebDriverWait(this.getDriver(), timeOutInMillis/1000)).until( new ExpectedCondition<Boolean>() {
        	@Override
            public Boolean apply(WebDriver d) {
                return func.apply(d);            	
            }
        });
    }
	
	/**
	 * This method will get base URL settings in gradle.properties
	 * 
	 * @return String: base URL
	 * @author Wei.Li
	 */	
	public String getBaseURL() {    		    
        String lsBaseURL=System.getProperty("QaUrl");
        if(lsBaseURL.endsWith("/")) {
        	return lsBaseURL.substring(0,lsBaseURL.length()-1);
        }
        return lsBaseURL;
    }
	
	/**
	 * This method will verify the page url doesn't contain "notfound" after clicking an element 
	 *
	 * @param WebElement element: the element will be clicked	 
	 * @return true/false
	 * @author Wei.Li
	 */			
	public boolean verifyURLNotContainsNotFoundAfterClickingElement(WebElement element) {
		String currentUrl=getDriver().getCurrentUrl();
        element.click();
        waitForCondition(Driver->{return !currentUrl.equalsIgnoreCase(getDriver().getCurrentUrl());},10000);
        return !getDriver().getCurrentUrl().contains("notfound");						
	}
	
	/**
	 * This method will verify if the page url contains expected keyword list 
	 *
	 * @param WebElement element: the element will be clicked	
	 * @param List<String> keywordList: expected keyword list in Url 
	 * @return true/false
	 * @author Wei.Li
	 */			
	public boolean verifyURLContainExpectedKeywordList(WebElement element,List<String> keywordList) {
		String currentUrl=getDriver().getCurrentUrl();
        element.click();
        waitForCondition(Driver->{return !currentUrl.equalsIgnoreCase(getDriver().getCurrentUrl());},10000);
        String afterUrl=getDriver().getCurrentUrl();
        for(String keyword:keywordList) {
        	if(!afterUrl.contains(keyword)) {
        		return false;
        	}
        }
        return true;						
	}
	
	/**
	 * This method will verify if the page url contains expected keyword 
	 *
	 * @param WebElement element: the element will be clicked	
	 * @param String keywordList: expected keyword in Url 
	 * @return true/false
	 * @author Wei.Li
	 */			
	public boolean verifyURLContainExpectedKeyword(WebElement element,String keyword) {
		String currentUrl=getDriver().getCurrentUrl();
        element.click();
        waitForCondition(Driver->{return !currentUrl.equalsIgnoreCase(getDriver().getCurrentUrl());},10000);
        String afterUrl=getDriver().getCurrentUrl();
        
        return afterUrl.toLowerCase().contains(keyword.toLowerCase());						
	}
	
	/**
	 * This method will verify if the page url is equal to specific Url 
	 *
	 * @param WebElement element: the element will be clicked	
	 * @param String keyword: expected Url 
	 * @return true/false
	 * @author Wei.Li
	 */			
	public boolean verifyURLEqualToExpectedKeyword(WebElement element,String keyword) {
		String currentUrl=getDriver().getCurrentUrl();
        element.click();
        waitForCondition(Driver->{return !currentUrl.equalsIgnoreCase(getDriver().getCurrentUrl());},10000);
        String afterUrl=getDriver().getCurrentUrl();
        
        return afterUrl.equalsIgnoreCase(keyword);						
	}
	
	/**
	 * This method will implement Escape key pressing action.
	 *
	 * @return void
	 * @author Wei.Li
	 */	
	 public void pressEscapeKey() {
		 Robot robot=null;
		 try {
			 robot=new Robot();
		 }
		 catch(AWTException e){
			 e.printStackTrace();
		 }		 
		 robot.keyPress(KeyEvent.VK_ESCAPE);		
		 robot.keyRelease(KeyEvent.VK_ESCAPE);
	 }

	/**
	 * This method will implement CTRL+A+DELETE to clear element contents.
	 *
	 * @return void
	 * @author Wei.Li
	 */
	 public void clearContent(WebElement element) {
		 element.click();
		 Robot robot=null;
		 try {
			 robot=new Robot();
		 }
		 catch(AWTException e){
			 e.printStackTrace();
		 }
		 robot.keyPress(KeyEvent.VK_CONTROL);
		 robot.keyPress(KeyEvent.VK_A);
		 robot.keyRelease(KeyEvent.VK_CONTROL);
		 robot.keyRelease(KeyEvent.VK_A);
		 
		 robot.keyPress(KeyEvent.VK_DELETE);
		 robot.keyRelease(KeyEvent.VK_DELETE);
	 }
	 
	//Get the URL 			
	public String URL() {
		return getDriver().getCurrentUrl();
	}
}
