package org.qp.grocery.service;

import org.qp.grocery.model.GroceryItem;
import org.qp.grocery.repository.GroceryItemRepository;
import org.qp.grocery.repository.OrderRepository;
import org.qp.grocery.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private GroceryItemRepository groceryItemRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    public List<GroceryItem> getAllGroceryItems() {
        return groceryItemRepository.findAll();
    }



}
