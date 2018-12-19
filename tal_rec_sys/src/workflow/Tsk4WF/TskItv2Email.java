package workflow.Tsk4WF;

import bean.Arrangement;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import workflow.Tsk_Itv2;

public class TskItv2Email implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) {
        String json=(String)delegateExecution.getVariable("json");
        Arrangement[] arrangements=ArrangementListUnpacker.unpack2array(json);
        Tsk_Itv2.email(arrangements);
    }
}
