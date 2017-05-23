package Action;

import Entity.User;
import Service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by cdewse on 17-5-7.
 */
public class UserAction extends ActionSupport implements ModelDriven<User>{
    //模型驱动封装表单数据
    //创建对象
    //前提要求，表单name属性要和实体类属性名称一致
    private User user = new User();
    @Override
    public User getModel() {
        return user;
    }


    //注入userService对象
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String execute() {
        return "success";
    }

    public String login() {

        //获取Actioncontext对象
        ActionContext context = ActionContext.getContext();
        //使用方法得到表单数据
        Map<String,Object> map= context.getParameters();

        HttpServletRequest request = ServletActionContext.getRequest();
        String[] username = (String[]) map.get("username");
        String[] password = (String[]) map.get("password");

        if (userService.login(username[0],password[0])){
            request.getSession().setAttribute("username",username[0]);
            return "success";
        }else {
            request.setAttribute("error","用户名或密码错误");
            return "error";
        }
    }

    public String register() {
//        //获取Actioncontext对象
//        ActionContext context = ActionContext.getContext();
//        //使用方法得到表单数据
//        Map<String,Object> map= context.getParameters();
//
//        Set<String> keys = map.keySet();
//        for (String key : keys) {
//
//        }
        HttpServletRequest request = ServletActionContext.getRequest();
        if(userService.register(user)){
            return "success";
        }else {
            request.setAttribute("registerError","账号已存在");
            return "error";
        }
    }

}
