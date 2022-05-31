package frontdoorprivacy.mapper.user;


import frontdoorprivacy.model.user.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {
    User getUserInfo(int userid);
    void updateUserInfo(UpdateUser updateUser);
    void joinUserInfo(JoinUser joinUser);
    UserLoginOutput enLogin(LoginUser loginUser);
    String checkmultiple(String inputId);
    void WithdrawUser(Withdraw withdraw);
    Basket showBasket(int B_PDID);
}
