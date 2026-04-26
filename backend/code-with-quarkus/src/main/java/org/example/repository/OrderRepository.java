package org.example.repository;

import java.util.List;

import org.example.entity.Order;
import org.example.entity.OrderStatus;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OrderRepository implements PanacheRepository<Order> {

    // Get orders by status (filtering)
    public List<Order> findByStatus(OrderStatus status) {
        return list("status", status);
    }

    // Get orders for a specific user
    public List<Order> findByUsername(String username) {
        return list("username", username);
    }

    // Optional: Admin can see all orders (already available via listAll())
}