package frontdoorprivacy.service.user;

import frontdoorprivacy.mapper.user.UserMapper;
import frontdoorprivacy.model.user.*;


import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class UserService{

    private static final Marker MESSAGE_MARKER = MarkerFactory.getMarker("USER");
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private static UserMapper userMapper;

    @Autowired
    private SqlSession sqlSession;


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

    public MySubscribeListRes mySubscribeList(MySubscribeListReq mySubscribeListReq) {
        return userMapper.mySubscribeList(mySubscribeListReq);
    }
}