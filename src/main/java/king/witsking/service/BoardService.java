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
import java.util.*;

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
        Game game = gameRepository.findById(gameId).orElseThrow(()->{
            return new IllegalArgumentException("게임을 찾을수없습니다");
        });
        if(game.isPlay()==false){
            Info info = Info.builder()
                    .gameId(gameId)
                    .username(user.getUsername())
                    .nickname(user.getNickname())
                    .number(num)
                    .build();
            infoRepository.save(info);
            game.setPeople(game.getPeople() + 1);
            if(game.getPeople()==game.getScale()){
                game.setPlay(true);
                //당첨자 알고리즘
                List<Info> infos = infoRepository.findByGameId(gameId);
                List<Integer> nums = new ArrayList<>();
                for(Info i : infos){
                    nums.add(i.getNumber());
                }

                // 숫자의 빈도를 저장할 Map 생성
                Map<Integer, Integer> frequencyMap = new HashMap<>();

                // 배열의 각 숫자의 빈도를 계산
                for (int number : nums) {
                    frequencyMap.put(number, frequencyMap.getOrDefault(number, 0) + 1);
                }

                // 빈도가 1인 숫자들 중 가장 작은 숫자를 찾음
                int winnerNum = Integer.MAX_VALUE;
                boolean found = false;
                String winnerUsername = null;
                for (int number : nums) {
                    if (frequencyMap.get(number) == 1 && number < winnerNum) {
                        winnerNum = number;
                        found = true;
                    }
                }
                if(found == false){
                    game.setWinner(null);
                }
                else{
                    for(Info i : infos){
                        if(i.getNumber()==winnerNum){
                            winnerUsername = i.getUsername();
                            break;
                        }
                    }
                    game.setWinner(winnerUsername);

                }
                System.out.println("우승자: "+winnerUsername);
                System.out.println("우승번호: "+winnerNum);
                // 결과 출력

                /*List<Integer> nums = new ArrayList<>();
                for(Info i : infos){
                    nums.add(i.getNumber());
                }
                Collections.sort(nums); //오름차순
                int winnerNum = 0;
                for(int i=0;i<nums.size()-1;i++){
                    if(nums.get(i)!=nums.get(i+1)){
                        winnerNum = nums.get(i);
                        break;
                    }
                }
                String winnerUsername = null;
                for(Info i : infos){
                    if(i.getNumber()==winnerNum){
                        winnerUsername = i.getUsername();
                    }
                }*/



            }
        }


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
