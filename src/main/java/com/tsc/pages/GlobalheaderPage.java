package com.tsc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.DigiAutoCustomException;
import utils.ReusableActions;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tsc.pages.base.BasePage;
import java.util.List;

public class GlobalheaderPage extends BasePage{
	
	
	
	public GlobalheaderPage(WebDriver driver) {
		super(driver);
	}

	//Sliver Links [Dynamic event, TS, Deals, OnAir, Program Guide, Watch Us Live]
	@FindBy(xpath = "//*[@class='Sliver']//a[contains(@href, 'todaysshowstopper')]")
	WebElement lnkTS;
	
	@FindBy(xpath="//*[@class='Sliver']//a[contains(@href, 'todaysshowstopper')]//span")
	WebElement lnkTScnt;
	
	@FindBy(xpath = "//*[@class='Sliver']//a[contains(@href, 'Deals')]")
	WebElement lnkDeals;
	
	@FindBy(xpath = "//*[@class='Sliver']//a[contains(@href, 'OnAir')]")
	WebElement lnkOnAir;
	
	@FindBy(xpath = "//*[@class='Sliver']//a[contains(@href, 'ProgramGuide')]")
	WebElement lnkProgramGuide;
	
	@FindBy(xpath = "//*[@class='Sliver']//a[contains(@href, 'ProgramGuide')]//div[contains(@class,'slvr-mnu-icon-container')]")
	WebElement imgProgramGuideIcon;
	
	@FindBy(xpath = "//*[@class='Sliver']//a[contains(@href, 'WatchUsLive')]")
	WebElement lnkWatchUsLive;
	
	@FindBy(xpath = "//*[@class='Sliver']//a[contains(@href, 'WatchUsLive')]//div[contains(@class,'slvr-mnu-icon-container')]")
	WebElement imgWatchUsLiveIcon;
	
	//Dynamic Event
	@FindBy(xpath = "//*[@class='Sliver']//a[@class='slideLink']")
	WebElement lnkdynamicEvent;
		
	//TSC Logo
	@FindBy(xpath = "//*[@class='Header']//div[@class='logo']")
	WebElement lnkTSClogo;
	
	@FindBy(xpath = "//*[@class='Header']//div[@class='logo']//a")
	WebElement lnkTSClogolink;
	
	//SerchBox
	@FindBy(xpath = "//*[@class='Header']//form[@class='reactAppForm']//input[@class='tsc-search-input']")
	WebElement searchBox;
	
	@FindBy(xpath = "//*[@class='Header']//form[@class='reactAppForm']//button[@class='submit-search-button']")
	WebElement btnSearchSubmit;
	
	//Favorite link
	@FindBy(xpath = "//*[@class='Header']//a[contains(@href, 'favourites')]")
	WebElement Favouriteslnk;
	
	//SignIn
	@FindBy(xpath = "//*[@class='Header']//a[@id='myAccountBtn']")
	WebElement Signinlnk;
	
	@FindBy(xpath = "//*[@class='Header']*[@class='svgSigninIcon']")
	WebElement SigninIcon;
	
	//MiniCart 
	@FindBy(xpath = "//*[@class='Header']//a[@id='tagCartButton']")
	WebElement Minicartlnk;
 
	@FindBy(xpath ="//*[@class='Header']//a[@id='tagCartButton']//span")
	WebElement MinicartIconcont;			

	@FindBy(xpath = "//*[@class='Header']//*[@class='svgBagIcon']")
	WebElement CartBagIcon;
	
	@FindBy(xpath = "//*[@class='Header']//div[@id='bagCounter']")
	WebElement CartBagCounter;

	
	public void waitForPageLoad() {
		new WebDriverWait(getDriver(), 1000).until(
				driver -> ((JavascriptExecutor) getDriver()).executeScript("return document.readyState").equals("complete"));
		}
	
	public boolean validateURL(String strExpectedUrl) {
		waitForPageLoad();
		if (getDriver().getCurrentUrl().equalsIgnoreCase(strExpectedUrl)) {
			return true;
			}
		return false;
		}
	
	//Sliver links are visible & Text is present
	
