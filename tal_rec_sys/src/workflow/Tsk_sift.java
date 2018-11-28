package workflow;

import bean.Arrangement;
import ienum.*;
import util.CommonConnection;
import util.iutil;

import java.util.ArrayList;
import java.util.Iterator;

public class Tsk_sift {

    //**************************************API Function***********************************************

    public static void record_sift_res(ArrayList<Arrangement> arrangements){
        Arrangement a=null;
        CommonConnection.setConnectUser(ConnectUser.SYS);
        Iterator<Arrangement> iterator=arrangements.iterator();
        while(iterator.hasNext()){
            a=iterator.next();
            int rec_id=a.getId();
            switch (a.getResult()){
                case TALENTS:{talents(rec_id);break;}
                case PASS:{pass(rec_id);break;}
            }
        }
    }

    public static void deal_points(ArrayList<Arrangement> arrangements){
        Arrangement a=null;
        CommonConnection.setConnectUser(ConnectUser.SYS);
        Iterator<Arrangement> iterator=arrangements.iterator();
        while(iterator.hasNext()){
            a=iterator.next();
            int rec_id=a.getId();
            if(a.getResult()==Arr_result.PASS){
                String stf_id= CommonConnection.singleResultQuery("select rec_recstu_id from recommend where rec_id="+rec_id);
                CommonConnection.makeUpdate("insert into points_change values("+PointsChangeRule.PASS_SIFT.toId()+
                        ","+stf_id+","+iutil.getDate()+")");
            }
        }
    }

    public static boolean isFinish(){
        return false;
    }

    //****************************************API Function*************************************

    private static void talents(int rec_id){
        String []values= CommonConnection.singleLineQuery(""+
                "select rec_recstu_id,rec_dealHR_id from recommend where rec_id="+rec_id,2);
        // 更新阶段或(与)结果
        CommonConnection.makeUpdate("update recommend set rec_recsta_id="+ RStage.FINISH.toId()+
                ",rec_recres_id="+ RResult.TALENTS.toId()+" where rec_id="+rec_id);

        // 将被推荐人添加到人才库表
        CommonConnection.makeUpdate("insert into talents values("+values[0]+","+values[1]+","+ TalentsFrom.BF_SIFT.toId());
    }

    private static void pass(int rec_id){
        // 更新阶段或(与)结果
        CommonConnection.makeUpdate("update recommend set rec_recsta_id="+ RStage.W_ARR_S.toId()+
                ",rec_recres_id="+ RResult.TALENTS.toId()+" where rec_id="+rec_id);
    }

}
