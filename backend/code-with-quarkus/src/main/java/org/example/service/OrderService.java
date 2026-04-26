package org.example.service;

import java.util.List;
import java.util.stream.Collectors;

import org.example.dto.OrderRequest;
import org.example.dto.OrderResponse;
import org.example.entity.Order;
import org.example.entity.OrderStatus;
import org.example.repository.OrderRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class OrderService {

    @Inject
    OrderRepository orderRepository;

    // CREATE ORDER
    public OrderResponse createOrder(OrderRequest request, String username) {

        Order order = new Order();
        order.setProduct(request.getProduct());
        order.setQuantity(request.getQuantity());
        order.setStatus(OrderStatus.CREATED);
        order.setUsername(username);

        orderRepository.persist(order);

        return mapToResponse(order);
    }

    // GET ALL ORDERS (ADMIN)
    public List<OrderResponse> getAllOrders() {
        return orderRepository.listAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // GET USER ORDERS
    public List<OrderResponse> getUserOrders(String username) {
        return orderRepository.findByUsername(username)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // FILTER BY STATUS
    public List<OrderResponse> filterByStatus(OrderStatus status) {
        return orderRepository.findByStatus(status)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // DELETE ORDER
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    // 🔁 ENTITY → DTO
    private OrderResponse mapToResponse(Order order) {
        return new OrderResponse(
                order.getId(),
                order.getProduct(),
                order.getQuantity(),
                order.getStatus(),
                order.getUsername()
        );
    }
}