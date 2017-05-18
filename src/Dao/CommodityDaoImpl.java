package Dao;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by cdewse on 17-5-16.
 */


public class CommodityDaoImpl implements CommodityDao {

    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Transactional
    @Override
    public void add() {
        hibernateTemplate.find("from Commodity");
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
