package workflow.Tsk4WF;

import ienum.ConnectUser;
import ienum.RrStage;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import util.CommonConnection;

public class Recommand_change implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution){
        String rr_id = delegateExecution.getVariable("Json").toString();
        CommonConnection.Update("update recruitment_requirements\n" +
                "set rr_sta_id = " + RrStage.W_SIFT.toId() +
                "where rr_id = " + rr_id, ConnectUser.SYS);
    }

}
