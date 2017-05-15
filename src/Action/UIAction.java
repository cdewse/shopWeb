package Action;

import Entity.Sugar;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;


/**
 * Created by cdewse on 17-5-7.
 */
public class UIAction extends ActionSupport {

        public String execute() {
            ActionContext context = ActionContext.getContext();
            Map<String, Object> map = context.getParameters();
            String[] location = (String[]) map.get("location");
            switch (location[0]) {
                case "login": return "login";
                case "register":return "register";
                default: return "index";
            }
    }
}
