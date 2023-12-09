package org.qp.grocery.controller;

import org.qp.grocery.model.GroceryItem;
import org.qp.grocery.service.GroceryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private GroceryItemService groceryItemService;

    @PostMapping("/grocery-items")
    public ResponseEntity<String> addGroceryItem(@RequestBody List<GroceryItem> request) {
        groceryItemService.addGroceries(request);
        return ResponseEntity.ok("Grocery item added successfully");
    }

    @GetMapping("/grocery-items")
    public ResponseEntity<List<GroceryItem>> viewAllGroceryItems() {
        List<GroceryItem> allGroceryItems = groceryItemService.getAllGroceryItems();
        return ResponseEntity.ok(allGroceryItems);
    }

    @DeleteMapping("/grocery-items/{itemId}")
    public ResponseEntity<String> removeGroceryItem(@PathVariable Long itemId) {
        groceryItemService.removeItem(itemId);
        return ResponseEntity.ok("Grocery item removed successfully");
    }

    @PutMapping("/grocery-items/{itemId}")
    public ResponseEntity<String> updateGroceryItemDetails(
            @PathVariable Long itemId,
            @RequestBody GroceryItem request) {
        groceryItemService.updateGroceryItem(itemId, request);
        return ResponseEntity.ok("Grocery item details updated successfully");
    }

    @PatchMapping("/grocery-items/{itemId}/inventory")
    public ResponseEntity<String> manageInventory(
            @PathVariable Long itemId,
            @RequestParam int quantity) {
        groceryItemService.manageInventory(itemId, quantity);
        return ResponseEntity.ok("Inventory levels updated successfully");
    }
}
