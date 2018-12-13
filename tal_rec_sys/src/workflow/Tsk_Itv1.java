package workflow;

import bean.Arrangement;
import ienum.*;
import util.CommonConnection;
import util.iutil;

import java.util.ArrayList;
import java.util.Iterator;

public class Tsk_Itv1 {

    //**************************************API Function***********************************************
    public static void record_res(Arrangement[] arrangements){
        for(Arrangement a:arrangements){
            int rec_id=a.getRec_id();
            switch (a.getResult()){
                case INTERVIEW:{interview(rec_id); break;}
                case TALENTS:{talents(rec_id);break;}
                case OTHERNEED:{otherneed(a);break;}
            }
        }
    }

    public static void deal_points(Arrangement[] arrangements){
        for(Arrangement a:arrangements){
            int rec_id=a.getRec_id();
            if(a.getResult()==Arr_result.INTERVIEW){
                String stf_id= CommonConnection.singleResultQuery("select rec_recstu_id from recommend where rec_id="+rec_id,ConnectUser.SYS);
                CommonConnection.Update("insert into points_change values("+PointsChangeRule.PASS_I1.toId()+
                        ","+stf_id+","+ iutil.getDate()+")",ConnectUser.SYS);
            }
        }
    }

    public static void email(){

    }

    public static boolean finish(int rrid){
        boolean unfinish_person= CommonConnection.existQuery("select * from recommend where rec_rr_id="+rrid+" and rec_recsta_id="+ RecStage.W_I1.toId(), ConnectUser.SYS);
        if(unfinish_person)return false;
        else{
            CommonConnection.Update("update recruitment_requirements set rr_sta_id="+ RrStage.W_I2+" where rr_id"+rrid,ConnectUser.SYS);
            return true;
        }
    }
    //**************************************API Function***********************************************
    public static void interview(int rec_id){
        // 更新阶段或(与)结果
        CommonConnection.Update("update recommend set rec_recsta_id="+ RecStage.W_I2.toId()+" where rec_id="+rec_id, ConnectUser.SYS);
    }
    public static void talents(int rec_id){
        String []values= CommonConnection.singleLineQuery(
                "select rec_recstu_id,rec_dealHR_id from recommend where rec_id="+rec_id,2,ConnectUser.SYS);
        // 将被推荐人添加到人才库表
        CommonConnection.Update("insert into talents values("+values[0]+","+values[1]+","+ TalentsFrom.AFT_I1.toId(),ConnectUser.SYS);
        // 更新阶段或(与)结果
        CommonConnection.Update("update recommend set rec_recsta_id="+ RecStage.FINISH.toId()+
                ",rec_recres_id="+ RecResult.TALENTS.toId()+" where rec_id="+rec_id,ConnectUser.SYS);
    }
    public static void otherneed(Arrangement a){
        int rec_id=a.getRec_id();
        int rr_id_of_otherNeed=a.getRr_id_of_otherNeed();
        String []values= CommonConnection.singleLineQuery(
                "select rec_rp_id,rec_dealHR_id from recommend where rec_id="+rec_id,2,ConnectUser.SYS);
        String new_HR_id=CommonConnection.singleResultQuery("select rr_hr_id from recruitment_requirements where rr_id="+rr_id_of_otherNeed,ConnectUser.SYS);
        //推荐到其它需求
        CommonConnection.Update("insert into recommend values("+rr_id_of_otherNeed+","+values[1]+","+values[0]+","+
                RecFrom.AFT_I1.toId()+","+RrStage.OPEN.toId()+","+new_HR_id+","+ RecResult.NONE.toId()+")",ConnectUser.SYS);
        // 更新阶段或(与)结果
        CommonConnection.Update("update recommend set rec_recsta_id="+ RecStage.FINISH.toId()+
                ",rec_recres_id="+ RecResult.OTHERNEED.toId()+" where rec_id="+rec_id,ConnectUser.SYS);
    }
}
