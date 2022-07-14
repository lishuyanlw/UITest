package com.tsc.test.tests.productDetail;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;

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
                int counter = getProductDetailPageThreadLocal().verifyReviewImageForAddedReviews();
                if(counter>0)
                    reporter.reportLogPass("Review Section contains reviews with image uploaded");
                else
                    reporter.reportLogFail("Review Section does not contains reviews with images");
            }
        }
    }
}
