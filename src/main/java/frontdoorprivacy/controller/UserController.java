package frontdoorprivacy.controller;

import frontdoorprivacy.model.user.User;
import frontdoorprivacy.model.user.UpdateUser;
import frontdoorprivacy.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping
        //("/user")
public class UserController{
    private Logger logger = LoggerFactory.getLogger(UserController.class);
    private static UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;

    }

    @GetMapping("/user/{userID}")
    public ResponseEntity<User> info(@PathVariable int userID) {

        User userInfo = userService.getUserInfo(userID);

        return new ResponseEntity<>(userInfo,HttpStatus.OK);
    }

    @PostMapping("/{userID}")
    public ResponseEntity<UpdateUser> update(@PathVariable int userID, @RequestBody User user){

        UpdateUser founduser = new UpdateUser();

        founduser.setId(userID);
        founduser.setP_UserId(user.getUserId());
        founduser.setP_EmailAddress(user.getEmailaddress());
        founduser.setP_Password(user.getPassword());
        founduser.setP_PhoneNumber(user.getPhoneNumber());

        userService.updateUserInfo(founduser);

        return new ResponseEntity<>(founduser, HttpStatus.OK);
    }


}


