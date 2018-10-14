package util;

import java.util.HashMap;
import bean.LoginUser;

public class Config {
    static boolean init=false;
    static String className="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static String conPostfix="jdbc:sqlserver://";
    static String ip="localhost";
    static String port="1433";
    static String databaseName="tal_rec_sys";

    static HashMap<String,LoginUser> loginUsers=new HashMap<String,LoginUser>();

    public static void Config_init() {
        LoginUser develop=new LoginUser("develop","123");
        LoginUser admin=new LoginUser("u_admin","123");
        LoginUser sys=new LoginUser("u_sys","123");
        LoginUser stuff=new LoginUser("u_stuff","123");
        LoginUser HR=new LoginUser("u_HR","123");
        loginUsers.put("develop", develop);
        loginUsers.put("sys", sys);
        loginUsers.put("admin", admin);
        loginUsers.put("stuff",stuff);
        loginUsers.put("HR",HR);
    }

    public static String getClassForName(){
        return className;
    }

    public static String getConnStr(String userName,String pwd) {
        return "jdbc:sqlserver://"+ip+":"+port+";DatabaseName="+databaseName+";user="+userName+";password="+pwd;
    }

    public static String getConnStr(String type) {
        if(!init) {
            Config_init();
            init=true;
        }
        LoginUser loginUser=loginUsers.get(type);
        return "jdbc:sqlserver://"+ip+":"+port+";DatabaseName="+databaseName+";user="+loginUser.getName()+";password="+loginUser.getPwd();
    }


    //不带参数时获得默认的开发用连接
    public static String getConnStr() {
        if(!init) {
            Config_init();
            init=true;
        }
        LoginUser develop=loginUsers.get("develop");
        return "jdbc:sqlserver://"+ip+":"+port+";DatabaseName="+databaseName+";user="+develop.getName()+";password="+develop.getPwd();
    }
}
