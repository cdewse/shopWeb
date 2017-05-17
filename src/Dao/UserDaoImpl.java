package Dao;

import Entity.User;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;
import utils.Encryption;

import java.io.IOError;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by cdewse on 17-5-14.
 */


public class UserDaoImpl implements UserDao {

    //得到hibernate对象
    private HibernateTemplate hibernateTemplate;
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Transactional
    @Override
    public void add(User user) throws DataAccessException {
        hibernateTemplate.save(Encryption.encrypt(user));
    }

    @Override
    public void delelte(User user) {

    }

    @Override
    public void update() {

    }

    @Override
    public void find() {

    }

    @Override
    public String findPassword(String username) {
        List<String> password;
        //获取数据库用户信息
        try {
            password = (List<String>) hibernateTemplate.find("select password from User where username=?", username);
            return password.get(0);
        }catch (Exception e){
            System.out.print("用户名或密码错误");
            return "Error";
        }
    }
}
