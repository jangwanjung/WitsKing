package king.witsking.service;

import king.witsking.model.Game;
import king.witsking.model.Info;
import king.witsking.model.User;
import king.witsking.repository.GameRepository;
import king.witsking.repository.InfoRepository;
import king.witsking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class BoardService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private InfoRepository infoRepository;
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public List<Game> 진행중인게임() {
        return gameRepository.findAll();
    }
    @Transactional
    public Game 게임(int gameId){
        Game game = gameRepository.findById(gameId).orElseThrow(()->{
            return new IllegalArgumentException("게임을 찾을수 없습니다");
        });
        return game;
    }

    @Transactional
    public int scale(int gameId){
        Game game = gameRepository.findById(gameId).orElseThrow(()->{
            return new IllegalArgumentException("게임을 찾을수없습니다");
        });

        return game.getScale();
    }

    @Transactional
    public void 등록(int num, int  gameId, int userId){
        User user = userRepository.findById(userId).orElseThrow(()->{
            return new IllegalArgumentException("유저를찾을수없습니다");
        });
        System.out.println(111111);
        Info info = Info.builder()
                .gameId(gameId)
                .username(user.getUsername())
                .nickname(user.getNickname())
                .number(num)
                .build();
        infoRepository.save(info);
        Game game = gameRepository.findById(gameId).orElseThrow(()->{
            return new IllegalArgumentException("게임을 찾을수없습니다");
        });
        game.setPeople(game.getPeople() + 1);

    }

    @Transactional
    public int 참여자수(int gameId){
        int cnt = infoRepository.countByGameId(gameId);
        return cnt;
    }

    @Transactional
    public List<Integer> 메인참여자수(){
        List<Integer> gamesId = gameRepository.findGameIdsWherePlayIsFalse();
        List<Integer> cnt = new ArrayList<>();
        for (Integer gameId : gamesId) {
            // gameId를 사용하는 코드 작성
            cnt.add(참여자수(gameId));
        }
        return cnt;
    }

    @Transactional
    public int[] 실시간참여자수(int gameId){
        Game game = gameRepository.findById(gameId).orElseThrow(()->{
            return new IllegalArgumentException("해당게임을 찾을수없습니다");
        });
        int [] arr  = new int [game.getScale()];

        List<Info> infos = infoRepository.findByGameId(gameId);
        for (Info info : infos) {
            arr[info.getNumber()-1]++;

        }
        return arr;

    }

    @Transactional
    public List<Info> 실시간참여자(int gameId){
        Game game = gameRepository.findById(gameId).orElseThrow(()->{
            return new IllegalArgumentException("해당게임을 찾을수없습니다");
        });

        List<Info> infos = infoRepository.findByGameId(gameId);
        return infos;

    }
}
