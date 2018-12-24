package workflow.Tsk4WF;

import MVC.Service.InterviewService;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

public class TskItv1Make implements JavaDelegate {

    @Autowired
    InterviewService interviewService;

    @Override
    public void execute(DelegateExecution delegateExecution) {
        String ip_id = (String) delegateExecution.getVariable("ip_id");
        String rp_id = (String) delegateExecution.getVariable("rp_id");
        String dealHR_id = (String)delegateExecution.getVariable("dealHR_id");
        String rr_id = (String)delegateExecution.getVariable("rr_id");
        String itv_time = (String)delegateExecution.getVariable("itv_time");
        String exmer_id = (String)delegateExecution.getVariable("exmer_id");
        String itv_detail = (String)delegateExecution.getVariable("itv_detail");
        String ip_rnd=(String)delegateExecution.getVariable("ip_rnd");
        interviewService.BuildInterview(ip_id,rp_id,dealHR_id,rr_id,itv_time,exmer_id,itv_detail,ip_rnd);
    }
}
