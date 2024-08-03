package king.witsking.controller.api;

import king.witsking.dto.ResponseDto;
import king.witsking.service.AdminService;
import org.eclipse.jdt.internal.compiler.env.INameEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class AdminApiController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/admin/makegame")
    public String makeGame(int scale,String giftName,String giftPhoto){

        adminService.게임생성(scale,giftName,giftPhoto);
        System.out.println(scale);
        System.out.println(giftName);
        System.out.println(giftPhoto);

        return "redirect:/";

    }
}