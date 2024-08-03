package king.witsking.repository;

import king.witsking.model.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList,Integer> {

}
