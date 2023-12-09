package org.qp.grocery.service;

import org.qp.grocery.model.GroceryItem;
import org.qp.grocery.model.GroceryOrder;
import org.qp.grocery.model.OrderStatus;
import org.qp.grocery.repository.GroceryItemRepository;
import org.qp.grocery.repository.GroceryOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroceryOrderService {

    private final GroceryOrderRepository groceryOrderRepository;
    private final GroceryItemRepository groceryItemRepository;

    @Autowired
    public GroceryOrderService(GroceryOrderRepository groceryOrderRepository, GroceryItemRepository groceryItemRepository) {
        this.groceryOrderRepository = groceryOrderRepository;
        this.groceryItemRepository = groceryItemRepository;
    }

    public ResponseEntity<String> createOrder(List<GroceryItem> items) {
        for (GroceryItem item : items) {
            if (!groceryItemRepository.existsById(item.getId())) {
                return ResponseEntity.badRequest().body("Grocery item with ID " + item.getId() + " not found");
            }
        }
        List<Long> ids = items.stream().map(item -> item.getId()).collect(Collectors.toList());
        GroceryOrder order = new GroceryOrder();
        order.setStatus(OrderStatus.PENDING);
        order.setItems(groceryItemRepository.findAllById(ids));
        groceryOrderRepository.save(order);

        return ResponseEntity.ok("Order created successfully");
    }
}
