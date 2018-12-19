package workflow.Tsk4WF;

import bean.Arrangement;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import workflow.Tsk_sift;

public class TskSiftRecord implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String json=(String)delegateExecution.getVariable("json");
        Arrangement[] arrangements=ArrangementListUnpacker.unpack2array(json);
        Tsk_sift.record_res(arrangements);
    }

    public static void execute_debug(String json){
        Arrangement[] arrangements=ArrangementListUnpacker.unpack2array(json);
        Tsk_sift.record_res(arrangements);
    }
}
