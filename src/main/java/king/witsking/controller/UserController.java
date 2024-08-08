package king.witsking.controller;

import king.witsking.config.auth.PrincipalDetail;
import king.witsking.dto.ResponseDto;
import king.witsking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/login")
    public String login(){
        return "user/login";

    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/user/join")
    public String join(){
        return "user/join";

    }

    @PostMapping("/user/join")
    public String join(String username, String nickname) {
        userService.saveUser(username,nickname);
        return "index";
    }

    @GetMapping("/gift")
    public String gift(Model model){

        model.addAttribute("gifts",userService.선물내역());

        return "user/gift";
    }


}
