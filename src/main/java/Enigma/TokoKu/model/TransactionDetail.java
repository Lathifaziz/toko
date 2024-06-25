package Enigma.TokoKu.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Transaction;

@Entity
@Table(name = "transaction_detail")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TransactionDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer quantity;
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "transaction_id")
    private Transaction transaction;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
