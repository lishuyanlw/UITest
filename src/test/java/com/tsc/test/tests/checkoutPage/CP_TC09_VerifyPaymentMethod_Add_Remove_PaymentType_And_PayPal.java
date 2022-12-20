package com.tsc.test.tests.checkoutPage;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tsc.api.apiBuilder.CartAPI;
import com.tsc.api.pojo.CartResponse;
import com.tsc.api.util.DataConverter;
import com.tsc.api.util.JsonParser;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CP_TC09_VerifyPaymentMethod_Add_Remove_PaymentType_And_PayPal extends BaseTest {
    /**
     CER-881 - Checkout - Payment Method - Verify dialog display and other options
     CER-882 - Checkout - Payment Method - Add new/change payment method, required message, fields display, Remove Card
     CER-883 - Checkout - Payment Method - Verify PayPal button
     */
    @Test(groups={"Regression","Checkout","CheckoutMobTab"})
    public void CP_TC09_VerifyPaymentMethod_Add_Remove_PaymentType_And_PayPal() throws IOException {
        getGlobalFooterPageThreadLocal().closePopupDialog();

        //Fetching test data from test data file
        String accessToken = getApiUserSessionDataMapThreadLocal().get("access_token").toString();
        String customerEDP = getApiUserSessionDataMapThreadLocal().get("customerEDP").toString();
        String lsUserName = TestDataHandler.constantData.getApiUserSessionParams().getLbl_username();
        String lsPassword = TestDataHandler.constantData.getApiUserSessionParams().getLbl_password();
        String paymentErrorMessage = TestDataHandler.constantData.getCheckOut().getLblPaymentMethodErrorMessage();
        List<List<String>> addNewCardErrorMessage = TestDataHandler.constantData.getCheckOut().getLstPaymentMethodCardAdditionErrorMessage();
        String invalidCreditCardNumber = TestDataHandler.constantData.getCheckOut().getLblInvalidCreditCardNumber();
        List<String> creditCardType = TestDataHandler.constantData.myAccount.getLst_newCreditCardType();
        JSONObject creditCardData = new DataConverter().readJsonFileIntoJSONObject("test-data/CreditCard.json");

        try{
            //Emptying Cart for test to run with right state
            getShoppingCartThreadLocal().emptyCart(Integer.valueOf(customerEDP),accessToken);

            //Verifying that item exists in cart and if not, create a new cart for user
            List<Map<String, String>> keyword = TestDataHandler.constantData.getCheckOut().getLst_SearchKeywords();
            List<Map<String, Object>> data = getShoppingCartThreadLocal().verifyCartExistsForUser(Integer.valueOf(customerEDP), accessToken, keyword,"all",false,0);
            if(data.size()==0){
                keyword = TestDataHandler.constantData.getShoppingCart().getLst_SearchKeywords();
                data = getShoppingCartThreadLocal().verifyCartExistsForUser(Integer.parseInt(customerEDP), accessToken, keyword,"all",false,0);
            }

            //Setting up initial test environment by deleting all cards associated with user and cart
            CartAPI cartAPI = new CartAPI();
            Response response = cartAPI.getAccountCartContentWithCustomerEDP(customerEDP,accessToken);
            CartResponse cartResponse= JsonParser.getResponseObject(response.asString(), new TypeReference<CartResponse>() {});
            getRegularCheckoutThreadLocal().deleteCreditCardForUserAndFromCart(cartResponse,customerEDP,accessToken);

            //Login using valid username and password
            getGlobalLoginPageThreadLocal().Login(lsUserName, lsPassword);
            try {
                getShoppingCartThreadLocal().waitForCondition(Driver -> {
                    return Integer.valueOf(getglobalheaderPageThreadLocal().CartBagCounter.getText()) > 0;
                }, 6000);
            }
            catch(Exception e){
                (new BasePage(this.getDriver())).applyStaticWait(3000);
            }
            getRegularCheckoutThreadLocal().navigateToCheckoutPage();

            //Verify error message for payment type as no card is associated with user
            reporter.reportLog("Verify error message for payment type as no card is associated with user");
            getRegularCheckoutThreadLocal().verifyErrorMessage(getRegularCheckoutThreadLocal().lblPaymentMethodErrorMessage,paymentErrorMessage);

            //Verify Add Payment Method dialog is displayed
            reporter.reportLog("Verify Add Payment Method dialog is displayed");
            getRegularCheckoutThreadLocal().openAddOrChangePaymentMethodDialog();
            getRegularCheckoutThreadLocal().verifyAddOrChangePaymentMethodDialogContents();

            //Verify required message for all fields and also invalid/expired message
            reporter.reportLog("Verify required message for all fields and also invalid/expired message");
            getRegularCheckoutThreadLocal().openUsingNewCardDialog();
            reporter.reportLog("1 > Verify required message for all fields on Add Payment Method Dialog");
            getRegularCheckoutThreadLocal().verifyUsingANewCardDialogContents();
            getRegularCheckoutThreadLocal().closeAddOrChangePaymentMethodDialog(true);
            reporter.reportLog("2 > Verify Mandatory Error Message");
            getRegularCheckoutThreadLocal().verifyErrorMessageOnAddPaymentMethodDialog(addNewCardErrorMessage.get(0));
            if(getRegularCheckoutThreadLocal().checkIfDeviceTypeNotDesktop(System.getProperty("Device"),System.getProperty("chromeMobileDevice"))){
                getRegularCheckoutThreadLocal().refresh();
                getRegularCheckoutThreadLocal().openAddOrChangePaymentMethodDialog();
                getRegularCheckoutThreadLocal().openUsingNewCardDialog();
            }
            reporter.reportLog("3 > Verify Invalid Credit Card Error Message");
            getRegularCheckoutThreadLocal().addAndVerifyInvalidCardErrorMessage(invalidCreditCardNumber,addNewCardErrorMessage.get(1).get(0));
            reporter.reportLog("4 > Verify Expired Credit Card Error Message");
            getRegularCheckoutThreadLocal().addNewCreditOrEditExistingCard("expired",true,false);
            getRegularCheckoutThreadLocal().closeAddOrChangePaymentMethodDialog(true);
            getRegularCheckoutThreadLocal().verifyErrorMessageOnAddPaymentMethodDialog(addNewCardErrorMessage.get(2));

            //Verify by adding existing card
            //Verify display of icon just after entering CC number - covered in function - addNewCreditCard()
            reporter.reportLog("Verify by adding existing card and \n" +
                    "Verify display of icon just after entering CC number");
            getRegularCheckoutThreadLocal().closeAddOrChangePaymentMethodDialog(false);
            String selectedCard = null;
            //Verify new card is displayed on Checkout page after save - covered in function - verifyPaymentMethodOnCheckoutWithCardOnAddChangeDialog()
            reporter.reportLog("Verify new card is displayed on Checkout page after save");
            for(String cardType:creditCardType){
//                getRegularCheckoutThreadLocal().refreshPageForMobileTablet();
                selectedCard = cardType;
                reporter.reportLog("cardType: "+cardType);
                getRegularCheckoutThreadLocal().openUsingNewCardDialog();
                //Verify by adding all types of cards
                reporter.reportLog("Verify by adding all types of cards for credit card: "+cardType);
                getRegularCheckoutThreadLocal().addNewCreditOrEditExistingCard(cardType,true,false);
//                getRegularCheckoutThreadLocal().closeAddOrChangePaymentMethodDialog(true);
                getRegularCheckoutThreadLocal().closeUsingANewCardDialog(true);
                //Store payment method saved on checkout page after adding payment method
                String paymentMethodCardType = getRegularCheckoutThreadLocal().getSelectedPaymentMethodFromCheckout(getRegularCheckoutThreadLocal().lblSelectedCardTypeForPayment);
                getRegularCheckoutThreadLocal().openAddOrChangePaymentMethodDialog();
                getRegularCheckoutThreadLocal().verifyPaymentMethodOnCheckoutWithCardOnAddChangeDialog(paymentMethodCardType, (JSONObject) creditCardData.get(cardType),null,null);
            }
            reporter.reportLog("Verifying selected card on PayMethod PopUp");
            getRegularCheckoutThreadLocal().verfiyAddedCardsForUserInPaymentMethod(selectedCard);

            //Verify Remove dialog screen and also verify click Yes should remove the card
            reporter.reportLog("Verify Remove dialog screen and verify click on close button should not remove the card");
            getRegularCheckoutThreadLocal().verifyRemovePaymentMethodForUser(false);
            reporter.reportLog("Verify Remove dialog screen and also verify click Yes should remove the card");
            getRegularCheckoutThreadLocal().verifyRemovePaymentMethodForUser(true);

            //Verify Edit Credit Card Functionality
            reporter.reportLog("Verify Edit Selected Credit Card for User");
            getRegularCheckoutThreadLocal().openAddOrChangePaymentMethodDialog();
            String cardType = getRegularCheckoutThreadLocal().getSelectedCardTypeOnPaymentMethodDialog();
            getRegularCheckoutThreadLocal().openAddOrEditAddressDialog(getDriver().findElement(getRegularCheckoutThreadLocal().byAddOrChangeShippingAddressDialogEditButton));
            getRegularCheckoutThreadLocal().editAndVerifyAddedCreditCardInPaymentMethodForUser(cardType,"5","2039",(JSONObject) creditCardData.get(cardType),true);

            //Verify Pay Pal Option
            reporter.reportLog("Verify PayPal option");
            //getRegularCheckoutThreadLocal().openAddOrChangePaymentMethodDialog();
            getRegularCheckoutThreadLocal().verifyPayPalFunctionality();
        }finally{
            //Emptying Cart for test to run with right state
            getShoppingCartThreadLocal().emptyCart(Integer.valueOf(customerEDP),accessToken);
        }
    }
}
