package utils;

import Entity.User;
import sun.misc.BASE64Encoder;
import sun.security.provider.MD5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * Created by cdewse on 17-5-15.
 * 简单加密
 */
public class Encryption {
    public static User encrypt(User user) { //表单密码加密
        String password = user.getPassword();
        user.setPassword(encrypt(password));
        return user;
    }

    public static String encrypt(String str) {

        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("md5");  //获取加密方式
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] md5 = md.digest(str.getBytes());   //对str进行MD5加密
        BASE64Encoder base64Encoder= new BASE64Encoder();    //获取Base64编码器
        String encode = base64Encoder.encode(md5);      //对MD5进行编码
        return encode;
    }
}
