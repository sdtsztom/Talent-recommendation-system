package workflow.Tsk4WF;

import MVC.Service.PointService;
import ienum.Point;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//积分奖励
@Service
public class TskOfferConfirmdeal_points implements JavaDelegate {

    @Autowired
    PointService pointService;

    @Override
    public void execute(DelegateExecution delegateExecution) {
        pointService.changePoint(Point.ENTRY.toString(),(String) delegateExecution.getVariable("stf_id"));
    }

}
