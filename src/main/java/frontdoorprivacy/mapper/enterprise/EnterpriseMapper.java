package frontdoorprivacy.mapper.enterprise;

import frontdoorprivacy.model.enterprise.Enterprise;
import frontdoorprivacy.model.enterprise.LoginEnterprise;
import frontdoorprivacy.model.enterprise.MyEnterpriseInfo;
import frontdoorprivacy.model.enterprise.UpdateEnterprise;
import frontdoorprivacy.model.user.LoginOutput;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Repository
@Mapper

public interface EnterpriseMapper {

    //회원가입
    void createEnterprise(Enterprise enterprise);
    String checkmultiple(String enterpriseId);
    LoginOutput enLogin(LoginEnterprise loginEnterprise);

    MyEnterpriseInfo getEnterpriseInfo(int id);
    void updateEnterpriseInfo(UpdateEnterprise updateEnterprise);

}
