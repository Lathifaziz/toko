package Enigma.TokoKu.utill;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
    public class SearchProductRequest {
    private String name;
    private Integer price;
}
