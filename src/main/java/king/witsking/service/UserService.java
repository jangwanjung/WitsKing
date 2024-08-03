package king.witsking.service;

import king.witsking.config.auth.PrincipalDetail;
import king.witsking.model.User;
import king.witsking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private HttpSession httpSession;

    @Transactional
    public boolean findUser(String username){
        User user = userRepository.findByUsername(username).orElse(null);
        System.out.println(333333333);
        //만약 없으면
        if (user == null){
            System.out.println(1111111);
            return false;
        }
        //만약 존재하면
        else {
            System.out.println(222222);
            return true;
        }

    }
    @Transactional
    public void saveUser(String username,String nickname){
        User user = User.builder()
                .username(username)
                .nickname(nickname)
                .build();
        userRepository.save(user);

    }

    @Transactional
    public void sessionSave(String username){
        User user = userRepository.findByUsername(username).orElseThrow(()->{
            return new IllegalArgumentException("해당유저를 찾을수없습니다");
        });
        PrincipalDetail updatedPrincipalDetail = new PrincipalDetail(user);
        // 새로운 Authentication 객체 생성
        Authentication newAuth = new UsernamePasswordAuthenticationToken(user.getUsername(), updatedPrincipalDetail);
        // SecurityContextHolder에 새로운 Authentication 객체 설정
        SecurityContextHolder.getContext().setAuthentication(newAuth);
    }
}
