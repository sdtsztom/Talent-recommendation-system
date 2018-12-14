package workflow;

import ienum.ConnectUser;
import ienum.RrStage;
import util.CommonConnection;

public class Tsk_open2sift {
    public static boolean Finish(int rrid){
        CommonConnection.Update("update recruitment_requirements set rec_recsta_id="+ RrStage.W_SIFT.toId()+" where rrid="+rrid, ConnectUser.SYS);
        return true;
    }
}