	public boolean DynamicEventLinkVisible() {
		return getReusableActionsInstance().isElementVisible(lnkdynamicEvent, 5);
		}
	public String validateDynamicEventLink() {
		String emptyhref="NOA href is empty";
		if (lnkdynamicEvent.getAttribute("href").isEmpty()) {
							
			return emptyhref;
			
		}else{
			return lnkdynamicEvent.getAttribute("href");
			}
		}
		
	public String validateTSLink() {
		String emptySTAIbtn="TS link href is empty";
		if (lnkTS.getAttribute("href").isEmpty()) {
							
			return emptySTAIbtn;
			
		}else{
			getReusableActionsInstance().isElementVisible(lnkTS, 5);
			return lnkTS.getText();
			}
		}
	
	/**
	 * This method will validate url of new windows after clicking <Today's Showstopper> link.
	 *
	 * @return true/false
	 * @author Wei.Li
	 */	
	public boolean validateUrlAfterClickingTodayShowstopperLink() throws IOException {
		return verifyURLNotContainsNotFoundAfterClickingElement(this.lnkTS);		
	}
	
	public String validateDealsLink() {
		String emptySTAIbtn="Deals link href is empty";
		if (lnkDeals.getAttribute("href").isEmpty()) {
							
			return emptySTAIbtn;
			
		}else{
			getReusableActionsInstance().isElementVisible(lnkDeals, 5);
			return lnkDeals.getText();
			}
		}
	
	public String validateOnAirLink() {
		String emptySTAIbtn="On Air link href is empty";
		if (lnkOnAir.getAttribute("href").isEmpty()) {
							
			return emptySTAIbtn;
			
		}else{
			getReusableActionsInstance().isElementVisible(lnkOnAir, 5);
			return lnkOnAir.getText();
			}
		}
	
	/**
	 * This method will validate ProgramGuide icon is visible.
	 *
	 * @return true/false
	 * @author Wei.Li
	 */	
	public boolean validateProgramGuideIconVisible() {
		return getReusableActionsInstance().isElementVisible(imgProgramGuideIcon, 5);
		}
	
	public String validateProgramGuideLink() {
		String emptySTAIbtn="Program Guide link href is empty";
		if (lnkProgramGuide.getAttribute("href").isEmpty()) {
							
			return emptySTAIbtn;
			
		}else{
			getReusableActionsInstance().isElementVisible(lnkProgramGuide, 5);
			return lnkProgramGuide.getText();
			}
		}
	
	/**
	 * This method will validate WatchUsLive icon is visible.
	 *
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean validateWatchUsLiveIconVisible() {
		return getReusableActionsInstance().isElementVisible(imgWatchUsLiveIcon, 5);
		}
	
	/**
	 * This method will validate clicking TSCLogo can navigate page to HomePage.
	 *
	 * @return true/false
	 * @author Wei.Li
	 */
	public boolean validateTSCLogoNavigateToHomePage() {
		String currentUrl1=getDriver().getCurrentUrl();		        
        this.lnkTS.click();
        waitForCondition(Driver->{return !currentUrl1.equalsIgnoreCase(getDriver().getCurrentUrl());},30000);
    	String currentUrl2=getDriver().getCurrentUrl();    
        
		getReusableActionsInstance().isElementVisible(this.lnkTSClogo, 10);
		this.lnkTSClogo.click();	    
        waitForCondition(Driver->{return !currentUrl2.equalsIgnoreCase(getDriver().getCurrentUrl());},10000);
              
        return this.getDriver().getCurrentUrl().equalsIgnoreCase(currentUrl1);		
		}
	
	public String validateWatchUsLiveLink() {
		String emptySTAIbtn="Watch Us Live link href is empty";
		if (lnkWatchUsLive.getAttribute("href").isEmpty()) {
							
			return emptySTAIbtn;
			
		}else{
			getReusableActionsInstance().isElementVisible(lnkWatchUsLive, 5);
			return lnkWatchUsLive.getText();
			}
		}
		
	//TSC Logo & Logo link is visible		
	
