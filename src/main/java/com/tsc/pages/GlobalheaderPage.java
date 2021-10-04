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
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tsc.pages.base.BasePage;

public class GlobalheaderPage extends BasePage{
	
	
	
	public GlobalheaderPage(WebDriver driver) {
		super(driver);
	}

	//Product results
	@FindBy(xpath = "//div[@class='Footer']//div[contains(@class,'blockPageWrap')]")
	WebElement productResultLoadingIndicator;
	
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
	
	By byDynamicEvent=By.xpath("//*[@class='Sliver']//a[@class='slideLink']");
		
	//TSC Logo
	@FindBy(xpath = "//*[@class='Header']//div[@class='logo']")
	WebElement lnkTSClogo;
	
	@FindBy(xpath = "//*[@class='Header']//div[@class='logo']//a")
	WebElement lnkTSClogolink;
	
	//SearchBox
	@FindBy(xpath = "//*[@class='Header']//form[@class='reactAppForm']//input[@class='tsc-search-input']|//div[contains(@class,'searchContainer')]//input")
	WebElement searchBox;
	
	@FindBy(xpath = "//*[@class='Header']//form[@class='reactAppForm']//button[@class='submit-search-button']|//div[contains(@class,'searchContainer')]//button[@type='submit']")
	WebElement btnSearchSubmit;
	
	@FindBy(xpath = "//div[@class='searchContainer']//button[contains(@class,'clear-search-button')]|//div[contains(@class,'searchContainer')]//button[@type='reset']")
	WebElement btnSearchClear;
		
	@FindBy(xpath = "//div[@class='searchContainer']//div[contains(@class,'suggestions-container')]|//div[contains(@class,'aa-Panel--desktop')]")
	WebElement ctnSearchResult;
	
	@FindBy(xpath = "//div[@class='searchContainer']//div[contains(@class,'suggestions-container')]|//div[contains(@class,'aa-Panel--desktop')]//ul")
	List<WebElement> searchQADropdwonmenuList;
	
	@FindBy(xpath = "//div[@class='searchContainer']//div[contains(@class,'suggestions-container--open')]//div[@class='tsc-category-title']")
	WebElement txtSearchResultCategoryHeader;
	
	@FindBy(xpath = "//div[@class='searchContainer']//div[contains(@class,'suggestions-container--open')]//ul//li")
	List<WebElement> searchResultList;
	
	By byCategoryAboveSearchResultList=By.xpath("//div[@class='searchContainer']//div[contains(@class,'suggestions-container--open')]//ul/preceding-sibling::div[@class='tsc-category-title']");
		
	//Favorite link
	@FindBy(xpath = "//*[@class='Header']//a[contains(@href, 'favourites')]")
	WebElement Favouriteslnk;
	
	//SignIn
	@FindBy(xpath = "//*[@class='Header']//a[@id='myAccountBtn']")
	WebElement Signinlnk;
	
	@FindBy(xpath = "//*[@class='Header']//div[@class='bagContainer']//*[contains(@class,'svgSigninIcon')]")
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
	 * @author Shruti.Desai
	 *Flyouts Headings
	 */
	@FindBy(xpath = "//div[contains(@class,'header-desktop')]//div[contains(@class,'megamenu')]//ul[@class='navLinkWrap']/li")
	List<WebElement> listFlyoutHeadings;
	
		
	@FindBy(xpath = "//*[@class='email-popup__button']")
	WebElement btnClose;
	public void closeadd() {
		btnClose.click();
	}

	public void waitForPageLoad() {
		getReusableActionsInstance().waitForPageLoad();
		waitForCondition(Driver->{return !this.productResultLoadingIndicator.getAttribute("style").equalsIgnoreCase("display: block;");},30000);
	}	
	
	public boolean validateURL(String strExpectedUrl) {
		getReusableActionsInstance().waitForPageLoad();
		if (getDriver().getCurrentUrl().equalsIgnoreCase(strExpectedUrl)) {
			return true;
		}
		return false;
	}
	
