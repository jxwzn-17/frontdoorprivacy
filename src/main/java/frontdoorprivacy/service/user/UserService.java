package frontdoorprivacy.service.user;

import frontdoorprivacy.mapper.user.UserMapper;
import frontdoorprivacy.model.product.DetailedProductReq;
import frontdoorprivacy.model.product.DetailedProductRes;
import frontdoorprivacy.model.user.*;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class UserService{

    private static final Marker MESSAGE_MARKER = MarkerFactory.getMarker("USER");
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private static UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    public User getUserInfo(int userid){
        return userMapper.getUserInfo(userid);
    }

    public void updateUserInfo(UpdateUser updateUser){
        userMapper.updateUserInfo(updateUser);
    }

    public void joinUserInfo(JoinUser joinUser){
        userMapper.joinUserInfo(joinUser);
    }

    public UserLoginOutput enLogin(LoginUser loginUser){
        return userMapper.enLogin(loginUser);
    }

    public String checkmultiple(String inputId){
        return userMapper.checkmultiple(inputId);
    }

    public void WithdrawUser(Withdraw withdraw) {
        userMapper.WithdrawUser(withdraw);
    }

    public List<MySubscribeListRes> mySubscribeList(MySubscribeListReq mySubscribeListReq) {
        return userMapper.mySubscribeList(mySubscribeListReq);
    }

    public void SubscribeWithdraw(SubscribeWithdrawReq subscribeWithdrawReq) {
        userMapper.SubscribeWithdraw(subscribeWithdrawReq);
    }

    public void SubscribeEnroll(SubscribeEnrollReq subscribeEnrollReq){
        userMapper.SubscribeEnroll(subscribeEnrollReq);
    }

    public String SubscribeCheck(SubscribeEnrollReq subscribeEnrollReq) {
        return userMapper.SubscribeCheck(subscribeEnrollReq);
    }

    public List<BasketListRes> showBasketList(BasketListReq basketListReq){
        return userMapper.showBasketList(basketListReq);
    }

    public void BasketInsert(BasketReq basketReq) {
        userMapper.BasketInsert(basketReq);
    }

}