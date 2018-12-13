package workflow;

import bean.Arrangement;
import ienum.*;
import util.CommonConnection;
import util.iutil;

import java.util.ArrayList;
import java.util.Iterator;

public class Tsk_sift {

    //**************************************API Function***********************************************

    public static void record_res(ArrayList<Arrangement> arrangements){
        Arrangement a=null;
        Iterator<Arrangement> iterator=arrangements.iterator();
        while(iterator.hasNext()){
            a=iterator.next();
            int rec_id=a.getRec_id();
            switch (a.getResult()){
                case TALENTS:{talents(rec_id);break;}
                case PASS:{pass(rec_id);break;}
            }
        }
    }

    public static void deal_points(ArrayList<Arrangement> arrangements){
        Arrangement a=null;
        Iterator<Arrangement> iterator=arrangements.iterator();
        while(iterator.hasNext()){
            a=iterator.next();
            int rec_id=a.getRec_id();
            if(a.getResult()==Arr_result.PASS){
                String stf_id= CommonConnection.singleResultQuery("select rec_recstu_id from recommend where rec_id="+rec_id,ConnectUser.SYS);
                CommonConnection.Update("insert into points_change values("+PointsChangeRule.PASS_SIFT.toId()+
                        ","+stf_id+","+iutil.getDate()+")",ConnectUser.SYS);
            }
        }
    }

    public static boolean finish(int rrid){
        boolean unfinish_person=CommonConnection.existQuery("select * from recommend where rec_rr_id="+rrid+" and rec_recsta_id="+RStage.W_SIFT.toId(),ConnectUser.SYS);
        if(unfinish_person)return false;
        else{
            CommonConnection.Update("update recruitment set rr_sta_id="+RrStage.W_ARR_S+" where rr_id"+rrid,ConnectUser.SYS);
            return true;
        }
    }

    //****************************************API Function*************************************

    private static void talents(int rec_id){
        String []values= CommonConnection.singleLineQuery(
                "select rec_recstu_id,rec_dealHR_id from recommend where rec_id="+rec_id,2,ConnectUser.SYS);
        // 将被推荐人添加到人才库表
        CommonConnection.Update("insert into talents values("+values[0]+","+values[1]+","+ TalentsFrom.BF_SIFT.toId(),ConnectUser.SYS);
        // 更新阶段或(与)结果
        CommonConnection.Update("update recommend set rec_recsta_id="+ RStage.FINISH.toId()+
                ",rec_recres_id="+ RResult.TALENTS.toId()+" where rec_id="+rec_id,ConnectUser.SYS);
    }

    private static void pass(int rec_id){
        // 更新阶段或(与)结果
        CommonConnection.Update("update recommend set rec_recsta_id="+ RStage.W_ARR_S.toId()+ " where rec_id="+rec_id,ConnectUser.SYS);
    }
}
