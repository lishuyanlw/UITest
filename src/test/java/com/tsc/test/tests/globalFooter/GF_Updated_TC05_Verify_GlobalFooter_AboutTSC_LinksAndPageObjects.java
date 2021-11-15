package com.tsc.test.tests.globalFooter;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GF_Updated_TC05_Verify_GlobalFooter_AboutTSC_LinksAndPageObjects extends BaseTest {

    @Test(groups={"Home","Regression","GlobalFooter"})
    public void verify_GlobalFooter_AboutTSC() {
        getGlobalFooterPageThreadLocal().closePopupDialog();
        BasePage basePage = new BasePage(this.getDriver());
        String lsBaseUrl = basePage.getBaseURL() + "/";

        reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(lsBaseUrl), "TSC url is correct", "TSC url is incorrect");
        reporter.reportLog("Global Footer Section");

        List<List<String>> lstNameAndLinks = TestDataHandler.constantData.getFooterSection().getLst_NameAndLinks();

        List<String> global_footer_items = new ArrayList<>();
        //Adding links present in About TSC to be verified
        global_footer_items.add("Terms of Use");
        global_footer_items.add("Privacy Policy");
        global_footer_items.add("Become a Vendor");
        for (String lsService : global_footer_items) {
            reporter.reportLog(lsService);
            WebElement selectedItem=getGlobalFooterPageThreadLocal().getServiceWebElement(lsService);
            String lsHref=basePage.getElementHref(selectedItem);
            HashMap<String,String> testData=getGlobalFooterPageThreadLocal().getTestDataWithSpecificName(lstNameAndLinks,lsService,true);
            if(testData.isEmpty()) {
                reporter.reportLogFail("Unable to find '"+lsService+"' link.");
            }
            reporter.softAssert(getGlobalFooterPageThreadLocal().verifyLinks(lsHref,testData.get("Link")),"The current '"+lsService+"' href of "+lsHref+" is equal to "+testData.get("Link"),"The current '"+lsService+"' href of "+lsHref+" is not equal to "+testData.get("Link"));

            if(!getGlobalFooterPageThreadLocal().goToService(lsService,getGlobalFooterPageThreadLocal().aboutUsPageTitle)) {
                reporter.reportLogFail("Unable to navigate to '"+lsService+"' page objects.");
            }
            else {
                //Verifying page title
                String pageTitle = getGlobalFooterPageThreadLocal().getPageTitle(getGlobalFooterPageThreadLocal().aboutUsPageTitle);
                reporter.softAssert(pageTitle.equalsIgnoreCase(testData.get("Title")),"Page Title matches for global footer link: "+lsService+" and title is: "+pageTitle,"Page Title doesn't match for global footer link: "+lsService+" and title is: "+pageTitle);
                //Verifying that user is navigated to respective section after navigating to page
                Boolean respectiveSectionValue=getGlobalFooterPageThreadLocal().verifyRespectiveSectionForLinkOnPage(getGlobalFooterPageThreadLocal().lstMyAccountItemTitle);
                reporter.softAssert(respectiveSectionValue,"Section for "+lsService+" on page: "+pageTitle+" is open after navigating","Section for "+lsService+" on page: "+pageTitle+" is not open after navigating");
                //Verifying Page Layout and sections
                getGlobalFooterPageThreadLocal().expandPanelItems(getGlobalFooterPageThreadLocal().lstMyAccountItemTitle,getGlobalFooterPageThreadLocal().lstMyAccountItemContent);
            }
        }

        //More About TSC
        String lsService = "More About TSC";
        ArrayList<WebElement> elementList=new ArrayList<WebElement>();
        reporter.reportLog(lsService);
        WebElement selectedItem=getGlobalFooterPageThreadLocal().getServiceWebElement(lsService);
        String lsHref=basePage.getElementHref(selectedItem);
        HashMap<String,String> testData=getGlobalFooterPageThreadLocal().getTestDataWithSpecificName(lstNameAndLinks,lsService,true);
        if(testData.isEmpty()) {
            reporter.reportLogFail("Unable to find '"+lsService+"' link.");
        }
        reporter.softAssert(getGlobalFooterPageThreadLocal().verifyLinks(lsHref,testData.get("Link")),"The current '"+lsService+"' href of "+lsHref+" is equal to "+testData.get("Link"),"The current '"+lsService+"' href of "+lsHref+" is not equal to "+testData.get("Link"));

        if(!getGlobalFooterPageThreadLocal().goToService(lsService,getGlobalFooterPageThreadLocal().aboutUsPageTitle)) {
            reporter.reportLogFail("Unable to navigate to '"+lsService+"' page objects.");
        }
        else {
            //Add In Page sub Header values
            for(WebElement item:getGlobalFooterPageThreadLocal().subHeaders) {
                elementList.add(item);
            }

            //Add Links present under different sub Headers on page
            for(WebElement item:getGlobalFooterPageThreadLocal().subHeaderLinks) {
                elementList.add(item);
            }

            getGlobalFooterPageThreadLocal().verifyElementListExistence(elementList);
        }
    }
}