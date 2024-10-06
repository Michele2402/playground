package esbet.start.playground.domain.model;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
public class Product {

    private UUID id;
    private String name;
    private String description;
    private String category;
    private double price;

    private Order order;

    @Builder
    public Product(UUID id, String name, String description, String category, double price, Order order) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
        this.order = order;
    }
}
