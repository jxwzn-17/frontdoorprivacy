package frontdoorprivacy.model.user;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LoginUser {

    private String userId;
    private String pw;

    public LoginUser() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }
}
