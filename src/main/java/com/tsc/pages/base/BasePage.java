package com.tsc.pages.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import extentreport.ExtentTestManager;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Reporter;
import utils.ReusableActions;

	/**
	 * The type Base page class.
	 */
	public class BasePage {
		
	public static Reporter reporter;
	
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
		reporter = new ExtentTestManager(getDriver());
	}

	/*
	@FindBy(xpath = "//div[@class='loading-spinner-bg']")
	WebElement overlayLoadingspinner;
	*/
	/**
	 * Gets default time out.
	 * @return the default time out
	 */
	protected long getDefaultTimeOut() {
		return TIME_OUT_SECONDS;
	}

	/**
	 * @return the reporter
	 */
	public static Reporter getReporter() {
		return reporter;
	}
	
	/**
	 * Gets driver url.
	 * @return the driver url
	 */
	protected String get_Driver_Url() {
		return getDriver().getCurrentUrl();
	}

	/**
	 * Gets driver.
	 * @return the driver
	 */
	protected WebDriver getDriver() {
		return webDriverThreadLocal.get();
	}

	/**
	 * This method returns the ReusableActions class instance from the ThreadLocal
	 */
	public ReusableActions getReusableActionsInstance() {
		return reusableActionsThreadLocal.get();
	}

	/**
	 * This method return the Actions class instance from the ThreadLocal
	 */

	public Actions getActionsInstance() {
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

	public boolean verifyLink(String url) {
		HttpURLConnection httpURLConnect = null;
		int response=-1;
		String responseMessage;
		waitForPageToLoad();
		try {
			httpURLConnect = (HttpURLConnection) new URL(url).openConnection();
			httpURLConnect.setConnectTimeout(20000);
			httpURLConnect.setReadTimeout(20000);
			httpURLConnect.connect();
			response = httpURLConnect.getResponseCode();
			responseMessage = httpURLConnect.getResponseMessage();
			httpURLConnect.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		if (response >= 400) {
			System.out.println("ResponseMessage: " + responseMessage + " is a broken link");
			return false;
		}
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
		WebDriverWait wait = new WebDriverWait(getDriver(), 200);
		wait.until(javascriptDone);
		this.getReusableActionsInstance().staticWait(3*this.getStaticWaitForApplication());
	}
	
	public void navigateBack() {
		waitForPageToLoad();
		getDriver().navigate().back();
		waitForPageToLoad();
	}
	
	/**
	 * This method will navigate to a specific URL using ReusableActions method.
	 * @return void
	 * @author Wei.Li
	 */	
	public void navigateToURL(String strURL) {
		getReusableActionsInstance().openSpecificUrl(strURL,30);

	}
	
	/**
	 * This method will implement explicit wait using Lambda function
	 * @param
	 * func<WebDriver,Boolean> func: Lambda expression
	 * 2-int timeOutInMillis: wait time in millisecond
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
	 * This method will verify the page loading by url changes
	 * @param-WebElement element: the element will be clicked
	 * @return String: changed url
	 * @author Wei.Li
	 */			
	public String waitForPageLoadingByUrlChange(WebElement element) {
		String currentUrl=getDriver().getCurrentUrl();
		getReusableActionsInstance().javascriptScrollByVisibleElement(element);
		waitForCondition(Driver->{return element.isDisplayed();},90000);
		getReusableActionsInstance().clickIfAvailable(element);
        //element.click();
        waitForCondition(Driver->{return !currentUrl.equalsIgnoreCase(getDriver().getCurrentUrl());},90000);
        getReusableActionsInstance().waitForPageLoad();
        getReusableActionsInstance().staticWait(3000);
        
        return getDriver().getCurrentUrl();
	}
	
	/**
	 * This method will implement Escape key pressing action.
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

	 public void pressEscapeKeyUsingSendKeys(){
		 Actions action = new Actions(getDriver());
		 action.sendKeys(Keys.ESCAPE).build().perform();
	 }

	/**
	 * This method will implement ENTER key pressing action.
	 * @param-WebElement element: the action related element
	 * @return void
	 * @author Wei.Li
    */ 
	 
	 public void pressEnterKey(WebElement element) {
		 element.sendKeys(Keys.chord(Keys.ENTER));
	 }	 

	/**
	 * This method will implement CTRL+A+DELETE to clear element contents.
	 * @param-WebElement element: the action related element
	 * @return void
	 * @author Wei.Li
	 */
	 public void clearContent(WebElement element) {
		 this.getReusableActionsInstance().javascriptScrollByVisibleElement(element);
		 this.getReusableActionsInstance().clickIfAvailable(element,3000);
		 //element.click();
		 /*element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		 element.sendKeys(Keys.chord(Keys.DELETE));*/

		 //We are using Action class below instead of above method as for firefox and Safari,
		 //unwanted character i.e. E000 unicode is added at start of string
		 Actions actions = new Actions(getDriver());
		 actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).build().perform();
	 }
 
	//Get the URL 			
	public String URL() {
		return this.removeLastSlashFromUrl(getDriver().getCurrentUrl());
	}

	/**
	 * This method will extract number in a target string.
	 * @param-String lsTarget: target string
	 * @return the list of extracted numbers
	 * @author Wei.Li
	 */
    public List<String> getNumberFromString(String lsTarget) {
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(lsTarget);
        
        List<String> list=new ArrayList<String>();
        while(m.find()) {
        	String lsGroup=m.group();
        	list.add(lsGroup);         	
        }
        
        return list;
    }

	/**
	 * This method will get element innerText.
	 * @param-WebElement element: element
	 * @return String
	 * @author Wei.Li
	 */		
	public String getElementInnerText(WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor)(this.getDriver());
		String lsText= (String)jse.executeScript("return arguments[0].innerText;", element);
		return lsText.replace("&nbsp;", "").trim();
	}
    
    /**
	 * This method will judge if ChildElement is visible.
	 * @return true/false
	 * @author Sachin.Sharma
	 */	
    public Boolean isChildElementVisible(WebElement element, String domProperty) {
        Object data = element.getAttribute(domProperty);
        if(data.equals("") || data == null) {
           return false;
        }
        switch(domProperty){
            case "innerText":
                return true;
            case "childElementCount":
                if(Integer.valueOf((String) data) > 1) {
                    return true;
             }
        }
        return false;
     }
    
	/**
	 * This method will return childElementCount.
	 * @param-WebElement parent: parent element
	 * @author Wei.Li
	 */		
	public long getChildElementCount(WebElement parent) {
		JavascriptExecutor jse = (JavascriptExecutor)(this.getDriver());
		long childSize= (long) jse.executeScript("return arguments[0].childElementCount;", parent);
				
		return childSize;		
	}
	
	/**
	 * This method will get element attribute.
	 * @param-WebElement element: element
	 * @author Wei.Li
	 */		
	public String getChildElementAttribute(WebElement element,String lsAttribute) {
		JavascriptExecutor jse = (JavascriptExecutor)(this.getDriver());
		return (String)jse.executeScript("return arguments[0].getAttribute(arguments[1]);", element,lsAttribute);				
	}
	
	/**
	 * This method will set element attribute.
	 * @param-WebElement parent: parent element
	 * @author Wei.Li
	 */		
	public void setChildElementAttribute(WebElement parent,String lsAttribute,String lsValue) {
		JavascriptExecutor jse = (JavascriptExecutor)(this.getDriver());
		jse.executeScript("arguments[0].setAttribute(arguments[1],arguments[2]);", parent,lsAttribute,lsValue);
	}
	
	/**
	 * This method will return childElement.
	 * @param-WebElement parent: parent element
	 * @return List<WebElement>: children element
	 * @author Wei.Li
	 */		
	@SuppressWarnings("unchecked")
	public List<WebElement> getChildrenList(WebElement parent) {
		JavascriptExecutor jse = (JavascriptExecutor)(this.getDriver());
		return (List<WebElement>) jse.executeScript("return arguments[0].children;", parent);			
	}
	
	/**
	 * This method will check if a childElement is existing by some specific Attribute.
	 * @param-WebElement parent: parent element
	 * @param-String lsAttribute: Attribute
	 * @param-String lsAttributeValue: Attribute value
	 * @return boolean
	 * @author Wei.Li
	 */		
	public boolean checkChildElementExistingByAttribute(WebElement parent,String lsAttribute,String lsAttributeValue) {
		List<WebElement> lstChild=this.getChildrenList(parent);
		for(WebElement child:lstChild) {
			if(this.hasElementAttribute(child,lsAttribute)) {				
				String lsValue=this.getChildElementAttribute(child,lsAttribute).trim();				
				if(lsValue.isEmpty()||lsValue==null) {
					continue;
				}
				else {
					if(lsValue.contains(" ")) {
						if(lsValue.toLowerCase().contains(lsAttributeValue.toLowerCase())) {
							return true;
						}
						else {
							continue;
						}
					}
					else {
						if(lsValue.equalsIgnoreCase(lsAttributeValue)) {
							return true;
						}
						else {
							continue;
						}
					}					
				}
			}
		}	
		return false;
	}
	
	/**
	 * This method will check if a childElement is existing by specific TagName and Attribute.
	 * @param-WebElement parent: parent element
	 * @param-String lsTagName: TagName
	 * @param-String lsAttribute: Attribute
	 * @param-String lsAttributeValue: Attribute value
	 * @return boolean
	 * @author Wei.Li
	 */		
	public boolean checkChildElementExistingByTagNameAndAttribute(WebElement parent,String lsTagName,String lsAttribute,String lsAttributeValue) {
		List<WebElement> lstChild=this.getChildrenList(parent);		
		for(WebElement child:lstChild) {	
			if(!child.getTagName().equalsIgnoreCase(lsTagName)) {
				continue;
			}
			
			if(this.hasElementAttribute(child,lsAttribute)) {				
				String lsValue=this.getChildElementAttribute(child,lsAttribute).trim();				
				if(lsValue.isEmpty()||lsValue==null) {
					continue;
				}
				else {
					if(lsValue.contains(" ")) {
						if(lsValue.toLowerCase().contains(lsAttributeValue.toLowerCase())) {
							return true;
						}
						else {
							continue;
						}
					}
					else {
						if(lsValue.equalsIgnoreCase(lsAttributeValue)) {
							return true;
						}
						else {
							continue;
						}
					}					
				}
			}
		}	
		return false;
	}
	
	/**
	 * This method will check if a childElement is existing by some specific TagName.
	 * @param-WebElement parent: parent element
	 * @param-String lsTagName: TagName
	 * @return boolean
	 * @author Wei.Li
	 */	
	public boolean checkChildElementExistingByTagName(WebElement parent,String lsTagName) {
		this.waitForPageToLoad();
		List<WebElement> lstChild=this.getChildrenList(parent);
		for(WebElement child:lstChild) {
			if(child.getTagName().equalsIgnoreCase(lsTagName)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * This method will identify if the element has a specific Attribute.
	 * @param-WebElement element: the element
	 * @param-String lsAttribute: the Attribute
	 * @return true/false
	 * @author Wei.Li
	 */		
	public boolean hasElementAttribute(WebElement element,String lsAttribute) {
		JavascriptExecutor jse = (JavascriptExecutor)(this.getDriver());
		return (boolean) jse.executeScript("return arguments[0].hasAttribute(arguments[1]);", element,lsAttribute);			
	}

	public void setElementValue(WebElement element,String lsValue) {
		JavascriptExecutor jse = (JavascriptExecutor)(this.getDriver());
		jse.executeScript("arguments[0].value = arguments[1]);", element,lsValue);
	}

	/**
	 * This method will click an element.
	 * @param-WebElement element: the element
	 * @return void
	 * @author Wei.Li
	 */		
	public void clickElement(WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor)(this.getDriver());
		jse.executeScript("arguments[0].click();", element);			
	}

	/**
	 * This method will split keyword using space.
	 * @param-String lsKeyword: input keyword
	 * @return split array
	 * @author Wei.Li
	 */	
	public String[] splitSearchKeyword(String lsKeyword) {
		return lsKeyword.trim().split(" ");
	}
	
    /**
	 * This method will get float from string.
	 * @param-String lsTarget: target string
	 * @param-boolean bHighestFirst
	 * @return float value
	 * @author Wei.Li
	 */	
    public float getFloatFromString(String lsTarget,boolean bHighestFirst) {
    	if(lsTarget.contains("-")) {
    		if(bHighestFirst) {
    			lsTarget=lsTarget.split("-")[1].trim();
    		}
    		else {
    			lsTarget=lsTarget.split("-")[0].trim();
    		}    		
    	}
    	lsTarget=lsTarget.replace(",", "").trim();
    	
    	String regex="\\d+\\.\\d+";
    	String lsReturn="";
    	Pattern pattern=Pattern.compile(regex);
    	Matcher matcher=pattern.matcher(lsTarget);
    	while(matcher.find())
    	{
    	    lsReturn=matcher.group();    	        	   
    	}
    	   			
    	return Float.parseFloat(lsReturn);
    }
    
    /**
	 * This method will get integer from string.
	 * @param-String lsTarget: target string
	 * @return int value
	 * @author Wei.Li
	 */	
    public int getIntegerFromString(String lsTarget) {
    	String regex="\\d+";
    	String lsReturn="";
    	Pattern pattern=Pattern.compile(regex);
    	Matcher matcher=pattern.matcher(lsTarget);
    	while(matcher.find())
    	{
    	    lsReturn=matcher.group();    	        	   
    	}
    	   			
    	return Integer.parseInt(lsReturn);
    }
    
    /**
	 * This method will verify element existing. 
	 * @param-WebElement element: input element
	 * @return true/false
	 * @author Wei.Li
	 */	
    public boolean verifyElementExisting(WebElement element) {    	
    	getReusableActionsInstance().javascriptScrollByVisibleElement(element);
    	return getReusableActionsInstance().isElementVisible(element);
    }
	
	/**
	 * This method is to verify element properties.
	 * @param-WebElement element: input element
	 * @param-String lsChoice: "Text"/"Image"/"Link"
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean verifyElementProperty(WebElement element,String lsChoice) {
		boolean bReturn=false;
		switch(lsChoice) {
		case "Text":
			getReusableActionsInstance().javascriptScrollByVisibleElement(element);
			if(!element.getText().trim().isEmpty()) {
				bReturn=true;
			}
			break;
		case "Image":
			if(!element.getAttribute("src").isEmpty()) {
				bReturn=true;
			}
			break;
		case "Link":
			if(!element.getAttribute("href").isEmpty()) {
				bReturn=true;
			}
			break;		
		}
		return bReturn;
	}
	
    /**
	 * This method is to get element text. 
	 * @param-WebElement element: input element
	 * @return String
	 * @author Wei.Li
	 */	
    public String getElementText(WebElement element) {    	
    	getReusableActionsInstance().javascriptScrollByVisibleElement(element);
    	return element.getText().trim();
    }
    
    /**
	 * This method is to get element href. 
	 * @param-WebElement element: input element
	 * @return String
	 * @author Wei.Li
	 */	
    public String getElementHref(WebElement element) {    	
    	return this.removeLastSlashFromUrl(element.getAttribute("href").trim());
    }
    
    /**
	 * This method is to get element image src. 
	 * @param-WebElement element: input element
	 * @return String
	 * @author Wei.Li
	 */	
    public String getElementImageSrc(WebElement element) {    	
    	return element.getAttribute("src").trim();
    }
    
	/**
	 * This method is to remove last slash from Url
	 * @param-String lsUrl: input Url
	 * @return String: Url
	 * @author Wei.Li
	 */
	public String removeLastSlashFromUrl(String lsUrl) {
		if(lsUrl.endsWith("/")) {
			lsUrl=lsUrl.substring(0,lsUrl.length()-1);
        }
		return lsUrl;
	}
	
	/**
	 * This method is to get UTF-8 format
	 * @param-String data: input data
	 * @author Sachin.Sharma
	 */
	public String getUTFEnabledData(String data) {
		   byte[] bytes = data.getBytes(StandardCharsets.UTF_8);
		   String utf8EncodedString = new String(bytes);
		   return utf8EncodedString;
	}

	/**
	 * This method is to convert non-ascii String to ascii
	 * @param - String data: input data
	 * @author Sachin.Sharma
	 */
	public static String convertToASCII(String data) {
		String nfdNormalizedString = Normalizer.normalize(data, Normalizer.Form.NFD);
		Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		return pattern.matcher(nfdNormalizedString).replaceAll("");
	}

	/*Method to get UTF-8 format for the list of string
	 *param list of string: input data list
	 *@author Shruti.Desai
	 */
	public List<String> getUTFEnabledDataList(List<String> data) {
		   List<String> utf8EncodedString = new ArrayList<String>();
		   for(String lsdata:data) {
			  byte[]  bytes = lsdata.getBytes(StandardCharsets.UTF_8);
			  String newutf8EncodedString = new String(bytes);
			  utf8EncodedString.add(newutf8EncodedString);
		   }
		   return utf8EncodedString;
	}

    /**
	 * This method is to get element from element list with a expected text. 
	 * @param-List<WebElement> elementList: input element list
	 * @param-String lsExpectedText: input expected text
	 * @return WebElement
	 * @author Wei.Li
	 */	
    public WebElement getElementFromList(List<WebElement> elementList,String lsExpectedText) { 
    	int listSize=elementList.size();
    	if(listSize==0) {
    		return null;
    	}
    	
    	String lsItem;
    	for(WebElement element:elementList) {
    		getReusableActionsInstance().javascriptScrollByVisibleElement(element);
    		lsItem=element.getText().trim();    		
    		if(lsItem.equalsIgnoreCase(lsExpectedText)) {
    			return element;
    		}
    	}
    	return null;
    }

	/**
	 * Method to convert words/string into camel case  
	 * @return String
	 * @author Shruti Desai
	 */
	public String createCamelCase(String headingName) {
		if(headingName.contains(" ")) {
			String[] words = headingName.split(" ");
			String camelCaseHeading= "";
			for (String parString : words){
				camelCaseHeading = camelCaseHeading+" "+(parString.charAt(0)+parString.substring(1).toLowerCase()) ; 
			}
			headingName = camelCaseHeading.trim();
			}else{
				headingName = headingName.charAt(0)+headingName.substring(1).toLowerCase();
			}	
		return headingName;
	}
	
	/**
	 * Method to get String of XPath  
	 * @return String:Xpath
	 * @author Shruti Desai
	 */						
	public String createXPath(String xpathExp, Object ...args){
		for(int i=0; i<args.length; i++) {
			xpathExp = xpathExp.replace("{"+i+"}", (CharSequence) args[i]);
		}
		return xpathExp;
	}
	
	/**
	 *Method to verify element link  	 
	 * @param-WebElement element: input element
	 * @author Wei.Li
	 */	
	 public void verifyElementLink(WebElement element) {
		 String lsTitle=element.getText().trim();
		 String lsLink=this.getElementHref(element);
		 if(!lsLink.isEmpty())
		 	reporter.reportLogPass("The href element of "+lsTitle+" is not empty");
		 else
		 	reporter.reportLogFailWithScreenshot("The href element of "+lsTitle+" is empty");
		 if(this.verifyLink(lsLink))
			 reporter.reportLogPass("Link for title: "+lsTitle+" is not broken!");
		 else
			 reporter.reportLogFail("Link for title: "+lsTitle+" is broken: "+lsLink);
	 }
	 
	 /**
	  * This method will return search result page title.	  
	  * @author Wei.Li
	  */
	 public String getPageTitle(WebElement webelement) {
		 if(getReusableActionsInstance().isElementVisible(webelement)) {
			 getReusableActionsInstance().javascriptScrollByVisibleElement(webelement);
			 return webelement.getText().trim();
		 }
			return "NoTitle";		
		}

	/**
	  * This method will apply static wait between steps
	 */
	public void applyStaticWait(long timeOut){
		getReusableActionsInstance().staticWait(timeOut);
	}

	/**Method to get get Url of landing page after clicking the Favourites's link
	 * @return String:url
	 * @author Shruti Desai
	 */
	public String getUrlForLandingpage(WebElement element) {
		String urlFavouriteslandingpage;
		getReusableActionsInstance().scrollToElement(element);
		getReusableActionsInstance().clickIfAvailable(element);
		getReusableActionsInstance().waitForPageLoad();
		getReusableActionsInstance().staticWait(3000);
		urlFavouriteslandingpage = getDriver().getCurrentUrl();
		return urlFavouriteslandingpage;
	}

	/**Method to find if an element is displayed and is enabled
	 * @param-WebElement element: input element
	 * @return-Boolean flag
	 */
	public boolean isElementPresent(WebElement element) {
		boolean flag = false;
		try {
			if (element.isDisplayed()
					|| element.isEnabled())
				flag = true;
		} catch (NoSuchElementException e) {
			flag = false;
		} catch (StaleElementReferenceException e) {
			flag = false;
		}
		return flag;
	}

	/**Method to mouse over an element using JS
	 * @param-WebElement element: input element
	 */
	public void mouseHoverJScript(WebElement HoverElement) {
		try {
			if (isElementPresent(HoverElement)) {
				String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover'," +
						"true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
			((JavascriptExecutor) getDriver()).executeScript(mouseOverScript,
					HoverElement);

			} else {
				System.out.println("Element was not visible to hover " + "\n");
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Element with " + HoverElement
					+ "is not attached to the page document"
					+ e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element " + HoverElement + " was not found in DOM"
					+ e.getStackTrace());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error occurred while hovering"
					+ e.getStackTrace());
		}
	}

	/**Method to click an element using JS
	 * @param-WebElement element: input element
	 */
	public void clickWebElementUsingJS(WebElement webElement){
		//this.mouseHoverJScript(webElement);
		JavascriptExecutor js = (JavascriptExecutor) this.getDriver();
		js.executeScript("arguments[0].click();",webElement);
	}

	/**Method to click an element using JS
	 * @param-WebElement element: input element
	 */
	public void clickWebElementUsingJSEvent(WebElement webElement){
		String clickElementScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('click'," +
				"true, true); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('click');}";
		((JavascriptExecutor) getDriver()).executeScript(clickElementScript,
				webElement);
	}

	/**
	 * Method to get the browser name where test is executing
	 */
	public String getExecutionBrowserName(){
		return System.getProperty("Browser");
	}

	/**
	 * Method to get redirect url from an href
	 */
	public String getRedirectUrlFromHref(String href) throws IOException {
		String redirectUrl = null;
		Process process = null;
		try{
			String url = "curl -Ls -w %{url_effective} -o /dev/null"+" "+href;
			process = Runtime.getRuntime().exec(url);
			redirectUrl = IOUtils.toString(process.getInputStream(), StandardCharsets.UTF_8);
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			process.destroy();
		}
		return redirectUrl;
	}

	/**
	 * Method to shorten the text
	 */
	public String getShortenText(String lsText, int shortenNumber){
		if (lsText.length() > shortenNumber) {
			lsText = lsText.substring(0, shortenNumber) + "...";
		}
		return lsText;
	}

	/**
	 * Method to getStaticWait
	 */
	public long getStaticWaitForApplication(){
		return Long.valueOf(System.getProperty("test_staticWait"));
	}

	/**
	 * This method will get double from string.
	 * @param-String lsTarget: target string
	 * @return double value
	 */
	public double getDoubleFromString(String lsTarget) {
		lsTarget=lsTarget.replace(",", "").trim();

		String regex="\\d+\\.\\d+";
		String lsReturn="";
		Pattern pattern=Pattern.compile(regex);
		Matcher matcher=pattern.matcher(lsTarget);
		while(matcher.find())
		{
			lsReturn=matcher.group();
		}

		return Double.parseDouble(lsReturn);
	}

	/**
	 * To compare double list sum with expected double value
	 * @param - lstItem - List<String>
	 * @param - expectedSummary - String
	 * @return - boolean
	 */
	public boolean checkDoubleEquation(List<Double> lstItem,double expectedSummary){
		double total=0.0;
		for(double item:lstItem){
			total+=item;
		}
		return Math.abs(total-expectedSummary)<0.01;
	}

	/**
	 * To compare double list sum with expected double value
	 * @param - lstItem - List<WebElement>
	 * @param - expectedSummary -WebElement
	 * @return - boolean
	 */
	public boolean checkDoubleEquation(List<WebElement> lstItem,WebElement expectedSummary){
		double total=0.0;
		for(WebElement item:lstItem){
			total+=this.getDoubleFromString(this.getElementInnerText(item));
		}

		double expectedValue=this.getDoubleFromString(this.getElementInnerText(expectedSummary));
		return Math.abs(total-expectedValue)<0.01;
	}

	/**
	 * To get the string before identifier
	 * @param - wholeString
	 * @param - beforeIdentifier
	 * @return - the string before identifier
	 */
	public String getStringBeforeGivenIdentifier(String wholeString,String beforeIdentifier){
		int findPos=wholeString.lastIndexOf(beforeIdentifier);
		return wholeString.substring(0,findPos);
	}

	/**
	 * To get the string after identifier
	 * @param - wholeString
	 * @param - afterIdentifier
	 * @return - the string after identifier
	 */
	public String getStringAfterGivenIdentifier(String wholeString,String afterIdentifier){
		int findPos=wholeString.lastIndexOf(afterIdentifier);
		return wholeString.substring(findPos+1);
	}

	/**
	 * To get the string between beforeIdentifier and afterIdentifier
	 * @param - wholeString
	 * @param - beforeIdentifier
	 * @param - afterIdentifier
	 * @return - the string between beforeIdentifier and afterIdentifier
	 */
	public String getBetweenString(String wholeString,String beforeIdentifier,String afterIdentifier){
		int beginPos=wholeString.lastIndexOf(beforeIdentifier);
		int endPos=wholeString.lastIndexOf(afterIdentifier);
		return wholeString.substring(beginPos+1,endPos);
	}

	/**
	 * To get a number between 0 and maximalNumber
	 * @param - int - maximalNumber
	 * @return - int - a number between 0 and maximalNumber
	 */
	public int getRandomNumber(int maximalNumber){
		Random rand = new Random();
		int randomNumber = rand.nextInt(maximalNumber);
		return randomNumber;
	}

	/**
	 * To get Multiple Float From String
	 * @param - String - lsSourceString
	 * @return
	 */
	public List<Float> getMultiFloatFromString(String lsSourceString) {
		//ArrayList to store the output
		ArrayList<Float> f = new ArrayList<Float>();
		//Creating a pattern to identify floats
		Pattern pat = Pattern.compile("[-]?[0-9]*\\.?[0-9]+");
		//matching the string with the pattern
		Matcher m = pat.matcher(lsSourceString);
		//extracting and storing the float values
		while(m.find()) {
			f.add(Float.parseFloat(m.group()));
		}

		return f;
	}

	/**
	 * To scroll window down
	 * @param - WebDriver - driver
	 * @param - int - offset
	 */
	public void scrollWindowDown(WebDriver driver, int offset ) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,arguments[0])", offset);
	}

	/**
	 * To scroll window up
	 * @param - WebDriver - driver
	 * @param - int - offset
	 */
	public void scrollWindowUp(WebDriver driver, int offset ) {
		offset=-offset;
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,arguments[0])", offset);
	}

	/**
	 * This method will get element textContent With Formatting Children.
	 * @param-WebElement element: element
	 * @return String
	 * @author Wei.Li
	 */
	public String getElementTextContentsWithFormattingChildren(WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor)(this.getDriver());
		String lsText= (String)jse.executeScript("return arguments[0].textContent;", element);
		return lsText.replace("&nbsp;", "").trim();
	}

	/**
	 * This method will get element textContent Without Children.
	 * @param-WebElement element: element
	 * @return String
	 * @author Wei.Li
	 */
	public String getElementTextContentsWithoutChildren(WebElement element) {
		String lsWholeContent=this.getElementInnerText(element);
		List<WebElement> lstChild=this.getChildrenList(element);
		for(WebElement child:lstChild) {
			String lsChildContent=this.getElementInnerText(child);
			lsWholeContent=lsWholeContent.replace(lsChildContent,"");
		}
		return lsWholeContent.trim();
	}
}
