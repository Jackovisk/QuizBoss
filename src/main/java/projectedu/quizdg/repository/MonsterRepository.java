package projectedu.quizdg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projectedu.quizdg.entity.Monster;

public interface MonsterRepository extends JpaRepository<Monster, Long> {
}
