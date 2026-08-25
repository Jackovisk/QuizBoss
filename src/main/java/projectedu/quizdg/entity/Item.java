package projectedu.quizdg.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_item")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    // Quanto custa na lojinha do jogo
    @Column(nullable = false)
    private Integer price;

    // Define a mecânica do item. Ex: "HEAL" (Cura), "SHIELD" (Defesa), "ATTACK_BOOST" (Dano Extra)
    @Column(nullable = false, length = 50)
    private String effectType;

    // A força da mecânica. Ex: Se for "HEAL", effectValue = 50 significa que cura 50 de vida.
    @Column(nullable = false)
    private Integer effectValue;
}