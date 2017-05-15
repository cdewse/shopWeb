package Dao;

import Entity.User;

/**
 * Created by cdewse on 17-5-14.
 */
public interface UserDao {
    public void add(User user);
    public void delelte(User user);
    public void update();
    public void find();
}
