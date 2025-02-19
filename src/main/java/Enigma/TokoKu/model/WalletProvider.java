package Enigma.TokoKu.model;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "wallet_provider")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class WalletProvider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private String name;
}
