package Enigma.TokoKu.utill;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class SearchCustomerRequest {
    private String name;
    private String birthPlace;

}
