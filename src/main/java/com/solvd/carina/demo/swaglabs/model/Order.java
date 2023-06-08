package com.solvd.carina.demo.swaglabs.model;

public class Order {
    private  Integer orderId;
    private String product;
    private Integer userId;

    public Order() {
    }
    public Order(Integer orderId, String product, Integer userId) {
        this.orderId = orderId;
        this.product = product;
        this.userId = userId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return String.format("[orderId = %d, product = %s, userId = %d]", orderId, product, userId);
    }
}
