package frontdoorprivacy.model.user;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LoginUser {

    private String inputId;
    private String pw;

    public LoginUser() {
    }

    public String getInputId() {
        return inputId;
    }

    public void setInputId(String inputId) {
        this.inputId = inputId;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }
}
