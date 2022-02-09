package com.tsc.test.tests.globalFooter;

import com.tsc.api.pojo.Product;
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
	public void Verify_GlobalFooter_SocialMedia() {

		getGlobalFooterPageThreadLocal().closePopupDialog();
		BasePage basePage=new BasePage(this.getDriver());		
		String lsBaseUrl=basePage.getBaseURL()+"/";

		if(getglobalheaderPageThreadLocal().validateURL(lsBaseUrl)){
			reporter.reportLogPass("TSC url is correct");
		}
		else{
			reporter.reportLogFail("TSC url is incorrect");
		}

		reporter.reportLog("Global Footer Section");	

		validateMajorNameAndLinks();
		validateActionContents();
		
	}
	
	public void validateActionContents() {
		reporter.reportLog("Global Footer Section contents for SocialMedia");
		
		BasePage basePage=new BasePage(this.getDriver());		
		String lsBaseUrl=basePage.getBaseURL()+"/";
		String lsUrl;
		
		List<String> lstSocialMediaLinks=TestDataHandler.constantData.getFooterSection().getLst_SocialMediaLinks();
		
		//Facebook
		getGlobalFooterPageThreadLocal().verifyFaceBookLink(lstSocialMediaLinks);
		
		//Twitter
		lsUrl=getGlobalFooterPageThreadLocal().getUrlWithSocialMediaName(lstSocialMediaLinks, "Twitter");		
		if(getGlobalFooterPageThreadLocal().verifyUrlAfterClickingElement(getGlobalFooterPageThreadLocal().lnkTwitter,lsUrl)){
			reporter.reportLogPass("The Url after clicking Twitter link is "+lsUrl);
		}
		else{
			reporter.reportLogFail("The Url after clicking Twitter link is not "+lsUrl);
		}

		basePage.navigateToURL(lsBaseUrl);
		getGlobalFooterPageThreadLocal().waitForPageLoading();
		basePage.getReusableActionsInstance().staticWait(1000);

		//Instagram
		lsUrl=getGlobalFooterPageThreadLocal().getUrlWithSocialMediaName(lstSocialMediaLinks, "Instagram");		
		if(getGlobalFooterPageThreadLocal().verifyUrlAfterClickingElement(getGlobalFooterPageThreadLocal().lnkInstagram,lsUrl)){
			reporter.reportLogPass("The Url after clicking Instagram link is "+lsUrl);
		}
		else{
			reporter.reportLogFail("The Url after clicking Instagram link is not "+lsUrl);
		}

		basePage.navigateToURL(lsBaseUrl);
		getGlobalFooterPageThreadLocal().waitForPageLoading();
		basePage.getReusableActionsInstance().staticWait(1000);
		
		//Youtube
		lsUrl=getGlobalFooterPageThreadLocal().getUrlWithSocialMediaName(lstSocialMediaLinks, "Youtube");		
		if(getGlobalFooterPageThreadLocal().verifyUrlAfterClickingElement(getGlobalFooterPageThreadLocal().lnkYoutube,lsUrl)){
			reporter.reportLogPass("The Url after clicking Youtube link is "+lsUrl);
		}
		else{
			reporter.reportLogFail("The Url after clicking Youtube link is not "+lsUrl);
		}

		basePage.navigateToURL(lsBaseUrl);
		getGlobalFooterPageThreadLocal().waitForPageLoading();
		basePage.getReusableActionsInstance().staticWait(1000);
		
		//Pinterest
		lsUrl=getGlobalFooterPageThreadLocal().getUrlWithSocialMediaName(lstSocialMediaLinks, "Pinterest");		
		if(getGlobalFooterPageThreadLocal().verifyUrlAfterClickingElement(getGlobalFooterPageThreadLocal().lnkPinterest,lsUrl)){
			reporter.reportLogPass("The Url after clicking Pinterest link is "+lsUrl);
		}
		else{
			reporter.reportLogFail("The Url after clicking Pinterest link is not "+lsUrl);
		}

		basePage.navigateToURL(lsBaseUrl);
		getGlobalFooterPageThreadLocal().waitForPageLoading();
		basePage.getReusableActionsInstance().staticWait(1000);
	}
	
	public void validateMajorNameAndLinks() {
		reporter.reportLog("Global Footer Section name and links for SocialMedia");

		//Facebook
		if(getGlobalFooterPageThreadLocal().verifyElementProperty(getGlobalFooterPageThreadLocal().lnkFacebook,"Link")){
			reporter.reportLogPass("Facebook link in Global footer is not empty");
		}
		else{
			reporter.reportLogFail("Facebook link in Global footer is empty");
		}
		if(getGlobalFooterPageThreadLocal().verifyElementProperty(getGlobalFooterPageThreadLocal().imgFacebook,"Image")){
			reporter.reportLogPass("Facebook icon in Global footer is not empty");
		}
		else{
			reporter.reportLogFail("Facebook icon in Global footer is empty");
		}

		//Twitter
		if(getGlobalFooterPageThreadLocal().verifyElementProperty(getGlobalFooterPageThreadLocal().lnkTwitter,"Link")){
			reporter.reportLogPass("Twitter link in Global footer is not empty");
		}
		else{
			reporter.reportLogFail("Twitter link in Global footer is empty");
		}
		if(getGlobalFooterPageThreadLocal().verifyElementProperty(getGlobalFooterPageThreadLocal().imgTwitter,"Image")){
			reporter.reportLogPass("Twitter icon in Global footer is not empty");
		}
		else{
			reporter.reportLogFail("Twitter icon in Global footer is empty");
		}

		//Instagram
		if(getGlobalFooterPageThreadLocal().verifyElementProperty(getGlobalFooterPageThreadLocal().lnkInstagram,"Link")){
			reporter.reportLogPass("Instagram link in Global footer is not empty");
		}
		else{
			reporter.reportLogFail("Instagram link in Global footer is empty");
		}
		if(getGlobalFooterPageThreadLocal().verifyElementProperty(getGlobalFooterPageThreadLocal().imgInstagram,"Image")){
			reporter.reportLogPass("Instagram icon in Global footer is not empty");
		}
		else{
			reporter.reportLogFail("Instagram icon in Global footer is empty");
		}

		//Youtube
		if(getGlobalFooterPageThreadLocal().verifyElementProperty(getGlobalFooterPageThreadLocal().lnkYoutube,"Link")){
			reporter.reportLogPass("Youtube link in Global footer is not empty");
		}
		else{
			reporter.reportLogFail("Youtube link in Global footer is empty");
		}
		if(getGlobalFooterPageThreadLocal().verifyElementProperty(getGlobalFooterPageThreadLocal().imgYoutube,"Image")){
			reporter.reportLogPass("Youtube icon in Global footer is not empty");
		}
		else{
			reporter.reportLogFail("Youtube icon in Global footer is empty");
		}

		//Pinterest
		if(getGlobalFooterPageThreadLocal().verifyElementProperty(getGlobalFooterPageThreadLocal().lnkPinterest,"Link")){
			reporter.reportLogPass("Pinterest link in Global footer is not empty");
		}
		else{
			reporter.reportLogFail("Pinterest link in Global footer is empty");
		}
		if(getGlobalFooterPageThreadLocal().verifyElementProperty(getGlobalFooterPageThreadLocal().imgPinterest,"Image")){
			reporter.reportLogPass("Pinterest icon in Global footer is not empty");
		}
		else{
			reporter.reportLogFail("Pinterest icon in Global footer is empty");
		}

	}

}
