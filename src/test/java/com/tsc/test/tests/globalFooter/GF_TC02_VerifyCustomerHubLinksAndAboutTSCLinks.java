package com.tsc.test.tests.globalFooter;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class GF_TC02_VerifyCustomerHubLinksAndAboutTSCLinks extends BaseTest {
	/*
	 * CER-169
	 * CER-170
	 */
	@Test(groups={"Regression","GlobalFooter"})
	public void GF_TC02_VerifyCustomerHubLinksAndAboutTSCLinks() throws IOException {
		getGlobalFooterPageThreadLocal().closePopupDialog();
		BasePage basePage=new BasePage(this.getDriver());		
		String lsBaseUrl=basePage.getBaseURL()+"/";

		if(getglobalheaderPageThreadLocal().validateURL(lsBaseUrl)){
			reporter.reportLogPass("TSC url is correct");
		}
		else{
			reporter.reportLogFailWithScreenshot("TSC url is incorrect");
		}
		reporter.reportLog("Global Footer Section");
		
		validateContents();

	}
	
	public void validateContents() {
		reporter.reportLog("Global Footer Section contents for CustomerHubLinks_AboutTSCLinks");
		
		BasePage basePage=new BasePage(this.getDriver());		
		
		List<List<String>> lstNameAndLinks=TestDataHandler.constantData.getFooterSection().getLst_NameAndLinks();
		
		//Credit card
		String lsText=basePage.getElementText(getGlobalFooterPageThreadLocal().lnkCreditCard);		
		String lsYmlHref=getGlobalFooterPageThreadLocal().getLinkWithSpecificName(lstNameAndLinks,lsText,true);
		if(lsYmlHref.isEmpty()) {
			reporter.reportLogFailWithScreenshot("Unable to find credit card link.");
		}
		String lsHref=basePage.getElementHref(getGlobalFooterPageThreadLocal().lnkCreditCard);
		if(getGlobalFooterPageThreadLocal().verifyLinks(lsHref,lsYmlHref)){
			reporter.reportLogPass("The current credit card href of "+lsHref+" is equal to "+lsYmlHref);
		}
		else{
			reporter.reportLogFailWithScreenshot("The current credit card href of "+lsHref+" is not equal to "+lsYmlHref);
		}

		String lsImageSrc=basePage.getElementImageSrc(getGlobalFooterPageThreadLocal().imgCreditCard);
		if(!lsImageSrc.isEmpty()){
			reporter.reportLogPass("The credit card image is not empty.");
		}
		else{
			reporter.reportLogFailWithScreenshot("The credit card image is empty.");
		}

		//Gift card
		lsText=basePage.getElementText(getGlobalFooterPageThreadLocal().lnkGiftCard);		
		lsYmlHref=getGlobalFooterPageThreadLocal().getLinkWithSpecificName(lstNameAndLinks,lsText,true);
		if(lsYmlHref.isEmpty()) {
			reporter.reportLogFailWithScreenshot("Unable to find Gift card link.");
		}
		lsHref=basePage.getElementHref(getGlobalFooterPageThreadLocal().lnkGiftCard);
		if(getGlobalFooterPageThreadLocal().verifyLinks(lsHref,lsYmlHref)){
			reporter.reportLogPass("The current Gift card href of "+lsHref+" is equal to "+lsYmlHref);
		}
		else{
			reporter.reportLogFailWithScreenshot("The current Gift card href of "+lsHref+" is not equal to "+lsYmlHref);
		}

		lsImageSrc=basePage.getElementImageSrc(getGlobalFooterPageThreadLocal().imgGiftCard);
		if(!lsImageSrc.isEmpty()){
			reporter.reportLogPass("The Gift card image is not empty.");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Gift card image is empty.");
		}

		//Send us feedback
		lsText=basePage.getElementText(getGlobalFooterPageThreadLocal().lnkSendUsFeedback);		
		lsYmlHref=getGlobalFooterPageThreadLocal().getLinkWithSpecificName(lstNameAndLinks,lsText,true);
		if(lsYmlHref.isEmpty()) {
			reporter.reportLogFailWithScreenshot("Unable to find Send us feedback link.");
		}
		lsHref=basePage.getElementHref(getGlobalFooterPageThreadLocal().lnkSendUsFeedback);
		if(getGlobalFooterPageThreadLocal().verifyLinks(lsHref,lsYmlHref)){
			reporter.reportLogPass("The current Send us feedback href of "+lsHref+" contains "+lsYmlHref);
		}
		else{
			reporter.reportLogFailWithScreenshot("The current Send us feedback href of "+lsHref+" does not contain "+lsYmlHref);
		}

		lsImageSrc=basePage.getElementImageSrc(getGlobalFooterPageThreadLocal().imgSendUsFeedback);
		if(!lsImageSrc.isEmpty()){
			reporter.reportLogPass("The Send us feedback image is not empty.");
		}
		else{
			reporter.reportLogFailWithScreenshot("The Send us feedback image is empty.");
		}

		//Language switch
		lsText=basePage.getUTFEnabledData(basePage.getElementText(getGlobalFooterPageThreadLocal().lnkLanguage));		
		lsYmlHref=getGlobalFooterPageThreadLocal().getLinkWithSpecificName(lstNameAndLinks,lsText,true);
		if(lsYmlHref.isEmpty()) {
			reporter.reportLogFailWithScreenshot("Unable to find Language switch link.");
		}
		lsHref=basePage.getElementHref(getGlobalFooterPageThreadLocal().lnkLanguage);
		if(getGlobalFooterPageThreadLocal().verifyLinks(lsHref,lsYmlHref)){
			reporter.reportLogPass("The current Language switch href of "+lsHref+" contains "+lsYmlHref);
		}
		else{
			reporter.reportLogFailWithScreenshot("The current Language switch href of "+lsHref+" does not contain "+lsYmlHref);
		}

		//TSC customer hub links
		getGlobalFooterPageThreadLocal().verifyTSCCustomerHubLlinks(lstNameAndLinks);
		
		//About TSC links
		getGlobalFooterPageThreadLocal().verifyAboutTSCLinks(lstNameAndLinks);
		
		//Rogers LOGO
		getGlobalFooterPageThreadLocal().verifyRogersLogo();		
		
		//Copyright text
		lsText=basePage.getUTFEnabledData(basePage.getElementText(getGlobalFooterPageThreadLocal().txtCopyrightLine1));
		if(getGlobalFooterPageThreadLocal().verifyEqualWithEncodingText(lstNameAndLinks, lsText)){
			reporter.reportLogPass("The copyright text1 is correct");
		}
		else{
			reporter.reportLogFailWithScreenshot("The copyright text1 is not correct");
		}

		lsText=basePage.getUTFEnabledData(basePage.getElementText(getGlobalFooterPageThreadLocal().txtCopyrightLine2));
		if(getGlobalFooterPageThreadLocal().verifyEqualWithEncodingText(lstNameAndLinks, lsText)){
			reporter.reportLogPass("The copyright text2 is correct");
		}
		else{
			reporter.reportLogFailWithScreenshot("The copyright text2 is not correct");
		}

	}

}
