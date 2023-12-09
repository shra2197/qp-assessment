package org.qp.grocery.repository;

import org.qp.grocery.model.GroceryUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<GroceryUser, Long> {
}