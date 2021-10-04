package com.tsc.test.tests.homePage;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.HomePage;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class HP_TC07_Verify_Global_Footer extends BaseTest {
	
	@Test(groups={"Home","Regression","GlobalFooter"})
	public void verify_Global_Footer_Section_Visibility() throws IOException {
		getGlobalFooterPageThreadLocal().closePopupDialog();
		BasePage basePage=new BasePage(this.getDriver());
		
		String lsBaseUrl=basePage.getBaseURL()+"/";
		
		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(lsBaseUrl), "TSC url is correct", "TSC url is incorrect");		
		reporter.reportLog("Global Footer Section");	
		
		List<String> lstSocialMediaLinks=TestDataHandler.constantDataVariables.getlst_SocialMediaLinks();
		
//		//Facebook
//		String lsUrl=getGlobalFooterPageThreadLocal().getUrlWithSocialMediaName(lstSocialMediaLinks, "Facebook");		
//		reporter.softAssert(getGlobalFooterPageThreadLocal().verifyElementProperty(getGlobalFooterPageThreadLocal().lnkFacebook,"Link"),"Facebook link in Global footer is not empty","Facebook link in Global footer is empty");
//		reporter.softAssert(getGlobalFooterPageThreadLocal().verifyElementProperty(getGlobalFooterPageThreadLocal().imgFacebook,"Image"),"Facebook icon in Global footer is not empty","Facebook icon in Global footer is empty");		
//		reporter.softAssert(getGlobalFooterPageThreadLocal().verifyUrlAfterClickingElement(getGlobalFooterPageThreadLocal().lnkFacebook,lsUrl),"The Url after clicking Facebook link is "+lsUrl,"The Url after clicking Facebook link is not "+lsUrl);
//
//		(new BasePage(this.getDriver())).navigateToURL(lsBaseUrl);
//		getGlobalFooterPageThreadLocal().waitForPageLoading();
//		
//		//Twitter
//		lsUrl=getGlobalFooterPageThreadLocal().getUrlWithSocialMediaName(lstSocialMediaLinks, "Twitter");		
//		reporter.softAssert(getGlobalFooterPageThreadLocal().verifyElementProperty(getGlobalFooterPageThreadLocal().lnkTwitter,"Link"),"Twitter link in Global footer is not empty","Twitter link in Global footer is empty");
//		reporter.softAssert(getGlobalFooterPageThreadLocal().verifyElementProperty(getGlobalFooterPageThreadLocal().imgTwitter,"Image"),"Twitter icon in Global footer is not empty","Twitter icon in Global footer is empty");		
//		reporter.softAssert(getGlobalFooterPageThreadLocal().verifyUrlAfterClickingElement(getGlobalFooterPageThreadLocal().lnkTwitter,lsUrl),"The Url after clicking Twitter link is "+lsUrl,"The Url after clicking Twitter link is not "+lsUrl);
//
//		(new BasePage(this.getDriver())).navigateToURL(lsBaseUrl);
//		getGlobalFooterPageThreadLocal().waitForPageLoading();
//
//		//Instagram
//		lsUrl=getGlobalFooterPageThreadLocal().getUrlWithSocialMediaName(lstSocialMediaLinks, "Instagram");		
//		reporter.softAssert(getGlobalFooterPageThreadLocal().verifyElementProperty(getGlobalFooterPageThreadLocal().lnkInstagram,"Link"),"Instagram link in Global footer is not empty","Instagram link in Global footer is empty");
//		reporter.softAssert(getGlobalFooterPageThreadLocal().verifyElementProperty(getGlobalFooterPageThreadLocal().imgInstagram,"Image"),"Instagram icon in Global footer is not empty","Instagram icon in Global footer is empty");		
//		reporter.softAssert(getGlobalFooterPageThreadLocal().verifyUrlAfterClickingElement(getGlobalFooterPageThreadLocal().lnkInstagram,lsUrl),"The Url after clicking Instagram link is "+lsUrl,"The Url after clicking Instagram link is not "+lsUrl);
//
//		(new BasePage(this.getDriver())).navigateToURL(lsBaseUrl);
//		getGlobalFooterPageThreadLocal().waitForPageLoading();
//		
//		//Youtube
//		lsUrl=getGlobalFooterPageThreadLocal().getUrlWithSocialMediaName(lstSocialMediaLinks, "Youtube");		
//		reporter.softAssert(getGlobalFooterPageThreadLocal().verifyElementProperty(getGlobalFooterPageThreadLocal().lnkYoutube,"Link"),"Youtube link in Global footer is not empty","Youtube link in Global footer is empty");
//		reporter.softAssert(getGlobalFooterPageThreadLocal().verifyElementProperty(getGlobalFooterPageThreadLocal().imgYoutube,"Image"),"Youtube icon in Global footer is not empty","Youtube icon in Global footer is empty");		
//		reporter.softAssert(getGlobalFooterPageThreadLocal().verifyUrlAfterClickingElement(getGlobalFooterPageThreadLocal().lnkYoutube,lsUrl),"The Url after clicking Youtube link is "+lsUrl,"The Url after clicking Youtube link is not "+lsUrl);
//
//		(new BasePage(this.getDriver())).navigateToURL(lsBaseUrl);
//		getGlobalFooterPageThreadLocal().waitForPageLoading();
//		
//		//Pinterest
//		lsUrl=getGlobalFooterPageThreadLocal().getUrlWithSocialMediaName(lstSocialMediaLinks, "Pinterest");		
//		reporter.softAssert(getGlobalFooterPageThreadLocal().verifyElementProperty(getGlobalFooterPageThreadLocal().lnkPinterest,"Link"),"Pinterest link in Global footer is not empty","Pinterest link in Global footer is empty");
//		reporter.softAssert(getGlobalFooterPageThreadLocal().verifyElementProperty(getGlobalFooterPageThreadLocal().imgPinterest,"Image"),"Pinterest icon in Global footer is not empty","Pinterest icon in Global footer is empty");		
//		reporter.softAssert(getGlobalFooterPageThreadLocal().verifyUrlAfterClickingElement(getGlobalFooterPageThreadLocal().lnkPinterest,lsUrl),"The Url after clicking Pinterest link is "+lsUrl,"The Url after clicking Pinterest link is not "+lsUrl);
//
//		(new BasePage(this.getDriver())).navigateToURL(lsBaseUrl);
//		getGlobalFooterPageThreadLocal().waitForPageLoading();
		
		List<List<String>> lstNameAndLinks=TestDataHandler.constantDataVariables.getlst_NameAndLinks();
		
		//Credit card
		String lsText=basePage.getElementText(getGlobalFooterPageThreadLocal().lnkCreditCard);
		String lsYmlHref=getGlobalFooterPageThreadLocal().getLinkWithSpecificName(lstNameAndLinks,lsText);
		if(lsYmlHref.isEmpty()) {
			reporter.reportLog("Unable to find credit card link in yml file.");
		}
		String lsHref=basePage.getElementHref(getGlobalFooterPageThreadLocal().lnkCreditCard);
		reporter.softAssert(lsHref.equalsIgnoreCase(lsYmlHref),"The current credit card href of "+lsHref+" is equal to "+lsYmlHref+ "in yml file","The current credit card href of "+lsHref+" is not equal to "+lsYmlHref+ "in yml file");
		String lsImageSrc=basePage.getElementImageSrc(getGlobalFooterPageThreadLocal().imgCreditCard);
		reporter.softAssert(!lsImageSrc.isEmpty(),"The credit card image is not empty.","The credit card image is empty.");
		
		//Gift card
		lsText=basePage.getElementText(getGlobalFooterPageThreadLocal().lnkGiftCard);
		lsYmlHref=getGlobalFooterPageThreadLocal().getLinkWithSpecificName(lstNameAndLinks,lsText);
		if(lsYmlHref.isEmpty()) {
			reporter.reportLog("Unable to find Gift card link in yml file.");
		}
		lsHref=basePage.getElementHref(getGlobalFooterPageThreadLocal().lnkGiftCard);
		reporter.softAssert(lsHref.equalsIgnoreCase(lsYmlHref),"The current Gift card href of "+lsHref+" is equal to "+lsYmlHref+ "in yml file","The current Gift card href of "+lsHref+" is not equal to "+lsYmlHref+ "in yml file");
		lsImageSrc=basePage.getElementImageSrc(getGlobalFooterPageThreadLocal().imgGiftCard);
		reporter.softAssert(!lsImageSrc.isEmpty(),"The Gift card image is not empty.","The Gift card image is empty.");
		
		//Send us feedback
		lsText=basePage.getElementText(getGlobalFooterPageThreadLocal().lnkSendUsFeedback);
		lsYmlHref=getGlobalFooterPageThreadLocal().getLinkWithSpecificName(lstNameAndLinks,lsText);
		if(lsYmlHref.isEmpty()) {
			reporter.reportLog("Unable to find Send us feedback link in yml file.");
		}
		lsHref=basePage.getElementHref(getGlobalFooterPageThreadLocal().lnkSendUsFeedback);
		reporter.softAssert(lsHref.contains(lsYmlHref),"The current Send us feedback href of "+lsHref+" contains "+lsYmlHref+ "in yml file","The current Send us feedback href of "+lsHref+" does not contain "+lsYmlHref+ "in yml file");
		lsImageSrc=basePage.getElementImageSrc(getGlobalFooterPageThreadLocal().imgSendUsFeedback);
		reporter.softAssert(!lsImageSrc.isEmpty(),"The Send us feedback image is not empty.","The Send us feedback image is empty.");
		
		
		for(WebElement item:getGlobalFooterPageThreadLocal().lnkTSCCustomerHubAllLinks) {
			lsText=basePage.getElementText(item);			
			lsYmlHref=getGlobalFooterPageThreadLocal().getLinkWithSpecificName(lstNameAndLinks,lsText);			
			if(lsYmlHref.isEmpty()) {
				reporter.reportLog("Unable to find "+lsText+" link in yml file.");
			}
			lsHref=basePage.getElementHref(item);	
			if(lsYmlHref.startsWith("/")) {
				reporter.softAssert(lsHref.equalsIgnoreCase(lsYmlHref),"The current "+lsText+" href of "+lsHref+" is equal to "+lsYmlHref+ "in yml file","The current "+lsText+" href of "+lsHref+" is not equal to "+lsYmlHref+ "in yml file");
			}else {
				reporter.softAssert(lsHref.toLowerCase().contains(lsYmlHref.toLowerCase()),"The current "+lsText+" href of "+lsHref+" contains "+lsYmlHref+ "in yml file","The current "+lsText+" href of "+lsHref+" does not contain "+lsYmlHref+ "in yml file");
			}
			
		}
		
		for(WebElement item:getGlobalFooterPageThreadLocal().lnkAboutTSCAllLinks) {
			lsText=basePage.getElementText(item);
			lsYmlHref=getGlobalFooterPageThreadLocal().getLinkWithSpecificName(lstNameAndLinks,lsText);
			if(lsYmlHref.isEmpty()) {
				reporter.reportLog("Unable to find "+lsText+" link in yml file.");
			}
			lsHref=basePage.getElementHref(item);
			if(lsYmlHref.startsWith("/")) {
				reporter.softAssert(lsHref.equalsIgnoreCase(lsYmlHref),"The current "+lsText+" href of "+lsHref+" is equal to "+lsYmlHref+ "in yml file","The current "+lsText+" href of "+lsHref+" is not equal to "+lsYmlHref+ "in yml file");
			}else {
				reporter.softAssert(lsHref.toLowerCase().contains(lsYmlHref.toLowerCase()),"The current "+lsText+" href of "+lsHref+" contains "+lsYmlHref+ "in yml file","The current "+lsText+" href of "+lsHref+" does not contain "+lsYmlHref+ "in yml file");
			}			
		}
		
		//Copyright text
		lsText=basePage.getUFTEnabledData(basePage.getElementText(getGlobalFooterPageThreadLocal().txtCopyrightLine1));
		reporter.softAssert(getGlobalFooterPageThreadLocal().verifyEqualWithEncodingText(lstNameAndLinks, lsText),"The copyright text is equal to the text in yml","The copyright text is not equal to the text in yml");
		lsText=basePage.getUFTEnabledData(basePage.getElementText(getGlobalFooterPageThreadLocal().txtCopyrightLine2));		
		reporter.softAssert(getGlobalFooterPageThreadLocal().verifyEqualWithEncodingText(lstNameAndLinks, lsText),"The copyright text is equal to the text in yml","The copyright text is not equal to the text in yml");


		
	}

}
