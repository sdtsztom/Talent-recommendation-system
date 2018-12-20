package workflow;

import bean.Arrangement;
import email_template.Intv2Pass2RpEmailTemplate;
import ienum.*;
import procedure.pointsReward;
import util.CommonConnection;
import util.iutil;

import java.util.ArrayList;
import java.util.Iterator;

public class Tsk_Itv2 {
    //**************************************API Function***********************************************
    public static void record_res(Arrangement[] arrangements){
        for(Arrangement a:arrangements){
            String rec_id=a.getRec_id();
            switch (a.getResult()){
                case PASS:{pass(rec_id); break;}
                case NOOFFER:{
                    noOffer(rec_id);break;}
            }
        }
    }

    public static void deal_points(Arrangement[] arrangements){
        for(Arrangement a:arrangements){
            String rec_id=a.getRec_id();
            if(a.getResult()== Arr_result.PASS){
                String stf_id= CommonConnection.singleResultQuery("select rec_recstu_id from recommend where rec_id="+rec_id, ConnectUser.SYS);
                pointsReward procedure=new pointsReward(Integer.parseInt(stf_id),PointsChangeRule.PASS_I2.toId());
                CommonConnection.execProcedure(procedure,ConnectUser.SYS);
            }
        }
    }

    public static void makeIntv(){

    }

    public static void email(Arrangement[] arrangements){
        for(Arrangement arrangement:arrangements) {
            String rec_id = arrangement.getRec_id();
            if(arrangement.getResult()==Arr_result.PASS){
                Intv2Pass2RpEmailTemplate emailTemplate = new Intv2Pass2RpEmailTemplate(rec_id);
                emailTemplate.send();
            }
        }

    }

    public static boolean finish(String rrid){
        boolean unfinish_person= CommonConnection.existQuery("select * from recommend where rec_rr_id="+rrid+" and rec_recsta_id="+ RecStage.W_I2.toId(), ConnectUser.SYS);
        if(unfinish_person)return false;
        else{
            CommonConnection.Update("update recruitment_requirements set rr_sta_id="+ RrStage.W_OC.toId()+" where rr_id="+rrid,ConnectUser.SYS);
            return true;
        }
    }
    //**************************************API Function***********************************************
    private static void pass(String rec_id){
        // 更新阶段或(与)结果
        CommonConnection.Update("update recommend set rec_recsta_id="+ RecStage.W_OC.toId()+ " where rec_id="+rec_id,ConnectUser.SYS);
    }
    private static void noOffer(String rec_id){
        CommonConnection.Update("update recommend set rec_recsta_id="+ RecStage.FINISH.toId()+
                ",rec_recres_id="+ RecResult.NOOFFER.toId()+" where rec_id="+rec_id,ConnectUser.SYS);
    }
}
