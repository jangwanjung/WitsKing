package king.witsking.controller.api;

import king.witsking.dto.ResponseDto;
import king.witsking.repository.UserRepository;
import king.witsking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserApiController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

}

