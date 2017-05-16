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

    //用户名密码参数跟数据匹配，相同返回true否则false
    public boolean Login(String username,String password){
        if(userDao.findPassword(username).equals(password)){
            return true;
        }
        return false;
    }
}
