package org.qp.grocery.repository;

import org.qp.grocery.model.GroceryItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroceryItemRepository extends JpaRepository<GroceryItem, Long> {

    GroceryItem save(GroceryItem groceryItem);

}
