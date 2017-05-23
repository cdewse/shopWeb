package Service;

import Dao.CommodityDao;
import Entity.Commodity;

import java.util.List;

/**
 * Created by cdewse on 17-5-17.
 */
public interface CommodityManageService<T> {


    List<T> queryAll(); //查询所有商品信息

    boolean addCommodity(Commodity commodity);


}
