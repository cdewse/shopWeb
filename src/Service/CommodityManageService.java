package Service;

import Dao.CommodityDao;

import java.util.List;

/**
 * Created by cdewse on 17-5-17.
 */
public interface CommodityManageService<T> {


    public List<T> queryAll(); //查询所有商品信息

}
