package esbet.start.playground.domain.model;

import esbet.start.playground.domain.enums.Status;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Data
public class Order {

    private UUID id;
    private Instant orderDate;
    private Status status;

    private User userEntity;
    private List<Product> productEntityList;
    private Shipping shippingEntityList;

    @Builder
    public Order(UUID id, Instant orderDate, Status status, User userEntity, List<Product> productEntityList, Shipping shippingEntityList) {
        this.id = id;
        this.orderDate = orderDate;
        this.status = status;
        this.userEntity = userEntity;
        this.productEntityList = productEntityList;
        this.shippingEntityList = shippingEntityList;
    }

    public double getTotal() {
        double total = 0;
        for (Product product : productEntityList) {
            total += product.getPrice();
        }
        return total;
    }

    public void ship() {
        status = Status.IN_DELIVERY;
    }

    public void deliver() {
        status = Status.DELIVERED;
    }
}
