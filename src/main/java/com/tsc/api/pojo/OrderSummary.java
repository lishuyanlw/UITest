package com.tsc.api.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderSummary {
    public String OrderNo;
    public String OrderDateTime;
    public String ShipDate;
    public String OrderTotal;
    public int Quantity;
    public String Status;
    public String OrderMethod;
    public Boolean Editable;
    public Boolean Trackable;
    public List OrderModificationValidationMessages;

    public String getOrderNo() {            return OrderNo;        }

    public void setOrderNo(String orderNo) {            OrderNo = orderNo;        }

    public String getOrderDateTime() {            return OrderDateTime;        }

    public void setOrderDateTime(String orderDateTime) {            OrderDateTime = orderDateTime;        }

    public String getShipDate() {            return ShipDate;        }

    public void setShipDate(String shipDate) {            ShipDate = shipDate;        }

    public String getOrderTotal() {            return OrderTotal;        }

    public void setOrderTotal(String orderTotal) {            OrderTotal = orderTotal;        }

    public int getQuantity() {            return Quantity;        }

    public void setQuantity(int quantity) {            Quantity = quantity;        }

    public String getStatus() {            return Status;        }

    public void setStatus(String status) {            Status = status;        }

    public String getOrderMethod() {            return OrderMethod;        }

    public void setOrderMethod(String orderMethod) {            OrderMethod = orderMethod;        }

    public Boolean getEditable() {            return Editable;        }

    public void setEditable(Boolean editable) {            Editable = editable;        }

    public Boolean getTrackable() {            return Trackable;        }

    public void setTrackable(Boolean trackable) {            Trackable = trackable;        }

    public List getOrderModificationValidationMessages() {            return OrderModificationValidationMessages;        }

    public void setOrderModificationValidationMessages(List orderModificationValidationMessages) {            OrderModificationValidationMessages = orderModificationValidationMessages;        }

}
