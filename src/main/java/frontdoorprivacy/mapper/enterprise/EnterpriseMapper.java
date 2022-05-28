package frontdoorprivacy.mapper.enterprise;

import frontdoorprivacy.model.enterprise.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Repository
@Mapper

public interface EnterpriseMapper {

    //회원가입
    void createEnterprise(Enterprise enterprise);
    String checkmultiple(String enterpriseId);
    EnterpriseLoginOutput enLogin(LoginEnterprise loginEnterprise);

    //마이페이지
    MyEnterpriseInfo getEnterpriseInfo(int id);
    void updateEnterpriseInfo(UpdateEnterprise updateEnterprise);
    void deleteEnterpriseInfo(int id);
}
