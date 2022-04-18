package com.tsc.api.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountResponse {
    public String SalesForceCustomerId;
    public int CustomerEDP;
    public String CustomerNo;
    public String Email;
    public AddressClass BillingAddress;
    public List<AddressClass> ShippingAddresses;
    public List<CreditCardsClass> CreditCards;
    public int Favourites;
    public int CustomerId;
    public int SecurityQuestionId;
    public String SecurityQuestionAnswer;
    public boolean IsFraud;
    public boolean IsEmployee;

    public String getSalesForceCustomerId() {
        return SalesForceCustomerId;
    }

    public void setSalesForceCustomerId(String salesForceCustomerId) {
        SalesForceCustomerId = salesForceCustomerId;
    }

    public int getCustomerEDP() {
        return CustomerEDP;
    }

    public void setCustomerEDP(int customerEDP) {
        CustomerEDP = customerEDP;
    }

    public String getCustomerNo() {
        return CustomerNo;
    }

    public void setCustomerNo(String customerNo) {
        CustomerNo = customerNo;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public AddressClass getBillingAddress() {
        return BillingAddress;
    }

    public void setBillingAddress(AddressClass billingAddress) {
        BillingAddress = billingAddress;
    }

    public List<AddressClass> getShippingAddresses() {
        return ShippingAddresses;
    }

    public void setShippingAddresses(List<AddressClass> shippingAddresses) {
        ShippingAddresses = shippingAddresses;
    }

    public List<CreditCardsClass> getCreditCards() {
        return CreditCards;
    }

    public void setCreditCards(List<CreditCardsClass> creditCards) {
        CreditCards = creditCards;
    }

    public int getFavourites() {
        return Favourites;
    }

    public void setFavourites(int favourites) {
        Favourites = favourites;
    }

    public int getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(int customerId) {
        CustomerId = customerId;
    }

    public int getSecurityQuestionId() {
        return SecurityQuestionId;
    }

    public void setSecurityQuestionId(int securityQuestionId) {
        SecurityQuestionId = securityQuestionId;
    }

    public String getSecurityQuestionAnswer() {
        return SecurityQuestionAnswer;
    }

    public void setSecurityQuestionAnswer(String securityQuestionAnswer) {
        SecurityQuestionAnswer = securityQuestionAnswer;
    }

    public boolean isFraud() {
        return IsFraud;
    }

    public void setFraud(boolean fraud) {
        IsFraud = fraud;
    }

    public boolean isEmployee() {
        return IsEmployee;
    }

    public void setEmployee(boolean employee) {
        IsEmployee = employee;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class AddressClass {
        public int Id;
        public String SalesForceAddressId;
        public String FirstName;
        public String LastName;
        public String DayPhone;
        public String Street;
        public String AddressRef1;
        public String City;
        public String State;
        public String ZipCode;
        public boolean IsDefault;
        public String POBoxNumber;
        public boolean IsPOBox;
        public String Address2Type;
        public String Address2Value;

        public int getId() {
            return Id;
        }

        public void setId(int id) {
            Id = id;
        }

        public String getSalesForceAddressId() {
            return SalesForceAddressId;
        }

        public void setSalesForceAddressId(String salesForceAddressId) {
            SalesForceAddressId = salesForceAddressId;
        }

        public String getFirstName() {
            return FirstName;
        }

        public void setFirstName(String firstName) {
            FirstName = firstName;
        }

        public String getLastName() {
            return LastName;
        }

        public void setLastName(String lastName) {
            LastName = lastName;
        }

        public String getDayPhone() {
            return DayPhone;
        }

        public void setDayPhone(String dayPhone) {
            DayPhone = dayPhone;
        }

        public String getStreet() {
            return Street;
        }

        public void setStreet(String street) {
            Street = street;
        }

        public String getAddressRef1() {
            return AddressRef1;
        }

        public void setAddressRef1(String addressRef1) {
            AddressRef1 = addressRef1;
        }

        public String getCity() {
            return City;
        }

        public void setCity(String city) {
            City = city;
        }

        public String getState() {
            return State;
        }

        public void setState(String state) {
            State = state;
        }

        public String getZipCode() {
            return ZipCode;
        }

        public void setZipCode(String zipCode) {
            ZipCode = zipCode;
        }

        public boolean isDefault() {
            return IsDefault;
        }

        public void setDefault(boolean aDefault) {
            IsDefault = aDefault;
        }

        public String getPOBoxNumber() {
            return POBoxNumber;
        }

        public void setPOBoxNumber(String POBoxNumber) {
            this.POBoxNumber = POBoxNumber;
        }

        public boolean isPOBox() {
            return IsPOBox;
        }

        public void setPOBox(boolean POBox) {
            IsPOBox = POBox;
        }

        public String getAddress2Type() {
            return Address2Type;
        }

        public void setAddress2Type(String address2Type) {
            Address2Type = address2Type;
        }

        public String getAddress2Value() {
            return Address2Value;
        }

        public void setAddress2Value(String address2Value) {
            Address2Value = address2Value;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CreditCardsClass{
        public int Id;
        public String ExpirationDate;
        public boolean Expired;
        public String Number;
        public String MaskedNumber;
        public boolean IsDefault;
        public String Type;
        public String DisplayExpirationMonth;
        public String DisplayExpirationYear;
        public String CVV;

        public int getId() {
            return Id;
        }

        public void setId(int id) {
            Id = id;
        }

        public String getExpirationDate() {
            return ExpirationDate;
        }

        public void setExpirationDate(String expirationDate) {
            ExpirationDate = expirationDate;
        }

        public boolean isExpired() {
            return Expired;
        }

        public void setExpired(boolean expired) {
            Expired = expired;
        }

        public String getNumber() {
            return Number;
        }

        public void setNumber(String number) {
            Number = number;
        }

        public String getMaskedNumber() {
            return MaskedNumber;
        }

        public void setMaskedNumber(String maskedNumber) {
            MaskedNumber = maskedNumber;
        }

        public boolean isDefault() {
            return IsDefault;
        }

        public void setDefault(boolean aDefault) {
            IsDefault = aDefault;
        }

        public String getType() {
            return Type;
        }

        public void setType(String type) {
            Type = type;
        }

        public String getDisplayExpirationMonth() {
            return DisplayExpirationMonth;
        }

        public void setDisplayExpirationMonth(String displayExpirationMonth) {
            DisplayExpirationMonth = displayExpirationMonth;
        }

        public String getDisplayExpirationYear() {
            return DisplayExpirationYear;
        }

        public void setDisplayExpirationYear(String displayExpirationYear) {
            DisplayExpirationYear = displayExpirationYear;
        }

        public String getCVV() {
            return CVV;
        }

        public void setCVV(String CVV) {
            this.CVV = CVV;
        }
    }
}


