package frontdoorprivacy.model.enterprise;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class MyEnterpriseInfo {
    String EnterpriseName;
    String EmailAddress;
    String Address;
    int PhoneNumber;

    public MyEnterpriseInfo() {
    }

    public String getEnterpriseName() {
        return EnterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        EnterpriseName = enterpriseName;
    }

    public String getEmailAddress() {
        return EmailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        EmailAddress = emailAddress;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        PhoneNumber = phoneNumber;
    }
}
