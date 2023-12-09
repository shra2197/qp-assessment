package org.qp.grocery.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class UserOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private GroceryUser user;

    @OneToMany
    @JoinColumn(name = "item_id")
    private List<GroceryItem> items;

    private int quantity;

    private LocalDateTime orderDate;

    // constructors, getters, setters
}
