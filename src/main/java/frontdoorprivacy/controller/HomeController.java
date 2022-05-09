package frontdoorprivacy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    /**
     * 완료!
     */
    @GetMapping
    public String Home(){
        return "/home";
    }

}
