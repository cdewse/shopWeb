import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;
import sun.misc.BASE64Encoder;
import utils.Encryption;
import utils.ImgIdGenerator;

import java.io.*;
import java.util.List;

/**
 * Created by cdewse on 17-5-22.
 */
public class Test {

    @org.junit.Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        HibernateTemplate hibernateTemplate = (HibernateTemplate) context.getBean("hibernateTemplate");
        List<?> list = hibernateTemplate.find("from Commodity");
        System.out.println(list.get(0));
    }

    @org.junit.Test
    public void test2() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("/home/cdewse/桌面/jpg/2017-05-06 15-28-54屏幕截图.png");
        //竹篮
        byte[] bytes = new byte[1024];

        File file = new File("/home/cdewse/桌面/jpg/abc.png");
//        int hasRead = 0;
        file.createNewFile();
        FileOutputStream fop = new FileOutputStream(file);
        //循环读取单位字节数组写入写入新文件
        while ((fileInputStream.read(bytes)) > 0) {

            fop.write(bytes);
        }
        fileInputStream.close();
        fop.close();
    }

    @org.junit.Test
    public void getUUIDTest(){
        BASE64Encoder encoder = new BASE64Encoder();
//        encoder.encode(ImgIdGenerator.getUUID().getBytes());
        System.out.println(ImgIdGenerator.getUUID());
        System.out.println(Encryption.encrypt(ImgIdGenerator.getUUID()));
    }
}
