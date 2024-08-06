package king.witsking.repository;

import king.witsking.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface GameRepository extends JpaRepository<Game,Integer> {

    @Query("SELECT g.id FROM Game g WHERE g.play = false")
    List<Integer> findGameIdsWherePlayIsFalse();
}
