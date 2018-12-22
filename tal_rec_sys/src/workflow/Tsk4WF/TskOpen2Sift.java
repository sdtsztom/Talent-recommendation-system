package workflow.Tsk4WF;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import workflow.Tsk_open2sift;

public class TskOpen2Sift implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String rrid=(String)delegateExecution.getVariable("rr_id");
        Tsk_open2sift.finish(rrid);
    }
}
