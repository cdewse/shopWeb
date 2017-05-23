package Action;


import Entity.Commodity;
import Service.CommodityManageService;
import Service.UploadService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import utils.MoveFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by cdewse on 17-5-22.
 */
public class CommodityAction extends ActionSupport implements ModelDriven{

    private Commodity commodity = new Commodity();

    @Override
    public Object getModel() {
        return commodity;
    }

    private CommodityManageService commodityManageService;
    public void setCommodityManageService(CommodityManageService commodityManageService) {
        this.commodityManageService = commodityManageService;
    }

    private UploadService uploadService;
    public void setUploadService(UploadService uploadService) {
        this.uploadService = uploadService;
    }

    @Override
    public String execute(){
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
//            e.printStackTrace();
            try {
                response.getWriter().write("ErrorInfo="+"上传失败！"); //前端未做处理
                response.getWriter().flush();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        try {
            response.getWriter().write(imgName);
            response.getWriter().flush();
        }catch (IOException e1){
            e1.printStackTrace();
        }
        return null;
    }

    public String add(){
        HttpServletRequest request = ServletActionContext.getRequest();
        commodityManageService.addCommodity(commodity);
        String fileName  = request.getParameter("picture");
        String initPath = "/home/cdewse/imagetemp";
        String aimPath  = "/home/cdewse/CommodityImage";
        if (fileName!=null){
            MoveFile.move(initPath,aimPath,fileName);
        }
        return "success";
    }


}
