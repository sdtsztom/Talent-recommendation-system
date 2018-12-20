package workflow.Tsk4WF;

import MVC.Service.InterviewService;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

public class TskItv2Make implements JavaDelegate {

    @Autowired
    InterviewService interviewService;

    @Override
    public void execute(DelegateExecution delegateExecution) {
        String id = (String)delegateExecution.getVariable("itv_id");
        String res = (String)delegateExecution.getVariable("itv_res_id");
        //interviewService.Update(id,"2",res);
    }
}
