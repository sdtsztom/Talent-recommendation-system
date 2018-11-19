package example;

import util.CommonConnection;
import ienum.ConnectUser;

import java.sql.*;

public class CommonConnection_Example {

    public static void main(String[] args) {
        CommonConnection.setConnectUser(ConnectUser.DEV);   //use role DEV to login into the database
        // equal expression:
        // ConnectUser user=ConnectUser.DEV;
        // CommonConnection.setConnectUser(user);
        ResultSet rs=CommonConnection.makeQuery("select * from stuff where stf_username='h'");
        try{
            while(rs.next()){
                String test=rs.getString(4);
                test=test.trim();   // You need trim if your data is of type:char,it's important
                System.out.println(test);
            }
            rs.close(); //Don't forget to close rs
        }catch(Exception e){
            e.printStackTrace();
        }

        // if rs only have one line record,the method singleLine is suggested,e.g.
        String []values=CommonConnection.singleLineQuery("select stf_id,stf_name from stuff where stf_username='h'",2);
        String id=values[0];
        String name=values[1];
        System.out.println(id+"/"+name);

        // we also provide method for the condition of one String result query,e.g.
        String tel_num=CommonConnection.singleResultQuery("select stf_tel from stuff where stf_username='h'");
        System.out.println(tel_num);
    }
}
