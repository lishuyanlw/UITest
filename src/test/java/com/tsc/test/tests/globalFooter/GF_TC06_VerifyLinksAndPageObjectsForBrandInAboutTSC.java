package com.tsc.test.tests.globalFooter;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GF_TC06_VerifyLinksAndPageObjectsForBrandInAboutTSC extends BaseTest {
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
    public void GF_TC06_VerifyLinksAndPageObjectsForBrandInAboutTSC() {
        getGlobalFooterPageThreadLocal().closePopupDialog();
        BasePage basePage = new BasePage(this.getDriver());
        String lsBaseUrl = basePage.getBaseURL() + "/";

        if(getglobalheaderPageThreadLocal().validateURL(lsBaseUrl)){
            reporter.reportLogPass("TSC url is correct");
        }
        else{
            reporter.reportLogFailWithScreenshot("TSC url is incorrect");
        }

        reporter.reportLog("Global Footer Section");

        List<List<String>> lstNameAndLinks = TestDataHandler.constantData.getFooterSection().getLst_NameAndLinks();
        //Shop By Brand
        String lsServiceSBB = "Shop By Brand";
        reporter.reportLog(lsServiceSBB);
        Map<String,String> testDataSBB=getGlobalFooterPageThreadLocal().getTestDataWithSpecificName(lstNameAndLinks,lsServiceSBB,true);
        WebElement selectedItemSBB=getGlobalFooterPageThreadLocal().getServiceWebElement(lsServiceSBB,testDataSBB.get("parent"));
        String lsHrefSBB=basePage.getElementHref(selectedItemSBB);
        if(testDataSBB.isEmpty()) {
            reporter.reportLogFail("Unable to find '"+lsServiceSBB+"' link.");
        }
        if(getGlobalFooterPageThreadLocal().verifyLinks(lsHrefSBB,testDataSBB.get("Link"))){
            reporter.reportLogPass("The current '"+lsServiceSBB+"' href of "+lsHrefSBB+" is equal to "+testDataSBB.get("Link"));
        }
        else{
            reporter.reportLogFailWithScreenshot("The current '"+lsServiceSBB+"' href of "+lsHrefSBB+" is not equal to "+testDataSBB.get("Link"));
        }

        if(!getGlobalFooterPageThreadLocal().goToService(lsServiceSBB,getGlobalFooterPageThreadLocal().aboutUsPageTitle,testDataSBB.get("parent"))) {
            reporter.reportLogFail("Unable to navigate to '"+lsServiceSBB+"' page objects.");
        }
        else {
            //Verifying page title
            String pageTitle = getGlobalFooterPageThreadLocal().getPageTitle(getGlobalFooterPageThreadLocal().aboutUsPageTitle);
            if(pageTitle.equalsIgnoreCase(lsServiceSBB)){
                reporter.reportLogPass("Page Title matches for global footer link: "+lsServiceSBB+" and  title is: "+pageTitle);
            }
            else{
                reporter.reportLogFailWithScreenshot("Page Title doesn't match for global footer link: "+lsServiceSBB+" and  title is: "+pageTitle);
            }

            //Verifying Page Elements
            if(getGlobalFooterPageThreadLocal().verifyElementExisting(getGlobalFooterPageThreadLocal().lblSearchForaBrand)){
                reporter.reportLogPass("The text Search for a Brand is displayed");
            }
            else{
                reporter.reportLogFailWithScreenshot("The text Search for a Brand is not displayed");
            }

            if(getGlobalFooterPageThreadLocal().verifyElementExisting(getGlobalFooterPageThreadLocal().textBoxShopByBrandInputSearchBox)){
                reporter.reportLogPass("Input Search Box is visible");
            }
            else{
                reporter.reportLogFailWithScreenshot("Input Search Box is not visible");
            }

            if(getGlobalFooterPageThreadLocal().verifyElementExisting(getGlobalFooterPageThreadLocal().lblShopByBrandFilterByCategory)){
                reporter.reportLogPass("The text Filter By Category is displayed");
            }
            else{
                reporter.reportLogFailWithScreenshot("The text Filter By Category is not displayed");
            }

            if(getGlobalFooterPageThreadLocal().verifyElementExisting(getGlobalFooterPageThreadLocal().buttonShopByBrandInputSearchBoxSearchButton)){
                reporter.reportLogPass("The Search Button is visible");
            }
            else{
                reporter.reportLogFailWithScreenshot("The Search Button is not visible");
            }

            if(getGlobalFooterPageThreadLocal().verifyElementExisting(getGlobalFooterPageThreadLocal().dropDownShopByBrandFilterByCategory)){
                reporter.reportLogPass("Drop Down for Filter By Category is displayed");
            }
            else{
                reporter.reportLogFailWithScreenshot("Drop Down for Filter By Category is not displayed");
            }

            if(getGlobalFooterPageThreadLocal().verifyElementExisting(getGlobalFooterPageThreadLocal().lblFilterByAlphabet)){
                reporter.reportLogPass("The text Filter By Alphabet is visible");
            }
            else{
                reporter.reportLogFailWithScreenshot("The text Filter By Alphabet is not visible");
            }

            //Verifying Drop Down Title matches with Page Title
            getGlobalFooterPageThreadLocal().verifyDropDownWithTitle(getGlobalFooterPageThreadLocal().dropDownShopByBrandFilterByCategory);

            //Verifying Find By Alphabets Links and its contents
            getGlobalFooterPageThreadLocal().verifyFindByAlphabet(getGlobalFooterPageThreadLocal().dropDownShopByBrandFilterByCategory, getGlobalFooterPageThreadLocal().linkFindByAlphabet);
        }
    }
}
