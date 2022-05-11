package frontdoorprivacy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    /**
     * 완료! (쓸모가 있을까?)
     */
    @GetMapping
    public String Home(){
        return "/home";
    }

}
