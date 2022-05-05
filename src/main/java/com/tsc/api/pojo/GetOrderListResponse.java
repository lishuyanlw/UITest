package com.tsc.api.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetOrderListResponse {

    public GetOrderListResponse(){}

    public Paging Paging;
    public List<OrderSummary> OrderSummary;

    public GetOrderListResponse.Paging getPaging() {
        return Paging;
    }

    public void setPaging(GetOrderListResponse.Paging paging) {
        Paging = paging;
    }

    public List<GetOrderListResponse.OrderSummary> getOrderSummary() {
        return OrderSummary;
    }

    public void setOrderSummary(List<GetOrderListResponse.OrderSummary> orderSummary) {
        OrderSummary = orderSummary;
    }

    public static class Paging {
        public int TotalRecords;
        public int TotalPages;
        public int CurrentPage;

        public int getTotalRecords() {
            return TotalRecords;
        }

        public void setTotalRecords(int totalRecords) {
            TotalRecords = totalRecords;
        }

        public int getTotalPages() {
            return TotalPages;
        }

        public void setTotalPages(int totalPages) {
            TotalPages = totalPages;
        }

        public int getCurrentPage() {
            return CurrentPage;
        }

        public void setCurrentPage(int currentPage) {
            CurrentPage = currentPage;
        }

    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class OrderSummary {
        public String OrderNo;
        public String OrderDateTime;
        public String ShipDate;
        public String OrderTotal;
        public int Quantity;
        public String Status;
        public String OrderMethod;
        public boolean Editable;
        public boolean Trackable;
        public List<String> OrderModificationValidationMessages;

        public String getOrderNo() {
            return OrderNo;
        }

        public void setOrderNo(String orderNo) {
            OrderNo = orderNo;
        }

        public String getOrderDateTime() {
            return OrderDateTime;
        }

        public void setOrderDateTime(String orderDateTime) {
            OrderDateTime = orderDateTime;
        }

        public String getShipDate() {
            return ShipDate;
        }

        public void setShipDate(String shipDate) {
            ShipDate = shipDate;
        }

        public String getOrderTotal() {
            return OrderTotal;
        }

        public void setOrderTotal(String orderTotal) {
            OrderTotal = orderTotal;
        }

        public int getQuantity() {
            return Quantity;
        }

        public void setQuantity(int quantity) {
            Quantity = quantity;
        }

        public String getStatus() {
            return Status;
        }

        public void setStatus(String status) {
            Status = status;
        }

        public String getOrderMethod() {
            return OrderMethod;
        }

        public void setOrderMethod(String orderMethod) {
            OrderMethod = orderMethod;
        }

        public boolean isEditable() {
            return Editable;
        }

        public void setEditable(boolean editable) {
            Editable = editable;
        }

        public boolean isTrackable() {
            return Trackable;
        }

        public void setTrackable(boolean trackable) {
            Trackable = trackable;
        }

        public List<String> getOrderModificationValidationMessages() {
            return OrderModificationValidationMessages;
        }

        public void setOrderModificationValidationMessages(List<String> orderModificationValidationMessages) {
            OrderModificationValidationMessages = orderModificationValidationMessages;
        }
    }
}
