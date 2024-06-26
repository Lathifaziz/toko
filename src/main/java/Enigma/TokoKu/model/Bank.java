package Enigma.TokoKu.model;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "bank")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Bank {

    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
}
