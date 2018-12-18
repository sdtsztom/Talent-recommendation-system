package workflow.Tsk4WF;

import bean.Arrangement;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import workflow.Tsk_offer_confirm;
import workflow.Tsk_sift;

public class TskOfferConfirm implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String type=(String)delegateExecution.getVariable("type");
        String recid=(String)delegateExecution.getVariable("recid");
        String username=(String)delegateExecution.getVariable("username");
        String pwd=(String)delegateExecution.getVariable("pwd");
        Tsk_offer_confirm.record_res(type,recid,username,pwd);
    }
}
