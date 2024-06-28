package Enigma.TokoKu.utill.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionRequestDTO {
    Integer customer_id;
    Integer product_id;
    Integer quantity;
    Integer price;
}
