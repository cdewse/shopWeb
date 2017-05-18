package Action;

import Entity.Commodity;
import Entity.User;
import Service.CommodityManageService;
import Service.CommodityManageServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by cdewse on 17-5-16.
 */
public class QueryAction extends ActionSupport{

    private CommodityManageService commodityManageService;

    public void setCommodityManageService(CommodityManageService commodityManageService) {
        this.commodityManageService = commodityManageService;
    }

    public String execute(){
        List list = commodityManageService.queryAll();
        HttpSession session = ServletActionContext.getRequest().getSession();
        session.setAttribute("commodityList",list);
        return "success";
    }

    public String queryPage(){

        return "none";
    }

}
