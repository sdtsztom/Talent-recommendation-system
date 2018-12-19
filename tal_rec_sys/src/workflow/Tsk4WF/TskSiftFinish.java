package workflow.Tsk4WF;

import bean.Arrangement;
import com.alibaba.fastjson.JSON;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import workflow.Tsk_sift;

public class TskSiftFinish implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) {
        String json=(String)delegateExecution.getVariable("json");
        Arrangement[] arrangements=ArrangementListUnpacker.unpack2array(json);
        boolean finish;
        for(Arrangement arrangement:arrangements) {
            if(Tsk_sift.finish(arrangement.getRec_id()) == false) {
                finish = false;
            }
        }
        finish = true;
        delegateExecution.setVariable("isFinish",finish);
    }

    public void exec_debug(String json){

    }
}
