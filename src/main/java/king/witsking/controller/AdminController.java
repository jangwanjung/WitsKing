package king.witsking.controller;

import king.witsking.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AdminController {

    @Autowired
    private BoardService boardService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/admin")
    public String adminPage(Model model) {
        model.addAttribute("games",boardService.진행중인게임());
        model.addAttribute("cnts",boardService.메인참여자수());
        return "admin/main";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/admin/table/{id}")
    public String adminTable(Model model, @PathVariable int id) {
        model.addAttribute("game",boardService.게임(id));
        model.addAttribute("usersCnt",boardService.실시간참여자수(id));
        model.addAttribute("users",boardService.실시간참여자(id));
        return "admin/table";
    }

}
