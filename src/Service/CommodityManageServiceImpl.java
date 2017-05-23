package Service;

import Dao.CommodityDao;
import Entity.Commodity;
import org.springframework.dao.DataAccessException;

import java.util.List;

/**
 * Created by cdewse on 17-5-17.
 */
public class CommodityManageServiceImpl<T> implements CommodityManageService<T> {


    private CommodityDao commodityDao;

    public void setCommodityDao(CommodityDao commodityDao) {
        this.commodityDao = commodityDao;
    }

    @Override
    public List<T> queryAll() {
        List list = commodityDao.getAll();
        return list;
    }

    @Override
    public boolean addCommodity(Commodity commodity) {
        try {
            commodityDao.add(commodity);
        } catch (DataAccessException e) {
            return false;
        }
        return true;
    }
}
