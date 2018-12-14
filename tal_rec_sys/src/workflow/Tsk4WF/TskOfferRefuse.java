package workflow.Tsk4WF;

import bean.Arrangement;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import workflow.Tsk_offer_confirm;
import workflow.Tsk_sift;

public class TskOfferRefuse implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String rec_id=(String)delegateExecution.getVariable("recid");
        Tsk_offer_confirm.record_res(rec_id);
    }
}
