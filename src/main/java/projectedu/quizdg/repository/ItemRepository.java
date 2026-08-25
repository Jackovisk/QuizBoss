package projectedu.quizdg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projectedu.quizdg.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}