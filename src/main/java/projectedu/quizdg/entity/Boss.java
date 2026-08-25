package projectedu.quizdg.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_boss")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Boss {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false)
    private Integer maxHealth;

    @Column(length = 255)
    private String imageUrl;

    // Nível de dificuldade para balancear o jogo (ex: 1 para Fácil, 3 para Difícil)
    @Column(nullable = false)
    private Integer difficultyLevel;

    @Column(nullable = false)
    private Integer currentHealth;

}