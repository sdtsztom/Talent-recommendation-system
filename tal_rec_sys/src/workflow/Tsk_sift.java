package workflow;

import bean.Arrangement;
import ienum.*;
import procedure.pointsReward;
import procedure.put2talents;
import util.CommonConnection;

public class Tsk_sift {

    //**************************************API Function***********************************************

    public static void record_res(Arrangement[] arrangements){
        for(Arrangement a:arrangements){
            String rec_id=a.getRec_id();
            switch (a.getResult()){
                case TALENTS:{talents(rec_id);break;}
                case PASS:{pass(rec_id);break;}
            }
        }
    }

    public static void deal_points(Arrangement[] arrangements){
        for(Arrangement a:arrangements){
            String rec_id=a.getRec_id();
            if(a.getResult()==Arr_result.PASS){
                String stf_id= CommonConnection.singleResultQuery("select rec_recstu_id from recommend where rec_id="+rec_id,ConnectUser.SYS);
                pointsReward procedure=new pointsReward(Integer.parseInt(stf_id),PointsChangeRule.PASS_SIFT.toId());
                CommonConnection.execProcedure(procedure,ConnectUser.SYS);
            }
        }
    }

    public static boolean finish(String rrid){
        boolean unfinish_person=CommonConnection.existQuery("select * from recommend where rec_rr_id="+rrid+" and rec_recsta_id="+ RecStage.W_SIFT.toId(),ConnectUser.SYS);
        if(unfinish_person)return false;
        else{
            CommonConnection.Update("update recruitment_requirements set rr_sta_id="+RrStage.W_ARR_S.toId()+" where rr_id="+rrid,ConnectUser.SYS);
            return true;
        }
    }

    //****************************************API Function*************************************

    private static void talents(String rec_id){
        put2talents procedure=new put2talents(Integer.parseInt(rec_id),TalentsFrom.BF_SIFT.toId());
        CommonConnection.execProcedure(procedure,ConnectUser.SYS);
    }

    private static void pass(String rec_id){
        // 更新阶段或(与)结果
        CommonConnection.Update("update recommend set rec_recsta_id="+ RecStage.W_ARR_S.toId()+ " where rec_id="+rec_id,ConnectUser.SYS);
    }
}
