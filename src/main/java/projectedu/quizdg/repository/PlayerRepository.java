package projectedu.quizdg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projectedu.quizdg.entity.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {

}