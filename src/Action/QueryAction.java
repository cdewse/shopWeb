package Action;

import Entity.User;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.orm.hibernate5.HibernateTemplate;

/**
 * Created by cdewse on 17-5-16.
 */
public class QueryAction extends ActionSupport{

    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public String execute(){
       return "success";
    }

    public String queryPage(){

        return "none";
    }

}
