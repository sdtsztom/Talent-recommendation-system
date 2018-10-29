package util;

import util.Config;
import java.sql.*;

public class Test {

    public static void main(String[] args) {
        ConnectUser user=ConnectUser.DEV;   //这是一个枚举类
        CommonConnection.setConnectUser(user);
        // or simpler expression:
        //CommonConnection.setConnectUser(ConnectUser.DEV);
        ResultSet rs=CommonConnection.makeQuery("select * from stuff");
        try{
            while(rs.next()){
                String test=rs.getString(4);
                System.out.println(test);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
