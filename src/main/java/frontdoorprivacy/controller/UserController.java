package frontdoorprivacy.controller;

import frontdoorprivacy.model.user.*;
import frontdoorprivacy.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;


@Controller
@RequestMapping
public class UserController{
    private Logger logger = LoggerFactory.getLogger(UserController.class);
    private static UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;

    }

    /**
     * 마이페이지에 값 띄워주기 5월 24일 수정본
     */
    @PostMapping("/mypage/user/profile")
    public ResponseEntity<User> info(@RequestBody UserLoginOutput userLoginOutput) {

        User userInfo = userService.getUserInfo(userLoginOutput.getEnid());

        return new ResponseEntity<>(userInfo, HttpStatus.OK);
    }

//    /**
//     * 마이페이지 5월 24일 수정전 원본
//     */
//    @GetMapping("/user/{userID}")
//    public ResponseEntity<User> info(@PathVariable int userID) {
//
//        User userInfo = userService.getUserInfo(userID);
//
//        return new ResponseEntity<>(userInfo,HttpStatus.OK);
//    }

    /**
     * 5월 24일 수정 - PathVariable 삭제
     * 마이페이지에서 수정해준 값을 받아와서 다시 넘겨주기
     */
    @PostMapping("/mypage/user/edit")
    public ResponseEntity<UpdateUser> update(@RequestBody User user){

        UpdateUser founduser = new UpdateUser();


        founduser.setId(user.getId());
        founduser.setP_UserId(user.getUserId());
        founduser.setP_Email(user.getEmail());
        founduser.setP_Password(user.getPassword());
        founduser.setP_PhoneNumber(user.getPhoneNumber());

        userService.updateUserInfo(founduser);

        return new ResponseEntity<>(founduser, HttpStatus.OK);
    }

    @PostMapping("/register/user")
    public ResponseEntity<?> join(@RequestBody JoinUser joinUser){

        userService.joinUserInfo(joinUser);

        HashMap<String,String> msg = new HashMap<>();
        msg.put("message","Success");
        return ResponseEntity.ok(msg);
    }

    /**
     * 중복성 검사
     */
    @PostMapping("/register/check")
    public ResponseEntity<?> check(@RequestBody HashMap<String,String> userID){
        String output;
        HashMap<String,String> returnvalue = new HashMap<>();
        output = userService.checkmultiple(userID.get("inputId"));
        logger.info(output);
        logger.info(userID.get("inputId"));
        returnvalue.put("returnvalue",output);

        return ResponseEntity.ok(returnvalue);
    }

    /**
     * 회원탈퇴
     */
    @PostMapping("/mypage/user/withdraw")
    public ResponseEntity<?> deleteUser(@RequestBody Withdraw withdraw) {
        userService.WithdrawUser(withdraw);
        HashMap<String,String> msg = new HashMap<>();
        msg.put("message","Success");
        return ResponseEntity.ok(msg);
    }

    /**
     * 장바구니 값 받아서 띄워주기
     */

    //확인 한번 해봐 프로시저랑 테이블 매칭은 아직이야... 철진아 이따가 포스트맨 사용해서 값넘어가는지 같이 확인하자
    //시간 될때 코드 한번 봐줘, 개인 로그인 한담에 상품을 장바구니에 넣었을 때, Basket 클래스로 넘어가서 값을 뿌려준다.
    // 마이페이지 장바구니 클릭시 확인

    @PostMapping("/mypage/user/basket")
    public ResponseEntity<Basket> basketUser(@RequestBody Basket basket) {
        Basket basketInfo = userService.showBasket(basket.getB_PDID());
        HashMap<String,String> msg = new HashMap<>();
        msg.put("message","Success");
        return new ResponseEntity<>(basketInfo, HttpStatus.OK);
    }




}


