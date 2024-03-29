package frontdoorprivacy.mapper.user;


import frontdoorprivacy.model.find.FindIdReq;
import frontdoorprivacy.model.find.FindPwReq;
import frontdoorprivacy.model.find.UpdatePwReq;
import frontdoorprivacy.model.product.CategoryProduct;
import frontdoorprivacy.model.product.DetailedProductReq;
import frontdoorprivacy.model.product.DetailedProductRes;
import frontdoorprivacy.model.user.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {

    User getUserInfo(int userid);
    void updateUserInfo(UpdateUser updateUser);
    void joinUserInfo(JoinUser joinUser);
    UserLoginOutput enLogin(LoginUser loginUser);
    String checkmultiple(String inputId);
    void WithdrawUser(Withdraw withdraw);
    List<MySubscribeListRes> mySubscribeList(MySubscribeListReq mySubscribeListReq);
    void SubscribeWithdraw(SubscribeWithdrawReq subscribeWithdrawReq);
    void SubscribeEnroll(SubscribeEnrollReq subscribeEnrollReq);

    String SubscribeCheck(SubscribeEnrollReq subscribeEnrollReq);

    List<BasketProduct> showBasketList(int basketListReq);

    void BasketInsert(BasketReq basketReq);

    void BasketWithdraw(BasketWithdrawReq basketWithdrawReq);


    void FindId(FindIdReq findIdReq);
    void FindPw(FindPwReq findPwReq);
    void UpdatePw(UpdatePwReq updatePwReq);
}
