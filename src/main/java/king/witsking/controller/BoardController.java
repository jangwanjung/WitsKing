package king.witsking.controller;

import king.witsking.service.AdminService;
import king.witsking.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private BoardService boardService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("gameList",boardService.진행중인게임());
        return "index";
    }
}
