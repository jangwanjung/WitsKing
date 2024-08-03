package king.witsking.service;

import king.witsking.model.GameList;
import king.witsking.repository.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private GameListRepository gameListRepository;

    public void 게임생성(int scale, String giftName , String giftPhoto){
        GameList gameList = GameList.builder()
                .scale(scale)
                .giftname(giftName)
                .giftphoto(giftPhoto)
                .play(false)
                .build();
        gameListRepository.save(gameList);

    }
}
