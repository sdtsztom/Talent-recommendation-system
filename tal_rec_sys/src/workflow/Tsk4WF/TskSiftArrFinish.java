package workflow.Tsk4WF;

import bean.Arrangement;
import com.alibaba.fastjson.JSON;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import workflow.Tsk_sift_arr;

public class TskSiftArrFinish implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) {
        String json = (String)delegateExecution.getVariable("json");
        Arrangement arrangement = JSON.parseObject(json,Arrangement.class);
        boolean finish = Tsk_sift_arr.finish(arrangement.getRec_id());
        delegateExecution.setVariable("isFinish",finish);
    }
}
