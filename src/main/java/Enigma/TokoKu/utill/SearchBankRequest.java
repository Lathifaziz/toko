package Enigma.TokoKu.utill;
import lombok.*;

@Setter
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class SearchBankRequest {
    private String name;
    private Integer id;
}
