package frontdoorprivacy.model.user;

public class UpdateUser {
        private String id;
        private String P_PhoneNumber;
        private String P_UserId;
        private String P_Password;
        private String P_EmailAddress;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getP_PhoneNumber() {
        return P_PhoneNumber;
    }

    public void setP_PhoneNumber(String p_PhoneNumber) {
        P_PhoneNumber = p_PhoneNumber;
    }

    public String getP_UserId() {
        return P_UserId;
    }

    public void setP_UserId(String p_UserId) {
        P_UserId = p_UserId;
    }

    public String getP_Password() {
        return P_Password;
    }

    public void setP_Password(String p_Password) {
        P_Password = p_Password;
    }

    public String getP_EmailAddress() {
        return P_EmailAddress;
    }

    public void setP_EmailAddress(String p_EmailAddress) {
        P_EmailAddress = p_EmailAddress;
    }

    public UpdateUser() {
    }
}
