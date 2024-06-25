package Enigma.TokoKu.model;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "transaction")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
