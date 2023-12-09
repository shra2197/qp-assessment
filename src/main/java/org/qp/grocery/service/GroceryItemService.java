package org.qp.grocery.service;

import org.qp.grocery.model.GroceryItem;
import org.qp.grocery.repository.GroceryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroceryItemService {

    private final GroceryItemRepository groceryItemRepository;

    @Autowired
    public GroceryItemService(GroceryItemRepository groceryItemRepository) {
        this.groceryItemRepository = groceryItemRepository;
    }

    public ResponseEntity<String> updateGroceryItem(Long itemId, GroceryItem updatedItem) {
        if (groceryItemRepository.existsById(itemId)) {
            GroceryItem item = groceryItemRepository.findById(itemId).orElseThrow();
            item.setName(updatedItem.getName());
            item.setPrice(updatedItem.getPrice());
            item.setQuantity(updatedItem.getQuantity());
            groceryItemRepository.save(item);
            return ResponseEntity.ok("Grocery item details updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public void manageInventory(Long itemId, int quantity) {
        GroceryItem items = getGroceryItem(itemId).get();
        items.setQuantity(quantity);
        updateGroceryItem(itemId, items);
    }

    public void addGroceries(List<GroceryItem> groceryItem) {
        groceryItemRepository.saveAll(groceryItem);
    }

    public List<GroceryItem> getAllGroceryItems() {
        return groceryItemRepository.findAll();
    }

    public void removeItem(Long id) {
        groceryItemRepository.deleteById(id);
    }

    public Optional<GroceryItem> getGroceryItem(Long id) {
        return groceryItemRepository.findById(id);
    }
}
