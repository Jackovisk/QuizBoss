package projectedu.quizdg.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_player")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Integer level;

    @Column(nullable = false)
    private Integer experience;

    @Column(nullable = false)
    private Integer maxHealth;

    @Column(nullable = false)
    private Integer currentHealth;
    
    @Column(nullable = false)
    private Integer armadura = 1;

    @Column(nullable = false)
    private Integer poderDaArma = 1;

    @Column(nullable = false)
    private Integer coins;

    public int getLevel() {
        return level;
    }

    public int getArmadura() {
        return  armadura;

    }
}