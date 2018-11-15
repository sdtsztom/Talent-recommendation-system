package example;

import util.MD5;

public class MD5_Example {
    public static void main(String []args){
        String encryptedStr= MD5.encrypt("13701111111");
        System.out.println(encryptedStr);
    }
}
