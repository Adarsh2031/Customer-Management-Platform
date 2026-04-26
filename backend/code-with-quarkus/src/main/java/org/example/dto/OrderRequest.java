package org.example.dto;

public class OrderRequest {

    private String product;
    private int quantity;

    // Constructors
    public OrderRequest() {}

    public OrderRequest(String product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    // Getters
    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    // Setters
    public void setProduct(String product) {
        this.product = product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}