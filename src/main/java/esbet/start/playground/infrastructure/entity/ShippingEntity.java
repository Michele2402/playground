package esbet.start.playground.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "shipping")
public class ShippingEntity {

    @Id
    @Column(columnDefinition = "UUID")
    private UUID id;

    private String address;

    private String city;

    private String state;

    private String country;

    private String zipCode;

    @OneToOne
    @JoinColumn(name = "order_id", nullable = false)
    private OrderEntity orderEntity;
}
