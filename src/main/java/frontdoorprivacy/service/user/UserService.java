package frontdoorprivacy.service.user;

import frontdoorprivacy.model.user.User;

public interface UserService {

    User join(User user);

    User findOne(long id);

    void update(long id, User updateUser);

}
