package com.tsc.test.tests.signIn;

import com.tsc.api.pojo.AccountResponse;
import com.tsc.api.util.DataConverter;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.data.pojos.ConstantData;
import com.tsc.test.base.BaseTest;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class SI_TC09_ForgotPassword extends BaseTest{
    /*
     * CER-917
     */
    @Test(groups={"Regression","SignIn"})
    public void SI_TC08_TransferPhoneAccount_ByExistingAccount() throws IOException {
        getGlobalFooterPageThreadLocal().closePopupDialog();

        //Fetching test data from test data file
        String lblUserName = TestDataHandler.constantData.getApiUserSessionParams().getLbl_username();
        String lblPassword = TestDataHandler.constantData.getApiUserSessionParams().getLbl_password();
        ConstantData.APIUserSessionParams apiUserSessionParams = TestDataHandler.constantData.getApiUserSessionParams();
        apiUserSessionData = apiResponseThreadLocal.get().getApiUserSessionData(lblUserName,lblPassword,apiUserSessionParams.getLbl_grantType(),apiUserSessionParams.getLbl_apiKey());
        String accessToken = apiUserSessionData.get("access_token").toString();

        AccountResponse accountResponse=getCreateAccountThreadLocal().getNewUserAccountDetails(accessToken);
        String phoneNumber= accountResponse.getBillingAddress().getDayPhone();
        reporter.reportLog("DayPhone: "+phoneNumber);
        String postalCode=accountResponse.getBillingAddress().getZipCode();
        String email= accountResponse.getEmail();
        String customerNumber= accountResponse.getCustomerNo();
        String firstName=accountResponse.getBillingAddress().getFirstName();

        JSONObject requestParams= DataConverter.readJsonFileIntoJSONObject("test-data/NewUser.json");
        String password= (String) requestParams.get("Password");

        getGlobalLoginPageThreadLocal().Login(email,password);

        getMyAccountPageThreadLocal().openSubItemWindow("Your Profile","Security Questions", getMyAccountPageThreadLocal().lblAccountSettingSectionTitle);
        Map<String,Object> presetSecurityQuestionMap=getMyAccountPageThreadLocal().changeSecurityQuestionFunctionInAccountSettingsSection(true);
        int presetSecurityQuestionIndex= (int) presetSecurityQuestionMap.get("SelectedIndex");
        String presetSecurityQuestionText= (String) presetSecurityQuestionMap.get("SelectText");
        String presetSecurityQuestionAnswer= (String) presetSecurityQuestionMap.get("Answer");

        getGlobalLoginPageThreadLocal().signOut();

        getGlobalLoginPageThreadLocal().goToForgotPasswordPage(null);

        String newPassword="qa123456";
        String newSecurityQuestionAnswer="1234";
        getForgotPasswordPageThreadLocal().resetPassword(email,phoneNumber,postalCode,presetSecurityQuestionAnswer,newPassword,newSecurityQuestionAnswer);

        String customerNumberOnMyAccountPage=getMyAccountPageThreadLocal().getCustomerNumberInHeader();
        if(customerNumber.equalsIgnoreCase(customerNumberOnMyAccountPage)){
            reporter.reportLogPass("The customer number:"+customerNumberOnMyAccountPage+" on MyAccount page is the same as the expected:"+customerNumber+" from API created account");
        }
        else{
            reporter.reportLogFail("The customer number:"+customerNumberOnMyAccountPage+" on MyAccount page is not the same as the expected:"+customerNumber+" from API created account");
        }

        String firstNameOnMyAccountPage=getMyAccountPageThreadLocal().getFirstNameInHeader();
        if(firstName.equalsIgnoreCase(firstNameOnMyAccountPage)){
            reporter.reportLogPass("The first name:"+firstNameOnMyAccountPage+" on MyAccount page is the same as the expected:"+firstName+" from API created account");
        }
        else{
            reporter.reportLogFail("The first name:"+firstNameOnMyAccountPage+" on MyAccount page is not the same as the expected:"+firstName+" from API created account");
        }

        getGlobalLoginPageThreadLocal().signOut();
        getGlobalLoginPageThreadLocal().Login(email,newPassword);
        customerNumberOnMyAccountPage=getMyAccountPageThreadLocal().getCustomerNumberInHeader();
        if(customerNumber.equalsIgnoreCase(customerNumberOnMyAccountPage)){
            reporter.reportLogPass("The customer number:"+customerNumberOnMyAccountPage+" on MyAccount page is the same as the expected:"+customerNumber+" from API created account");
        }
        else{
            reporter.reportLogFail("The customer number:"+customerNumberOnMyAccountPage+" on MyAccount page is not the same as the expected:"+customerNumber+" from API created account");
        }

        firstNameOnMyAccountPage=getMyAccountPageThreadLocal().getFirstNameInHeader();
        if(firstName.equalsIgnoreCase(firstNameOnMyAccountPage)){
            reporter.reportLogPass("The first name:"+firstNameOnMyAccountPage+" on MyAccount page is the same as the expected:"+firstName+" from API created account");
        }
        else{
            reporter.reportLogFail("The first name:"+firstNameOnMyAccountPage+" on MyAccount page is not the same as the expected:"+firstName+" from API created account");
        }



    }
}
