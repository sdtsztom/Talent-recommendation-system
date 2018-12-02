package util;

import java.sql.*;
import java.util.ArrayList;

import Interface.Rs2List;
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

    private static void setConnectUser(ConnectUser user){
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

    //********************************************************************** Query Methods*************************************************************

    //caller should rember to close the returned ReslutSet!
    public static ResultSet makeQuery(String query,ConnectUser connect_user){
        if(!checkConnecting())return null;
        setConnectUser(connect_user);
        ResultSet rs=null;
        try{
            rs=sql.executeQuery(query);
        }catch(Exception e){
            System.out.println("the query caused error:"+query+"......");
            e.printStackTrace();
        }
        return rs;
    }

    public static int Update(String query) {
        if(!checkConnecting()) return 0;
        int rs = 0;
        try {
            rs=sql.executeUpdate(query);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public static ResultSet limitQuery(String query,int limit,int page){
        // TO-DO
        return null;
    }

    public static String singleResultQuery(String query,ConnectUser connect_user){
        if(!checkConnecting())return null;
        setConnectUser(connect_user);
        ResultSet rs=null;
        String result=null;
        try{
            rs=sql.executeQuery(query);
            rs.next();
            result=rs.getString(1).trim();
            rs.close();
        }catch(Exception e){
            System.out.println("the query caused error:"+query+"......");
            e.printStackTrace();
        }
        return result;
    }

    public static String[] singleLineQuery(String query, int ncol,ConnectUser connect_user){
        if(!checkConnecting())return null;
        setConnectUser(connect_user);
        ResultSet rs=null;
        String []result=null;
        try{
            rs=sql.executeQuery(query);
            result=new String[ncol];
            rs.next();
            for(int i=0;i<ncol;++i)result[i]=rs.getString(i+1).trim();
            rs.close();
        }catch(Exception e){
            System.out.println("the query caused error:"+query+"......");
            e.printStackTrace();
        }
        return result;
    }

    public static boolean existQuery(String query,ConnectUser connect_user){
        boolean have_rs=false;
        setConnectUser(connect_user);
        if(!checkConnecting())return have_rs;
        try{
            ResultSet rs=sql.executeQuery(query);
            have_rs=rs.next();
            rs.close();
        }catch(Exception e){
            System.out.println("the query caused error:"+query+"......");
            e.printStackTrace();
        }
        return have_rs;
    }

    public static <E extends Rs2List> ArrayList<E> listQuery (String query,E e,ConnectUser connect_user){
        ArrayList<E>list=null;
        if(!checkConnecting())return list;
        setConnectUser(connect_user);
        list=new ArrayList<E>();
        try {
            ResultSet rs=sql.executeQuery(query);
            while(rs.next()){
                list.add((E)e.fromRs(rs));
            }
            rs.close();
        } catch (SQLException e1) {
            System.out.println("the query caused error:"+query+"......");
            e1.printStackTrace();
        }
        return list;
    }

    //********************************************************************** Update Methods*************************************************************

    public static int Update(String query,ConnectUser connect_user) {
        if(!checkConnecting()) return 0;
        setConnectUser(connect_user);
        int rs = 0;
        try {
            rs=sql.executeUpdate(query);
        }catch (Exception e) {
            System.out.println("the query caused error:"+query+"......");
            e.printStackTrace();
        }
        return rs;
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
