package frontdoorprivacy.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class User {

    private long id;
    private Role role;
    private String userName;
    private String birth;
    private String phoneNumber;
    private String userId;
    private String password;
    private String email;
    private UseYN userYN;

    public User(Role role, String userName, String birth, String phoneNumber, String userId,
                String password, String email) {
        this.role = role;
        this.userName = userName;
        this.birth = birth;
        this.phoneNumber = phoneNumber;
        this.userId = userId;
        this.password = password;
        this.email = email;
    }
}
