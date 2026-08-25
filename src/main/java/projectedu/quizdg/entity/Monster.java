package projectedu.quizdg.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_monster")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Monster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false)
    private Integer maxHealth;

    @Column(nullable = false)
    private Integer currentHealth;

    @Column(nullable = false, length = 10)
    private String stageId;

    @Column(nullable = false)
    private Integer rewardCoins;

    @Column(nullable = false)
    private Integer rewardXp;

    @Column(nullable = false)
    private Integer difficultyLevel;

    @Column(nullable = false, length = 50)
    private String mechanicType = "NORMAL";
}