package frontdoorprivacy.service.enterprise;

import frontdoorprivacy.mapper.enterprise.EnterpriseMapper;
import frontdoorprivacy.mapper.user.UserMapper;
import frontdoorprivacy.model.enterprise.*;

import frontdoorprivacy.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnterpriseService {
    private static final Marker MESSAGE_MARKER = MarkerFactory.getMarker("ENTERPRISE");
    private static final Logger logger = LoggerFactory.getLogger(EnterpriseService.class);
    private static EnterpriseMapper enterpriseMapper;

    @Autowired
    public EnterpriseService(EnterpriseMapper enterpriseMapper){ this.enterpriseMapper = enterpriseMapper;}

    public void createEnterprise(Enterprise enterprise){
        enterpriseMapper.createEnterprise(enterprise);
    }

    public String checkmultiple(String enterpriseId){ return enterpriseMapper.checkmultiple(enterpriseId);}
    public EnterpriseLoginOutput enLogin(LoginEnterprise loginEnterprise){return enterpriseMapper.enLogin(loginEnterprise);}

    //마이페이지
    public MyEnterpriseInfo getEnterpriseInfo(int id){ return enterpriseMapper.getEnterpriseInfo(id);}
    public void updateEnterpriseInfo(UpdateEnterprise updateEnterprise){enterpriseMapper.updateEnterpriseInfo(updateEnterprise);}
    public void deleteEnterpriseInfo(int id){enterpriseMapper.deleteEnterpriseInfo(id);}
}
