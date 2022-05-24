package frontdoorprivacy.model.user;

import lombok.Getter;
import lombok.Setter;

/**
 * 회원수정폼에서 받아올 값들을 입력하는 창
 */
@Getter
@Setter
public class User {
    private int id; //USID
    private String userName;
    private String birth;
    private String phoneNumber;
    private String userId;
    private String password;
    private String email;
    private String UseYN;
    private String Role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUseYN() {
        return UseYN;
    }

    public void setUseYN(String useYN) {
        UseYN = useYN;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public User() {
    }
}
