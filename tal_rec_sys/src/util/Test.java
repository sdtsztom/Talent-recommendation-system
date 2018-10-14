package util;

import util.Config;
import java.sql.*;

public class Test {

    public static void main(String[] args) {
        CommonConnection.setConnectUser("develop");
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
