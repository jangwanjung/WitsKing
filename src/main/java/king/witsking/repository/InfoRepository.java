package king.witsking.repository;

import king.witsking.model.Game;
import king.witsking.model.Info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface InfoRepository extends JpaRepository<Info, Integer> {
    List<Info> findByGameId(int id);

    int countByGameId(int gameId);

}
