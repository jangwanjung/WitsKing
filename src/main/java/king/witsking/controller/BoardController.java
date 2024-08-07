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
        return "index";
    }

    @GetMapping("/table/{id}")
    public String table(@PathVariable int id, Model model) {
        model.addAttribute("game",boardService.게임(id));
        model.addAttribute("cnt",boardService.참여자수(id));
        return "/board/table";
    }

    @GetMapping("/history")
    public String history(Model model) {
        model.addAttribute("games",boardService.진행중인게임());
        return "/board/history";
    }

    @GetMapping("/history/table/{id}")
    public String adminTable(Model model, @PathVariable int id) {
        model.addAttribute("game",boardService.게임(id));
        model.addAttribute("usersCnt",boardService.실시간참여자수(id));
        model.addAttribute("users",boardService.실시간참여자(id));
        return "board/result";
    }


}
