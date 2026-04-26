package org.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String product;

    @Column(nullable = false)
    private int quantity;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Column(nullable = false)
    private String username; // owner of order

    // Constructors
    public Order() {}

    public Order(String product, int quantity, OrderStatus status, String username) {
        this.product = product;
        this.quantity = quantity;
        this.status = status;
        this.username = username;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public String getUsername() {
        return username;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // toString
    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", product='" + product + '\'' +
                ", quantity=" + quantity +
                ", status=" + status +
                ", username='" + username + '\'' +
                '}';
    }
}