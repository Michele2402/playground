package esbet.start.playground.infrastructure.entity;

import esbet.start.playground.domain.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "app_order")
public class OrderEntity {

    @Id
    @Column(columnDefinition = "UUID")
    private UUID id;

    private Instant orderDate;

    private Status status;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity userEntity;

    @OneToMany(mappedBy = "orderEntity", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ProductEntity> productEntityList;

    @OneToOne(mappedBy = "orderEntity", cascade = CascadeType.ALL)
    private ShippingEntity shippingEntityList;
}
