package frontdoorprivacy.mapper;


import frontdoorprivacy.model.user.MyPageUser;
import frontdoorprivacy.model.user.UpdateUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper

public interface UserMapper {
    MyPageUser getUserInfo(int userid);

    void updateUserInfo(UpdateUser updateUser);
}
