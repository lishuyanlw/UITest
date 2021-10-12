package com.tsc.test.tests.globalFooter;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.openqa.selenium.WebElement;

public class GF_TC04_Verify_GlobalFooter_CustomerHubServicePageObjects extends BaseTest {
	
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
		String lsHref=basePage.getElementHref(selectedItem);		
		String lsYmlHref=getGlobalFooterPageThreadLocal().getLinkWithSpecificName(lstNameAndLinks,lsService,true);
		if(lsYmlHref.isEmpty()) {
			reporter.reportLogFail("Unable to find Customer Service link.");
		}		
		reporter.softAssert(getGlobalFooterPageThreadLocal().verifyLinks(lsHref,lsYmlHref),"The current Customer Service href of "+lsHref+" is equal to "+lsYmlHref,"The current Customer Service href of "+lsHref+" is not equal to "+lsYmlHref);
		
		if(!getGlobalFooterPageThreadLocal().goToService(lsService)) {
			reporter.reportLogFail("Unable to navigate to Customer service page objects.");
		}
		else {
			reporter.softAssert(lsHref.equalsIgnoreCase(basePage.URL()),"Current Url of "+basePage.URL()+" is equal to the previous element href of "+lsHref,"Current Url of "+basePage.URL()+" is not equal to the previous element href of "+lsHref);
			reporter.softAssert(basePage.verifyElementExisting(getGlobalFooterPageThreadLocal().lblCustomerService),"Customer service text is existing","Customer service text is not existing");
			reporter.softAssert(basePage.verifyElementExisting(getGlobalFooterPageThreadLocal().lblHowCanWeHelpYou),"Help text is existing","Help text is not existing");
			reporter.softAssert(basePage.verifyElementExisting(getGlobalFooterPageThreadLocal().inputSearchBox),"Search box is existing","Search box is not existing");
			reporter.softAssert(basePage.verifyElementExisting(getGlobalFooterPageThreadLocal().lblFrequentlyAskedQuestions),"Frequently asked questions is existing","Frequently asked questions is not existing");
			
			int listSize=getGlobalFooterPageThreadLocal().lstFrequentlyAskedQuestions.size();
			for(int i=0;i<listSize;i++) {
				WebElement item=getGlobalFooterPageThreadLocal().lstFrequentlyAskedQuestions.get(i);
				String lsItem=item.getText().trim();
				reporter.reportLog(lsItem);
				reporter.softAssert(!lsItem.isEmpty(),"The item text is not empty","The item text is empty");
				reporter.softAssert(!basePage.getElementHref(item).isEmpty(),"The link of "+lsItem+" is not empty","The link of "+lsItem+" is empty");
				getGlobalFooterPageThreadLocal().verifyLinksForFrequentlyAskedQuestionsInCustomerServicePageObject(item);
			}
		}
		

		
	}

}
