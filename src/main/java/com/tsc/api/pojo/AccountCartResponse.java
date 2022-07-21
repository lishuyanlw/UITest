package com.tsc.api.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountCartResponse {
    public String CartGuid;
    public String PaymentMethod;
    public String ShipCode;
    public boolean IsStrikeModeOn;
    public boolean IsDonationFlowEnabled;
    public String PromoCode;
    public boolean IsMaxCartCheckoutLimitReached;
    public boolean IsMaxCartLineCountReached;
    public boolean IsMaxQuantityPerCartLineReached;
    public boolean IsCartMerged;
    public boolean IsPhysicalDeliveryAddressRequired;
    public boolean IsPaymentCreditCardExpired;
    public boolean IsOrderRecapSuccess;
    public OrderSummaryClass OrderSummary;
    public AddressClass ShippingAddress;
    public CreditCardsClass CreditCard;
    public List<Long> RelatedCartIds;
    public List<GiftCardsClass> GiftCards;
    public CartMessagesClass CartMessages;
    public List<AvailableShipMethodsClass> AvailableShipMethods;
    public List<Integer> AvailableInstallments;
    public List<AvailableInstallmentsBreakdownClass> AvailableInstallmentsBreakdown;
    public PromotionalEasyPayInstallmentClass PromotionalEasyPayInstallment;
    public List<CartLinesClass> CartLines;
    public BuyerClass Buyer;
    public List<ProductsClass> Products;

    public String getCartGuid() {
        return CartGuid;
    }

    public void setCartGuid(String cartGuid) {
        CartGuid = cartGuid;
    }

    public String getPaymentMethod() {
        return PaymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        PaymentMethod = paymentMethod;
    }

    public String getShipCode() {
        return ShipCode;
    }

    public void setShipCode(String shipCode) {
        ShipCode = shipCode;
    }

    public boolean isStrikeModeOn() {
        return IsStrikeModeOn;
    }

    public void setStrikeModeOn(boolean strikeModeOn) {
        IsStrikeModeOn = strikeModeOn;
    }

    public boolean isDonationFlowEnabled() {
        return IsDonationFlowEnabled;
    }

    public void setDonationFlowEnabled(boolean donationFlowEnabled) {
        IsDonationFlowEnabled = donationFlowEnabled;
    }

    public String getPromoCode() {
        return PromoCode;
    }

    public void setPromoCode(String promoCode) {
        PromoCode = promoCode;
    }

    public boolean isMaxCartCheckoutLimitReached() {
        return IsMaxCartCheckoutLimitReached;
    }

    public void setMaxCartCheckoutLimitReached(boolean maxCartCheckoutLimitReached) {
        IsMaxCartCheckoutLimitReached = maxCartCheckoutLimitReached;
    }

    public boolean isMaxCartLineCountReached() {
        return IsMaxCartLineCountReached;
    }

    public void setMaxCartLineCountReached(boolean maxCartLineCountReached) {
        IsMaxCartLineCountReached = maxCartLineCountReached;
    }

    public boolean isMaxQuantityPerCartLineReached() {
        return IsMaxQuantityPerCartLineReached;
    }

    public void setMaxQuantityPerCartLineReached(boolean maxQuantityPerCartLineReached) {
        IsMaxQuantityPerCartLineReached = maxQuantityPerCartLineReached;
    }

    public boolean isCartMerged() {
        return IsCartMerged;
    }

    public void setCartMerged(boolean cartMerged) {
        IsCartMerged = cartMerged;
    }

    public boolean isPhysicalDeliveryAddressRequired() {
        return IsPhysicalDeliveryAddressRequired;
    }

    public void setPhysicalDeliveryAddressRequired(boolean physicalDeliveryAddressRequired) {
        IsPhysicalDeliveryAddressRequired = physicalDeliveryAddressRequired;
    }

    public boolean isPaymentCreditCardExpired() {
        return IsPaymentCreditCardExpired;
    }

    public void setPaymentCreditCardExpired(boolean paymentCreditCardExpired) {
        IsPaymentCreditCardExpired = paymentCreditCardExpired;
    }

    public boolean isOrderRecapSuccess() {
        return IsOrderRecapSuccess;
    }

    public void setOrderRecapSuccess(boolean orderRecapSuccess) {
        IsOrderRecapSuccess = orderRecapSuccess;
    }

    public OrderSummaryClass getOrderSummary() {
        return OrderSummary;
    }

    public void setOrderSummary(OrderSummaryClass orderSummary) {
        OrderSummary = orderSummary;
    }

    public AddressClass getShippingAddress() {
        return ShippingAddress;
    }

    public void setShippingAddress(AddressClass shippingAddress) {
        ShippingAddress = shippingAddress;
    }

    public CreditCardsClass getCreditCard() {
        return CreditCard;
    }

    public void setCreditCard(CreditCardsClass creditCard) {
        CreditCard = creditCard;
    }

    public List<Long> getRelatedCartIds() {
        return RelatedCartIds;
    }

    public void setRelatedCartIds(List<Long> relatedCartIds) {
        RelatedCartIds = relatedCartIds;
    }

    public List<GiftCardsClass> getGiftCards() {
        return GiftCards;
    }

    public void setGiftCards(List<GiftCardsClass> giftCards) {
        GiftCards = giftCards;
    }

    public CartMessagesClass getCartMessages() {
        return CartMessages;
    }

    public void setCartMessages(CartMessagesClass cartMessages) {
        CartMessages = cartMessages;
    }

    public List<AvailableShipMethodsClass> getAvailableShipMethods() {
        return AvailableShipMethods;
    }

    public void setAvailableShipMethods(List<AvailableShipMethodsClass> availableShipMethods) {
        AvailableShipMethods = availableShipMethods;
    }

    public List<Integer> getAvailableInstallments() {
        return AvailableInstallments;
    }

    public void setAvailableInstallments(List<Integer> availableInstallments) {
        AvailableInstallments = availableInstallments;
    }

    public List<AvailableInstallmentsBreakdownClass> getAvailableInstallmentsBreakdown() {
        return AvailableInstallmentsBreakdown;
    }

    public void setAvailableInstallmentsBreakdown(List<AvailableInstallmentsBreakdownClass> availableInstallmentsBreakdown) {
        AvailableInstallmentsBreakdown = availableInstallmentsBreakdown;
    }

    public PromotionalEasyPayInstallmentClass getPromotionalEasyPayInstallment() {
        return PromotionalEasyPayInstallment;
    }

    public void setPromotionalEasyPayInstallment(PromotionalEasyPayInstallmentClass promotionalEasyPayInstallment) {
        PromotionalEasyPayInstallment = promotionalEasyPayInstallment;
    }

    public List<CartLinesClass> getCartLines() {
        return CartLines;
    }

    public void setCartLines(List<CartLinesClass> cartLines) {
        CartLines = cartLines;
    }

    public BuyerClass getBuyer() {
        return Buyer;
    }

    public void setBuyer(BuyerClass buyer) {
        Buyer = buyer;
    }

    public List<ProductsClass> getProducts() {
        return Products;
    }

    public void setProducts(List<ProductsClass> products) {
        Products = products;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class OrderSummaryClass{
        public String OrderNo;
        public int TotalQuantity;
        public String MerchandiseSubTotal;
        public double MerchandiseSubTotalAmount;
        public String Discount;
        public double DiscountAmount;
        public String DefaultShippingHandling;
        public double DefaultShippingHandlingAmount;
        public String ShippingHandling;
        public double ShippingHandlingAmount;
        public String TaxTotal;
        public double TaxTotalAmount;
        public String GiftCard;
        public String GiftCardAmount;
        public double AppliedCreditAmount;
        public String GrandTotal;
        public double GrandTotalAmount;
        public double TotalOrderAmount;
        public double AmountDue;
        public String MultipackSavings;
        public double MultipackSavingsAmount;
        public String TotalSavings;
        public double TotalSavingsAmount;
        public EasyPayClass EasyPay;
        public String ShipmentProvince;
        public String PreviousOrderTotal;
        public String OrderTotalDifference;
        public String AppliedPromocode;
        public String PromocodeMessage;
        public List<String> NewOrderNumbers;

        public String getOrderNo() {
            return OrderNo;
        }

        public void setOrderNo(String orderNo) {
            OrderNo = orderNo;
        }

        public int getTotalQuantity() {
            return TotalQuantity;
        }

        public void setTotalQuantity(int totalQuantity) {
            TotalQuantity = totalQuantity;
        }

        public String getMerchandiseSubTotal() {
            return MerchandiseSubTotal;
        }

        public void setMerchandiseSubTotal(String merchandiseSubTotal) {
            MerchandiseSubTotal = merchandiseSubTotal;
        }

        public double getMerchandiseSubTotalAmount() {
            return MerchandiseSubTotalAmount;
        }

        public void setMerchandiseSubTotalAmount(int merchandiseSubTotalAmount) {
            MerchandiseSubTotalAmount = merchandiseSubTotalAmount;
        }

        public String getDiscount() {
            return Discount;
        }

        public void setDiscount(String discount) {
            Discount = discount;
        }

        public double getDiscountAmount() {
            return DiscountAmount;
        }

        public void setDiscountAmount(int discountAmount) {
            DiscountAmount = discountAmount;
        }

        public String getDefaultShippingHandling() {
            return DefaultShippingHandling;
        }

        public void setDefaultShippingHandling(String defaultShippingHandling) {
            DefaultShippingHandling = defaultShippingHandling;
        }

        public double getDefaultShippingHandlingAmount() {
            return DefaultShippingHandlingAmount;
        }

        public void setDefaultShippingHandlingAmount(int defaultShippingHandlingAmount) {
            DefaultShippingHandlingAmount = defaultShippingHandlingAmount;
        }

        public String getShippingHandling() {
            return ShippingHandling;
        }

        public void setShippingHandling(String shippingHandling) {
            ShippingHandling = shippingHandling;
        }

        public double getShippingHandlingAmount() {
            return ShippingHandlingAmount;
        }

        public void setShippingHandlingAmount(int shippingHandlingAmount) {
            ShippingHandlingAmount = shippingHandlingAmount;
        }

        public String getTaxTotal() {
            return TaxTotal;
        }

        public void setTaxTotal(String taxTotal) {
            TaxTotal = taxTotal;
        }

        public double getTaxTotalAmount() {
            return TaxTotalAmount;
        }

        public void setTaxTotalAmount(int taxTotalAmount) {
            TaxTotalAmount = taxTotalAmount;
        }

        public String getGiftCard() {
            return GiftCard;
        }

        public void setGiftCard(String giftCard) {
            GiftCard = giftCard;
        }

        public String getGiftCardAmount() {
            return GiftCardAmount;
        }

        public void setGiftCardAmount(String giftCardAmount) {
            GiftCardAmount = giftCardAmount;
        }

        public double getAppliedCreditAmount() {
            return AppliedCreditAmount;
        }

        public void setAppliedCreditAmount(int appliedCreditAmount) {
            AppliedCreditAmount = appliedCreditAmount;
        }

        public String getGrandTotal() {
            return GrandTotal;
        }

        public void setGrandTotal(String grandTotal) {
            GrandTotal = grandTotal;
        }

        public double getGrandTotalAmount() {
            return GrandTotalAmount;
        }

        public void setGrandTotalAmount(int grandTotalAmount) {
            GrandTotalAmount = grandTotalAmount;
        }

        public double getTotalOrderAmount() {
            return TotalOrderAmount;
        }

        public void setTotalOrderAmount(int totalOrderAmount) {
            TotalOrderAmount = totalOrderAmount;
        }

        public double getAmountDue() {
            return AmountDue;
        }

        public void setAmountDue(int amountDue) {
            AmountDue = amountDue;
        }

        public String getMultipackSavings() {
            return MultipackSavings;
        }

        public void setMultipackSavings(String multipackSavings) {
            MultipackSavings = multipackSavings;
        }

        public double getMultipackSavingsAmount() {
            return MultipackSavingsAmount;
        }

        public void setMultipackSavingsAmount(int multipackSavingsAmount) {
            MultipackSavingsAmount = multipackSavingsAmount;
        }

        public String getTotalSavings() {
            return TotalSavings;
        }

        public void setTotalSavings(String totalSavings) {
            TotalSavings = totalSavings;
        }

        public double getTotalSavingsAmount() {
            return TotalSavingsAmount;
        }

        public void setTotalSavingsAmount(int totalSavingsAmount) {
            TotalSavingsAmount = totalSavingsAmount;
        }

        public EasyPayClass getEasyPay() {
            return EasyPay;
        }

        public void setEasyPay(EasyPayClass easyPay) {
            EasyPay = easyPay;
        }

        public String getShipmentProvince() {
            return ShipmentProvince;
        }

        public void setShipmentProvince(String shipmentProvince) {
            ShipmentProvince = shipmentProvince;
        }

        public String getPreviousOrderTotal() {
            return PreviousOrderTotal;
        }

        public void setPreviousOrderTotal(String previousOrderTotal) {
            PreviousOrderTotal = previousOrderTotal;
        }

        public String getOrderTotalDifference() {
            return OrderTotalDifference;
        }

        public void setOrderTotalDifference(String orderTotalDifference) {
            OrderTotalDifference = orderTotalDifference;
        }

        public String getAppliedPromocode() {
            return AppliedPromocode;
        }

        public void setAppliedPromocode(String appliedPromocode) {
            AppliedPromocode = appliedPromocode;
        }

        public String getPromocodeMessage() {
            return PromocodeMessage;
        }

        public void setPromocodeMessage(String promocodeMessage) {
            PromocodeMessage = promocodeMessage;
        }

        public List<String> getNewOrderNumbers() {
            return NewOrderNumbers;
        }

        public void setNewOrderNumbers(List<String> newOrderNumbers) {
            NewOrderNumbers = newOrderNumbers;
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class EasyPayClass{
            public int NoOfInstallments;
            public String TotalPaymentToday;
            public String BalanceRemainingAfterToday;
            public int NoOfFutureMonthlyPayments;
            public String FutureMonthlyPayment;

            public int getNoOfInstallments() {
                return NoOfInstallments;
            }

            public void setNoOfInstallments(int noOfInstallments) {
                NoOfInstallments = noOfInstallments;
            }

            public String getTotalPaymentToday() {
                return TotalPaymentToday;
            }

            public void setTotalPaymentToday(String totalPaymentToday) {
                TotalPaymentToday = totalPaymentToday;
            }

            public String getBalanceRemainingAfterToday() {
                return BalanceRemainingAfterToday;
            }

            public void setBalanceRemainingAfterToday(String balanceRemainingAfterToday) {
                BalanceRemainingAfterToday = balanceRemainingAfterToday;
            }

            public int getNoOfFutureMonthlyPayments() {
                return NoOfFutureMonthlyPayments;
            }

            public void setNoOfFutureMonthlyPayments(int noOfFutureMonthlyPayments) {
                NoOfFutureMonthlyPayments = noOfFutureMonthlyPayments;
            }

            public String getFutureMonthlyPayment() {
                return FutureMonthlyPayment;
            }

            public void setFutureMonthlyPayment(String futureMonthlyPayment) {
                FutureMonthlyPayment = futureMonthlyPayment;
            }
        }
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

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class GiftCardsClass{
        public int Id;
        public int Balance;
        public String MaskedNumber;

        public int getId() {
            return Id;
        }

        public void setId(int id) {
            Id = id;
        }

        public int getBalance() {
            return Balance;
        }

        public void setBalance(int balance) {
            Balance = balance;
        }

        public String getMaskedNumber() {
            return MaskedNumber;
        }

        public void setMaskedNumber(String maskedNumber) {
            MaskedNumber = maskedNumber;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CartMessagesClass{
        public String OfferDiscountMessage;
        public String OfferShippingMessage;
        public String OfferQualifyOrNot;
        public String OfferApplied;
        public String EstimatedDateLabel;
        public String EstimatedDate;
        public String MaxCheckoutLimitReached;
        public String MaxCartLineCountReached;
        public String MaxQuantityPerCartLineReached;
        public String PhysicalAddressRequired;
        public String GiftCardNotEligible;
        public String OutOfStockMessage;
        public String FreeShippingMessage;

        public String getOfferDiscountMessage() {
            return OfferDiscountMessage;
        }

        public void setOfferDiscountMessage(String offerDiscountMessage) {
            OfferDiscountMessage = offerDiscountMessage;
        }

        public String getOfferShippingMessage() {
            return OfferShippingMessage;
        }

        public void setOfferShippingMessage(String offerShippingMessage) {
            OfferShippingMessage = offerShippingMessage;
        }

        public String getOfferQualifyOrNot() {
            return OfferQualifyOrNot;
        }

        public void setOfferQualifyOrNot(String offerQualifyOrNot) {
            OfferQualifyOrNot = offerQualifyOrNot;
        }

        public String getOfferApplied() {
            return OfferApplied;
        }

        public void setOfferApplied(String offerApplied) {
            OfferApplied = offerApplied;
        }

        public String getEstimatedDateLabel() {
            return EstimatedDateLabel;
        }

        public void setEstimatedDateLabel(String estimatedDateLabel) {
            EstimatedDateLabel = estimatedDateLabel;
        }

        public String getEstimatedDate() {
            return EstimatedDate;
        }

        public void setEstimatedDate(String estimatedDate) {
            EstimatedDate = estimatedDate;
        }

        public String getMaxCheckoutLimitReached() {
            return MaxCheckoutLimitReached;
        }

        public void setMaxCheckoutLimitReached(String maxCheckoutLimitReached) {
            MaxCheckoutLimitReached = maxCheckoutLimitReached;
        }

        public String getMaxCartLineCountReached() {
            return MaxCartLineCountReached;
        }

        public void setMaxCartLineCountReached(String maxCartLineCountReached) {
            MaxCartLineCountReached = maxCartLineCountReached;
        }

        public String getMaxQuantityPerCartLineReached() {
            return MaxQuantityPerCartLineReached;
        }

        public void setMaxQuantityPerCartLineReached(String maxQuantityPerCartLineReached) {
            MaxQuantityPerCartLineReached = maxQuantityPerCartLineReached;
        }

        public String getPhysicalAddressRequired() {
            return PhysicalAddressRequired;
        }

        public void setPhysicalAddressRequired(String physicalAddressRequired) {
            PhysicalAddressRequired = physicalAddressRequired;
        }

        public String getGiftCardNotEligible() {
            return GiftCardNotEligible;
        }

        public void setGiftCardNotEligible(String giftCardNotEligible) {
            GiftCardNotEligible = giftCardNotEligible;
        }

        public String getOutOfStockMessage() {
            return OutOfStockMessage;
        }

        public void setOutOfStockMessage(String outOfStockMessage) {
            OutOfStockMessage = outOfStockMessage;
        }

        public String getFreeShippingMessage() {
            return FreeShippingMessage;
        }

        public void setFreeShippingMessage(String freeShippingMessage) {
            FreeShippingMessage = freeShippingMessage;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class AvailableShipMethodsClass{
        public String Method;
        public String Label;
        public String Description;
        public String ShippingCost;
        public String CourierType;
        public String EstimatedDeliveryDate;

        public String getMethod() {
            return Method;
        }

        public void setMethod(String method) {
            Method = method;
        }

        public String getLabel() {
            return Label;
        }

        public void setLabel(String label) {
            Label = label;
        }

        public String getDescription() {
            return Description;
        }

        public void setDescription(String description) {
            Description = description;
        }

        public String getShippingCost() {
            return ShippingCost;
        }

        public void setShippingCost(String shippingCost) {
            ShippingCost = shippingCost;
        }

        public String getCourierType() {
            return CourierType;
        }

        public void setCourierType(String courierType) {
            CourierType = courierType;
        }

        public String getEstimatedDeliveryDate() {
            return EstimatedDeliveryDate;
        }

        public void setEstimatedDeliveryDate(String estimatedDeliveryDate) {
            EstimatedDeliveryDate = estimatedDeliveryDate;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class AvailableInstallmentsBreakdownClass{
        public int NoOfInstallments;
        public String MonthlyPayment;

        public int getNoOfInstallments() {
            return NoOfInstallments;
        }

        public void setNoOfInstallments(int noOfInstallments) {
            NoOfInstallments = noOfInstallments;
        }

        public String getMonthlyPayment() {
            return MonthlyPayment;
        }

        public void setMonthlyPayment(String monthlyPayment) {
            MonthlyPayment = monthlyPayment;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PromotionalEasyPayInstallmentClass{
        public int NoOfInstallments;
        public String MonthlyPayment;

        public int getNoOfInstallments() {
            return NoOfInstallments;
        }

        public void setNoOfInstallments(int noOfInstallments) {
            NoOfInstallments = noOfInstallments;
        }

        public String getMonthlyPayment() {
            return MonthlyPayment;
        }

        public void setMonthlyPayment(String monthlyPayment) {
            MonthlyPayment = monthlyPayment;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CartLinesClass{
        public int Id;
        public InCartClass InCart;
        public CartLineItemClass CartLineItem;

        public int getId() {
            return Id;
        }

        public void setId(int id) {
            Id = id;
        }

        public InCartClass getInCart() {
            return InCart;
        }

        public void setInCart(InCartClass inCart) {
            InCart = inCart;
        }

        public CartLineItemClass getCartLineItem() {
            return CartLineItem;
        }

        public void setCartLineItem(CartLineItemClass cartLineItem) {
            CartLineItem = cartLineItem;
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class InCartClass{
            public String ItemNo;
            public String ShippingHandling;
            public String UnitPrice;
            public double PriceUnit;
            public int Quantity;
            public String TotalPrice;
            public String ShippingMessage;
//            public CustomFieldsClass CustomFields;
            public String QuantityToBeReducedMessage;
            public boolean IsEditable;
            public String EstimatedDateLabel;
            public String EstimatedDeliveryDate;
            public String EstimatedShipDate;

            public String getItemNo() {
                return ItemNo;
            }

            public void setItemNo(String itemNo) {
                ItemNo = itemNo;
            }

            public String getShippingHandling() {
                return ShippingHandling;
            }

            public void setShippingHandling(String shippingHandling) {
                ShippingHandling = shippingHandling;
            }

            public String getUnitPrice() {
                return UnitPrice;
            }

            public void setUnitPrice(String unitPrice) {
                UnitPrice = unitPrice;
            }

            public double getPriceUnit() {
                return PriceUnit;
            }

            public void setPriceUnit(int priceUnit) {
                PriceUnit = priceUnit;
            }

            public int getQuantity() {
                return Quantity;
            }

            public void setQuantity(int quantity) {
                Quantity = quantity;
            }

            public String getTotalPrice() {
                return TotalPrice;
            }

            public void setTotalPrice(String totalPrice) {
                TotalPrice = totalPrice;
            }

            public String getShippingMessage() {
                return ShippingMessage;
            }

            public void setShippingMessage(String shippingMessage) {
                ShippingMessage = shippingMessage;
            }

            /**
            public CustomFieldsClass getCustomFields() {
                return CustomFields;
            }

            public void setCustomFields(CustomFieldsClass customFields) {
                CustomFields = customFields;
            }
            */

            public String getQuantityToBeReducedMessage() {
                return QuantityToBeReducedMessage;
            }

            public void setQuantityToBeReducedMessage(String quantityToBeReducedMessage) {
                QuantityToBeReducedMessage = quantityToBeReducedMessage;
            }

            public boolean isEditable() {
                return IsEditable;
            }

            public void setEditable(boolean editable) {
                IsEditable = editable;
            }

            public String getEstimatedDateLabel() {
                return EstimatedDateLabel;
            }

            public void setEstimatedDateLabel(String estimatedDateLabel) {
                EstimatedDateLabel = estimatedDateLabel;
            }

            public String getEstimatedDeliveryDate() {
                return EstimatedDeliveryDate;
            }

            public void setEstimatedDeliveryDate(String estimatedDeliveryDate) {
                EstimatedDeliveryDate = estimatedDeliveryDate;
            }

            public String getEstimatedShipDate() {
                return EstimatedShipDate;
            }

            public void setEstimatedShipDate(String estimatedShipDate) {
                EstimatedShipDate = estimatedShipDate;
            }
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class CartLineItemClass{
            public String ItemNo;
            public int EdpNo;
            public String UpcNo;
            public int Inventory;
            public String Style;
            public String StyleDimensionId;
            public String Size;
            public String SizeDimensionId;
            public int SkuAvailabilityType;
            public String SkuAvailabilityMessage;
            public String AppliedShipping;
            public String DefaultShipping;
            public String DefaultPrice;
            public String AppliedPrice;
            public String WasPrice;
            public String SavePrice;
            public String EasyPaymentPrice;
            public boolean IsSoldOut;
            public boolean IsDonation;
            public boolean IsAdp;
            public boolean IsAdvanceOrBackOrder;
            public String ImageUrl;
            public int Weight;
            public int StandingOrderIntervalInDays;

            public String getItemNo() {
                return ItemNo;
            }

            public void setItemNo(String itemNo) {
                ItemNo = itemNo;
            }

            public int getEdpNo() {
                return EdpNo;
            }

            public void setEdpNo(int edpNo) {
                EdpNo = edpNo;
            }

            public String getUpcNo() {
                return UpcNo;
            }

            public void setUpcNo(String upcNo) {
                UpcNo = upcNo;
            }

            public int getInventory() {
                return Inventory;
            }

            public void setInventory(int inventory) {
                Inventory = inventory;
            }

            public String getStyle() {
                return Style;
            }

            public void setStyle(String style) {
                Style = style;
            }

            public String getStyleDimensionId() {
                return StyleDimensionId;
            }

            public void setStyleDimensionId(String styleDimensionId) {
                StyleDimensionId = styleDimensionId;
            }

            public String getSize() {
                return Size;
            }

            public void setSize(String size) {
                Size = size;
            }

            public String getSizeDimensionId() {
                return SizeDimensionId;
            }

            public void setSizeDimensionId(String sizeDimensionId) {
                SizeDimensionId = sizeDimensionId;
            }

            public int getSkuAvailabilityType() {
                return SkuAvailabilityType;
            }

            public void setSkuAvailabilityType(int skuAvailabilityType) {
                SkuAvailabilityType = skuAvailabilityType;
            }

            public String getSkuAvailabilityMessage() {
                return SkuAvailabilityMessage;
            }

            public void setSkuAvailabilityMessage(String skuAvailabilityMessage) {
                SkuAvailabilityMessage = skuAvailabilityMessage;
            }

            public String getAppliedShipping() {
                return AppliedShipping;
            }

            public void setAppliedShipping(String appliedShipping) {
                AppliedShipping = appliedShipping;
            }

            public String getDefaultShipping() {
                return DefaultShipping;
            }

            public void setDefaultShipping(String defaultShipping) {
                DefaultShipping = defaultShipping;
            }

            public String getDefaultPrice() {
                return DefaultPrice;
            }

            public void setDefaultPrice(String defaultPrice) {
                DefaultPrice = defaultPrice;
            }

            public String getAppliedPrice() {
                return AppliedPrice;
            }

            public void setAppliedPrice(String appliedPrice) {
                AppliedPrice = appliedPrice;
            }

            public String getWasPrice() {
                return WasPrice;
            }

            public void setWasPrice(String wasPrice) {
                WasPrice = wasPrice;
            }

            public String getSavePrice() {
                return SavePrice;
            }

            public void setSavePrice(String savePrice) {
                SavePrice = savePrice;
            }

            public String getEasyPaymentPrice() {
                return EasyPaymentPrice;
            }

            public void setEasyPaymentPrice(String easyPaymentPrice) {
                EasyPaymentPrice = easyPaymentPrice;
            }

            public boolean isSoldOut() {
                return IsSoldOut;
            }

            public void setSoldOut(boolean soldOut) {
                IsSoldOut = soldOut;
            }

            public boolean isDonation() {
                return IsDonation;
            }

            public void setDonation(boolean donation) {
                IsDonation = donation;
            }

            public boolean isAdp() {
                return IsAdp;
            }

            public void setAdp(boolean adp) {
                IsAdp = adp;
            }

            public boolean isAdvanceOrBackOrder() {
                return IsAdvanceOrBackOrder;
            }

            public void setAdvanceOrBackOrder(boolean advanceOrBackOrder) {
                IsAdvanceOrBackOrder = advanceOrBackOrder;
            }

            public String getImageUrl() {
                return ImageUrl;
            }

            public void setImageUrl(String imageUrl) {
                ImageUrl = imageUrl;
            }

            public int getWeight() {
                return Weight;
            }

            public void setWeight(int weight) {
                Weight = weight;
            }

            public int getStandingOrderIntervalInDays() {
                return StandingOrderIntervalInDays;
            }

            public void setStandingOrderIntervalInDays(int standingOrderIntervalInDays) {
                StandingOrderIntervalInDays = standingOrderIntervalInDays;
            }
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class BuyerClass{
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
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ProductsClass{
        public String ItemNo;
        public String Name;
        public String Overview;
        public int Installments;
        public int DefaultDimensionId;
        public int DefaultEdp;
        public List<VideosClass> Videos;
        public List<String> RelatedItemNos;
        public List<String> AutoDeliveryItemNos;
        public boolean IsShowstopper;
        public boolean IsDonation;
        public boolean IsWebOnly;
        public boolean IsSoldOut;
        public boolean IsSearchable;
        public String ParentItemNo;
        public boolean EnabledAddToCart;
        public String NoReturnsMessage;
        public String PriceIsLabel;
        public String SavePriceLabel;
        public String IsPriceRange;
        public String WasPriceRange;
        public boolean ShowPriceIs;
        public boolean ShowPriceWas;
        public LinkClass ProductLink;
        public LinkClass ProductTypeLink;
        public List<String> ProductTypes;
        public LinkClass BrandLink;
        public int ProductReviewCount;
        public int ProductReviewRating;
        public List<StylesOrSizeClass> Styles;
        public List<StylesOrSizeClass> Sizes;
        public List<DeliveryOptionsClass> DeliveryOptions;
        public List<String> AvailableSwatches;
        public List<String> AlternateImageUrls;
        public List<EdpsClass> Edps;
        public String ProductType;
        public List<ProductTypePathClass> ProductTypePath;
        public String Brand;
        public String BrandDimensionId;
        public boolean ShowBadgeImage;
        public String BadgeImagePath;
        public boolean IsLive;
        public OnAirInfoClass OnAirInfo;
        public ProductMessagesClass ProductMessages;
        public List<CustomFieldsClass> CustomFields;
        public boolean IsRestricted;
        public List<String> RestrictedProvinces;
        public String ValidationMessage;
        public String VendorNo;
        public String VendorName;
        public String ShipMethod;
        public List<EsmScriptsClass> EsmScripts;

        public String getItemNo() {
            return ItemNo;
        }

        public void setItemNo(String itemNo) {
            ItemNo = itemNo;
        }

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            Name = name;
        }

        public String getOverview() {
            return Overview;
        }

        public void setOverview(String overview) {
            Overview = overview;
        }

        public int getInstallments() {
            return Installments;
        }

        public void setInstallments(int installments) {
            Installments = installments;
        }

        public int getDefaultDimensionId() {
            return DefaultDimensionId;
        }

        public void setDefaultDimensionId(int defaultDimensionId) {
            DefaultDimensionId = defaultDimensionId;
        }

        public int getDefaultEdp() {
            return DefaultEdp;
        }

        public void setDefaultEdp(int defaultEdp) {
            DefaultEdp = defaultEdp;
        }

        public List<VideosClass> getVideos() {
            return Videos;
        }

        public void setVideos(List<VideosClass> videos) {
            Videos = videos;
        }

        public List<String> getRelatedItemNos() {
            return RelatedItemNos;
        }

        public void setRelatedItemNos(List<String> relatedItemNos) {
            RelatedItemNos = relatedItemNos;
        }

        public List<String> getAutoDeliveryItemNos() {
            return AutoDeliveryItemNos;
        }

        public void setAutoDeliveryItemNos(List<String> autoDeliveryItemNos) {
            AutoDeliveryItemNos = autoDeliveryItemNos;
        }

        public boolean isShowstopper() {
            return IsShowstopper;
        }

        public void setShowstopper(boolean showstopper) {
            IsShowstopper = showstopper;
        }

        public boolean isDonation() {
            return IsDonation;
        }

        public void setDonation(boolean donation) {
            IsDonation = donation;
        }

        public boolean isWebOnly() {
            return IsWebOnly;
        }

        public void setWebOnly(boolean webOnly) {
            IsWebOnly = webOnly;
        }

        public boolean isSoldOut() {
            return IsSoldOut;
        }

        public void setSoldOut(boolean soldOut) {
            IsSoldOut = soldOut;
        }

        public boolean isSearchable() {
            return IsSearchable;
        }

        public void setSearchable(boolean searchable) {
            IsSearchable = searchable;
        }

        public String getParentItemNo() {
            return ParentItemNo;
        }

        public void setParentItemNo(String parentItemNo) {
            ParentItemNo = parentItemNo;
        }

        public boolean isEnabledAddToCart() {
            return EnabledAddToCart;
        }

        public void setEnabledAddToCart(boolean enabledAddToCart) {
            EnabledAddToCart = enabledAddToCart;
        }

        public String getNoReturnsMessage() {
            return NoReturnsMessage;
        }

        public void setNoReturnsMessage(String noReturnsMessage) {
            NoReturnsMessage = noReturnsMessage;
        }

        public String getPriceIsLabel() {
            return PriceIsLabel;
        }

        public void setPriceIsLabel(String priceIsLabel) {
            PriceIsLabel = priceIsLabel;
        }

        public String getSavePriceLabel() {
            return SavePriceLabel;
        }

        public void setSavePriceLabel(String savePriceLabel) {
            SavePriceLabel = savePriceLabel;
        }

        public String getIsPriceRange() {
            return IsPriceRange;
        }

        public void setIsPriceRange(String isPriceRange) {
            IsPriceRange = isPriceRange;
        }

        public String getWasPriceRange() {
            return WasPriceRange;
        }

        public void setWasPriceRange(String wasPriceRange) {
            WasPriceRange = wasPriceRange;
        }

        public boolean isShowPriceIs() {
            return ShowPriceIs;
        }

        public void setShowPriceIs(boolean showPriceIs) {
            ShowPriceIs = showPriceIs;
        }

        public boolean isShowPriceWas() {
            return ShowPriceWas;
        }

        public void setShowPriceWas(boolean showPriceWas) {
            ShowPriceWas = showPriceWas;
        }

        public LinkClass getProductLink() {
            return ProductLink;
        }

        public void setProductLink(LinkClass productLink) {
            ProductLink = productLink;
        }

        public LinkClass getProductTypeLink() {
            return ProductTypeLink;
        }

        public void setProductTypeLink(LinkClass productTypeLink) {
            ProductTypeLink = productTypeLink;
        }

        public List<String> getProductTypes() {
            return ProductTypes;
        }

        public void setProductTypes(List<String> productTypes) {
            ProductTypes = productTypes;
        }

        public LinkClass getBrandLink() {
            return BrandLink;
        }

        public void setBrandLink(LinkClass brandLink) {
            BrandLink = brandLink;
        }

        public int getProductReviewCount() {
            return ProductReviewCount;
        }

        public void setProductReviewCount(int productReviewCount) {
            ProductReviewCount = productReviewCount;
        }

        public int getProductReviewRating() {
            return ProductReviewRating;
        }

        public void setProductReviewRating(int productReviewRating) {
            ProductReviewRating = productReviewRating;
        }

        public List<StylesOrSizeClass> getStyles() {
            return Styles;
        }

        public void setStyles(List<StylesOrSizeClass> styles) {
            Styles = styles;
        }

        public List<StylesOrSizeClass> getSizes() {
            return Sizes;
        }

        public void setSizes(List<StylesOrSizeClass> sizes) {
            Sizes = sizes;
        }

        public List<DeliveryOptionsClass> getDeliveryOptions() {
            return DeliveryOptions;
        }

        public void setDeliveryOptions(List<DeliveryOptionsClass> deliveryOptions) {
            DeliveryOptions = deliveryOptions;
        }

        public List<String> getAvailableSwatches() {
            return AvailableSwatches;
        }

        public void setAvailableSwatches(List<String> availableSwatches) {
            AvailableSwatches = availableSwatches;
        }

        public List<String> getAlternateImageUrls() {
            return AlternateImageUrls;
        }

        public void setAlternateImageUrls(List<String> alternateImageUrls) {
            AlternateImageUrls = alternateImageUrls;
        }

        public List<EdpsClass> getEdps() {
            return Edps;
        }

        public void setEdps(List<EdpsClass> edps) {
            Edps = edps;
        }

        public String getProductType() {
            return ProductType;
        }

        public void setProductType(String productType) {
            ProductType = productType;
        }

        public List<ProductTypePathClass> getProductTypePath() {
            return ProductTypePath;
        }

        public void setProductTypePath(List<ProductTypePathClass> productTypePath) {
            ProductTypePath = productTypePath;
        }

        public String getBrand() {
            return Brand;
        }

        public void setBrand(String brand) {
            Brand = brand;
        }

        public String getBrandDimensionId() {
            return BrandDimensionId;
        }

        public void setBrandDimensionId(String brandDimensionId) {
            BrandDimensionId = brandDimensionId;
        }

        public boolean isShowBadgeImage() {
            return ShowBadgeImage;
        }

        public void setShowBadgeImage(boolean showBadgeImage) {
            ShowBadgeImage = showBadgeImage;
        }

        public String getBadgeImagePath() {
            return BadgeImagePath;
        }

        public void setBadgeImagePath(String badgeImagePath) {
            BadgeImagePath = badgeImagePath;
        }

        public boolean isLive() {
            return IsLive;
        }

        public void setLive(boolean live) {
            IsLive = live;
        }

        public OnAirInfoClass getOnAirInfo() {
            return OnAirInfo;
        }

        public void setOnAirInfo(OnAirInfoClass onAirInfo) {
            OnAirInfo = onAirInfo;
        }

        public ProductMessagesClass getProductMessages() {
            return ProductMessages;
        }

        public void setProductMessages(ProductMessagesClass productMessages) {
            ProductMessages = productMessages;
        }

        public List<CustomFieldsClass> getCustomFields() {
            return CustomFields;
        }

        public void setCustomFields(List<CustomFieldsClass> customFields) {
            CustomFields = customFields;
        }

        public boolean isRestricted() {
            return IsRestricted;
        }

        public void setRestricted(boolean restricted) {
            IsRestricted = restricted;
        }

        public List<String> getRestrictedProvinces() {
            return RestrictedProvinces;
        }

        public void setRestrictedProvinces(List<String> restrictedProvinces) {
            RestrictedProvinces = restrictedProvinces;
        }

        public String getValidationMessage() {
            return ValidationMessage;
        }

        public void setValidationMessage(String validationMessage) {
            ValidationMessage = validationMessage;
        }

        public String getVendorNo() {
            return VendorNo;
        }

        public void setVendorNo(String vendorNo) {
            VendorNo = vendorNo;
        }

        public String getVendorName() {
            return VendorName;
        }

        public void setVendorName(String vendorName) {
            VendorName = vendorName;
        }

        public String getShipMethod() {
            return ShipMethod;
        }

        public void setShipMethod(String shipMethod) {
            ShipMethod = shipMethod;
        }

        public List<EsmScriptsClass> getEsmScripts() {
            return EsmScripts;
        }

        public void setEsmScripts(List<EsmScriptsClass> esmScripts) {
            EsmScripts = esmScripts;
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class VideosClass{
            public String Description;
            public String Thumbnail;
            public String Filename;
            public String Format;

            public String getDescription() {
                return Description;
            }

            public void setDescription(String description) {
                Description = description;
            }

            public String getThumbnail() {
                return Thumbnail;
            }

            public void setThumbnail(String thumbnail) {
                Thumbnail = thumbnail;
            }

            public String getFilename() {
                return Filename;
            }

            public void setFilename(String filename) {
                Filename = filename;
            }

            public String getFormat() {
                return Format;
            }

            public void setFormat(String format) {
                Format = format;
            }
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class LinkClass{
            public String ShortLinkText;
            public String LinkText;
            public String LinkWithoutDomain;

            public String getShortLinkText() {
                return ShortLinkText;
            }

            public void setShortLinkText(String shortLinkText) {
                ShortLinkText = shortLinkText;
            }

            public String getLinkText() {
                return LinkText;
            }

            public void setLinkText(String linkText) {
                LinkText = linkText;
            }

            public String getLinkWithoutDomain() {
                return LinkWithoutDomain;
            }

            public void setLinkWithoutDomain(String linkWithoutDomain) {
                LinkWithoutDomain = linkWithoutDomain;
            }
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class StylesOrSizeClass {
            public String TypeId;
            public String DimensionId;
            public String DisplayName;
            public String ParentId;
            public boolean HasChildren;
            public int ProductsCount;
            public ParentDimensions ParentDimensions;

//            public List<DimensionValueDetailSectionsClass> DimensionValueDetailSections;

            public String getTypeId() {
                return TypeId;
            }

            public void setTypeId(String typeId) {
                TypeId = typeId;
            }

            public String getDimensionId() {
                return DimensionId;
            }

            public void setDimensionId(String dimensionId) {
                DimensionId = dimensionId;
            }

            public String getDisplayName() {
                return DisplayName;
            }

            public void setDisplayName(String displayName) {
                DisplayName = displayName;
            }

            public String getParentId() {
                return ParentId;
            }

            public void setParentId(String parentId) {
                ParentId = parentId;
            }

            public boolean isHasChildren() {
                return HasChildren;
            }

            public void setHasChildren(boolean hasChildren) {
                HasChildren = hasChildren;
            }

            public int getProductsCount() {
                return ProductsCount;
            }

            public void setProductsCount(int productsCount) {
                ProductsCount = productsCount;
            }

            public StylesOrSizeClass.ParentDimensions getParentDimensions() {
                return ParentDimensions;
            }

            public void setParentDimensions(StylesOrSizeClass.ParentDimensions parentDimensions) {
                ParentDimensions = parentDimensions;
            }

//            public List<DimensionValueDetailSectionsClass> getDimensionValueDetailSections() {
//                return DimensionValueDetailSections;
//            }
//
//            public void setDimensionValueDetailSections(List<DimensionValueDetailSectionsClass> dimensionValueDetailSections) {
//                DimensionValueDetailSections = dimensionValueDetailSections;
//            }

            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class ParentDimensions {}

            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class DimensionValueDetailSectionsClass{
                public int InfoTabId;
                public int TabTypeId;
                public NameClass Name;
                public NameClass OverrideTabName;
                public int Order;
                public List<ContentsClass> Contents;
                public boolean IsItemLevel;

                public int getInfoTabId() {
                    return InfoTabId;
                }

                public void setInfoTabId(int infoTabId) {
                    InfoTabId = infoTabId;
                }

                public int getTabTypeId() {
                    return TabTypeId;
                }

                public void setTabTypeId(int tabTypeId) {
                    TabTypeId = tabTypeId;
                }

                public NameClass getName() {
                    return Name;
                }

                public void setName(NameClass name) {
                    Name = name;
                }

                public NameClass getOverrideTabName() {
                    return OverrideTabName;
                }

                public void setOverrideTabName(NameClass overrideTabName) {
                    OverrideTabName = overrideTabName;
                }

                public int getOrder() {
                    return Order;
                }

                public void setOrder(int order) {
                    Order = order;
                }

                public List<ContentsClass> getContents() {
                    return Contents;
                }

                public void setContents(List<ContentsClass> contents) {
                    Contents = contents;
                }

                public boolean isItemLevel() {
                    return IsItemLevel;
                }

                public void setItemLevel(boolean itemLevel) {
                    IsItemLevel = itemLevel;
                }

                @JsonIgnoreProperties(ignoreUnknown = true)
                public static class NameClass{
                    public String En;
                    public String Fr;

                    public String getEn() {
                        return En;
                    }

                    public void setEn(String en) {
                        En = en;
                    }

                    public String getFr() {
                        return Fr;
                    }

                    public void setFr(String fr) {
                        Fr = fr;
                    }
                }

                @JsonIgnoreProperties(ignoreUnknown = true)
                public static class ContentsClass{
                    public int ContentOrder;
                    public String Type;
                    public int ContentPositionId;
                    public NameClass Content;
                    public boolean IsItemLevel;

                    public int getContentOrder() {
                        return ContentOrder;
                    }

                    public void setContentOrder(int contentOrder) {
                        ContentOrder = contentOrder;
                    }

                    public String getType() {
                        return Type;
                    }

                    public void setType(String type) {
                        Type = type;
                    }

                    public int getContentPositionId() {
                        return ContentPositionId;
                    }

                    public void setContentPositionId(int contentPositionId) {
                        ContentPositionId = contentPositionId;
                    }

                    public NameClass getContent() {
                        return Content;
                    }

                    public void setContent(NameClass content) {
                        Content = content;
                    }

                    public boolean isItemLevel() {
                        return IsItemLevel;
                    }

                    public void setItemLevel(boolean itemLevel) {
                        IsItemLevel = itemLevel;
                    }
                }
            }
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class DeliveryOptionsClass{
            public String ItemNo;
            public int EdpNo;
            public String DisplayName;

            public String getItemNo() {
                return ItemNo;
            }

            public void setItemNo(String itemNo) {
                ItemNo = itemNo;
            }

            public int getEdpNo() {
                return EdpNo;
            }

            public void setEdpNo(int edpNo) {
                EdpNo = edpNo;
            }

            public String getDisplayName() {
                return DisplayName;
            }

            public void setDisplayName(String displayName) {
                DisplayName = displayName;
            }
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class EdpsClass{
            public String ItemNo;
            public int EdpNo;
            public String UpcNo;
            public int Inventory;
            public String Style;
            public String StyleDimensionId;
            public String Size;
            public String SizeDimensionId;
            public int SkuAvailabilityType;
            public String SkuAvailabilityMessage;
            public String AppliedShipping;
            public String DefaultShipping;
            public String DefaultPrice;
            public String AppliedPrice;
            public String WasPrice;
            public String SavePrice;
            public String EasyPaymentPrice;
            public boolean IsSoldOut;
            public boolean IsDonation;
            public boolean IsAdp;
            public boolean IsAdvanceOrBackOrder;
            public String ImageUrl;
            public int Weight;
            public int StandingOrderIntervalInDays;

            public String getItemNo() {
                return ItemNo;
            }

            public void setItemNo(String itemNo) {
                ItemNo = itemNo;
            }

            public int getEdpNo() {
                return EdpNo;
            }

            public void setEdpNo(int edpNo) {
                EdpNo = edpNo;
            }

            public String getUpcNo() {
                return UpcNo;
            }

            public void setUpcNo(String upcNo) {
                UpcNo = upcNo;
            }

            public int getInventory() {
                return Inventory;
            }

            public void setInventory(int inventory) {
                Inventory = inventory;
            }

            public String getStyle() {
                return Style;
            }

            public void setStyle(String style) {
                Style = style;
            }

            public String getStyleDimensionId() {
                return StyleDimensionId;
            }

            public void setStyleDimensionId(String styleDimensionId) {
                StyleDimensionId = styleDimensionId;
            }

            public String getSize() {
                return Size;
            }

            public void setSize(String size) {
                Size = size;
            }

            public String getSizeDimensionId() {
                return SizeDimensionId;
            }

            public void setSizeDimensionId(String sizeDimensionId) {
                SizeDimensionId = sizeDimensionId;
            }

            public int getSkuAvailabilityType() {
                return SkuAvailabilityType;
            }

            public void setSkuAvailabilityType(int skuAvailabilityType) {
                SkuAvailabilityType = skuAvailabilityType;
            }

            public String getSkuAvailabilityMessage() {
                return SkuAvailabilityMessage;
            }

            public void setSkuAvailabilityMessage(String skuAvailabilityMessage) {
                SkuAvailabilityMessage = skuAvailabilityMessage;
            }

            public String getAppliedShipping() {
                return AppliedShipping;
            }

            public void setAppliedShipping(String appliedShipping) {
                AppliedShipping = appliedShipping;
            }

            public String getDefaultShipping() {
                return DefaultShipping;
            }

            public void setDefaultShipping(String defaultShipping) {
                DefaultShipping = defaultShipping;
            }

            public String getDefaultPrice() {
                return DefaultPrice;
            }

            public void setDefaultPrice(String defaultPrice) {
                DefaultPrice = defaultPrice;
            }

            public String getAppliedPrice() {
                return AppliedPrice;
            }

            public void setAppliedPrice(String appliedPrice) {
                AppliedPrice = appliedPrice;
            }

            public String getWasPrice() {
                return WasPrice;
            }

            public void setWasPrice(String wasPrice) {
                WasPrice = wasPrice;
            }

            public String getSavePrice() {
                return SavePrice;
            }

            public void setSavePrice(String savePrice) {
                SavePrice = savePrice;
            }

            public String getEasyPaymentPrice() {
                return EasyPaymentPrice;
            }

            public void setEasyPaymentPrice(String easyPaymentPrice) {
                EasyPaymentPrice = easyPaymentPrice;
            }

            public boolean isSoldOut() {
                return IsSoldOut;
            }

            public void setSoldOut(boolean soldOut) {
                IsSoldOut = soldOut;
            }

            public boolean isDonation() {
                return IsDonation;
            }

            public void setDonation(boolean donation) {
                IsDonation = donation;
            }

            public boolean isAdp() {
                return IsAdp;
            }

            public void setAdp(boolean adp) {
                IsAdp = adp;
            }

            public boolean isAdvanceOrBackOrder() {
                return IsAdvanceOrBackOrder;
            }

            public void setAdvanceOrBackOrder(boolean advanceOrBackOrder) {
                IsAdvanceOrBackOrder = advanceOrBackOrder;
            }

            public String getImageUrl() {
                return ImageUrl;
            }

            public void setImageUrl(String imageUrl) {
                ImageUrl = imageUrl;
            }

            public int getWeight() {
                return Weight;
            }

            public void setWeight(int weight) {
                Weight = weight;
            }

            public int getStandingOrderIntervalInDays() {
                return StandingOrderIntervalInDays;
            }

            public void setStandingOrderIntervalInDays(int standingOrderIntervalInDays) {
                StandingOrderIntervalInDays = standingOrderIntervalInDays;
            }
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class ProductTypePathClass{
            public String FacetTypeId;
            public String FacetValueId;
            public String FacetValueNameEn;
            public String FacetValueNameFr;
            public String FacetValueDisplayName;
            public String FacetValueParentId;
            public int FacetValueDisplayOrder;

            public String getFacetTypeId() {
                return FacetTypeId;
            }

            public void setFacetTypeId(String facetTypeId) {
                FacetTypeId = facetTypeId;
            }

            public String getFacetValueId() {
                return FacetValueId;
            }

            public void setFacetValueId(String facetValueId) {
                FacetValueId = facetValueId;
            }

            public String getFacetValueNameEn() {
                return FacetValueNameEn;
            }

            public void setFacetValueNameEn(String facetValueNameEn) {
                FacetValueNameEn = facetValueNameEn;
            }

            public String getFacetValueNameFr() {
                return FacetValueNameFr;
            }

            public void setFacetValueNameFr(String facetValueNameFr) {
                FacetValueNameFr = facetValueNameFr;
            }

            public String getFacetValueDisplayName() {
                return FacetValueDisplayName;
            }

            public void setFacetValueDisplayName(String facetValueDisplayName) {
                FacetValueDisplayName = facetValueDisplayName;
            }

            public String getFacetValueParentId() {
                return FacetValueParentId;
            }

            public void setFacetValueParentId(String facetValueParentId) {
                FacetValueParentId = facetValueParentId;
            }

            public int getFacetValueDisplayOrder() {
                return FacetValueDisplayOrder;
            }

            public void setFacetValueDisplayOrder(int facetValueDisplayOrder) {
                FacetValueDisplayOrder = facetValueDisplayOrder;
            }
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class OnAirInfoClass{
            public String OnAirStart;
            public int DurationInSecond;

            public String getOnAirStart() {
                return OnAirStart;
            }

            public void setOnAirStart(String onAirStart) {
                OnAirStart = onAirStart;
            }

            public int getDurationInSecond() {
                return DurationInSecond;
            }

            public void setDurationInSecond(int durationInSecond) {
                DurationInSecond = durationInSecond;
            }
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class ProductMessagesClass{
            public String AppliedOfferMessage;

            public String getAppliedOfferMessage() {
                return AppliedOfferMessage;
            }

            public void setAppliedOfferMessage(String appliedOfferMessage) {
                AppliedOfferMessage = appliedOfferMessage;
            }
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class EsmScriptsClass{
            public String ScriptTypeCode;
            public String ScriptType;
            public List<String> ScriptInfo;

            public String getScriptTypeCode() {
                return ScriptTypeCode;
            }

            public void setScriptTypeCode(String scriptTypeCode) {
                ScriptTypeCode = scriptTypeCode;
            }

            public String getScriptType() {
                return ScriptType;
            }

            public void setScriptType(String scriptType) {
                ScriptType = scriptType;
            }

            public List<String> getScriptInfo() {
                return ScriptInfo;
            }

            public void setScriptInfo(List<String> scriptInfo) {
                ScriptInfo = scriptInfo;
            }
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CustomFieldsClass{
        public int Sequence;
        public String DisplayName;
        public int MaxLength;
        public String DisplayValue;

        public int getSequence() {
            return Sequence;
        }

        public void setSequence(int sequence) {
            Sequence = sequence;
        }

        public String getDisplayName() {
            return DisplayName;
        }

        public void setDisplayName(String displayName) {
            DisplayName = displayName;
        }

        public int getMaxLength() {
            return MaxLength;
        }

        public void setMaxLength(int maxLength) {
            MaxLength = maxLength;
        }

        public String getDisplayValue() {
            return DisplayValue;
        }

        public void setDisplayValue(String displayValue) {
            DisplayValue = displayValue;
        }
    }
}


