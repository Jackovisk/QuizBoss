package projectedu.quizdg.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projectedu.quizdg.entity.Boss;
import projectedu.quizdg.entity.Monster;
import projectedu.quizdg.entity.Player;
import projectedu.quizdg.entity.Question;
import projectedu.quizdg.repository.BossRepository;
import projectedu.quizdg.repository.PlayerRepository;
@Service
public class CombatService {

    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private BossRepository bossRepository;

    public Integer calculatePLayerDamage(Player player, Boss boss, Question question, Monster monster, double extraMultiplier) {

        int playerBaseAttack = (player.getPoderDaArma() * player.getLevel()) + (question.getDifficultyLevel() * 5);

        int bossDefense = boss.getDifficultyLevel() * 5;

        int rawDamage = playerBaseAttack - bossDefense;

        rawDamage = Math.max(1, rawDamage);

        return (int) (rawDamage * extraMultiplier);
    }

    public Integer calculateBossDamage(Boss boss, Question question,Player player, double extraMultiplier) {


        int bossBaseAttack = (boss.getDifficultyLevel()*5)+(question.getDifficultyLevel()*5);

        int playerDefense = player.getArmadura()* player.getLevel();

        int rawDamage = bossBaseAttack- playerDefense;

        rawDamage = Math.max(1, rawDamage);

        return  (int) (rawDamage * extraMultiplier);



    }


    public Integer calculateMonsterDamage(Monster monster, Question question, Player player, double extraMultiplier){



    }

    public String processCombatTurnBoss(Player player, Boss boss, Question question,Monster monster, boolean isCorrectAnswer) {

        if (isCorrectAnswer) {

            int damage = calculatePLayerDamage(player, boss, question,monster, 1.0);


            int novaVidaBoss = boss.getCurrentHealth() - damage;
            boss.setCurrentHealth(Math.max(0, novaVidaBoss));


            bossRepository.save(boss);


            if (boss.getCurrentHealth() == 0) {
                return "VITÓRIA! Você acertou e derrotou o " + boss.getName() + " com um golpe de " + damage + " de dano!";
            }

            return "ACERTOU! Você causou " + damage + " de dano. " ;

        } else {

            int damage = calculateBossDamage(boss, question, player, 1.0);


            int novaVidaPlayer = player.getCurrentHealth() - damage;
            player.setCurrentHealth(Math.max(0, novaVidaPlayer));


            playerRepository.save(player);


            if (player.getCurrentHealth() == 0) {
                return "GAME OVER! Você errou e " + boss.getName() + " te eliminou. Não fique abalado, aprenda com os erros e siga novamente";
            }

            return "ERROU! O Boss contra-atacou causando " + damage + " de dano. Sua vida restante: " + player.getCurrentHealth();
        }
    }


}
