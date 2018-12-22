package workflow.Tsk4WF;

import bean.Arrangement;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import workflow.Tsk_Itv1;

public class TskItv1PointDeal implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution){
        String json=(String)delegateExecution.getVariable("json");
        Arrangement[] arrangements=ArrangementListUnpacker.unpack2array(json);
        Tsk_Itv1.deal_points(arrangements);
    }
}
