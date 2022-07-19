package com.tsc.test.tests.productDetail;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class PD_TC19_VerifyProductDetail_ReviewsWithImage extends BaseTest {
    @Test(groups = {"ProductDetail", "Regression", "Regression_Mobile", "Regression_Tablet"})
    public void PD_TC19_VerifyProductDetail_ReviewsWithImage() throws IOException {
        getGlobalFooterPageThreadLocal().closePopupDialog();
        BasePage basePage = new BasePage(this.getDriver());
        reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(basePage.getBaseURL() + "/"), "TSC url is correct", "TSC url is incorrect");

        reporter.reportLog("Verify URL");
        String lsProductNumber, lsUrl;
        String searchKeyword = TestDataHandler.constantData.getSearchResultPage().getLst_APISearchingKeyword().get(1);

        if(getProductDetailPageThreadLocal().goToProductItemWithPreConditions(Arrays.asList(searchKeyword),"ProductWithEasyPaySizeChartAndReviewWithImage",null)) {
            lsProductNumber = getProductDetailPageThreadLocal().selectedProduct.productNumber;
            lsUrl = basePage.URL();
            reporter.softAssert(lsUrl.contains("productdetails"), "The Url is containing productdetails", "The Url is not containing productdetails");
            reporter.softAssert(lsUrl.contains(lsProductNumber),"The Url is containing selected product number of "+lsProductNumber,"The Url is not containing selected product number of "+lsProductNumber);
            if (getProductDetailPageThreadLocal().goToProductReviewSection()) {
                reporter.reportLog("Verify review image is present for reviews");
                HashMap<String, HashMap<String,String>> map = getProductDetailPageThreadLocal().verifyReviewImageForAddedReviews();
                reporter.reportLog("Verify review data on pop-up window under review histogram");
                if(System.getProperty("Device").equalsIgnoreCase("Mobile"))
                        //|| System.getProperty("Browser").contains("safari"))
                    reporter.reportLog("Review image in histogram functionality can't be tested on mobile due to emulator not displaying image as expected or on Safari due to xpath");
                else
                    getProductDetailPageThreadLocal().verifyReviewImagesInHistogram(map);
                if(map.size()>0)
                    reporter.reportLogPass("Review Section contains reviews with image uploaded");
                else
                    reporter.reportLogFail("Review Section does not contains reviews with images");
            }
        }
    }
}
