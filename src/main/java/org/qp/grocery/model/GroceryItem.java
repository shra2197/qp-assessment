package org.qp.grocery.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class GroceryItem {
    @Id
    @JsonProperty("item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonProperty("item_name")
    private String name;
    @JsonProperty("item_price")
    private double price;
    @JsonProperty("item_quantity")
    private int quantity;

    public GroceryItem() {
    }

    @JsonCreator
    public GroceryItem(@JsonProperty("item_id") Long id,
                       @JsonProperty("item_name") String name,
                       @JsonProperty("item_price") double price,
                       @JsonProperty("item_quantity") int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
