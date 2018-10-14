package util;

import java.sql.*;

public class CommonConnection {
    public static boolean loadDriver=false;
    public static boolean connecting=false;
    public static Connection conn=null;
    public static Statement sql=null;

    public static void setConnectUser(String userName){
        if(!loadDriver){
            try{
                Class.forName(Config.getClassForName());
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        try {
            conn=DriverManager.getConnection(Config.getConnStr(userName));
            sql=conn.createStatement();
            connecting=true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet makeQuery(String query){
        if(!connecting)return null;
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
