package projectedu.quizdg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projectedu.quizdg.entity.Boss;

public interface BossRepository extends JpaRepository<Boss, Long> {
    
}