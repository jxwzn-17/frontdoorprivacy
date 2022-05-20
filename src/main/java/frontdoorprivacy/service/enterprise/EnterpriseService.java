package frontdoorprivacy.service.enterprise;

import frontdoorprivacy.mapper.enterprise.EnterpriseMapper;
import frontdoorprivacy.mapper.user.UserMapper;
import frontdoorprivacy.model.enterprise.Enterprise;
import frontdoorprivacy.model.enterprise.LoginEnterprise;
import frontdoorprivacy.model.user.LoginOutput;
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
    public LoginOutput enLogin(LoginEnterprise loginEnterprise){return enterpriseMapper.enLogin(loginEnterprise);}

}
