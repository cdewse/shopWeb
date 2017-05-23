package Dao;

import Entity.Commodity;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by cdewse on 17-5-16.
 */

@Transactional
public class CommodityDaoImpl implements CommodityDao {

    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }


    @Override
    public void add(Commodity commodity) {
        hibernateTemplate.save(commodity);
    }

    @Override
    public void delete() {

    }

    @Override
    public void update() {

    }

    @Override
    public String find() {
        return null;
    }

    @Override
    public List getAll() {
        List list = hibernateTemplate.find("from Commodity");
        return list;
    }

    @Override
    public List<String> getCategory() {
        return null;
    }
}
