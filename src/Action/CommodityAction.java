package Action;


import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import sun.misc.BASE64Decoder;
import utils.ImgIdGenerator;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by cdewse on 17-5-22.
 * 图片名称返回到前端没写
 */
public class CommodityAction extends ActionSupport {

    @Override
    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        //获取ajax传过来的参数内容
        String picture1 = request.getParameter("image");

        //得到上传的图片名称
        String imageName = request.getParameter("imageName");
        //通过名称得到图片格式
        String imageType = imageName.substring(imageName.indexOf('.'));
        //jsFileReaderreadasdataurlbase64编码发过来的数据格式为data:image/png;base64,iVBORw0KGgo。。。。，‘，’后面的才为真正需要的数据
        //因为传过来的时候经过urlencode标准的base64的/、+会被转换为%xx，所以需要把空格替换为+号，或者用非标准的base64编解码，它们将"+/"改为"_-"或者"!_"
        //此处采用第一种
        String base64 = picture1.substring(picture1.indexOf(',')+1).replace(' ','+');
        //获取base64解码器
        BASE64Decoder base64Decoder = new BASE64Decoder();
        //得到解码后的字节数组
        byte[] bytes = base64Decoder.decodeBuffer(base64);
        //创建对应的文件
        File file = new File("/home/cdewse/IdeaProjects/ShopWeb/web/image/"+ImgIdGenerator.getUUID()+imageType);
        file.createNewFile();
        //创建文件输出流，文件不存在不会自动创建，没有会报fileNotFound错误
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        //写入
        fileOutputStream.write(bytes);
        //关闭输出流
        fileOutputStream.close();
        return "success";
    }
}
