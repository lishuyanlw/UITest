package com.tsc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.ReusableActions;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

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

	//slivers [TS,Deals,OnAir,Programguide,WatchusLive]
	@FindBy(xpath = "//*[@class='Sliver']//a[contains(@href, 'TodaysShowstopper')]")
	WebElement lnkTS;
	
	@FindBy(xpath = "//*[@class='Sliver']//a[contains(@href, 'Deals')]")
	WebElement lnkDeals;
	
	@FindBy(xpath = "//*[@class='Sliver']//a[contains(@href, 'OnAir')]")
	WebElement lnkOnAir;
	
	@FindBy(xpath = "//*[@class='Sliver']//a[contains(@href, 'ProgramGuide')]")
	WebElement lnkProgramGuide;
	
	@FindBy(xpath = "//*[@class='Sliver']//a[contains(@href, 'WatchUsLive')]")
	WebElement lnkWatchUsLive;
	
	/*
	 * //Dynamic Event
	 * 
	 * @FindBy(xpath = " ") WebElement lnk;
	 */
	
	//TSC Logo
	@FindBy(xpath = "//*[@class='Header']//div[@class='logo']")
	WebElement lnkTSClogo;
	
	//SerchBox
	@FindBy(xpath = "//*[@class='Header']//form[@class='reactAppForm']//input[@class='tsc-search-input']\"")
	WebElement searchBox;
	
	@FindBy(xpath = "//*[@class='Header']//form[@class='reactAppForm']//button[@class='submit-search-button']\"")
	WebElement submitBtn;
	
	//Favoritelink
	@FindBy(xpath = "//*[@class='Header']//a[contains(@href, 'favourites')]")
	WebElement Favouriteslnk;
	
	//SignIn
	@FindBy(xpath = "//*[@class='Header']//a[@id='myAccountBtn']")
	WebElement Signinlnk;
	//find element for mouseover action on sigin button , use List<WebElement>
	
	@FindBy(xpath = "//*[@class='Header']*[@class='svgSigninIcon']")
	WebElement SigninIcon;
	
	//MiniCart
	@FindBy(xpath = "//*[@class='Header']//a[@id='tagCartButton']")
	WebElement Minicartlnk;
	
	@FindBy(xpath = "\"//*[@class='Header']*[@class='svgBagIcon']")
	WebElement CartBagIcon;
	
	@FindBy(xpath = "//*[@class='Header']//div[@id='bagCounter']")
	WebElement CartBagCounter;
	
	
		
	
	/*
	@FindBy(xpath = " ")
	WebElement lnk;
	
	@FindBy(xpath = " ")
	WebElement lnk;
	*/
	//String strUrl = URLDecoder.decode(getDriver().getCurrentUrl(), StandardCharsets.UTF_8.name());
	
	public String URL() {
		return getDriver().getCurrentUrl();
	}
		
	
	public void waitForPageLoad() {
		new WebDriverWait(getDriver(), 1000).until(
				driver -> ((JavascriptExecutor) getDriver()).executeScript("return document.readyState").equals("complete"));
	}
	
	/*
	//Slivers are visible
	public boolean validateTSLink() {
		 return getReusableActionsInstance().isElementVisible(lnkTS, 10);
		//return lnkTS.isDisplayed();
	}
	
	
	public boolean validateDealsLink() {
		
		//return lnkDeals.isDisplayed();
		return getReusableActionsInstance().isElementVisible(lnkDeals, 10);
	}
	
	
	public boolean validateOnAirLink() {
		//return getReusableActionsInstance().isElementVisible(lnkOnAir, 10);
		return lnkOnAir.isDisplayed();
	}
	
	public boolean validateProgramGuideLink() {
		//return getReusableActionsInstance().isElementVisible(lnkProgramGuide, 10);
		return lnkProgramGuide.isDisplayed();
	}
	
	public boolean validateWatchUsLiveLink() {
		//return getReusableActionsInstance().isElementVisible(lnkWatchUsLive, 10);
		return lnkWatchUsLive.isDisplayed();
	}
	
	//TSC Logo visible
	public boolean validateTSCLogo() {
		//return getReusableActionsInstance().isElementVisible(lnkTSClogo, 10);
		return lnkTSClogo.isDisplayed();
	}
	
	//Search box visible
	public boolean validateSearchbox() {
		//return getReusableActionsInstance().isElementVisible(searchBox, 10);
		return searchBox.isDisplayed();
	}
	
	public boolean validateSubmitbtn() {
		//return getReusableActionsInstance().isElementVisible(submitBtn, 10);
		return submitBtn.isDisplayed();
	}
	
	//Favorite link visible
	public boolean validateFavouritesLink() {
		//return getReusableActionsInstance().isElementVisible(Favouriteslnk, 10);
		return Favouriteslnk.isDisplayed();
	}
	
	//Sigin Link visible
	public boolean validateSiginLink() {
		//return getReusableActionsInstance().isElementVisible(Signinlnk, 10);
		return Signinlnk.isDisplayed();
	}
	
	public boolean validateSiginIcon() {
		//return getReusableActionsInstance().isElementVisible(SigninIcon, 10);
		return SigninIcon.isDisplayed();
	}
	
	//Minicart Link visible
	public boolean validateMinicartLink() {
		//return getReusableActionsInstance().isElementVisible(Minicartlnk, 10);
		return Minicartlnk.isDisplayed();
	}
	
	public boolean validateMinicartIcon() {
		//return getReusableActionsInstance().isElementVisible(CartBagIcon, 10);
		return CartBagIcon.isDisplayed();
	}
	
	public boolean validateCartBagCounter() {
		//return getReusableActionsInstance().isElementVisible(CartBagCounter, 10);
		return CartBagCounter.isDisplayed();
	}
	
	public boolean validateTSCLogo() {
		return getReusableActionsInstance().isElementVisible(lnkTSClogo, 10);
		//return lnkTSClogo.isDisplayed();
	}
	
	
	*/
		
		
	public boolean validateURL(String strExpectedUrl) {
		waitForPageLoad();
		// waitforOverlayLoadingSpinnerToDisapper();
		if (getDriver().getCurrentUrl().equalsIgnoreCase(strExpectedUrl)) {
			return true;
		}
		return false;
	}
	
	public boolean validateTSLink() {
			return getReusableActionsInstance().isElementVisible(lnkTS, 5);
		}
	
	/*
	public boolean validateTSLink() {
		return getReusableActionsInstance().isElementVisible(lnkTS, 5);
		}
	
	public boolean validateTSLink() {
		return getReusableActionsInstance().isElementVisible(lnkTS, 5);
		}
	
	public boolean validateTSLink() {
		return getReusableActionsInstance().isElementVisible(lnkTS, 5);
		}
		*/
}
