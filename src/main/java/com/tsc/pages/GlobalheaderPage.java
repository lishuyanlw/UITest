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
	
	@FindBy(xpath = "//*[@class='Sliver']//a[contains(@href, 'WatchUsLive')]")
	WebElement lnkWatchUsLive;
	
	//Dynamic Event
	@FindBy(xpath = "//*[@class='Sliver']//a[@class='slideLink']")
	WebElement dynamicEventlnk;
	
	/*
	 * 
	 * 
	 * @FindBy(xpath = " ") WebElement lnk;
	 */
	
	//TSC Logo
	@FindBy(xpath = "//*[@class='Header']//div[@class='logo']")
	WebElement lnkTSClogo;
	
	@FindBy(xpath = "//*[@class='Header']//div[@class='logo']//a")
	WebElement lnkTSClogolink;
	//SerchBox
	@FindBy(xpath = "//*[@class='Header']//form[@class='reactAppForm']//input[@class='tsc-search-input']")
	WebElement searchBox;
	
	@FindBy(xpath = "//*[@class='Header']//form[@class='reactAppForm']//button[@class='submit-search-button']")
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
 
	@FindBy(xpath ="//*[@class='Header']//a[@id='tagCartButton']//span")
	WebElement MinicartIconcont;			

	@FindBy(xpath = "//*[@class='Header']//*[@class='svgBagIcon']")
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
	
	//Sliver links are visible
	
	public boolean DynamicEventLinkVisible() {
		return getReusableActionsInstance().isElementVisible(dynamicEventlnk, 5);
		}
	public String validateDynamicEventLink() {
		String emptyhref="NOA href is empty";
		if (dynamicEventlnk.getAttribute("href").isEmpty()) {
							
			return emptyhref;
			
		}else{
			return dynamicEventlnk.getAttribute("href");
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
	
	public String validateProgramGuideLink() {
		String emptySTAIbtn="Program Guide link href is empty";
		if (lnkProgramGuide.getAttribute("href").isEmpty()) {
							
			return emptySTAIbtn;
			
		}else{
			getReusableActionsInstance().isElementVisible(lnkProgramGuide, 5);
			return lnkProgramGuide.getText();
			}
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
		
	public boolean validateSearchsubmitbtn() {
		return getReusableActionsInstance().isElementVisible(submitBtn, 5);
				
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

	//Sign In Link
	
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
	
	
		
	//Sliver links content
	
	public boolean veriylinkcont(String strActualText, String strExpectedText ){
		
			return (strActualText.equalsIgnoreCase(strExpectedText));
		
	}
	public String getlnkTScntCont() {
		return lnkTScnt.getText();
	}
	
	public String getlnkDealskCont() {
		return lnkDeals.getText();
	}
	
	public String getlnkOnAirCont() {
		return lnkOnAir.getText();
	}
	
	public String getlnkProgramGuideCont() {
		return lnkProgramGuide.getText();
	}
	
	public String getlnkWatchUsLiveCont() {
		return lnkWatchUsLive.getText();
	}
	
	public String getlnkSigninCont() {
		return Signinlnk.getText();
	}
	
	public String getFavouriteslnkCont() {
		return Favouriteslnk.getText();
	}
	
	public String getMinicartIconcontCont() {
		return MinicartIconcont.getText();
	}
	
		
	public String URL() {
		return getDriver().getCurrentUrl();
		}
		

}
