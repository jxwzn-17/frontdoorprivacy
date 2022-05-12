package frontdoorprivacy.model.user;

import lombok.Getter;
import lombok.Setter;

/**
 * 회원수정폼에서 받아올 값들을 입력하는 창
 */
@Getter
@Setter
public class MyPageUser {
    private String id; //USID
    private String username;
    private String birth;
    private String phoneNumber;
    private String userId;
    private String password;
    private String emailaddress;
    private char UserYN;
    private char Role;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    public char getUserYN() {
        return UserYN;
    }

    public void setUserYN(char userYN) {
        UserYN = userYN;
    }

    public char getRole() {
        return Role;
    }

    public void setRole(char role) {
        Role = role;
    }

    public MyPageUser() {
    }
}
