package frontdoorprivacy.model.user;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class LoginOutput {
    int enid;
    String enterpriseId;
    String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LoginOutput() {
    }

    public int getEnid() {
        return enid;
    }

    public void setEnid(int enid) {
        this.enid = enid;
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }
}
