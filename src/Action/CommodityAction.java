package Action;


import Service.UploadService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by cdewse on 17-5-22.
 * 有时会出现nullpointexception！！！
 */
public class CommodityAction extends ActionSupport {
    private UploadService uploadService;

    public void setUploadService(UploadService uploadService) {
        this.uploadService = uploadService;
    }

    @Override
    public String execute() throws IOException {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("text"+";charset=UTF-8");
        response.setHeader("Pragma","No-cache");
        response.setHeader("Cache-Control","no-cache");
        response.setDateHeader("Expires",0);
        //获取ajax传过来的参数内容
        String image = request.getParameter("image");
        //得到上传的图片名称
        String imageName = request.getParameter("imageName");
        String imgName = null;

        try {
            imgName = uploadService.uploadCimage(imageName,image);
        } catch (IOException e) {
            e.printStackTrace();
            try {
                response.getWriter().write("ErrorInfo="+"上传失败！");
                response.getWriter().flush();

            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        response.getWriter().write(imgName);
        response.getWriter().flush();
        return null;
    }
}
