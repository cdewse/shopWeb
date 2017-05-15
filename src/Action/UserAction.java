package Action;

import Entity.User;
import Service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.util.Map;
import java.util.Set;

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

        //用户名123456
        String username = "123456";
        //密码123456
        String password = "123456";

        //获取Actioncontext对象
        ActionContext context = ActionContext.getContext();
        //使用方法得到表单数据
        Map<String,Object> map= context.getParameters();

        String[] username1 = (String[]) map.get("username");
        String[] password1 = (String[]) map.get("password");
        if (username.equals(username1[0]) && password.equals(password1[0])) {
            return "success";
        }
        return "index";
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

        userService.add(user);
        return "success";
    }


}
