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
@Table(name = "product")
public class ProductEntity {

    @Id
    @Column(columnDefinition = "UUID")
    private UUID id;

    private String name;

    private String description;

    private String category;

    private double price;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private OrderEntity orderEntity;
}
