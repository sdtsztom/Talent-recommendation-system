package workflow.Tsk4WF;

import bean.Arrangement;
import ienum.ConnectUser;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import util.CommonConnection;
import workflow.Tsk_sift;
import workflow.Tsk_sift_arr;

public class TskSiftArrFinish implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) {
        String json=(String)delegateExecution.getVariable("json");
        Arrangement[] arrangements=ArrangementListUnpacker.unpack2array(json);
        String rrid= CommonConnection.singleResultQuery("select rec_rr_id from recommend where rec_id="+arrangements[0].getRec_id(), ConnectUser.SYS);
        boolean finish = Tsk_sift_arr.finish(rrid);
        delegateExecution.setVariable("isFinish",finish);
    }
}
