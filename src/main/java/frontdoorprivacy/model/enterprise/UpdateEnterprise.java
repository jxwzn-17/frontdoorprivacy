package frontdoorprivacy.model.enterprise;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class UpdateEnterprise {

    int id;
    String e_name;
    String e_email;
    String e_address;
    int e_phone;
    int e_accountnumber;
    String e_bankname;
    String e_password;

    public int getE_accountnumber() {
        return e_accountnumber;
    }

    public void setE_accountnumber(int e_accountnumber) {
        this.e_accountnumber = e_accountnumber;
    }

    public String getE_bankname() {
        return e_bankname;
    }

    public void setE_bankname(String e_bankname) {
        this.e_bankname = e_bankname;
    }

    public String getE_password() {
        return e_password;
    }

    public void setE_password(String e_password) {
        this.e_password = e_password;
    }

    public UpdateEnterprise() {
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getE_name() {
        return e_name;
    }

    public void setE_name(String e_name) {
        this.e_name = e_name;
    }

    public String getE_email() {
        return e_email;
    }

    public void setE_email(String e_email) {
        this.e_email = e_email;
    }

    public String getE_address() {
        return e_address;
    }

    public void setE_address(String e_address) {
        this.e_address = e_address;
    }

    public int getE_phone() {
        return e_phone;
    }

    public void setE_phone(int e_phone) {
        this.e_phone = e_phone;
    }
}
