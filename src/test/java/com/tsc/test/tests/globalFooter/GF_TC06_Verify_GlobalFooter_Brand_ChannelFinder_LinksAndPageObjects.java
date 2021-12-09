package com.tsc.test.tests.globalFooter;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.List;

public class GF_TC06_Verify_GlobalFooter_Brand_ChannelFinder_LinksAndPageObjects extends BaseTest {
    /*
     * CER 191
     * CER 192
     * CER 193
     * CER 194
     * CER 195
     * CER 196
     * CER 197
     */
    @Test(groups={"Home","Regression","GlobalFooter"})
    public void verify_GlobalFooter_Brand() {
        getGlobalFooterPageThreadLocal().closePopupDialog();
        BasePage basePage = new BasePage(this.getDriver());
        String lsBaseUrl = basePage.getBaseURL() + "/";

        reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(lsBaseUrl), "TSC url is correct", "TSC url is incorrect");
        reporter.reportLog("Global Footer Section");

        List<List<String>> lstNameAndLinks = TestDataHandler.constantData.getFooterSection().getLst_NameAndLinks();
        //Shop By Brand
        String lsServiceSBB = "Shop By Brand";
        reporter.reportLog(lsServiceSBB);
        WebElement selectedItemSBB=getGlobalFooterPageThreadLocal().getServiceWebElement(lsServiceSBB);
        String lsHrefSBB=basePage.getElementHref(selectedItemSBB);
        HashMap<String,String> testDataSBB=getGlobalFooterPageThreadLocal().getTestDataWithSpecificName(lstNameAndLinks,lsServiceSBB,true);
        if(testDataSBB.isEmpty()) {
            reporter.reportLogFail("Unable to find '"+lsServiceSBB+"' link.");
        }
        reporter.softAssert(getGlobalFooterPageThreadLocal().verifyLinks(lsHrefSBB,testDataSBB.get("Link")),"The current '"+lsServiceSBB+"' href of "+lsHrefSBB+" is equal to "+testDataSBB.get("Link"),"The current '"+lsServiceSBB+"' href of "+lsHrefSBB+" is not equal to "+testDataSBB.get("Link"));

        if(!getGlobalFooterPageThreadLocal().goToService(lsServiceSBB,getGlobalFooterPageThreadLocal().aboutUsPageTitle)) {
            reporter.reportLogFail("Unable to navigate to '"+lsServiceSBB+"' page objects.");
        }
        else {
            //Verifying page title
            String pageTitle = getGlobalFooterPageThreadLocal().getPageTitle(getGlobalFooterPageThreadLocal().aboutUsPageTitle);
            reporter.softAssert(pageTitle.equalsIgnoreCase(lsServiceSBB),"Page Title matches for global footer link: "+lsServiceSBB+" and  title is: "+pageTitle,"Page Title doesn't match for global footer link: "+lsServiceSBB+" and  title is: "+pageTitle);

            //Verifying Page Elements
            reporter.softAssert(getGlobalFooterPageThreadLocal().verifyElementExisting(getGlobalFooterPageThreadLocal().lblSearchForaBrand),"The text Search for a Brand is displayed","The text Search for a Brand is not displayed");
            reporter.softAssert(getGlobalFooterPageThreadLocal().verifyElementExisting(getGlobalFooterPageThreadLocal().textBoxShopByBrandInputSearchBox),"Input Search Box is visible","Input Search Box is not visible");
            reporter.softAssert(getGlobalFooterPageThreadLocal().verifyElementExisting(getGlobalFooterPageThreadLocal().lblShopByBrandFilterByCategory),"The text Filter By Category is displayed","The text Filter By Category is not displayed");
            reporter.softAssert(getGlobalFooterPageThreadLocal().verifyElementExisting(getGlobalFooterPageThreadLocal().buttonShopByBrandInputSearchBoxSearchButton),"The Search Button is visible","The Search Button is not visible");
            reporter.softAssert(getGlobalFooterPageThreadLocal().verifyElementExisting(getGlobalFooterPageThreadLocal().dropDownShopByBrandFilterByCategory),"Drop Down for Filter By Category is displayed","Drop Down for Filter By Category is not displayed");
            reporter.softAssert(getGlobalFooterPageThreadLocal().verifyElementExisting(getGlobalFooterPageThreadLocal().lblFilterByAlphabet),"The text Filter By Alphabet is visible","The text Filter By Alphabet is not visible");

            //Verifying Drop Down Title matches with Page Title
            getGlobalFooterPageThreadLocal().verifyDropDownWithTitle(getGlobalFooterPageThreadLocal().dropDownShopByBrandFilterByCategory);

            //Verifying Find By Alphabets Links and its contents
            getGlobalFooterPageThreadLocal().verifyFindByAlphabet(getGlobalFooterPageThreadLocal().dropDownShopByBrandFilterByCategory, getGlobalFooterPageThreadLocal().linkFindByAlphabet);
        }
    }
}
