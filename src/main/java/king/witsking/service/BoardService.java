package king.witsking.service;

import king.witsking.model.GameList;
import king.witsking.repository.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {

    @Autowired
    private GameListRepository gameListRepository;

    public List<GameList> 진행중인게임() {
        return gameListRepository.findAll();

    }
}
