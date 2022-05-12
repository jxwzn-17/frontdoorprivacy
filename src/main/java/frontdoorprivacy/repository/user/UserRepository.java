package frontdoorprivacy.repository.user;


import frontdoorprivacy.model.user.User;


public interface UserRepository {

    User save(User user);

    User findById(long id);

    void updateUser(long id, User updateUser);

}
