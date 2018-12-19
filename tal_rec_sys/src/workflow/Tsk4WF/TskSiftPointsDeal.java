package workflow.Tsk4WF;

import bean.Arrangement;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import workflow.Tsk_sift;

public class TskSiftPointsDeal implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String json=(String)delegateExecution.getVariable("json");
        Arrangement[] arrangements=ArrangementListUnpacker.unpack2array(json);
        Tsk_sift.deal_points(arrangements);
    }

    public void exec_debug(String json){
        Arrangement[] arrangements=ArrangementListUnpacker.unpack2array(json);
        Tsk_sift.deal_points(arrangements);
    }
}
