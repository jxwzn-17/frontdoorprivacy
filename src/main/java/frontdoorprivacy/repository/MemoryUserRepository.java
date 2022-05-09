package frontdoorprivacy.repository;

import frontdoorprivacy.domain.User;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MemoryUserRepository implements UserRepository {

    private static Map<String, User> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public void save(User user) {
        //sequence 는 기본 id값 (int 형)
        user.setId(++sequence);

        //해쉬맵에 정보를 저장해줌
        store.put(user.getUserId(), user);
    }



    @Override
    public User findById(String userId) {
        return store.get(userId);
    }

    @Override
    public void updateUser(String userId, User updateUser) {
        User foundUser = findById(userId);
    }


}
