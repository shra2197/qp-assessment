package org.qp.grocery.repository;

import org.qp.grocery.model.GroceryOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroceryOrderRepository extends JpaRepository<GroceryOrder, Long> {
}