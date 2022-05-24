package frontdoorprivacy.model.user;

public class UserLoginOutputV2 {

    String enid;
    String enterpriseId;
    String role;

    public String getEnid() {
        return enid;
    }

    public void setEnid(String enid) {
        this.enid = enid;
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
