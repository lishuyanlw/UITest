package com.tsc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RegularCheckoutPage_Mobile extends RegularCheckoutPage{

    public RegularCheckoutPage_Mobile(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//header//div[contains(@class,'progressbar__wrap')]//div[@class='progressbar__title--mobile']")
    public WebElement lblReviewOrderProgressBar;

    @Override
    public void verifyCheckoutHeaderContents() {
        String lsText;

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(iconTSCHeaderLogo);
        if (this.getReusableActionsInstance().isElementVisible(iconTSCHeaderLogo)) {
            reporter.reportLogPass("The TSC header icon is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The TSC header icon is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblCheckout);
        lsText = lblCheckout.getText().trim();
        if (!lsText.isEmpty()) {
            reporter.reportLogPass("The checkout header title is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The checkout header title is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(iconAddressProgressBar);
        if (this.getReusableActionsInstance().isElementVisible(iconAddressProgressBar)) {
            reporter.reportLogPass("The address icon in progress bar is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The address icon in progress bar is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(iconPaymentProgressBar);
        if (this.getReusableActionsInstance().isElementVisible(iconPaymentProgressBar)) {
            reporter.reportLogPass("The payment icon in progress bar is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The payment icon in progress bar is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(lblReviewOrderProgressBar);
        lsText = lblReviewOrderProgressBar.getText().trim();
        if (!lsText.isEmpty()) {
            reporter.reportLogPass("The review order title in progress bar is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The review order title in progress bar is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(iconReviewOrderProgressBar);
        if (this.getReusableActionsInstance().isElementVisible(iconReviewOrderProgressBar)) {
            reporter.reportLogPass("The review order icon in header is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The review order icon in header is not displaying correctly");
        }

        this.getReusableActionsInstance().javascriptScrollByVisibleElement(btnGoToShoppingBag);
        if (this.getReusableActionsInstance().isElementVisible(btnGoToShoppingBag)) {
            reporter.reportLogPass("The GoToShoppingBag button in header is displaying correctly");
        } else {
            reporter.reportLogFailWithScreenshot("The GoToShoppingBag button in header is not displaying correctly");
        }
    }

}
