package dev.battino.backend.domains.returns;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "returns")
public class Returns {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "returns_id")
    private Integer id;

    @NotNull
    @Size(min = 3, max = 255)
    @Column(name = "returns_reason")
    private String reason;

    @NotNull
    @Column(name = "returns_amount")
    private double amount;

    @NotNull
    @Column(name = "returns_order_id")
    private int orderId;
}
