package king.witsking.service;

import king.witsking.model.Game;
import king.witsking.model.Info;
import king.witsking.repository.GameRepository;
import king.witsking.repository.InfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private InfoRepository infoRepository;

    public void 게임생성(int scale, String giftName , String giftPhoto, String title){
        Game game = king.witsking.model.Game.builder()
                .title(title)
                .scale(scale)
                .giftname(giftName)
                .giftphoto(giftPhoto)
                .play(false)
                .build();
        gameRepository.save(game);





    }
}
