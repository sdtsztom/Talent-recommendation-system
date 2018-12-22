package util;

import java.sql.*;
import java.util.ArrayList;

import Interface.Procedure;
import Interface.Rs2Bean;
import com.sun.rowset.CachedRowSetImpl;
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
    public static CachedRowSetImpl makeQuery(String query,ConnectUser connect_user){
        setConnectUser(connect_user);
        ResultSet rs=null;
        CachedRowSetImpl cached_rs=null;
        try{
            cached_rs=new CachedRowSetImpl();
            rs=sql.executeQuery(query);
            cached_rs.populate(rs);
            rs.close();
        }catch(Exception e){
            System.out.println("the query caused error:"+query+"......");
            e.printStackTrace();
        }
        return cached_rs;
    }

    public static ResultSet limitQuery(String query,int limit,int page){
        // TODO
        return null;
    }

    public static String singleResultQuery(String query,ConnectUser connect_user){
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

    public static Date singleDataQuery(String query,ConnectUser connect_user){
        setConnectUser(connect_user);
        ResultSet rs=null;
        Date result=null;
        try{
            rs=sql.executeQuery(query);
            rs.next();
            result=rs.getDate(1);
            rs.close();
        }catch(Exception e){
            System.out.println("the query caused error:"+query+"......");
            e.printStackTrace();
        }
        return result;
    }

    public static boolean existQuery(String query,ConnectUser connect_user){
        setConnectUser(connect_user);
        boolean have_rs=false;
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

    public static <E extends Rs2Bean> ArrayList<E> listQuery (String query, E e, ConnectUser connect_user){
        setConnectUser(connect_user);
        ArrayList<E>list=null;
        list=new ArrayList<E>();
        try {
            CachedRowSetImpl cached_rs=new CachedRowSetImpl();
            ResultSet rs=sql.executeQuery(query);
            cached_rs.populate(rs);
            rs.close();
            while(cached_rs.next()){
                list.add((E)e.fromRs(cached_rs));
            }
            cached_rs.close();
        } catch (SQLException e1) {
            System.out.println("the query caused error:"+query+"......");
            e1.printStackTrace();
        }
        return list;
    }

    public static <E extends Rs2Bean> E beanQuery(String query, E e, ConnectUser connect_user){
        setConnectUser(connect_user);
        E e_temp=null;
        try {
            CachedRowSetImpl cached_rs=new CachedRowSetImpl();
            ResultSet rs=sql.executeQuery(query);
            cached_rs.populate(rs);
            rs.close();
            cached_rs.next();
            e_temp=(E)e.fromRs(cached_rs);
            cached_rs.close();
        } catch (SQLException e1) {
            System.out.println("the query caused error:"+query+"......");
            e1.printStackTrace();
        }
        return e_temp;
    }

    //********************************************************************** Update Methods*************************************************************

    public static int Update(String query,ConnectUser connect_user) {
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

    public static void execProcedure(Procedure procedureClass,ConnectUser connectUser){
        setConnectUser(connectUser);
        try{
            CallableStatement procedure=conn.prepareCall("{call "+procedureClass.getProcedureName()+"}");
            procedureClass.setProcedure(procedure);
            procedure.execute();
            procedureClass.receive(procedure);
            procedure.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static boolean checkConnecting(){
        if(!connecting)return false;
        else return true;
    }

    public static void closeConnection(ConnectUser connect_user){
        if(connect_user!=ConnectUser.ADMIN&&connect_user!=ConnectUser.DEV){
            System.out.println("Error:closeConnection is a critical operation.\n"+
                    "It requires you have right of Admin or Develop.\n"+
                    "If you don't know what the operation may cause,don't do it.\n");
        }
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
