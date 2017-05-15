package Dao;

import Entity.User;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;
import utils.Encryption;

import java.util.Date;

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
    public void add(User user) {
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
}
