package king.witsking.repository;

import king.witsking.model.Gift;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GiftRepository extends JpaRepository<Gift,Integer> {
}
