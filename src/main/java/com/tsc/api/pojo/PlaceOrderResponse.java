package com.tsc.api.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlaceOrderResponse {

    public PlaceOrderResponse(){}

    public CartResponse OrderedCart;
    public CartResponse NewCart;
    public String OrderModificationDeadline;

    public CartResponse getOrderedCart() {
        return OrderedCart;
    }

    public void setOrderedCart(CartResponse orderedCart) {
        OrderedCart = orderedCart;
    }

    public CartResponse getNewCart() {
        return NewCart;
    }

    public void setNewCart(CartResponse newCart) {
        NewCart = newCart;
    }

    public String getOrderModificationDeadline() {
        return OrderModificationDeadline;
    }

    public void setOrderModificationDeadline(String orderModificationDeadline) {
        OrderModificationDeadline = orderModificationDeadline;
    }
}
