package frontdoorprivacy.controller;

import frontdoorprivacy.domain.MyPageUser;
import frontdoorprivacy.domain.Role;
import frontdoorprivacy.domain.User;
import frontdoorprivacy.service.UserService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 임시 데이터 넣어준것임
     */
    //Role role, String userName, String birth, String phoneNumber, String userId,
    //                String password, String email
    @PostConstruct
    public void init() {
        userService.join(new User(Role.Basic,"양철진", "123","123","userA","123","gra"));

    }



    @ResponseBody
    @PostMapping("/mypage/user/edit")
    public ResponseEntity<User> UserMyPage(@RequestBody MyPageUser user) {

        User founduser = userService.findOne(user.getUserId());
        founduser.setEmail(user.getEmail());
        founduser.setBirth(user.getBirth());
        founduser.setUserName(user.getUserName());
        founduser.setPhoneNumber(user.getPhoneNumber());

        log.info("email={},birth={},phoneNumber={},userName={},userId={}",user.getEmail(),user.getBirth(),user.getPhoneNumber(),user.getUserName(),user.getUserId());

        return new ResponseEntity<User>(founduser,HttpStatus.OK);
    }


}
