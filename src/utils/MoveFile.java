package utils;

import java.io.File;

/**
 * Created by cdewse on 17-5-23.
 * 文件移动
 */
public class MoveFile {
    public static void move(String initPath, String aimPath, String fileName) {
        File file = new File(initPath+"/"+fileName);
        file.renameTo(new File(aimPath + "/" + fileName));
    }
}
