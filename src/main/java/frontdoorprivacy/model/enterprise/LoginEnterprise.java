package frontdoorprivacy.model.enterprise;


import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class LoginEnterprise {

    private String userId;
    private String pw;

    public LoginEnterprise() {
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
