package com.tsc.test.tests.globalFooter;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class GF_TC01_Verify_GlobalFooter_SocialMedia extends BaseTest {
	/*
	 * CER-167
	 */
	@Test(groups={"Sanity","Home","Regression","GlobalFooter"})
	public void Verify_GlobalFooter_SocialMedia() throws IOException {
		getGlobalFooterPageThreadLocal().closePopupDialog();
		BasePage basePage=new BasePage(this.getDriver());		
		String lsBaseUrl=basePage.getBaseURL()+"/";
		
		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(lsBaseUrl), "TSC url is correct", "TSC url is incorrect");
		reporter.reportLog("Global Footer Section");	

		validateMajorNameAndLinks();
		validateActionContents();
		
	}
	
	public void validateActionContents() {
		reporter.reportLog("Global Footer Section contents for SocialMedia");
		
		BasePage basePage=new BasePage(this.getDriver());		
		String lsBaseUrl=basePage.getBaseURL()+"/";
		
		List<String> lstSocialMediaLinks=TestDataHandler.constantData.getFooterSection().getLst_SocialMediaLinks();
		
		//Facebook
		String lsUrl=getGlobalFooterPageThreadLocal().getUrlWithSocialMediaName(lstSocialMediaLinks, "Facebook");		
		reporter.softAssert(getGlobalFooterPageThreadLocal().verifyUrlAfterClickingElement(getGlobalFooterPageThreadLocal().lnkFacebook,lsUrl),"The Url after clicking Facebook link is "+lsUrl,"The Url after clicking Facebook link is not "+lsUrl);

		basePage.navigateToURL(lsBaseUrl);
		getGlobalFooterPageThreadLocal().waitForPageLoading();
		
		//Twitter
		lsUrl=getGlobalFooterPageThreadLocal().getUrlWithSocialMediaName(lstSocialMediaLinks, "Twitter");		
		reporter.softAssert(getGlobalFooterPageThreadLocal().verifyUrlAfterClickingElement(getGlobalFooterPageThreadLocal().lnkTwitter,lsUrl),"The Url after clicking Twitter link is "+lsUrl,"The Url after clicking Twitter link is not "+lsUrl);

		basePage.navigateToURL(lsBaseUrl);
		getGlobalFooterPageThreadLocal().waitForPageLoading();

		//Instagram
		lsUrl=getGlobalFooterPageThreadLocal().getUrlWithSocialMediaName(lstSocialMediaLinks, "Instagram");		
		reporter.softAssert(getGlobalFooterPageThreadLocal().verifyUrlAfterClickingElement(getGlobalFooterPageThreadLocal().lnkInstagram,lsUrl),"The Url after clicking Instagram link is "+lsUrl,"The Url after clicking Instagram link is not "+lsUrl);

		basePage.navigateToURL(lsBaseUrl);
		getGlobalFooterPageThreadLocal().waitForPageLoading();
		
		//Youtube
		lsUrl=getGlobalFooterPageThreadLocal().getUrlWithSocialMediaName(lstSocialMediaLinks, "Youtube");		
		reporter.softAssert(getGlobalFooterPageThreadLocal().verifyUrlAfterClickingElement(getGlobalFooterPageThreadLocal().lnkYoutube,lsUrl),"The Url after clicking Youtube link is "+lsUrl,"The Url after clicking Youtube link is not "+lsUrl);

		basePage.navigateToURL(lsBaseUrl);
		getGlobalFooterPageThreadLocal().waitForPageLoading();
		
		//Pinterest
		lsUrl=getGlobalFooterPageThreadLocal().getUrlWithSocialMediaName(lstSocialMediaLinks, "Pinterest");		
		reporter.softAssert(getGlobalFooterPageThreadLocal().verifyUrlAfterClickingElement(getGlobalFooterPageThreadLocal().lnkPinterest,lsUrl),"The Url after clicking Pinterest link is "+lsUrl,"The Url after clicking Pinterest link is not "+lsUrl);

		basePage.navigateToURL(lsBaseUrl);
		getGlobalFooterPageThreadLocal().waitForPageLoading();
	}
	
	public void validateMajorNameAndLinks() {
		reporter.reportLog("Global Footer Section name and links for SocialMedia");

		//Facebook
		reporter.softAssert(getGlobalFooterPageThreadLocal().verifyElementProperty(getGlobalFooterPageThreadLocal().lnkFacebook,"Link"),"Facebook link in Global footer is not empty","Facebook link in Global footer is empty");
		reporter.softAssert(getGlobalFooterPageThreadLocal().verifyElementProperty(getGlobalFooterPageThreadLocal().imgFacebook,"Image"),"Facebook icon in Global footer is not empty","Facebook icon in Global footer is empty");		

		//Twitter
		reporter.softAssert(getGlobalFooterPageThreadLocal().verifyElementProperty(getGlobalFooterPageThreadLocal().lnkTwitter,"Link"),"Twitter link in Global footer is not empty","Twitter link in Global footer is empty");
		reporter.softAssert(getGlobalFooterPageThreadLocal().verifyElementProperty(getGlobalFooterPageThreadLocal().imgTwitter,"Image"),"Twitter icon in Global footer is not empty","Twitter icon in Global footer is empty");		

		//Instagram
		reporter.softAssert(getGlobalFooterPageThreadLocal().verifyElementProperty(getGlobalFooterPageThreadLocal().lnkInstagram,"Link"),"Instagram link in Global footer is not empty","Instagram link in Global footer is empty");
		reporter.softAssert(getGlobalFooterPageThreadLocal().verifyElementProperty(getGlobalFooterPageThreadLocal().imgInstagram,"Image"),"Instagram icon in Global footer is not empty","Instagram icon in Global footer is empty");		
	
		//Youtube
		reporter.softAssert(getGlobalFooterPageThreadLocal().verifyElementProperty(getGlobalFooterPageThreadLocal().lnkYoutube,"Link"),"Youtube link in Global footer is not empty","Youtube link in Global footer is empty");
		reporter.softAssert(getGlobalFooterPageThreadLocal().verifyElementProperty(getGlobalFooterPageThreadLocal().imgYoutube,"Image"),"Youtube icon in Global footer is not empty","Youtube icon in Global footer is empty");		
		
		//Pinterest
		reporter.softAssert(getGlobalFooterPageThreadLocal().verifyElementProperty(getGlobalFooterPageThreadLocal().lnkPinterest,"Link"),"Pinterest link in Global footer is not empty","Pinterest link in Global footer is empty");
		reporter.softAssert(getGlobalFooterPageThreadLocal().verifyElementProperty(getGlobalFooterPageThreadLocal().imgPinterest,"Image"),"Pinterest icon in Global footer is not empty","Pinterest icon in Global footer is empty");		
		
	}

}
