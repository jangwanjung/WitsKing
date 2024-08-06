package king.witsking.controller.api;

import king.witsking.dto.ResponseDto;
import king.witsking.model.Game;
import king.witsking.model.User;
import king.witsking.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardApiController {

    @Autowired
    private BoardService boardService;

    @PostMapping("/board/table")
    public ResponseDto<Integer> selectTable(@RequestParam int num, @RequestParam int gameId, @RequestParam int userId) {
        System.out.println(num);
        System.out.println(gameId);
        System.out.println(userId);

        boardService.등록(num, gameId, userId);


        return new ResponseDto<Integer>(HttpStatus.OK.value(),1);

    }
}
