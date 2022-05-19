package frontdoorprivacy.controller;


import frontdoorprivacy.model.enterprise.Enterprise;
import frontdoorprivacy.service.enterprise.EnterpriseService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;

import java.util.HashMap;

@Controller
@RequestMapping
public class RegisterController {
    private Logger logger = LoggerFactory.getLogger(RegisterController.class);
    private static EnterpriseService enterpriseService;


    @Autowired
    public RegisterController(EnterpriseService enterpriseService) {
        this.enterpriseService = enterpriseService;
    }

    //회원가입
    @PostMapping("/register/company")
    public void create(@RequestBody Enterprise enterprise){
        logger.info(enterprise.getEnterpriseName());
        logger.info(enterprise.getEnterpriseNumber());
        logger.info(enterprise.getEnterpriseId());

        enterpriseService.createEnterprise(enterprise);

    }

    @PostMapping("/register/company/check")
    public String check(@RequestBody HashMap<String,String> enterpriseID){
        String output;

       output = enterpriseService.checkmultiple(enterpriseID.get("enterpriseId"));
       logger.info(output);

       return output;
    }
}
