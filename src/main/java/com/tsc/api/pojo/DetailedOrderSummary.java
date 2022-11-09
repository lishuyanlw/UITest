package com.tsc.api.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DetailedOrderSummary {
    public OrderSummary OrderSummary;
    public String CustomerNo;
    public String CustomerName;
    public String BillingAddress;
    public String BillingCityProvincePostalCode;
    public String DayPhone;
    public String PaymentType;
    public String CreditCardNo;
    public String CCExpiry;
    public String NoOfEasyPays;
    public List EasyPayBreakdown;
    public String RefundAmount;
    public String PromoCode;
    public List<ReturnReasons> ReturnReasons;
    public List<ShipLevels> ShipLevels;
    public String MerchandiseSubTotal;
    public String Discount;
    public String ShippingHandling;
    public String TaxTotal;
    public String GiftCardRedemption;
    public String CreditAmountApplied;
    public String GrandTotal;
    public String ActualOrderTotal;
    public String GstRegNumber;
    public String PstRegNumber;

    public com.tsc.api.pojo.OrderSummary getOrderSummary() {
        return OrderSummary;
    }

    public void setOrderSummary(com.tsc.api.pojo.OrderSummary orderSummary) {
        OrderSummary = orderSummary;
    }

    public String getCustomerNo() {
        return CustomerNo;
    }

    public void setCustomerNo(String customerNo) {
        CustomerNo = customerNo;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getBillingAddress() {
        return BillingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        BillingAddress = billingAddress;
    }

    public String getBillingCityProvincePostalCode() {
        return BillingCityProvincePostalCode;
    }

    public void setBillingCityProvincePostalCode(String billingCityProvincePostalCode) {
        BillingCityProvincePostalCode = billingCityProvincePostalCode;
    }

    public String getDayPhone() {
        return DayPhone;
    }

    public void setDayPhone(String dayPhone) {
        DayPhone = dayPhone;
    }

    public String getPaymentType() {
        return PaymentType;
    }

    public void setPaymentType(String paymentType) {
        PaymentType = paymentType;
    }

    public String getCreditCardNo() {
        return CreditCardNo;
    }

    public void setCreditCardNo(String creditCardNo) {
        CreditCardNo = creditCardNo;
    }

    public String getCCExpiry() {
        return CCExpiry;
    }

    public void setCCExpiry(String CCExpiry) {
        this.CCExpiry = CCExpiry;
    }

    public String getNoOfEasyPays() {
        return NoOfEasyPays;
    }

    public void setNoOfEasyPays(String noOfEasyPays) {
        NoOfEasyPays = noOfEasyPays;
    }

    public List getEasyPayBreakdown() {
        return EasyPayBreakdown;
    }

    public void setEasyPayBreakdown(List easyPayBreakdown) {
        EasyPayBreakdown = easyPayBreakdown;
    }

    public String getRefundAmount() {
        return RefundAmount;
    }

    public void setRefundAmount(String refundAmount) {
        RefundAmount = refundAmount;
    }

    public String getPromoCode() {
        return PromoCode;
    }

    public void setPromoCode(String promoCode) {
        PromoCode = promoCode;
    }

    public List<DetailedOrderSummary.ReturnReasons> getReturnReasons() {
        return ReturnReasons;
    }

    public void setReturnReasons(List<DetailedOrderSummary.ReturnReasons> returnReasons) {
        ReturnReasons = returnReasons;
    }

    public List<DetailedOrderSummary.ShipLevels> getShipLevels() {
        return ShipLevels;
    }

    public void setShipLevels(List<DetailedOrderSummary.ShipLevels> shipLevels) {
        ShipLevels = shipLevels;
    }

    public String getMerchandiseSubTotal() {
        return MerchandiseSubTotal;
    }

    public void setMerchandiseSubTotal(String merchandiseSubTotal) {
        MerchandiseSubTotal = merchandiseSubTotal;
    }

    public String getDiscount() {
        return Discount;
    }

    public void setDiscount(String discount) {
        Discount = discount;
    }

    public String getShippingHandling() {
        return ShippingHandling;
    }

    public void setShippingHandling(String shippingHandling) {
        ShippingHandling = shippingHandling;
    }

    public String getTaxTotal() {
        return TaxTotal;
    }

    public void setTaxTotal(String taxTotal) {
        TaxTotal = taxTotal;
    }

    public String getGiftCardRedemption() {
        return GiftCardRedemption;
    }

    public void setGiftCardRedemption(String giftCardRedemption) {
        GiftCardRedemption = giftCardRedemption;
    }

    public String getCreditAmountApplied() {
        return CreditAmountApplied;
    }

    public void setCreditAmountApplied(String creditAmountApplied) {
        CreditAmountApplied = creditAmountApplied;
    }

    public String getGrandTotal() {
        return GrandTotal;
    }

    public void setGrandTotal(String grandTotal) {
        GrandTotal = grandTotal;
    }

    public String getActualOrderTotal() {
        return ActualOrderTotal;
    }

    public void setActualOrderTotal(String actualOrderTotal) {
        ActualOrderTotal = actualOrderTotal;
    }

    public String getGstRegNumber() {
        return GstRegNumber;
    }

    public void setGstRegNumber(String gstRegNumber) {
        GstRegNumber = gstRegNumber;
    }

    public String getPstRegNumber() {
        return PstRegNumber;
    }

    public void setPstRegNumber(String pstRegNumber) {
        PstRegNumber = pstRegNumber;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ReturnReasons{
        public String Code;
        public String Reason;

        public String getCode() {            return Code;        }

        public void setCode(String code) {            Code = code;        }

        public String getReason() {            return Reason;        }

        public void setReason(String reason) {            Reason = reason;        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ShipLevels{
        public String ShipOrderNo;
        public String ShipDate;
        public String DeliveryDate;
        public String ReturnByDate;
        public Boolean IsReturnDeadlinePassed;
        public Boolean ShowIneligibleForReturnMessage;
        public Boolean IsDropShip;
        public Boolean ShowCanadaPostReturnCTA;
        public Boolean ShowGenericReturnCTA;
        public String ShipAddressee;
        public String ShipAddress;
        public String ShipCityProvincePostalCode;
        public String ShipMethod;
        public String TrackingNo;
        public String TrackingURL;
        public List<Items> Items;

        public String getShipOrderNo() {
            return ShipOrderNo;
        }

        public void setShipOrderNo(String shipOrderNo) {
            ShipOrderNo = shipOrderNo;
        }

        public String getShipDate() {
            return ShipDate;
        }

        public void setShipDate(String shipDate) {
            ShipDate = shipDate;
        }

        public String getDeliveryDate() {
            return DeliveryDate;
        }

        public void setDeliveryDate(String deliveryDate) {
            DeliveryDate = deliveryDate;
        }

        public String getReturnByDate() {
            return ReturnByDate;
        }

        public void setReturnByDate(String returnByDate) {
            ReturnByDate = returnByDate;
        }

        public Boolean getReturnDeadlinePassed() {
            return IsReturnDeadlinePassed;
        }

        public void setReturnDeadlinePassed(Boolean returnDeadlinePassed) {
            IsReturnDeadlinePassed = returnDeadlinePassed;
        }

        public Boolean getShowIneligibleForReturnMessage() {
            return ShowIneligibleForReturnMessage;
        }

        public void setShowIneligibleForReturnMessage(Boolean showIneligibleForReturnMessage) {
            ShowIneligibleForReturnMessage = showIneligibleForReturnMessage;
        }

        public Boolean getDropShip() {
            return IsDropShip;
        }

        public void setDropShip(Boolean dropShip) {
            IsDropShip = dropShip;
        }

        public Boolean getShowCanadaPostReturnCTA() {
            return ShowCanadaPostReturnCTA;
        }

        public void setShowCanadaPostReturnCTA(Boolean showCanadaPostReturnCTA) {
            ShowCanadaPostReturnCTA = showCanadaPostReturnCTA;
        }

        public Boolean getShowGenericReturnCTA() {
            return ShowGenericReturnCTA;
        }

        public void setShowGenericReturnCTA(Boolean showGenericReturnCTA) {
            ShowGenericReturnCTA = showGenericReturnCTA;
        }

        public String getShipAddressee() {
            return ShipAddressee;
        }

        public void setShipAddressee(String shipAddressee) {
            ShipAddressee = shipAddressee;
        }

        public String getShipAddress() {
            return ShipAddress;
        }

        public void setShipAddress(String shipAddress) {
            ShipAddress = shipAddress;
        }

        public String getShipCityProvincePostalCode() {
            return ShipCityProvincePostalCode;
        }

        public void setShipCityProvincePostalCode(String shipCityProvincePostalCode) {
            ShipCityProvincePostalCode = shipCityProvincePostalCode;
        }

        public String getShipMethod() {
            return ShipMethod;
        }

        public void setShipMethod(String shipMethod) {
            ShipMethod = shipMethod;
        }

        public String getTrackingNo() {
            return TrackingNo;
        }

        public void setTrackingNo(String trackingNo) {
            TrackingNo = trackingNo;
        }

        public String getTrackingURL() {
            return TrackingURL;
        }

        public void setTrackingURL(String trackingURL) {
            TrackingURL = trackingURL;
        }

        public List<DetailedOrderSummary.Items> getItems() {
            return Items;
        }

        public void setItems(List<DetailedOrderSummary.Items> items) {
            Items = items;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Items{
        public String ShipOrderNo;
        public String LineNo;
        public String ItemEDP;
        public String ItemNo;
        public String ItemNoForDisplay;
        public String Description;
        public String Style;
        public String Size;
        public String UnitPrice;
        public String ItemQuantity;
        public String TotalPrice;
        public String Status;
        public Boolean IsReturnable;
        public String ReturnRestrictionMessage;
        public String ItemURL;
        public String ItemImageURL;
        public String WriteAReviewURL;
        public String ReturnInfoURL;
        public List CustomData;
        public String FinalSaleMessage;
        public String VendorReturnCode;

        public String getShipOrderNo() {
            return ShipOrderNo;
        }

        public void setShipOrderNo(String shipOrderNo) {
            ShipOrderNo = shipOrderNo;
        }

        public String getLineNo() {
            return LineNo;
        }

        public void setLineNo(String lineNo) {
            LineNo = lineNo;
        }

        public String getItemEDP() {
            return ItemEDP;
        }

        public void setItemEDP(String itemEDP) {
            ItemEDP = itemEDP;
        }

        public String getItemNo() {
            return ItemNo;
        }

        public void setItemNo(String itemNo) {
            ItemNo = itemNo;
        }

        public String getItemNoForDisplay() {
            return ItemNoForDisplay;
        }

        public void setItemNoForDisplay(String itemNoForDisplay) {
            ItemNoForDisplay = itemNoForDisplay;
        }

        public String getDescription() {
            return Description;
        }

        public void setDescription(String description) {
            Description = description;
        }

        public String getStyle() {
            return Style;
        }

        public void setStyle(String style) {
            Style = style;
        }

        public String getSize() {
            return Size;
        }

        public void setSize(String size) {
            Size = size;
        }

        public String getUnitPrice() {
            return UnitPrice;
        }

        public void setUnitPrice(String unitPrice) {
            UnitPrice = unitPrice;
        }

        public String getItemQuantity() {
            return ItemQuantity;
        }

        public void setItemQuantity(String itemQuantity) {
            ItemQuantity = itemQuantity;
        }

        public String getTotalPrice() {
            return TotalPrice;
        }

        public void setTotalPrice(String totalPrice) {
            TotalPrice = totalPrice;
        }

        public String getStatus() {
            return Status;
        }

        public void setStatus(String status) {
            Status = status;
        }

        public Boolean getReturnable() {
            return IsReturnable;
        }

        public void setReturnable(Boolean returnable) {
            IsReturnable = returnable;
        }

        public String getReturnRestrictionMessage() {
            return ReturnRestrictionMessage;
        }

        public void setReturnRestrictionMessage(String returnRestrictionMessage) {
            ReturnRestrictionMessage = returnRestrictionMessage;
        }

        public String getItemURL() {
            return ItemURL;
        }

        public void setItemURL(String itemURL) {
            ItemURL = itemURL;
        }

        public String getItemImageURL() {
            return ItemImageURL;
        }

        public void setItemImageURL(String itemImageURL) {
            ItemImageURL = itemImageURL;
        }

        public String getWriteAReviewURL() {
            return WriteAReviewURL;
        }

        public void setWriteAReviewURL(String writeAReviewURL) {
            WriteAReviewURL = writeAReviewURL;
        }

        public String getReturnInfoURL() {
            return ReturnInfoURL;
        }

        public void setReturnInfoURL(String returnInfoURL) {
            ReturnInfoURL = returnInfoURL;
        }

        public List getCustomData() {
            return CustomData;
        }

        public void setCustomData(List customData) {
            CustomData = customData;
        }

        public String getFinalSaleMessage() {
            return FinalSaleMessage;
        }

        public void setFinalSaleMessage(String finalSaleMessage) {
            FinalSaleMessage = finalSaleMessage;
        }

        public String getVendorReturnCode() {
            return VendorReturnCode;
        }

        public void setVendorReturnCode(String vendorReturnCode) {
            VendorReturnCode = vendorReturnCode;
        }
    }

}
