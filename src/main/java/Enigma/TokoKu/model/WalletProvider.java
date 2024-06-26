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

    private String name;
}
