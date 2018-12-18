package util;

import java.util.HashMap;
import bean.LoginUser;
import ienum.ConnectUser;

public class Config {
    static boolean init=false;
    static String webServerIp="localhost";
    static String webServerPort="8080";
    static String className="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static String conPostfix="jdbc:sqlserver://";
    static String databaseIp ="localhost";
    static String databasePort ="1433";
    static String databaseName="tal_rec_sys";
    static int confirm_days_limit=15;

    static HashMap<String,LoginUser> loginUsers=new HashMap<String,LoginUser>();

    public static void Config_init() {
        LoginUser develop=new LoginUser("u_dev","12345678a");
        LoginUser admin=new LoginUser("u_admin","12345678a");
        LoginUser sys=new LoginUser("u_sys","12345678a");
        LoginUser stuff=new LoginUser("u_stuff","12345678a");
        LoginUser HR=new LoginUser("u_HR","12345678a");
        loginUsers.put("develop", develop);
        loginUsers.put("sys", sys);
        loginUsers.put("admin", admin);
        loginUsers.put("stuff",stuff);
        loginUsers.put("hr",HR);
    }

    public static String getClassForName(){
        return className;
    }

    public static String getConnStr(String userName,String pwd) {
        return conPostfix+ databaseIp +":"+ databasePort +";DatabaseName="+databaseName+";user="+userName+";password="+pwd;
    }

    public static String getConnStr(ConnectUser user) {
        if(!init) {
            Config_init();
            init=true;
        }
        LoginUser loginUser=loginUsers.get(user.toString());
        return "jdbc:sqlserver://"+ databaseIp +":"+ databasePort +";DatabaseName="+databaseName+";user="+loginUser.getUsername()+";password="+loginUser.getPwd();
    }


    //不带参数时获得默认的开发用连接
    public static String getConnStr() {
        if(!init) {
            Config_init();
            init=true;
        }
        LoginUser develop=loginUsers.get("develop");
        return "jdbc:sqlserver://"+ databaseIp +":"+ databasePort +";DatabaseName="+databaseName+";user="+develop.getUsername()+";password="+develop.getPwd();
    }

    public static String getWebServerIp(){return webServerIp;}

    public static String getWebServerPort(){return webServerPort;}
}
