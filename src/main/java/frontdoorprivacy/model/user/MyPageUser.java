package frontdoorprivacy.model.user;

import lombok.Getter;
import lombok.Setter;

/**
 * 회원수정폼에서 받아올 값들을 입력하는 창
 */
@Getter
@Setter
public class MyPageUser {
    private String email;
    private String birth;
    private String phoneNumber;
    private String userId;
}