	//Sliver links are visible & Text is present
	/**
	 * This method will validate DynamicEvent  is visible.
	 *
	 * @return true/false
	 * 
	 * @author Wei.Li
	 */	
	public boolean DynamicEventLinkVisible() {
		if(!this.getReusableActionsInstance().isElementVisible(this.byDynamicEvent,30)) {
			return true;
		}
		return this.lnkdynamicEvent.isDisplayed();
	}
	
	/**
	 * This method will validate the href of DynamicEventLink is existing.
	 *
	 * @return true/false
	 * 
	 * @author Wei.Li
	 */	
	public boolean validateDynamicEventLink() {
		if(!this.getReusableActionsInstance().isElementVisible(this.byDynamicEvent,30)) {
			return true;
		}
		if (lnkdynamicEvent.getAttribute("href").isEmpty()) {							
			return false;			
		}
		
		return true;
	}
	
	/**
	 * This method will return TS text.
	 * @author Wei.Li
	 */
	public String getTSText() {
		getReusableActionsInstance().isElementVisible(lnkTS, 5);
		return lnkTS.getText();		
	}
	
	/**
	 * This method will return TS link.
	 * @author Wei.Li
	 */
	public String getTSLink() {
		String emptySTAIbtn="TS link href is empty";
		if (lnkTS.getAttribute("href").isEmpty()) {							
			return emptySTAIbtn;			
		}else{			
			return lnkTS.getAttribute("href");
		}
	}
	
	/**
	 * This method will return Deals text.
	 * @author Wei.Li
	 */
	public String getDealsText() {
		getReusableActionsInstance().isElementVisible(lnkDeals, 5);
		return lnkDeals.getText();
	}
	
	/**
	 * This method will return Deals link.
	 * @author Wei.Li
	 */
	public String getDealsLink() {
		String emptySTAIbtn="Deals link href is empty";
		if (lnkDeals.getAttribute("href").isEmpty()) {							
			return emptySTAIbtn;			
		}else{			
			return lnkDeals.getAttribute("href");
		}
	}
	
	/**
	 * This method will return OnAir text.
	 * @author Wei.Li
	 */
	public String getOnAirText() {
		getReusableActionsInstance().isElementVisible(lnkOnAir, 5);
		return lnkOnAir.getText();
	}
	
