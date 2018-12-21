package util;


import MVC.ActivitiService.ActivitiService;
import ienum.ConnectUser;

public class TaskUtil {

    private static String id;

    private static String rrid;

    private static ActivitiService activitiService;

    public static String getId(String name) {
        id = activitiService.getTaskIdByName(name);
        return id;
    }

    public static String getrr_id(String rec_id) {
        rrid= CommonConnection.singleResultQuery("select rec_rr_id from recommend where rec_id="+rec_id, ConnectUser.SYS);
        return rrid;
    }
}
