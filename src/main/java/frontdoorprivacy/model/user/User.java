package frontdoorprivacy.model.user;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class User {

    private long id;
    private Role role; //회원가입에서 일반 사용자면 Basic, 기업사용자면 Enterprise 를 넣어줄것
    private String userName;
    private String birth;
    private String phoneNumber;
    private String userId;
    private String password;
    private String email;
    private UseYN userYN; //기본값으로 Y를 써줄것



    public User(String userName, String birth, String phoneNumber, String userId,
                String password, String email) {
        this.userName = userName;
        this.birth = birth;
        this.phoneNumber = phoneNumber;
        this.userId = userId;
        this.password = password;
        this.email = email;
    }
}
