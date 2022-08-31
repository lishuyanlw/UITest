package com.tsc.test.tests.checkoutPage;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CP_TC04_VerifyReguLarCheckout_LowInventory_NavigationShoppingCartIconButton extends BaseTest{
	/*
	 * CER-874
	 * CER-875
	 */
	@Test(groups={"Regression","ShoppingCart"})
	public void CP_TC04_VerifyReguLarCheckout_LowInventory_NavigationShoppingCartIconButton() throws IOException {
		String lsUserName = TestDataHandler.constantData.getApiUserSessionParams().getLbl_username();
		String lsPassword = TestDataHandler.constantData.getApiUserSessionParams().getLbl_password();

		//Fetching test data from test data file
		String accessToken = getApiUserSessionDataMapThreadLocal().get("access_token").toString();
		int customerEDP = Integer.valueOf(getApiUserSessionDataMapThreadLocal().get("customerEDP").toString());

		getGlobalFooterPageThreadLocal().closePopupDialog();
		List<Map<String, String>> keywordList = TestDataHandler.constantData.getCheckoutPage().getLst_SearchKeywords();
		List<Map<String, Object>> data = getShoppingCartThreadLocal().verifyCartExistsForUser(customerEDP, accessToken, keywordList, true);

		//Login using valid username and password
		getGlobalLoginPageThreadLocal().Login(lsUserName, lsPassword);
		BasePage basePage = new BasePage(this.getDriver());
		try {
			getShoppingCartThreadLocal().waitForCondition(Driver -> {
				return Integer.valueOf(getglobalheaderPageThreadLocal().CartBagCounter.getText()) > 0;
			}, 6000);
		} catch (Exception e) {
			(new BasePage(this.getDriver())).applyStaticWait(3000);
		}

		List<String> lstKeywordList = TestDataHandler.constantData.getSearchResultPage().getLst_APISearchingKeyword();
		Map<String, Object> outputDataCriteria = new HashMap<String, Object>();
		outputDataCriteria.put("style", "1");
		outputDataCriteria.put("size", "1");
		outputDataCriteria.put("quantity", "-10");
		if (getProductDetailPageThreadLocal().goToProductItemWithPreConditions(lstKeywordList, "ConditionsForVideoAndStyleAndSizeWithoutCheckingSoldOutCriteria", outputDataCriteria)) {
			String lsProductName = getProductDetailPageThreadLocal().selectedProduct.productName;
			String lsStyle = getProductDetailPageThreadLocal().selectedProduct.productEDPColor;
			String lsSize = getProductDetailPageThreadLocal().selectedProduct.productEDPSize;
			Map<String,Object> mapProduct=new HashMap<>();
			mapProduct.put("productName",lsProductName);
			mapProduct.put("productStyle",lsStyle);
			mapProduct.put("productSize",lsSize);

			getProductDetailPageThreadLocal().chooseGivenStyleAndSizeAndQuantity(lsStyle, lsSize, 1);
			Map<String,Object> PDPMap=getProductDetailPageThreadLocal().getPDPDesc();
			int leftNumberInPDP=(int) PDPMap.get("productLeftNumber");

			basePage.clickElement(getProductDetailPageThreadLocal().btnAddToBag);
			basePage.waitForCondition(Driver -> {
				return getProductDetailPageThreadLocal().lblAddToBagPopupWindowTitle.isDisplayed();
			}, 30000);

			getProductDetailPageThreadLocal().goToShoppingCartFromAddToBagPopupWithLoginFirst();
			String lsShoppingCartURLNavigatedFromPDP=basePage.URL();

			if (getShoppingCartThreadLocal().checkIsDropdownMenuForInstallmentNumber()) {
				List<String> lstOptionText = getShoppingCartThreadLocal().getInstallmentOptions();
				getShoppingCartThreadLocal().setInstallmentSetting(lstOptionText.get(1));
			}
			int installmentsNumberForShoppingCart = getShoppingCartThreadLocal().getInstallmentNumber();
			getShoppingCartThreadLocal().goToCheckoutPage();

			List<Map<String, Object>> productListMapForCheckOutPage = getRegularCheckoutThreadLocal().getCheckoutItemListDesc("all");
			int findIndex=getShoppingCartThreadLocal().findGivenProductIndexInProductList(mapProduct,productListMapForCheckOutPage);
			reporter.reportLog("findIndex: "+findIndex);
			if(findIndex!=-1){
				if(productListMapForCheckOutPage.get(findIndex).get("productLeftNumber")!=null){
					reporter.reportLogPass("The left inventory info for product: '"+lsProductName+"' is displaying on checkout page");
					int leftNumberInCheckOutPage=(int) productListMapForCheckOutPage.get(findIndex).get("productLeftNumber");
					if(leftNumberInPDP==leftNumberInCheckOutPage){
						reporter.reportLogPass("The low inventory number on CheckOut page is the same as the one on PDP");
					}
					else{
						reporter.reportLogFail("The low inventory number: "+leftNumberInCheckOutPage+" on CheckOut page is the same as the one: "+leftNumberInPDP+" on PDP");
					}
				}
				else{
					reporter.reportLogFail("The left inventory info for product: '"+lsProductName+"' is not displaying on checkout page");
				}

				if(findIndex==0){
					reporter.reportLogPass("newly added item of the product: '"+lsProductName+"' with low inventory is shown on top of list of checkout items on CheckOut page.");
				}
				else{
					reporter.reportLogFail("newly added item of the product: '"+lsProductName+"' with low inventory is not shown on top of list of checkout items on CheckOut page.");
				}
			}
			else{
				reporter.reportLogFail("The product: '"+lsProductName+"' with low inventory cannot be found on CheckOut page!");
			}

			Map<String, Object> summaryMapForCheckOutList = getRegularCheckoutThreadLocal().getCheckoutItemCountAndSubTotal(productListMapForCheckOutPage);
			int itemCountForCheckOutList = (int) summaryMapForCheckOutList.get("itemCount");
			float subTotalForCheckOutList = (float) summaryMapForCheckOutList.get("subTotal");

			int itemCountInHeader=getRegularCheckoutThreadLocal().getOrderItemCount();
			if(itemCountForCheckOutList==itemCountInHeader){
				reporter.reportLogPass("The item count: "+itemCountForCheckOutList+" in checkout item list is equal to the one: "+itemCountInHeader+" in the header");
			}
			else{
				reporter.reportLogFail("The item count: "+itemCountForCheckOutList+" in checkout item list is not equal to the one: "+itemCountInHeader+" in the header");
			}

			reporter.reportLog("Verify orderSummary business logic");
			Map<String, Object> orderSummaryMapForCheckOutPage = getRegularCheckoutThreadLocal().getOrderSummaryDesc();
			getRegularCheckoutThreadLocal().verifyOrderSummaryBusinessLogic(subTotalForCheckOutList, orderSummaryMapForCheckOutPage, null);

			reporter.reportLog("Verify installment business logic");
			Map<String, Object> easyPaymentMapForCheckOutPage = getRegularCheckoutThreadLocal().getEasyPayDesc();
			getRegularCheckoutThreadLocal().verifyInstallmentBusinessLogic(installmentsNumberForShoppingCart, orderSummaryMapForCheckOutPage);

			reporter.reportLog("Verify checkout header contents");
			getRegularCheckoutThreadLocal().verifyCheckoutHeaderContents();

			reporter.reportLog("Verify checkout product list contents");
			getRegularCheckoutThreadLocal().verifyMandatoryContentsForCheckoutProductList();
			getRegularCheckoutThreadLocal().verifyOptionalContentsForCheckoutProductList();

			reporter.reportLog("Verify order summary contents");
			getRegularCheckoutThreadLocal().verifyOrderSummaryContents();

			reporter.reportLog("Verify easyPayment contents");
			getRegularCheckoutThreadLocal().verifyEasyPayContents();

			reporter.reportLog("Verify Navigation to ShoppingCart page by clicking GoToShoppingBag icon button in checkout header");
			getRegularCheckoutThreadLocal().GoToShoppingBag();
			String lsShoppingCartURLNavigatedFromCheckOutPage=basePage.URL();
			if(lsShoppingCartURLNavigatedFromCheckOutPage.equalsIgnoreCase(lsShoppingCartURLNavigatedFromPDP)&&
					lsShoppingCartURLNavigatedFromCheckOutPage.toLowerCase().contains("shoppingcart")){
				reporter.reportLogPass("Navigated to ShoppingCart page by clicking GoToShoppingBag button in checkout header successfully");
			}
			else{
				reporter.reportLogFail("Failed to navigated to ShoppingCart page by clicking GoToShoppingBag button in checkout header");
			}
		}
		else{
			reporter.reportLogFail("Unable to find the product with low inventory!");
		}
	}
}