	public String validateTSCLogoLink() {
		String emptySTAIbtn="TSC logo link href is empty";
		if (lnkTSClogolink.getAttribute("href").isEmpty()) {
							
			return emptySTAIbtn;
			
		}else{
			getReusableActionsInstance().isElementVisible(lnkTSClogolink, 5);
			return lnkTSClogolink.getText();
			}
		}
	
	public boolean validateTSCLogo() {
		return getReusableActionsInstance().isElementVisible(lnkTSClogo, 5);
				
			}
	
	//Search box visible
	public String validateSearchbox() {
			getReusableActionsInstance().isElementVisible(searchBox, 5);
				return searchBox.getAttribute("placeholder");
			}
		
	public boolean validateSearchSubmitbtn() {
		return getReusableActionsInstance().isElementVisible(btnSearchSubmit, 5);
				
			}
		
	//Favorite link visible
	public String validateFavouritesLink() {
		String emptySTAIbtn="Favourites link href is empty";
		if (Favouriteslnk.getAttribute("href").isEmpty()) {
							
			return emptySTAIbtn;
			
		}else{
			getReusableActionsInstance().isElementVisible(Favouriteslnk, 5);
			return Favouriteslnk.getText();
			}
		}

	//Sign In Link is visible
	public String validateSignInLink() {
		String emptySTAIbtn="Sign In link href is empty";
		if (Signinlnk.getAttribute("href").isEmpty()) {
							
			return emptySTAIbtn;
			
		}else{
			getReusableActionsInstance().isElementVisible(Signinlnk, 5);
			return Signinlnk.getText();
			}
		}
	
	public boolean validateSiginIcon() {
				return getReusableActionsInstance().isElementVisible(SigninIcon, 5);
				}
		
	//Mini cart Link visible
	public String validateMinicartLink() {
		String emptySTAIbtn="Mini cart link href is empty";
		if (Minicartlnk.getAttribute("href").isEmpty()) {
							
			return emptySTAIbtn;
			
		}else{
			getReusableActionsInstance().isElementVisible(Minicartlnk, 5);
			return MinicartIconcont.getText();
			}
		}
	
	public boolean validateMinicartIcon() {
			return getReusableActionsInstance().isElementVisible(CartBagIcon, 5);
			 }
	
	public boolean validateMinicartBagCounter() {
		return getReusableActionsInstance().isElementVisible(CartBagCounter, 5);
		}
	
	/**
	 * This method will validate url of new windows after clicking OnAirLink button
	 *
	 * @return true/false
	 * 
	 * @author Wei.Li
	 */	
	public boolean validateUrlAfterClickingOnAirLink() throws IOException {
		return verifyURLNotContainsNotFoundAfterClickingElement(this.lnkOnAir);		
	}
	
	/**
	 * This method will validate url of new windows after clicking WatchUsLive button
	 *
	 * @return true/false
	 * 
	 * @author Wei.Li
	 */		
	public boolean validateUrlAfterClickingWatchUsLiveLink() throws IOException {
		return verifyURLNotContainsNotFoundAfterClickingElement(this.lnkWatchUsLive);		
	}
	
	/**
	 * This method will validate url pattern of new windows after clicking ProgramGuide button
	 *
	 * @return true/false
	 * 
	 * @author Wei.Li
	 */		
	public boolean validateUrlPatternAfterClickingProgramGuideLink() throws IOException {
		String expectedUrl=(new BasePage(this.getDriver())).getBaseURL()+"/pages/programguide/daily?ic=HP_ProgramGuide";
			
		return verifyURLEqualToExpectedKeyword(this.lnkProgramGuide,expectedUrl);		
	}
	
	/**
	 * This method will validate url pattern of new windows after clicking Deals button
	 *
	 * @return true/false
	 * 
	 * @author Wei.Li
	 */		
	public boolean validateUrlPatternAfterClickingDealsLink() throws IOException {
		ArrayList<String> keywordList=new ArrayList<String>();
		keywordList.add(this.getBaseURL());
		keywordList.add("/pages/productresults?nav=");
		keywordList.add("ic=HP_Deals");
			
		return verifyURLContainExpectedKeywordList(this.lnkDeals,keywordList);		
	}
		
	//Get the URL 			
	public String URL() {
		return getDriver().getCurrentUrl();
		}
	

}
