package frontdoorprivacy.service.user;

import frontdoorprivacy.mapper.UserMapper;
import frontdoorprivacy.model.user.MyPageUser;
import frontdoorprivacy.model.user.UpdateUser;
import frontdoorprivacy.model.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//public interface UserService {
//
//    User join(User user);
//
//    User findOne(long id);
//
//    void update(long id, User updateUser);
//
//}
@Service
public class UserService{
    private static final Marker MESSAGE_MARKER = MarkerFactory.getMarker("USER");
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private static UserMapper userMapper;



    @Autowired
    public UserService(UserMapper userMapper){this.userMapper = userMapper;}

    public MyPageUser getUserInfo(int userid){return userMapper.getUserInfo(userid);}

    public void updateUserInfo(UpdateUser updateUser){
        userMapper.updateUserInfo(updateUser);
    }
}