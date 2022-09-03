package frontdoorprivacy.controller;


import frontdoorprivacy.model.enterprise.Checkcompany;
import frontdoorprivacy.model.enterprise.Enterprise;
import frontdoorprivacy.model.enterprise.EnterpriseLoginOutput;
import frontdoorprivacy.model.enterprise.LoginEnterprise;
import frontdoorprivacy.model.user.LoginInfo;

import frontdoorprivacy.model.user.LoginUser;
import frontdoorprivacy.model.user.UserLoginOutput;
import frontdoorprivacy.service.enterprise.EnterpriseService;
import frontdoorprivacy.service.user.UserService;
import okhttp3.*;
import org.json.simple.JSONObject;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping
public class RegisterController {
    private Logger logger = LoggerFactory.getLogger(RegisterController.class);
    private static EnterpriseService enterpriseService;
    private static UserService userService;
    final String api = "cKqwuJwD4dWpxAOJgZb4NX1o4sv1SfX4OI2nsejYBiHT%2BJLkNYjTx2BB2vhnkiotIWw34cusHY186hxqAIpqjg%3D%3D";
    @Autowired
    public RegisterController(EnterpriseService enterpriseService, UserService userService) {
        this.enterpriseService = enterpriseService;
        this.userService = userService;
    }

    //회원가입
    @PostMapping("/register/company")
    public ResponseEntity<?> create(@RequestBody Enterprise enterprise){

        HashMap<String,String> msg = new HashMap<>();

        logger.info(enterprise.getEnterpriseName());
        logger.info(enterprise.getEnterpriseNumber());
        logger.info(enterprise.getEnterpriseId());

        enterpriseService.createEnterprise(enterprise);
        msg.put("message","Success");
        return ResponseEntity.ok(msg);

    }

    // 아이디 중복성 검사
    @PostMapping("/register/company/check")
    public ResponseEntity<?> check(@RequestBody HashMap<String,String> enterpriseID){
        String output;
        HashMap<String,String> returnvalue = new HashMap<>();
        output = enterpriseService.checkmultiple(enterpriseID.get("enterpriseId"));
//       logger.info(output);
        returnvalue.put("returnvalue",output);

       return ResponseEntity.ok(returnvalue);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginInfo loginInfo){
        EnterpriseLoginOutput output = new EnterpriseLoginOutput();
        UserLoginOutput userLoginOutput = new UserLoginOutput();
//        logger.info(loginInfo.getRole());
//        logger.info(loginInfo.getUserId());
//        logger.info(loginInfo.getPassword());




        if(loginInfo.getRole().equals("E")){
//           logger.info("if문 입장");
            LoginEnterprise input = new LoginEnterprise();
            input.setUserId(loginInfo.getUserId());
            input.setPw(loginInfo.getPassword());
            output = enterpriseService.enLogin(input);

            return new ResponseEntity<>(output, HttpStatus.OK);
        }else{
            //유저 로그인
            LoginUser loginUser = new LoginUser();
            logger.info("else 문 입장");
            loginUser.setInputId(loginInfo.getUserId());
            loginUser.setPw(loginInfo.getPassword());
            userLoginOutput = userService.enLogin(loginUser);

            return new ResponseEntity<>(userLoginOutput, HttpStatus.OK);
        }


    }

    @PostMapping("/register/company/auth")
    public ResponseEntity<?> check(@RequestBody Checkcompany checkcompany){

        HashMap<String,String> returnvalue = new HashMap<>();
        //진위여부 확인 코드
        String a = getCompanyNum(checkcompany,api);
        //성공이면 보내줄 것
        logger.info("msg: "+ a);
        if(enterpriseService.cntEnterpriseNumber(checkcompany.getEnterpriseNumber())>0){
            logger.info("중복");
            returnvalue.put("message","Duplicate");
        }else if(enterpriseService.cntEnterpriseNumber(checkcompany.getEnterpriseNumber())==0) {
            String[] ang = a.split("data");
            if ((ang[1].split(",")[1]).equals("\"b_stt\":\"계속사업자\"")) {
                returnvalue.put("message", "Success");
                logger.info("두번째 if문 입장");
            } else {
                returnvalue.put("message", "Error");
                logger.info("두번째 else문 입장");
            }
        }

        return ResponseEntity.ok(returnvalue);
    }
    public static String getCompanyNum(Checkcompany checkcompany, String apiKey) {
        //resttemplate통신이 안되서 okhttp3으로 통신
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        //요청형식이 json 배열임
        List<String> companynum = new ArrayList<>();
        companynum.add(checkcompany.getEnterpriseNumber());



        JSONObject requestBody=new JSONObject();
        requestBody.put("b_no",companynum);

        okhttp3.RequestBody body = okhttp3.RequestBody.create(requestBody.toString(),mediaType);

        Request request = new Request.Builder()
                .url("http://api.odcloud.kr/api/nts-businessman/v1/status?serviceKey="+apiKey)
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();
        //결과 탐색
        try {
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (Exception e) {

            return e.getMessage();
        }
    }

}
