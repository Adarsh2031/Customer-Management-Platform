package org.example.dto;

import org.example.entity.OrderStatus;

public class OrderResponse {

    private Long id;
    private String product;
    private int quantity;
    private OrderStatus status;
    private String username;

    public OrderResponse() {}

    public OrderResponse(Long id, String product, int quantity, OrderStatus status, String username) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.status = status;
        this.username = username;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public String getProduct() { return product; }
    public int getQuantity() { return quantity; }
    public OrderStatus getStatus() { return status; }
    public String getUsername() { return username; }

    public void setId(Long id) { this.id = id; }
    public void setProduct(String product) { this.product = product; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setStatus(OrderStatus status) { this.status = status; }
    public void setUsername(String username) { this.username = username; }
}