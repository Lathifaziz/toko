package Enigma.TokoKu.utill.DTO;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WalletProviderRequestDTO {
    Integer customer_id;
    Integer wallet_provider_id;
    Integer ballance;
}