	/**
	 * This method will return OnAir link.
	 * @author Wei.Li
	 */
	public String getOnAirLink() {
		String emptySTAIbtn="On Air link href is empty";
		if (lnkOnAir.getAttribute("href").isEmpty()) {							
			return emptySTAIbtn;			
		}else{
			return lnkOnAir.getAttribute("href");
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
	
	/**
	 * This method will return ProgramGuide text.
	 * @author Wei.Li
	 */
	public String getProgramGuideText() {
		getReusableActionsInstance().isElementVisible(lnkProgramGuide, 5);
		return lnkProgramGuide.getText();
	}
	
	/**
	 * This method will return ProgramGuide link.
	 * @author Wei.Li
	 */
	public String getProgramGuideLink() {
		String emptySTAIbtn="Program Guide link href is empty";
		if (lnkProgramGuide.getAttribute("href").isEmpty()) {							
			return emptySTAIbtn;			
		}else{
			return lnkProgramGuide.getAttribute("href");
		}
	}
	
	/**
	 * This method will return WatchUsLive text.
	 * @author Wei.Li
	 */
	public String getWatchUsLiveText() {
		getReusableActionsInstance().isElementVisible(lnkWatchUsLive, 5);
		return lnkWatchUsLive.getText();
	}
	
	/**
	 * This method will return WatchUsLive link.
	 * @author Wei.Li
	 */
	public String getWatchUsLiveLink() {
		String emptySTAIbtn="Watch Us Live link href is empty";
		if (lnkWatchUsLive.getAttribute("href").isEmpty()) {							
			return emptySTAIbtn;			
		}else{
			return lnkWatchUsLive.getAttribute("href");
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
		String lsHomePage=new BasePage(this.getDriver()).getBaseURL()+"/";				
		String currentUrl=getDriver().getCurrentUrl();		        
                
		getReusableActionsInstance().isElementVisible(this.lnkTSClogo, 10);
		this.lnkTSClogo.click();	    
        waitForCondition(Driver->{return !currentUrl.equalsIgnoreCase(getDriver().getCurrentUrl());},10000);
              
        return this.getDriver().getCurrentUrl().equalsIgnoreCase(lsHomePage);		
		}
				
	//TSC Logo & Logo link is visible	
	public String validateTSCLogoLink() {
		String emptySTAIbtn="TSC logo link href is empty";
		String lsUrl=lnkTSClogolink.getAttribute("href");
		if (lsUrl.isEmpty()) {
							
			return emptySTAIbtn;
			
		}else{
			return lsUrl;
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
	public String validateMinicartLinkName() {
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
	 * This method will verify MiniCart link
	 *
	 * @return true/false
	 * 
	 * @author Wei.Li
	 */
	public boolean verifyMiniCartLink(String lsMinicartLink) {
		String lsMiniCartLink=this.Minicartlnk.getAttribute("href");
		if(lsMiniCartLink.isEmpty()) {
			return false;
		}
		else {			
			if(lsMiniCartLink.equalsIgnoreCase(lsMinicartLink)) {
				return true;
			}
			else {
				return false;
			}
		}	
	}
	
	/**
	 * This method will get url of new windows after clicking MiniCart link
	 *
	 * @return String: changed Url
	 * 
	 * @author Wei.Li
	 */		
	public String getUrlAfterClickingMiniCartLink() throws IOException {
		getReusableActionsInstance().javascriptScrollToTopOfPage();
		return waitForPageLoadingByUrlChange(this.Minicartlnk);		
	}
	
	/**
	 * This method will get full url after clicking TodayShowstopper link.
	 * @return String: changed Url 
	 * @author Wei.Li
	 */
	public String getUrlAfterClickingTSLink() {
		getReusableActionsInstance().javascriptScrollToTopOfPage();
		return waitForPageLoadingByUrlChange(this.lnkTS);
	}
	
	/**
	 * This method will get full url after clicking Deals link.
	 * @return String: changed Url
	 * @author Wei.Li
	 */
	public String getUrlAfterClickingDealsLink() {
		getReusableActionsInstance().javascriptScrollToTopOfPage();
		return waitForPageLoadingByUrlChange(this.lnkDeals);
	}
	
	/**
	 * This method will get full url after clicking OnAir link.
	 * @return String: changed Url
	 * @author Wei.Li
	 */
	public String getUrlAfterClickingOnAirLink() {
		getReusableActionsInstance().javascriptScrollToTopOfPage();
		return waitForPageLoadingByUrlChange(this.lnkOnAir);
	}
	
	/**
	 * This method will get full url after clicking ProgramGuide link.
	 * @return String: changed Url
	 * @author Wei.Li
	 */
	public String getUrlAfterClickingProgramGuideLink() {
		getReusableActionsInstance().javascriptScrollToTopOfPage();
		return waitForPageLoadingByUrlChange(this.lnkProgramGuide);
	}

	/**
	 * This method will get full url after clicking WatchUsLive link.
	 * @return String: changed Url
	 * @author Wei.Li
	 */
	public String getUrlAfterClickingWatchUsLiveLink() {
		getReusableActionsInstance().javascriptScrollToTopOfPage();
		return waitForPageLoadingByUrlChange(this.lnkWatchUsLive);
	}
	
	/*
	 * @author Shruti.Desai
	 *Flyouts Sub Menu
	 */

	/*Method to get Flyouts Headings count 
	 * @return number of Flyouts Headings
	 * @author Shruti Desai
	 */
	public int getFlyoutHeadingCount() {
		return listFlyoutHeadings.size();
	}
	
	/*Method to verify lable & get it for Flyout headings
	 * @return text:Flyout Headings
	 * @author Shruti Desai
	 */
	public String getFlyoutHeadings(int headingNumber) { 
		WebElement WebElement=listFlyoutHeadings.get(headingNumber).findElement(By.xpath(".//span"));
	 	getReusableActionsInstance().javascriptScrollByVisibleElement(WebElement); 
	 		return WebElement.getText(); 
	}
	
	
	/*Method to validate href is not empty before clicking it
	 * @return true/false
	 * @author Shruti Desai
	 */
	 public boolean validateFlyouthref(int headingNumber) {
		WebElement WebElement=listFlyoutHeadings.get(headingNumber).findElement(By.xpath(".//a"));
		getReusableActionsInstance().javascriptScrollByVisibleElement(WebElement);
			if (!WebElement.getAttribute("href").isEmpty()) {
				return true;
			}
				return false;
		}
	 
	 /*Method to validate href is not empty before clicking it
	 *@return  list:Flyout heading href
	 * @author Shruti Desai
	 */
	 public String getFlyoutLink(int headingNumber) {
		 String emptyhref="Flyout heading's href is empty";
		 WebElement WebElement=listFlyoutHeadings.get(headingNumber).findElement(By.xpath(".//a"));
			getReusableActionsInstance().javascriptScrollByVisibleElement(WebElement);
				
		 if (WebElement.getAttribute("href").isEmpty()) {
			return emptyhref;
		 }else{
			return WebElement.getAttribute("href");
		 }
	 }
	 
	 /*Method to get URL after clicking on category of Flyout heading
	  *@return text: URL
	  * @author Shruti Desai
	  */
	 public String getURLafterClickFlyoutHeading(int headingNumber) {
		WebElement WebElement=listFlyoutHeadings.get(headingNumber).findElement(By.xpath(".//a"));
		if(getReusableActionsInstance().isElementVisible(WebElement,2)){
			getReusableActionsInstance().javascriptScrollByVisibleElement(WebElement);  
			getReusableActionsInstance().clickWhenVisible(WebElement,5);
			return (getDriver().getCurrentUrl());
		 }else {
			return null;	
		 }
	}
	
	
//Sub Menu Section
	
	/*Method to get list of Flyout Headings
	 * @return list:Flyout Heading
	 * @author Shruti Desai
	 */		
	public List<String> getFlyoutHeadings() { 
		List<String> FlyoutHeadings= new ArrayList<String>();
		String newHeading;
		for(WebElement item:listFlyoutHeadings) {
			newHeading=item.getText().trim();
			if(newHeading.contains("&")) {
				String[] words = newHeading.split(" ");
				String camelCaseHeading= "";
				for (String parString : words){
					camelCaseHeading = camelCaseHeading+ " " + (parString.charAt(0)+parString.substring(1).toLowerCase()); 
				}
				newHeading = camelCaseHeading.trim();
				}else{
					newHeading = newHeading.charAt(0)+newHeading.substring(1).toLowerCase();
				}	
				FlyoutHeadings.add(newHeading);
		}
		return FlyoutHeadings;
	}					
							
	/*Method to get String of XPath  
	 * @return String:Xpath
	 * @author Shruti Desai
	 */						
	public String createXPath(String xpathExp, Object ...args){
		for(int i=0; i<args.length; i++) {
			xpathExp = xpathExp.replace("{"+i+"}", (CharSequence) args[i]);
		}
		return xpathExp;
	}
			
	/*Method to get list of Flyout submenu Headings
	 * @return list:Flyout sub menu Headings
	 * @author Shruti Desai
	 */
	public List<String> getFlyoutSubMenuHeadings(String headingName) {
		String xpathHeading =createXPath("//div[contains(@class,'header-desktop')]//div[contains(@class,'megamenu')]//ul[@class='navLinkWrap']/li[contains(.,'{0}')]" ,headingName); 
		WebElement headingWebElement = getDriver().findElement(By.xpath(xpathHeading));
		List<String> SubMenuHeadinglist =new ArrayList<String>();
		getReusableActionsInstance().scrollToElement(headingWebElement);
		getReusableActionsInstance().staticWait(3000);
		List<WebElement> SubMenuHeadings=headingWebElement.findElements(By.xpath(".//div[@class='flyout']//div[@class='flyoutRow2Left']//li//b[not(a)]"));
		for (WebElement SBheading:SubMenuHeadings) {
			SubMenuHeadinglist.add(SBheading.getText());
		}	
		return SubMenuHeadinglist;
	}	
	 /*Method to get list of Flyout submenu heding in camel case 
	 * @return list:Flyout sub menu camel case
	 * @author Shruti Desai
	 */

 public List<String> getFlyoutSubMenu(String headingName) { 
		String xpathHeading =createXPath("//li[@class='navLinkItem']//span[contains(text(),'{0}')]" ,headingName); 
		WebElement headingWebElement = getDriver().findElement(By.xpath(xpathHeading));
		getReusableActionsInstance().scrollToElement(headingWebElement);
		getReusableActionsInstance().staticWait(3000);
		List<WebElement> SubMenu=headingWebElement.findElements(By.xpath("./ancestor::li//div[@class='flyout']//div[@class='flyoutRow2Left']//ul//li[1]//b"));
		List<String> SubMenulist =new ArrayList<String>();
		String newSubmenu;
		for(WebElement e:SubMenu) {
			newSubmenu=e.getText().trim();
			if(newSubmenu.contains(" ")) {
				String[] words = newSubmenu.split(" ");
				String camelCaseHeading= "";
				for (String parString : words){
				camelCaseHeading = camelCaseHeading+ " " + (parString.charAt(0)+parString.substring(1).toLowerCase()); 
				}
				newSubmenu = camelCaseHeading.trim();
			}else{
				newSubmenu = newSubmenu.charAt(0)+newSubmenu.substring(1).toLowerCase();
			}	
			SubMenulist.add(newSubmenu);
		}
		return SubMenulist;
	}				 
		 
	/*Method to get list of Flyout submenu link's text
	 * @return list:Flyout sub menu links
	 * @author Shruti Desai
	 */
	public List<String> getFlyoutSubMenuLinkText(String headingName, String subMenuHeadingName) {
		String xpathHeading =createXPath("//div[contains(@class,'header-desktop')]//div[contains(@class,'megamenu')]//ul[@class='navLinkWrap']/li[contains(@class,'navLinkItem')]//span[contains(.,'{0}')]" ,headingName); 
		WebElement headingWebElement = getDriver().findElement(By.xpath(xpathHeading));
		String xpathSubMenuHeading =createXPath("./ancestor::li[contains(@class,'navLinkItem')]//div[@class='flyout']//ul//li/b[contains(.,'{0}')]" ,subMenuHeadingName); 
		List<WebElement> subMenuHeadingWebElement = headingWebElement.findElements(By.xpath(xpathSubMenuHeading));
		List<String> SubMenulist =new ArrayList<String>();
		for(WebElement subMenuHeading:subMenuHeadingWebElement) {
		getReusableActionsInstance().staticWait(3000);
		List<WebElement> SubMenuLinks=subMenuHeading.findElements(By.xpath("./ancestor::ul[1]/li/a"));
		for (WebElement SBlinks:SubMenuLinks) {
			SubMenulist.add(SBlinks.getText());
			}
		}
		return SubMenulist;
	}	 
	 
	/* Method to Validate FEATURED BRANDS section is displayed on right side by extracting its class
	  * @return text: class of Feature Brand section heading
	  * @author Shruti Desai
	  */
	 public String validateFeatureBrandSectionIsOnTheRight(String headingName) {
		WebElement brandSubMenu=getDriver().findElement(By.xpath("//*[@class='flyout']//div[@class='flyoutRow2Right']//descendant::b//ancestor::div[@class='flyoutRow2Right']"));
		return brandSubMenu.getAttribute("class");
	}
	 
	 /*Method to get list of Flyout submenu Headings in the Brand Section
		 * @return list:Flyout sub menu Headings in the Brand Section
		 * @author Shruti Desai
		 */
		public String getFeatureBrandSectionHeading(String headingName) {
			String xpathHeading =createXPath("//div[contains(@class,'header-desktop')]//div[contains(@class,'megamenu')]//ul[@class='navLinkWrap']/li[contains(.,'{0}')]" ,headingName); 
			WebElement headingWebElement = getDriver().findElement(By.xpath(xpathHeading));
			getReusableActionsInstance().scrollToElement(headingWebElement);
			WebElement SubMenuHeadings=headingWebElement.findElement(By.xpath(".//div[@class='flyout']//div[@class='flyoutRow2Right']//li//b[not(a)]"));
			return SubMenuHeadings.getText();
		 }	 
		
	 /* Method to validate all href & src for Flyout submenu links in both right hand side and Brand Section are not empty.
	  * @return : true/false
	  * @author Shruti Desai
	  */
	public String validateFlyoutSubMenuSRCandHREF(String headingName,String section) {
		List<WebElement> SubMenuLinks =null;
		List<WebElement> SubMenuLinkImages =null;
		WebElement brandSectionViewAlllink =null;
		if(section==null) {
			String xpathHeading =createXPath("//*[@id='megamenu']//span[contains(text(),'{0}')]/parent::a/following-sibling::div//div[@class='flyoutRow2Container']/div[1]//li//a" ,headingName); 
			SubMenuLinks =getDriver().findElements(By.xpath(xpathHeading));
		}else{
			String xpathlinks =createXPath("//*[@id='megamenu']//span[contains(text(),'{0}')]/parent::a/following-sibling::div//div[@class='flyoutRow2Container']/div[2]//div//a[contains(@href,'HDR')]" ,headingName); 
			String xpathimages =createXPath("//*[@id='megamenu']//span[contains(text(),'{0}')]/parent::a/following-sibling::div//div[@class='flyoutRow2Container']/div[2]//div//img" ,headingName); 
			String xpathViewAlllink =createXPath("//*[@id='megamenu']//span[contains(text(),'{0}')]/parent::a/following-sibling::div//div[@class='flyoutRow2Container']/div[2]//div//a[contains(text(),'View All >')]" ,headingName); 
			SubMenuLinks=getDriver().findElements(By.xpath(xpathlinks));
			SubMenuLinkImages=getDriver().findElements(By.xpath(xpathimages));
			brandSectionViewAlllink = getDriver().findElement(By.xpath(xpathViewAlllink));
		}
		if(section==null) {
			for (WebElement SBlinks:SubMenuLinks) {
				if(SBlinks.getAttribute("href").isEmpty()) {
				return ("href is not present for link: "+SBlinks.getText());
				}
			}
			return ("href is present for all links in left hand side section");
		}else {
			String viewAlllinkText =brandSectionViewAlllink.getText();
			for (int i=0; i<SubMenuLinkImages.size(); i++) {
				String href = SubMenuLinks.get(i).getAttribute("href");
				String src = SubMenuLinkImages.get(i).getAttribute("src");
				if(href==null) {
					if(src!=null){
						return ("href is not present for the link "+src+" in Brand Section");
				}else if(src==null) {
					return("src is not present for the link: "+href);	
					}
				}
			}
			if(brandSectionViewAlllink.getAttribute("href").isEmpty()) {
			return ("href of "+viewAlllinkText+ " is empty");
			}
		return("href and src are present for all links in the Brand Section");
		}
	}
	

	
}

