package Service;

import Dao.UserDao;
import Entity.User;
import org.springframework.dao.DataAccessException;
import utils.Encryption;

/**
 * Created by cdewse on 17-5-15.
 */
public class UserServiceImpl implements UserService{

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean register(User user){
        try {
            userDao.add(user);
        }catch (DataAccessException dae){
            return false;
        }
        return true;
    }

    //用户名密码参数跟数据匹配，相同返回true否则false
    public boolean login(String username, String password){//以后添加邮箱验证功能，还有邮箱不能重复注册
        if(userDao.findPassword(username).equals(Encryption.encrypt(password))){
            return true;
        }
        return false;
    }
}
