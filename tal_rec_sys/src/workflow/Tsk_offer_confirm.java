package workflow;

import bean.Arrangement;
import ienum.*;
import util.CommonConnection;
import util.iutil;

import java.util.ArrayList;
import java.util.Iterator;

public class Tsk_offer_confirm {
    public static void record_res(String rpid,String username,String pwd){
    }

    public static void record_res(String rpid,Boolean refuse){
    }

    public static void deal_points(String rpid){
        String stf_id= CommonConnection.singleResultQuery("select rec_recstu_id from recommend where rec_rp_id="+rpid+" and rec_recsta_id="+RecStage.W_OC.toId(), ConnectUser.SYS);
        CommonConnection.Update("insert into points_change values("+ PointsChangeRule.TW.toId()+
                ","+stf_id+","+ iutil.getDate()+")",ConnectUser.SYS);
    }

    public static boolean finish(int rrid){
        boolean unfinish_person= CommonConnection.existQuery("select * from recommend where rec_rr_id="+rrid+" and rec_recsta_id="+ RecStage.W_OC.toId(), ConnectUser.SYS);
        if(unfinish_person)return false;
        else{
            CommonConnection.Update("update recruitment_requirements set rr_sta_id="+ RrStage.FINISH+" where rr_id"+rrid,ConnectUser.SYS);
            return true;
        }
    }
}
