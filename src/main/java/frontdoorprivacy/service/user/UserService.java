package frontdoorprivacy.service.user;

import frontdoorprivacy.mapper.user.UserMapper;
import frontdoorprivacy.model.user.JoinUser;
import frontdoorprivacy.model.user.User;
import frontdoorprivacy.model.user.UpdateUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService{
    private static final Marker MESSAGE_MARKER = MarkerFactory.getMarker("USER");
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private static UserMapper userMapper;



    @Autowired
    public UserService(UserMapper userMapper){this.userMapper = userMapper;}

    public User getUserInfo(int userid){return userMapper.getUserInfo(userid);}

    public void updateUserInfo(UpdateUser updateUser){
        userMapper.updateUserInfo(updateUser);
    }

    public void joinUserInfo(JoinUser joinUser){
        userMapper.joinUserInfo(joinUser);
    }
}