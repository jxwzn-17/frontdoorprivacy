package frontdoorprivacy.model.enterprise;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Checkcompany {

    String enterpriseBirth;
    String enterpriseNumber;
    String enterpriseRepresentName;

    public Checkcompany() {
    }

    public String getEnterpriseBirth() {
        return enterpriseBirth;
    }

    public void setEnterpriseBirth(String enterpriseBirth) {
        this.enterpriseBirth = enterpriseBirth;
    }

    public String getEnterpriseNumber() {
        return enterpriseNumber;
    }

    public void setEnterpriseNumber(String enterpriseNumber) {
        this.enterpriseNumber = enterpriseNumber;
    }

    public String getEnterpriseRepresentName() {
        return enterpriseRepresentName;
    }

    public void setEnterpriseRepresentName(String enterpriseRepresentName) {
        this.enterpriseRepresentName = enterpriseRepresentName;
    }
}
