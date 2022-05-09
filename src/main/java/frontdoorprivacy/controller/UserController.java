package frontdoorprivacy.controller;

import frontdoorprivacy.domain.User;
import frontdoorprivacy.service.UserService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 5월 3일 구현 시작
 */
@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 회원가입 창을 띄워주는 컨트롤러
     * 완료!
     */
    @GetMapping("/user/new")
    public String joinForm() {
        return "user/joinForm";
    }

    /**
     * 미완료
     * @return
     */
    @PostMapping("/user/new")
    public String join() {

        return "user/login";
    }

    /**
     * 마이페이지에서 내 정보를 확인할수 있도록 해주는 컨트롤러
     * 대충 완료
     */
    @GetMapping("/user/{userId}")
    public String Info(@PathVariable String userId, Model model) {
        User user = userService.findOne(userId);
        model.addAttribute("user",user);
        return "user/mypage/info";
    }


    /**
     * 마이페이지 수정 폼에 들어갈 수 있도록 해주는 컨트롤러
     * 대충 완료
     */
    @GetMapping("/user/{userId}/edit")
    public String edit(@PathVariable String userId, Model model) {
        User user = userService.findOne(userId);
        model.addAttribute("user",user);
        return "user/mypage/edit";
    }


    /**
     *
     */






}
