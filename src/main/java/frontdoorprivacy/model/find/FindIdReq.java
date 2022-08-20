package frontdoorprivacy.model.find;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class FindIdReq {
    private String role;
    private String name;
    private String email;

    private String exitYN;
    private String id;

    public FindIdReq() {
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getExitYN() {
        return exitYN;
    }

    public void setExitYN(String exitYN) {
        this.exitYN = exitYN;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
