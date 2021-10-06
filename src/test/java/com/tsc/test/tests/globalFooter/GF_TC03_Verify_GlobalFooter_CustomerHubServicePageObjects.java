package com.tsc.test.tests.globalFooter;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.openqa.selenium.WebElement;

public class GF_TC03_Verify_GlobalFooter_CustomerHubServicePageObjects extends BaseTest {
	
	@Test(groups={"Home","Regression","GlobalFooter"})
	public void Verify_GlobalFooter_CustomerHubServicePageObjects() throws IOException {
		getGlobalFooterPageThreadLocal().closePopupDialog();
		BasePage basePage=new BasePage(this.getDriver());		
		String lsBaseUrl=basePage.getBaseURL()+"/";
		
		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(lsBaseUrl), "TSC url is correct", "TSC url is incorrect");		
		reporter.reportLog("Global Footer Section");		

		List<List<String>> lstNameAndLinks=TestDataHandler.constantDataVariables.getlst_NameAndLinks();
		String lsService;
		
		//Customer service
		lsService="Customer Service";
		WebElement selectedItem=getGlobalFooterPageThreadLocal().getServiceWebElement(lsService);
		String lsText=selectedItem.getText().trim();
		String lsHref=basePage.getElementHref(selectedItem);		
		String lsYmlHref=getGlobalFooterPageThreadLocal().getLinkWithSpecificName(lstNameAndLinks,lsText,true);
		if(lsYmlHref.isEmpty()) {
			reporter.reportLog("Unable to find credit card link in yml file.");
		}		
		reporter.softAssert(getGlobalFooterPageThreadLocal().verifyLinks(lsHref,lsYmlHref),"The current credit card href of "+lsHref+" is equal to "+lsYmlHref+ "in yml file","The current credit card href of "+lsHref+" is not equal to "+lsYmlHref+ "in yml file");
		
		if(getGlobalFooterPageThreadLocal().goToService(lsService)) {
			reporter.reportLog("Unable to navigate to Customer service page objects.");
		}
		else {
			reporter.softAssert(lsHref.equalsIgnoreCase(basePage.URL()),"Current Url of "+basePage.URL()+" is equal to the previous element href of "+lsHref,"Current Url of "+basePage.URL()+" is not equal to the previous element href of "+lsHref);
			reporter.softAssert(basePage.verifyElementExisting(getGlobalFooterPageThreadLocal().lblCustomerService),"Customer service text is existing","Customer service text is not existing");
			reporter.softAssert(basePage.verifyElementExisting(getGlobalFooterPageThreadLocal().lblHowCanWeHelpYou),"Help text is existing","Help text is not existing");
			reporter.softAssert(basePage.verifyElementExisting(getGlobalFooterPageThreadLocal().inputSearchBox),"Search box is existing","Search box is not existing");
			reporter.softAssert(basePage.verifyElementExisting(getGlobalFooterPageThreadLocal().lblFrequentlyAskedQuestions),"Frequently asked questions is existing","Frequently asked questions is not existing");
			
			for(WebElement item:getGlobalFooterPageThreadLocal().lstFrequentlyAskedQuestions) {
				String lsItem=item.getText().trim();
				reporter.softAssert(!lsItem.isEmpty(),"The item text is not empty","The item text is empty");
				reporter.softAssert(!basePage.getElementHref(item).isEmpty(),"The link of "+lsItem+" is not empty","The link of "+lsItem+" is empty");
				getGlobalFooterPageThreadLocal().verifyLinksForFrequentlyAskedQuestionsInCustomerServicePageObject(item);
			}
		}
		

		
	}

}
