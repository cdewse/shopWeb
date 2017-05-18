package Dao;

import java.util.List;

/**
 * Created by cdewse on 17-5-16.
 */
public interface CommodityDao {
    public void add();
    public void delete();
    public void update();
    public String find();
    public List getAll();
    public List<String> getCategory();
}
