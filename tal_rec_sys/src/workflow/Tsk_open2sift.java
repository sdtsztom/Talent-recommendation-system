package workflow;

import ienum.ConnectUser;
import ienum.RrStage;
import util.CommonConnection;

public class Tsk_open2sift {
    public static boolean Finish(String rrid){
        System.out.println("update recruitment_requirements set rr_sta_id="+ RrStage.W_SIFT.toId()+" where rr_id="+rrid);
        CommonConnection.Update("update recruitment_requirements set rr_sta_id="+ RrStage.W_SIFT.toId()+" where rr_id="+rrid, ConnectUser.SYS);
        return true;
    }
}
