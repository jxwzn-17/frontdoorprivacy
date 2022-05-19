package frontdoorprivacy.mapper.enterprise;

import frontdoorprivacy.model.enterprise.Enterprise;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Repository
@Mapper

public interface EnterpriseMapper {

    //회원가입
    void createEnterprise(Enterprise enterprise);
    String checkmultiple(String enterpriseId);

}
