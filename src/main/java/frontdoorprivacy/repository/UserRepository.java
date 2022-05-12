package frontdoorprivacy.repository;


import frontdoorprivacy.domain.user.User;


public interface UserRepository {

    void save(User user);

    User findById(String userId);

    void updateUser(String userId, User updateUser);

}
