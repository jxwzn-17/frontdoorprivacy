package frontdoorprivacy.controller;

import frontdoorprivacy.domain.User;
import frontdoorprivacy.service.UserService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

/**
 * 5월 3일 구현 시작
 * 5월 9일에 생각한것 : 리액트라서 반환값으로 html 경로처럼 해주면 안되는것. 따라서 json 형식으로 반환해줘야함.
 */
@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 1. 회원가입
     * 2. 마이페이지
     * 3. 로그인
     */

    /**
     * 임시 데이터 넣어준것임
     */
    @PostConstruct
    public void init() {
        userService.join(new User("양철진","980404","01054012473","UserA","gra1259@naver.com"));

    }

    @ResponseBody
    @PostMapping("/mypage/user/edit")
    public ResponseEntity<User> UserMyPage(@RequestBody User user) {

        User founduser = userService.findOne(user.getUserId());
        founduser.setEmail(user.getEmail());
        founduser.setBirth(user.getBirth());
        founduser.setEmail(user.getEmail());
        founduser.setPhoneNumber(user.getPhoneNumber());

        return new ResponseEntity<>(founduser, HttpStatus.OK);
    }


}
