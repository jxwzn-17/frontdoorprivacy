package frontdoorprivacy.model.user;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class LoginOutput {
    int enid;
    String enterpriseId;

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
