package com.tsc.api.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlaceOrderResponse {

    public PlaceOrderResponse(){}

    public AccountCartResponse OrderedCart;
    public AccountCartResponse NewCart;
    public String OrderModificationDeadline;

    public AccountCartResponse getOrderedCart() {
        return OrderedCart;
    }

    public void setOrderedCart(AccountCartResponse orderedCart) {
        OrderedCart = orderedCart;
    }

    public AccountCartResponse getNewCart() {
        return NewCart;
    }

    public void setNewCart(AccountCartResponse newCart) {
        NewCart = newCart;
    }

    public String getOrderModificationDeadline() {
        return OrderModificationDeadline;
    }

    public void setOrderModificationDeadline(String orderModificationDeadline) {
        OrderModificationDeadline = orderModificationDeadline;
    }
}
