package esbet.start.playground.domain.model;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
public class Shipping {

    private UUID id;
    private String address;
    private String city;
    private String state;
    private String country;
    private String zipCode;

    private Order order;

    @Builder
    public Shipping(UUID id, String address, String city, String state, String country, String zipCode, Order order) {
        this.id = id;
        this.address = address;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
        this.order = order;
    }

    public String getFullAddress() {
        return String.format("%s, %s, %s, %s, %s", address, city, state, country, zipCode);
    }
}
