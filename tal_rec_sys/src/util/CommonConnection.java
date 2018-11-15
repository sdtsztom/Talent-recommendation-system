package util;

import java.sql.*;
import ienum.ConnectUser;

/*
 * user:tsz
 * Notice:
 *      1. 对于查询方法，如果在查询过程中出现错误会返回null，因此对于查询结果，要注意检验是否为null
 */

public class CommonConnection {
    private static boolean loadDriver=false;
    private static boolean connecting=false;
    private static Connection conn=null;
    private static Statement sql=null;
    private static ConnectUser curUser=null;

    public static void setConnectUser(ConnectUser user){
        if(!loadDriver){
            try{
                Class.forName(Config.getClassForName());
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        if(curUser!=null&&user==curUser)return ; //连接与现有连接角色一致，则直接重用现有连接
        try {
            conn=DriverManager.getConnection(Config.getConnStr(user));
            sql=conn.createStatement();
            connecting=true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //caller should rember to close the returned ReslutSet!
    public static ResultSet makeQuery(String query){
        if(!checkConnecting())return null;
        ResultSet rs=null;
        try{
            rs=sql.executeQuery(query);
        }catch(Exception e){
            e.printStackTrace();
        }
        return rs;
    }

    public static ResultSet limitQuery(String query,int limit,int page){
        // TO-DO
        return null;
    }

    public static String singleResultQuery(String query){
        if(!checkConnecting())return null;
        ResultSet rs=null;
        String result=null;
        try{
            rs=sql.executeQuery(query);
            rs.next();
            result=rs.getString(1).trim();
            rs.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public static String[] singleLineQuery(String query, int ncol){
        if(!checkConnecting())return null;
        ResultSet rs=null;
        String []result=null;
        try{
            rs=sql.executeQuery(query);
            result=new String[ncol];
            rs.next();
            for(int i=0;i<ncol;++i)result[i]=rs.getString(i+1).trim();
            rs.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public static boolean existQuery(String query){
        boolean have_rs=false;
        if(!checkConnecting())return have_rs;
        ResultSet rs=null;
        try{
            rs=sql.executeQuery(query);
            have_rs=rs.next();
            rs.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return have_rs;
    }

    public static boolean checkConnecting(){
        if(!connecting){
            System.out.println("Error:connection havn't established yet!");
            return false;
        }else return true;
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
