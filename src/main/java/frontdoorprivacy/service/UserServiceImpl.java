package frontdoorprivacy.service;

import frontdoorprivacy.domain.User;
import frontdoorprivacy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * 회원가입을 처리하기 위한 비지니스 로직이다.
     */
    @Override
    public void join(User user) {

        //user를 받아서 중복회원검사 등의 예외처리를 해주어야함 (5월 3일 아직 미구현)


        // 모든 예외를 통과하는 경우 가입을 할 수 있도록 해야함(구현 완)
        userRepository.save(user);

        //return 값 등이 필요하다면 메소드 타입을 바꾸어 주고 return 해줄 것 (미정상태)


    }

    @Override
    public User findOne(String userId) {
        return userRepository.findById(userId);
    }

}
