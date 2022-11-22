package com.tsc.test.tests.signIn;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SI_TC07_TransferPhoneAccount_ByGuestAccount extends BaseTest{
    /*
     * CER-917
     */
    @Test(groups={"Regression","SignIn"})
    public void SI_TC07_TransferPhoneAccount_ByGuestAccount() throws IOException {
        getGlobalFooterPageThreadLocal().closePopupDialog();
        BasePage basePage=new BasePage(this.getDriver());
        List<String> lstKeywordList=TestDataHandler.constantData.getCheckOut().getLst_SearchingKeywordForPlaceOrder();

        Map<String,Object> outputDataCriteria= new HashMap<String,Object>();
        outputDataCriteria.put("style", "2");
        outputDataCriteria.put("size", "2");
        outputDataCriteria.put("quantity", "2");
        if(getProductDetailPageThreadLocal().goToProductItemWithPreConditions(lstKeywordList,"ConditionsForMultipleStyleAndSize",outputDataCriteria)) {
            String[] lstStyle = getProductDetailPageThreadLocal().getStyleList();
            String[] lstSizeFirstItem = getProductDetailPageThreadLocal().getSizeListForGivenStyle(0);
            //String[] lstSizeSecondItem = getProductDetailPageThreadLocal().getSizeListForGivenStyle(1);

            getProductDetailPageThreadLocal().chooseGivenStyleAndSizeAndQuantity(lstStyle[0], lstSizeFirstItem[0], 1);
            basePage.clickElement(getProductDetailPageThreadLocal().btnAddToBag);
            basePage.waitForCondition(Driver -> {
                return getProductDetailPageThreadLocal().lblAddToBagPopupWindowTitle.isDisplayed();
            }, 30000);

            basePage.getReusableActionsInstance().javascriptScrollByVisibleElement(getProductDetailPageThreadLocal().btnAddToBagPopupWindowButtonSectionCheckOut);
            getProductDetailPageThreadLocal().btnAddToBagPopupWindowButtonSectionCheckOut.click();
            basePage.waitForCondition(Driver->{return getGlobalLoginPageThreadLocal().btnCreateAccountOrContinueAsGuest.isDisplayed();},120000);

            getGlobalLoginPageThreadLocal().goToGuestCheckoutPage();
            Map<String,Object> createdUserMap=getGuestCheckoutThreadLocal().createNewAccount(null,null,false);
            String phoneNumber= (String) createdUserMap.get("phoneNumber");
            String email= (String) createdUserMap.get("email");
            String firstName=(String) createdUserMap.get("firstName");

            getGuestCheckoutThreadLocal().goToPaymentPage();
            getGuestCheckoutThreadLocal().addNewCreditOrEditExistingCard("tsc");

            reporter.reportLog("Navigate to Review Screen");
            getGuestCheckoutThreadLocal().goToReviewPage();

            getRegularCheckoutThreadLocal().goToOrderConfirmationPage();
            Map<String,Object> receiptMap=getOrderConfirmationThreadLocal().getReceiptDesc();
            String customerNumber= (String) receiptMap.get("customerNumber");

            reporter.reportLog("Go To Transfer Phone Account Page Through Header");
            getGlobalLoginPageThreadLocal().goToTransferPhoneAccountPageThroughHeader();

            reporter.reportLog("Verify Form Contents");
            getTransferPhoneAccountThreadLocal().verifyFormContents();

            reporter.reportLog("Verify Show Or Hide Password Function");
            getTransferPhoneAccountThreadLocal().verifyShowOrHidePasswordFunction();

            reporter.reportLog("Verify Forgot Customer Part Contents");
            getTransferPhoneAccountThreadLocal().verifyForgotCustomerPartContents();

            reporter.reportLog("Verify error messages");
            List<String> lstErrorMessage=TestDataHandler.constantData.getLoginUser().getLstErrorMessageForTransferPhoneAccount();
            getTransferPhoneAccountThreadLocal().verifyErrorMessages(lstErrorMessage);

            getTransferPhoneAccountThreadLocal().createNewAccount(customerNumber,phoneNumber,email,"qa1234",true,true);

            reporter.reportLog("Login with newly created email: "+email+" and password: qa1234");
            boolean bSignIn=getGlobalLoginPageThreadLocal().checkSignInStatus();
            if(bSignIn){
                reporter.reportLogPass("Login successfully with newly created email: "+email+" and password: qa1234");
            }
            else{
                reporter.reportLogFailWithScreenshot("Login failed with newly created email: "+email+" and password: qa1234");
            }

            String customerNumberOnMyAccountPage=getMyAccountPageThreadLocal().getCustomerNumberInHeader();
            if(customerNumber.equalsIgnoreCase(customerNumberOnMyAccountPage)){
                reporter.reportLogPass("The customer number:"+customerNumberOnMyAccountPage+" on MyAccount page is the same as the expected:"+customerNumber+" on OrderConfirmation page");
            }
            else{
                reporter.reportLogFail("The customer number:"+customerNumberOnMyAccountPage+" on MyAccount page is not the same as the expected:"+customerNumber+" on OrderConfirmation page");
            }

            String firstNameOnMyAccountPage=getMyAccountPageThreadLocal().getFirstNameInHeader();
            if(firstName.equalsIgnoreCase(firstNameOnMyAccountPage)){
                reporter.reportLogPass("The first name:"+firstNameOnMyAccountPage+" on MyAccount page is the same as the expected:"+firstName+" for creating guest account");
            }
            else{
                reporter.reportLogFail("The first name:"+firstNameOnMyAccountPage+" on MyAccount page is not the same as the expected:"+firstName+" for creating guest account");
            }

        }
    }
}
