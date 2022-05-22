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
