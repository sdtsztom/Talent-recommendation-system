package util;

import java.security.MessageDigest;
import java.math.BigInteger;

public class MD5 {
    public static String encrypt(String info){
        info=preprocess(info);
        MessageDigest md5=null;
        try{md5 = MessageDigest.getInstance("MD5");}
        catch(Exception e){e.printStackTrace();}
        md5.update(info.getBytes());
        return (new BigInteger(1,md5.digest())).toString(16).substring(8,24);
    }

    private static String preprocess(String info){
        return info.length()+info;  //由于直接使用信息加密容易被人猜出，因此加入额外信息
    }
}
