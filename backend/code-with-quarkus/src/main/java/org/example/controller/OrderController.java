package org.example.controller;

import java.util.List;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.example.dto.OrderRequest;
import org.example.dto.OrderResponse;
import org.example.entity.OrderStatus;
import org.example.service.OrderService;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;

@Path("/orders")
@Consumes("application/json")
@Produces("application/json")
public class OrderController {

    @Inject
    OrderService orderService;

    @Inject
    JsonWebToken jwt;

    // CREATE ORDER (CUSTOMER + ADMIN)
    @POST
    @RolesAllowed({"CUSTOMER", "ADMIN"})
    public OrderResponse create(OrderRequest request) {
        String username = jwt.getSubject();
        return orderService.createOrder(request, username);
    }

    // GET ALL ORDERS (ADMIN ONLY)
    @GET
    @RolesAllowed("ADMIN")
    public List<OrderResponse> getAll() {
        return orderService.getAllOrders();
    }

    // GET MY ORDERS (CUSTOMER)
    @GET
    @Path("/my")
    @RolesAllowed("CUSTOMER")
    public List<OrderResponse> myOrders() {
        return orderService.getUserOrders(jwt.getSubject());
    }

    // FILTER BY STATUS
    @GET
    @Path("/filter")
    public List<OrderResponse> filter(@QueryParam("status") OrderStatus status) {
        return orderService.filterByStatus(status);
    }

    // DELETE ORDER (ADMIN)
    @DELETE
    @Path("/{id}")
    @RolesAllowed("ADMIN")
    public void delete(@PathParam("id") Long id) {
        orderService.deleteOrder(id);
    }
}