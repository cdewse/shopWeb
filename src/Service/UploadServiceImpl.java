package Service;

import sun.misc.BASE64Decoder;
import utils.ImgIdGenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by cdewse on 17-5-23.
 */
public class UploadServiceImpl implements UploadService{
    @Override
    public String uploadCimage(String imageName,String image) throws IOException{
        //通过名称得到图片格式
        String imageType = imageName.substring(imageName.indexOf('.'));
        //jsFileReaderreadasdataurlbase64编码发过来的数据格式为data:image/png;base64,iVBORw0KGgo。。。。，‘，’后面的才为真正需要的数据
        //因为传过来的时候经过urlencode标准的base64的/、+会被转换为%xx，所以需要把空格替换为+号，或者用非标准的base64编解码，它们将"+/"改为"_-"或者"!_"
        //此处采用第一种
        String base64 = image.substring(image.indexOf(',')+1).replace(' ','+');
        //获取base64解码器
        BASE64Decoder base64Decoder = new BASE64Decoder();
        //创建对应的文件
        String fileName = ImgIdGenerator.getUUID() + imageType;
        File file = new File("/home/cdewse/IdeaProjects/ShopWeb/web/image/" + fileName);
        file.createNewFile();
        //得到解码后的字节数组
        byte[] bytes = base64Decoder.decodeBuffer(base64);
        //创建文件输出流，文件不存在不会自动创建，没有会报fileNotFound错误
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        //写入
        fileOutputStream.write(bytes);
        //关闭输出流
        fileOutputStream.close();
        return fileName;
    }
}
