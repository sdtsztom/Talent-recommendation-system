package util;

import ienum.ConnectUser;

public class Identifier {

    public static boolean identify(String username,String encyptedPwd){
        CommonConnection.setConnectUser(ConnectUser.SYS);
        String pwd=CommonConnection.singleResultQuery("select stf_pwd from stuff where stf_username='"+username+"'");
        if(pwd==null)return false;
        if(encyptedPwd.equals(MD5.encrypt(pwd)))return true;
        else return false;
    }

//    public static boolean identify(String username, String encyptedPwd, String job_type, JobType expected_job_type){
//        CommonConnection.setConnectUser(ConnectUser.SYS);
//        String pwd=CommonConnection.singleResultQuery("select stf_pwd from stuff where stf_username='"+username+"'");
//        if(pwd==null)return false;
//        if(!encyptedPwd.equals(MD5.encrypt(pwd)))return false;
//        else if(job_type.equals(expected_job_type.toString()))return true;
//        else return false;
//    }
}
