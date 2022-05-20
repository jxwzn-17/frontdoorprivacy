package frontdoorprivacy.model.user;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class LoginInfo {
    String userId;
    String password;
    String role;

    public LoginInfo() {
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
