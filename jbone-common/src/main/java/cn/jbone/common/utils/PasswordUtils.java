package cn.jbone.common.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class PasswordUtils {
    public static String getMd5PasswordWithSalt(String password,String salt){
        String newPassword = new SimpleHash("MD5", password,  ByteSource.Util.bytes(salt), 1024).toHex();
        return newPassword;
    }

    public static void main(String[] args) {
        System.out.println(PasswordUtils.getMd5PasswordWithSalt("jbone","1521896490652"));
    }
}
