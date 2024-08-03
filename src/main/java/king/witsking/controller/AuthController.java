package king.witsking.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import king.witsking.config.auth.PrincipalDetail;
import king.witsking.model.KakaoOAuthToken;
import king.witsking.model.KakaoProfile;
import king.witsking.model.User;
import king.witsking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;


@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @Value("${password}")
    private String password;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private HttpSession httpSession;

    @GetMapping("/oauth/kakao/callback")
    public String kakaoCallback(String code, Model model) {
        RestTemplate rt = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type","application/x-www-form-urlencoded");
        MultiValueMap<String, String> param = new LinkedMultiValueMap<>();
        param.add("grant_type","authorization_code");
        param.add("client_id","ac7aa397c0dd823feac44c965b8da082");
        param.add("redirect_uri","http://localhost:8000/oauth/kakao/callback");
        param.add("code",code);
        HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest = new HttpEntity<>(param, headers);
        ResponseEntity<String> response = rt.exchange(
                "https://kauth.kakao.com/oauth/token",
                HttpMethod.POST,
                kakaoTokenRequest,
                String.class
        );
        ObjectMapper objectMapper = new ObjectMapper();
        KakaoOAuthToken oauthTokenKakao = null;
        try {
            oauthTokenKakao = objectMapper.readValue(response.getBody(), KakaoOAuthToken.class);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        RestTemplate rt2 = new RestTemplate();
        HttpHeaders headers2 = new HttpHeaders();
        headers2.add("Content-type","application/x-www-form-urlencoded;charset=utf-8");
        headers2.add("Authorization","Bearer "+ oauthTokenKakao.getAccess_token());
        HttpEntity<MultiValueMap<String,String>> kakaoProfileRequest2 = new HttpEntity<>(headers2);
        ResponseEntity<String> respones2 = rt2.exchange(
                //post요청주소
                "https://kapi.kakao.com/v2/user/me",
                //http메소드
                HttpMethod.POST,
                //보낼값
                kakaoProfileRequest2,
                String.class
        );
        ObjectMapper objectMapper2 = new ObjectMapper();
        KakaoProfile kakaoProfile = null;
        try {
            kakaoProfile = objectMapper2.readValue(respones2.getBody(), KakaoProfile.class);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        String username = kakaoProfile.getProperties().getNickname()+"_"+kakaoProfile.getId();


        User kakaoUser = User.builder()
                .username(username)
                .build();
        boolean exist = userService.findUser(kakaoUser.getUsername());  //존재하면 exist == ture 없으면 ==false
        if(exist == false) {
            model.addAttribute("kakaoUser",kakaoUser);
            System.out.println("못찾음");
            return "user/join";
        }
        userService.sessionSave(username);
        return "index";
    }
}
