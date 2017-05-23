package Service;

import java.io.IOException;

/**
 * Created by cdewse on 17-5-23.
 */
public interface UploadService {

    String uploadCimage(String imageName,String image) throws IOException;//上传商品图片同时返回图片名称
}
