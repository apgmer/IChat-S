package me.xiaotian.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by guoxiaotian on 2016/10/9.
 */
//密码工具类
public final class PasswordUtil {

    private PasswordUtil() {
    }

    private static String salt = "saldjflasf;lasj;lfjasl;fjaslkdjf;la";

    /**
     * 生成密码
     *
     * @param pass
     * @return md5Str
     */
    public static String generatePass(String pass) {
        return generateMd5Str(pass);
    }

    /**
     * 检查密码是否符合
     * @param pass 明文密码
     * @param md5Pass 密文密码
     * @return true | false
     */
    public static boolean isEqual(String pass, String md5Pass) {
        return generateMd5Str(pass).equals(md5Pass);
    }

    /**
     * 生成md5Str
     * @param str
     * @return
     */
    private static String generateMd5Str(String str) {
        String pass_salt = str + "[]" + salt;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("md5");
            messageDigest.update(pass_salt.getBytes());
            return new BigInteger(1, messageDigest.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
