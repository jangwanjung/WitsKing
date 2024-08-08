package king.witsking.service;

import king.witsking.model.Game;
import king.witsking.model.Gift;
import king.witsking.model.Info;
import king.witsking.model.User;
import king.witsking.repository.GameRepository;
import king.witsking.repository.GiftRepository;
import king.witsking.repository.InfoRepository;
import king.witsking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AdminService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private InfoRepository infoRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GiftRepository giftRepository;

    @Transactional
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

    @Transactional
    public void 상품보내기(String username, String giftName, String giftPhoto){
        Gift gift = Gift.builder()
                .username(username)
                .giftName(giftName)
                .giftPhoto(giftPhoto)
                .build();
        giftRepository.save(gift);
    }
}
