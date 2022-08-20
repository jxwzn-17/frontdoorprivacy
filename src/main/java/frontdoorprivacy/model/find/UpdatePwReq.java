package frontdoorprivacy.model.find;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class UpdatePwReq {
    private String newpasswd;
    private String role;
    private String id;

    public UpdatePwReq() {
    }

    public String getNewpasswd() {
        return newpasswd;
    }

    public void setNewpasswd(String newpasswd) {
        this.newpasswd = newpasswd;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
