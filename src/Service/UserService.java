package Service;

import Entity.User;

/**
 * Created by cdewse on 17-5-17.
 */
public interface UserService {

    public boolean register(User user);
    public boolean login(String username, String password);
}
