package frontdoorprivacy.service;

import frontdoorprivacy.domain.user.User;

public interface UserService {

    void join(User user);

    User findOne(String userId);

    void update(String userId, User updateUser);

}
