package com.tsc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GlobalHeaderPage_Tablet extends GlobalHeaderPage {

    public GlobalHeaderPage_Tablet(WebDriver driver) {
        super(driver);
    }

    @Override
    public void hoverOnWatchTSC() {
        super.hoverOnWatchTSC();
        this.btnWatchTSCBlackHeader.click();
        this.btnWatchTSCBlackHeader.click();
    }

    @Override
    public void verifyTopSellingProductsExistingByChangingItemInTrendingOrFeaturedBrandsList(List<WebElement> elementList) {
        String lsItem;
        for(WebElement element:elementList) {
            getReusableActionsInstance().javascriptScrollByVisibleElement(element);
            getReusableActionsInstance().scrollToElement(element);
            getReusableActionsInstance().staticWait(300);
            lsItem=element.getText();
            //reporter.softAssert(getReusableActionsInstance().isElementVisible(this.lblPossibleItemMatches),"The title of Top selling products is displaying correctly by selecting item of '"+lsItem+"'", "The title of Top selling products is not displaying correctly by selcting item of '"+lsItem+"'");
            reporter.softAssert(getReusableActionsInstance().isElementVisible(this.cntPossibleItemMatchesList),"The Top selling products list is displaying correctly by selecting item of '"+lsItem+"'","The Top selling products list is not displaying correctly by selcting item of '"+lsItem+"'");
        }
    }
}
