package Service;

import Entity.User;

/**
 * Created by cdewse on 17-5-17.
 */
public interface UserService {

    boolean register(User user);
    boolean login(String username, String password);
}
