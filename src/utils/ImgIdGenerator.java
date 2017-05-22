package utils;

import java.util.UUID;

/**
 * Created by cdewse on 17-5-23.
 * 图片随机名称生成器
 */
public class ImgIdGenerator {
    public static String getUUID() {
        return Encryption.encrypt(UUID.randomUUID().toString());
    }

}
