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
     *
     * 받는건 p_USID 로 받고, 보내는건 MySubscribeListRes 객체를 리스트에 담아서 보내줌
     */
    @PostMapping("/mypage/user/manage")
    public ResponseEntity<List<MySubscribeListRes>> mySubscribeProduct(@RequestBody MySubscribeListReq mySubscribeListReq){
        List<MySubscribeListRes> mySubscribeListRes = userService.mySubscribeList(mySubscribeListReq);
        System.out.println(mySubscribeListReq.getP_USID());
        return new ResponseEntity<>(mySubscribeListRes, HttpStatus.OK);
    }

    /**
     * 구독 해지하기
     * Request -> p_SSID 받아서 UseYN = 'N' 으로 바꿔줌
     */
    @PostMapping("/mypage/user/manage/withdraw")
    public ResponseEntity<?> subscribeWithdraw(@RequestBody SubscribeWithdrawReq subscribeWithdrawReq){
        userService.SubscribeWithdraw(subscribeWithdrawReq);
        HashMap<String,String> msg = new HashMap<>();
        msg.put("message","Success");
        return ResponseEntity.ok(msg);
    }

    @PostMapping("/product/detail/subscribe")
    public ResponseEntity<?> insertSubscribe(@RequestBody SubscribeEnrollReq subscribeEnrollReq) {
        logger.info("usid={}",subscribeEnrollReq.getP_USID());
        logger.info("pdid={}",subscribeEnrollReq.getP_PDID());
        logger.info("sub={}",subscribeEnrollReq.getP_SubscribeCycle());
        if(userService.SubscribeCheck(subscribeEnrollReq).equals("0")){
            userService.SubscribeEnroll(subscribeEnrollReq);
            HashMap<String,String> msg = new HashMap<>();
            msg.put("message","Success");
            return ResponseEntity.ok(msg);
        }else{
            HashMap<String,String> msg = new HashMap<>();
            msg.put("message","Failed");
            return ResponseEntity.ok(msg);
        }
    }

    @PostMapping("/mypage/user/basket/insert")
    public ResponseEntity<?> basketinsert(@RequestBody BasketReq basketReq){
        userService.BasketInsert(basketReq);
        HashMap<String,String> msg = new HashMap<>();
        msg.put("message","Success");
        return ResponseEntity.ok(msg);

    }

    @PostMapping("/mypage/user/basket")
    public ResponseEntity<List<BasketListRes>> basketList(@RequestBody BasketListReq basketListReq){
        List<BasketListRes> basketListRes = userService.showBasketList(basketListReq);
        return new ResponseEntity<>(basketListRes, HttpStatus.OK);

    }

    @PostMapping("/mypage/user/basket/withdraw")
    public ResponseEntity<?> basketWithdraw(@RequestBody BasketWithdrawReq basketWithdrawReq){
        userService.BasketWithdraw(basketWithdrawReq);
        HashMap<String,String> msg = new HashMap<>();
        msg.put("message","Success");
        return ResponseEntity.ok(msg);
    }



}