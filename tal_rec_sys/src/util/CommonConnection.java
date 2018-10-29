package util;

import java.sql.*;

public class CommonConnection {
    public static boolean loadDriver=false;
    public static boolean connecting=false;
    public static Connection conn=null;
    public static Statement sql=null;
    public static ConnectUser curUser=null;

    public static void setConnectUser(ConnectUser user){
        if(!loadDriver){
            try{
                Class.forName(Config.getClassForName());
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        if(curUser!=null&&user==curUser)return; //连接与现有连接角色一致，则直接重用现有连接
        try {
            conn=DriverManager.getConnection(Config.getConnStr(user));
            sql=conn.createStatement();
            connecting=true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet makeQuery(String query){
        if(!connecting){
            System.out.println("Error:connection havn't established yet!");
            return null;
        }
        ResultSet rs=null;
        try{
            rs=sql.executeQuery(query);
        }catch(Exception e){
            e.printStackTrace();
        }
        return rs;
    }

    public static void closeConnection(){
        try {
            sql.close();
            conn.close();
            connecting=false;
            curUser=null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
