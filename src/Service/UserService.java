package Service;

import Dao.UserDao;
import Entity.User;

/**
 * Created by cdewse on 17-5-15.
 */
public class UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void add(User user){
        userDao.add(user);

    }

    public String Login(String username){
        return userDao.findPassword(username);
    }
}
