package workflow;

import bean.Arrangement;
import email_template.SiftEmailTemplate;
import ienum.*;
import procedure.pointsReward;
import util.CommonConnection;

public class Tsk_sift_arr {

    //**************************************API Function***********************************************
    public static void record_res(Arrangement[] arrangements){
        for(Arrangement a:arrangements){
            String rec_id=a.getRec_id();
            switch (a.getResult()){
                case INTERVIEW:{interview(rec_id); break;}
                case TALENTS:{talents(rec_id);break;}
                case OTHERNEED:{otherneed(a);break;}
            }
        }
    }

    public static void email(Arrangement[] arrangements){
        for(Arrangement a:arrangements){
            String rec_id=a.getRec_id();
            String []values=CommonConnection.singleLineQuery("rp_name,recstu_email from recommend_notify where rec_id="+rec_id,2,ConnectUser.SYS);
            SiftEmailTemplate email=new SiftEmailTemplate(values[1],values[0],a.getResult());
            email.send();
        }
    }

    public static boolean finish(int rrid){
        boolean unfinish_person= CommonConnection.existQuery("select * from recommend where rec_rr_id="+rrid+" and rec_recsta_id="+ RecStage.W_ARR_S.toId(), ConnectUser.SYS);
        if(unfinish_person)return false;
        else{
            CommonConnection.Update("update recruitment_requirements set rr_sta_id="+ RrStage.W_I1.toId()+" where rr_id"+rrid,ConnectUser.SYS);
            return true;
        }
    }
    //**************************************API Function***********************************************
    public static void interview(String rec_id){
        // 更新阶段或(与)结果
        CommonConnection.Update("update recommend set rec_recsta_id="+ RecStage.W_I1.toId()+" where rec_id="+rec_id,ConnectUser.SYS);
    }
    public static void talents(String rec_id){
        pointsReward procedure=new pointsReward(Integer.parseInt(rec_id),TalentsFrom.AFT_SIFT.toId());
        CommonConnection.execProcedure(procedure,ConnectUser.SYS);
    }

    public static void otherneed(Arrangement a){
        String rec_id=a.getRec_id();
        String rr_id_of_otherNeed=a.getRr_id_of_otherNeed();
        String []values= CommonConnection.singleLineQuery(
                "select rec_rp_id,rec_dealHR_id from recommend where rec_id="+rec_id,2,ConnectUser.SYS);
        String new_HR_id=CommonConnection.singleResultQuery("select rr_hr_id from recruitment_requirements where rr_id="+rr_id_of_otherNeed,ConnectUser.SYS);
        //推荐到其它需求
        CommonConnection.Update("insert into recommend values("+rr_id_of_otherNeed+","+values[1]+","+values[0]+","+
                RecFrom.AFT_SIFT.toId()+","+RrStage.OPEN.toId()+","+new_HR_id+","+ RecResult.NONE.toId()+")",ConnectUser.SYS);
        // 更新阶段或(与)结果
        CommonConnection.Update("update recommend set rec_recsta_id="+ RecStage.FINISH.toId()+
                ",rec_recres_id="+ RecResult.OTHERNEED.toId()+" where rec_id="+rec_id,ConnectUser.SYS);
    }
}
