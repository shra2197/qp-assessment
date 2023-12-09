package org.qp.grocery.repository;

import org.qp.grocery.model.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<UserOrder, Long> {
    List<UserOrder> findByUserId(Long userId);
}
