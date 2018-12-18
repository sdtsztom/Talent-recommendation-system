package workflow;

import bean.Arrangement;
import ienum.*;
import procedure.pointsReward;
import procedure.rp2stuff;
import util.CommonConnection;
import util.iutil;

import java.util.ArrayList;
import java.util.Iterator;

public class Tsk_offer_confirm {
    public static void record_res(String type,String rec_id,String username,String pwd){
        if(type.equals("confirm")){
            String rpid=CommonConnection.singleResultQuery("select rec_rp_id from recommend where rec_id="+rec_id,ConnectUser.SYS);
            rp2stuff procedure=new rp2stuff(rpid,username,pwd);
            CommonConnection.execProcedure(procedure,ConnectUser.SYS);
        }else if(type.equals("refuse")){
            CommonConnection.Update("update recommend set rec_recsta_id="+ RecStage.FINISH.toId()+
                    ",rec_recres_id="+ RecResult.REFUSE.toId()+" where rec_id="+rec_id,ConnectUser.SYS);
        }
    }

    public static void deal_points(String rec_id){
        String stf_id= CommonConnection.singleResultQuery("select rec_recstu_id from recommend where rec_id="+rec_id, ConnectUser.SYS);
        //本来应该是wake work时的奖励，但是来不及做了，就用offer confirm来代替take work
        pointsReward procedure=new pointsReward(Integer.parseInt(stf_id),PointsChangeRule.TW.toId());
        CommonConnection.execProcedure(procedure,ConnectUser.SYS);
    }

    public static boolean finish(int rrid){
        boolean unfinish_person= CommonConnection.existQuery("select * from recommend where rec_rr_id="+rrid+" and rec_recsta_id="+ RecStage.W_OC.toId(), ConnectUser.SYS);
        if(unfinish_person)return false;
        else{
            CommonConnection.Update("update recruitment_requirements set rr_sta_id="+ RrStage.FINISH.toId()+" where rr_id"+rrid,ConnectUser.SYS);
            return true;
        }
    }
}
