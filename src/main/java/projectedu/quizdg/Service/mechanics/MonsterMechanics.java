package projectedu.quizdg.Service.mechanics;

import projectedu.quizdg.entity.Monster;
import projectedu.quizdg.entity.Player;

public interface MonsterMechanics {

    int calculateDamage (Monster monster, Player player, int rawDamage);


}
