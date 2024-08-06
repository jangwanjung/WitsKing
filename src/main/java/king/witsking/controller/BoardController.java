package king.witsking.controller;

import king.witsking.service.AdminService;
import king.witsking.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BoardController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private BoardService boardService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("games",boardService.진행중인게임());
        model.addAttribute("cnts",boardService.메인참여자수());
        return "index";
    }

    @GetMapping("/table/{id}")
    public String table(@PathVariable int id, Model model) {
        model.addAttribute("game",boardService.게임(id));
        model.addAttribute("cnt",boardService.참여자수(id));
        return "/board/table";
    }


}
