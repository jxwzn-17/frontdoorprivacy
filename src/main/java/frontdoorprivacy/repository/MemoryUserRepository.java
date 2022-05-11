package frontdoorprivacy.repository;

import frontdoorprivacy.domain.User;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class MemoryUserRepository implements UserRepository {

    private static Map<String, User> store = new ConcurrentHashMap<>();
    private static long sequence = 0L;

    @Override
    public void save(User user) {
        //sequence 는 기본 id값 (int 형)
        user.setId(++sequence);

        //해쉬맵에 정보를 저장해줌
        store.put(user.getUserId(), user);
    }


    /**
     * sequence 값이 아닌 userId를 통해 아이디 찾아주기
     * 예외처리 미완료
     */
    @Override
    public User findById(String userId) {
        return store.get(userId);
    }


    /**
     *     private long id; //
     *     private Role role; // 역할 변경 불가
     *     private String userName; //이름 변경 불가
     *     private String birth; //생년월일 변경 불가
     *     private String phoneNumber; //전화번호 변경 불가
     *     private String userId; //id 변경 불가
     *     private String password; //비밀번호 변경 가능
     *     private String email; // 이메일 변경 가능
     */
    @Override
    public void updateUser(String userId, User updateUser) {
        User foundUser = findById(userId);
        foundUser.setPassword(updateUser.getPassword());
        foundUser.setEmail(updateUser.getEmail());
    }


}
