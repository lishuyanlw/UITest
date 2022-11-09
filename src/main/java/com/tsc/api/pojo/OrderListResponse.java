package com.tsc.api.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderListResponse {

    public Paging Paging;
    public List<OrderSummary> OrderSummary;

    public com.tsc.api.pojo.Paging getPaging() {        return Paging;    }

    public void setPaging(com.tsc.api.pojo.Paging paging) {        Paging = paging;    }

    public List<OrderSummary> getOrderSummary() {
        return OrderSummary;
    }

    public void setOrderSummary(List<OrderSummary> orderSummary) {
        OrderSummary = orderSummary;
    }


}
