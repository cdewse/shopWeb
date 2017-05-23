package Dao;

import Entity.Commodity;

import java.util.List;

/**
 * Created by cdewse on 17-5-16.
 */
public interface CommodityDao {
    void add(Commodity commodity);
    void delete();
    void update();
    String find();
    List getAll();
    List<String> getCategory();
}
