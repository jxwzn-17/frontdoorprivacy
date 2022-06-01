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
import java.util.List;


@Controller
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
     * 내가 구독한 상품 띄워주기
     *
     * 로직 - 유저의 usid 받아와서 sql문을 이용하여 내가 구독한 상품의 리스트를 받아올것임.
     */
    @PostMapping("/mypage/user/manage/list")
    public ResponseEntity<List<MySubscribeListRes>> mySubscribeProduct(@RequestBody MySubscribeListReq mySubscribeListReq){
        List<MySubscribeListRes> mySubscribeListRes = userService.mySubscribeList(mySubscribeListReq);
        System.out.println(mySubscribeListReq.getP_USID());
        return new ResponseEntity<>(mySubscribeListRes, HttpStatus.OK);
    }

}


