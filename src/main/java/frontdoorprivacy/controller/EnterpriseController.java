package frontdoorprivacy.controller;

import frontdoorprivacy.model.enterprise.MyEnterpriseInfo;
import frontdoorprivacy.model.enterprise.UpdateEnterprise;
import frontdoorprivacy.service.enterprise.EnterpriseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;

@Controller
@RequestMapping("/mypage/company")
public class EnterpriseController {
    private Logger logger = LoggerFactory.getLogger(EnterpriseController.class);
    private static EnterpriseService enterpriseService;

    @Autowired
    public EnterpriseController(EnterpriseService enterpriseService){this.enterpriseService= enterpriseService;}

    @PostMapping("/profile")
    public ResponseEntity<MyEnterpriseInfo> info(@RequestBody HashMap<String,Integer> companyinfo) {

        logger.info(String.valueOf(companyinfo.get("enid")));
        MyEnterpriseInfo myEnterpriseInfo = enterpriseService.getEnterpriseInfo(companyinfo.get("enid"));

         return new ResponseEntity<MyEnterpriseInfo>(myEnterpriseInfo,HttpStatus.OK);
    }

    @PostMapping("/edit/get")
    public ResponseEntity<MyEnterpriseInfo> edit(@RequestBody HashMap<String,Integer> companyinfo) {

        logger.info(String.valueOf(companyinfo.get("enid")));
        MyEnterpriseInfo myEnterpriseInfo = enterpriseService.getEnterpriseInfo(companyinfo.get("enid"));

        return new ResponseEntity<MyEnterpriseInfo>(myEnterpriseInfo,HttpStatus.OK);
    }

    @PostMapping("/edit")
    public ResponseEntity<?> update(@RequestBody UpdateEnterprise updateEnterprise){

        HashMap<String, String> msg = new HashMap<>();
        logger.info(updateEnterprise.getE_bankname());
        logger.info(updateEnterprise.getE_name());
        logger.info(updateEnterprise.getE_password());

        enterpriseService.updateEnterpriseInfo(updateEnterprise);

        msg.put("message","Success");
        return ResponseEntity.ok(msg);
    }

    @PostMapping("/withdraw")
    public ResponseEntity<?> delete(@RequestBody HashMap<String, Integer> id){
//        logger.info();
        HashMap<String, String> msg = new HashMap<>();
        enterpriseService.deleteEnterpriseInfo(id.get("enid"));

        msg.put("message","Success");
        return ResponseEntity.ok(msg);
    }
}
