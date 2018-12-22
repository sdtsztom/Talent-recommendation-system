package workflow.Tsk4WF;

import bean.Arrangement;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import util.CommonConnection;
import workflow.Tsk_offer_confirm;

public class TskOfferFinish implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) {
        String rrid = (String)delegateExecution.getVariable("rr_id");
        //String json=(String)delegateExecution.getVariable("json");
        //Arrangement[] arrangements=ArrangementListUnpacker.unpack2array(json);
        //String rrid= CommonConnection.singleResultQuery("select rec_rr_id from recommend where rec_id="+arrangements[0].getRec_id(), ConnectUser.SYS);
        boolean finish = Tsk_offer_confirm.finish(rrid);
        System.out.println("TaskOffer---------"+finish);
        int isFinish = finish ? 1 : 0;
        delegateExecution.setVariable("isFinish",isFinish);
    }
}
