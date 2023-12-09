package org.qp.grocery.controller;

import org.qp.grocery.model.GroceryItem;
import org.qp.grocery.model.UserOrder;
import org.qp.grocery.service.GroceryOrderService;
import org.qp.grocery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private GroceryOrderService groceryOrderService;

    @GetMapping("/grocery-items")
    public ResponseEntity<List<GroceryItem>> viewAllGroceryItems() {
        List<GroceryItem> allGroceryItems = userService.getAllGroceryItems();
        return ResponseEntity.ok(allGroceryItems);
    }

    @PostMapping("/grocery-items/order")
    public ResponseEntity<String> createOrder(@RequestBody List<GroceryItem> groceryItems) {
        UserOrder userOrder = new UserOrder();
        return groceryOrderService.createOrder(groceryItems);
    }
}