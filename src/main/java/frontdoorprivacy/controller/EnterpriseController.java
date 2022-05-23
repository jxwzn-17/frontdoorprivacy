package frontdoorprivacy.controller;

import frontdoorprivacy.model.enterprise.MyEnterpriseInfo;
import frontdoorprivacy.model.enterprise.UpdateEnterprise;
import frontdoorprivacy.model.user.UpdateUser;
import frontdoorprivacy.model.user.User;
import frontdoorprivacy.service.enterprise.EnterpriseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.slf4j.LoggerFactory;

import java.util.HashMap;

@Controller
@RequestMapping("/mypage/company")
public class EnterpriseController {
    private Logger logger = LoggerFactory.getLogger(EnterpriseController.class);
    private static EnterpriseService enterpriseService;

    @Autowired
    public EnterpriseController(EnterpriseService enterpriseService){this.enterpriseService= enterpriseService;}

    @GetMapping("/profile")
    public ResponseEntity<MyEnterpriseInfo> info(@PathVariable int userID) {

        MyEnterpriseInfo myEnterpriseInfo = enterpriseService.getEnterpriseInfo(userID);

         return new ResponseEntity<MyEnterpriseInfo>(myEnterpriseInfo,HttpStatus.OK);
    }

    @PostMapping("/profile/edit")
    public ResponseEntity<?> update(@RequestBody UpdateEnterprise updateEnterprise){

        HashMap<String, String> msg = new HashMap<>();
        enterpriseService.updateEnterpriseInfo(updateEnterprise);

        msg.put("message","Success");
        return ResponseEntity.ok(msg);
    }
}
