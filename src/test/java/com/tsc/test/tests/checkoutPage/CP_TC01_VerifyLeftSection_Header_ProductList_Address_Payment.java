package com.tsc.test.tests.checkoutPage;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CP_TC01_VerifyLeftSection_Header_ProductList_Address_Payment extends BaseTest{
	/*
	 * CER-844
	 */
	@Test(groups={"Regression","ShoppingCart"})
	public void CP_TC01_VerifyLeftSection_Header_ProductList_Address_Payment() throws IOException {
		getGlobalFooterPageThreadLocal().closePopupDialog();

		String lsUserName = TestDataHandler.constantData.getApiUserSessionParams().getLbl_username();
		String lsPassword = TestDataHandler.constantData.getApiUserSessionParams().getLbl_password();

		//Fetching test data from test data file
		String accessToken = getApiUserSessionDataMapThreadLocal().get("access_token").toString();
		int customerEDP = Integer.valueOf(getApiUserSessionDataMapThreadLocal().get("customerEDP").toString());
		List<Map<String, String>> keyword = TestDataHandler.constantData.getShoppingCart().getLst_SearchKeywords();
		List<Map<String, Object>> data = getShoppingCartThreadLocal().verifyCartExistsForUser(customerEDP, accessToken, keyword,true);

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
		getProductDetailPageThreadLocal().goToShoppingCartByClickingShoppingCartIconInGlobalHeader();

		List<String> lstOptionText=getShoppingCartThreadLocal().getInstallmentOptions();
		getShoppingCartThreadLocal().setInstallmentSetting(lstOptionText.get(1));

		Map<String, Object> productMapForShoppingCart = getShoppingCartThreadLocal().getShoppingSectionDetails("all");
		List<Map<String,Object>> productListForShoppingCart= (List<Map<String, Object>>) productMapForShoppingCart.get("shoppingList");
		int itemCountForShoppingCart= (int) productMapForShoppingCart.get("shoppingAmount");
		float subTotalForShoppingCart= (float) productMapForShoppingCart.get("shoppingSubTotal");

		Map<String, Object> orderSummaryMapForShoppingCart = getShoppingCartThreadLocal().getOrderSummaryDesc();
		Map<String, Object> easyPaymentMapForShoppingCart = getShoppingCartThreadLocal().getEasyPayDesc();
		int installmentsNumberForShoppingCart= (int) easyPaymentMapForShoppingCart.get("installmentsNumber");

		getShoppingCartThreadLocal().goToCheckoutPage();
		List<Map<String,Object>> productListMapForCheckOutPage = getRegularCheckoutThreadLocal().getCheckoutItemListDesc("all");
		Map<String,Object> summaryMapForCheckOutList=getRegularCheckoutThreadLocal().getCheckoutItemCountAndSubTotal(productListMapForCheckOutPage);
		int itemCountForCheckOutList= (int) summaryMapForCheckOutList.get("itemCount");
		float subTotalForCheckOutList= (float) summaryMapForCheckOutList.get("subTotal");

		Map<String, Object> orderSummaryMapForCheckOutPage = getRegularCheckoutThreadLocal().getOrderSummaryDesc();
		Map<String, Object> easyPaymentMapForCheckOutPage = getRegularCheckoutThreadLocal().getEasyPayDesc();

//		getRegularCheckoutThreadLocal().verifyOrderSummaryBusinessLogic(subTotalForCheckOutList,orderSummaryMapForCheckOutPage,null);
//		getRegularCheckoutThreadLocal().verifyInstallmentBusinessLogic(installmentsNumberForShoppingCart,orderSummaryMapForCheckOutPage);
//
//		getRegularCheckoutThreadLocal().verifyCheckoutHeaderContents();
//		getRegularCheckoutThreadLocal().verifyMandatoryContentsForCheckoutProductList();
//		getRegularCheckoutThreadLocal().verifyOptionalContentsForCheckoutProductList();
//		getRegularCheckoutThreadLocal().verifyAddressAndPaymentContents();
//		getRegularCheckoutThreadLocal().verifyOrderSummaryContents();
//		getRegularCheckoutThreadLocal().verifyEasyPayContents();
//		getRegularCheckoutThreadLocal().verifyGiftCardAndPlaceOrderContents();
//
//
//		if(getRegularCheckoutThreadLocal().checkChangeShippingMethodButtonExisting()){
//			reporter.reportLog("Verify Shipping method");
//			getRegularCheckoutThreadLocal().openAddOrChangePaymentMethodDialog();
//			getRegularCheckoutThreadLocal().chooseShippingMethodInChangeShippingMethodDialogWithGivenIndex(1);
//			getRegularCheckoutThreadLocal().closeChangeShippingMethodDialog(true);
//		}

		reporter.reportLog("Verify Payment Method");
		getRegularCheckoutThreadLocal().openAddOrChangePaymentMethodDialog();
//		getRegularCheckoutThreadLocal().openUsingNewCardDialog();
//		getRegularCheckoutThreadLocal().addNewTSCCard();
		getRegularCheckoutThreadLocal().addOrChangePaymentMethod(false);
		getRegularCheckoutThreadLocal().closeAddOrChangePaymentMethodDialog(true);

//		reporter.reportLog("Verify payment option");
//		List<String> paymentOptionList=getRegularCheckoutThreadLocal().getPaymentOptionTextList();
//		getRegularCheckoutThreadLocal().setPaymentOptionByGivenText(paymentOptionList.get(1));
//
//		reporter.reportLog("Verify shipping address");
//		getRegularCheckoutThreadLocal().openAddOrChangeAddressDialog();
//		getRegularCheckoutThreadLocal().openAddOrEditAddressDialog(getRegularCheckoutThreadLocal().btnAddOrChangeShippingAddressDialogAddNewAddressButton);
//		getRegularCheckoutThreadLocal().addOrEditAddress();
//		getRegularCheckoutThreadLocal().closeAddOrEditAddressDialog(true);
//
//		reporter.reportLog("Verify billing address");
//		getRegularCheckoutThreadLocal().openChangeBillingAddressDialog();
//		getRegularCheckoutThreadLocal().addOrEditAddress();
//		getRegularCheckoutThreadLocal().closeChangeBillingAddressDialog(true);



	}
}

