package workflow.Interview2;

import MVC.Service.PointService;
import ienum.Point;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

//积分奖励发放
public class deal_points implements JavaDelegate {

    @Autowired
    PointService pointService;

    @Override
    public void execute(DelegateExecution delegateExecution) {
        pointService.changePoint(Point.FINALINTERVIEW.toString(),(String) delegateExecution.getVariable("stf_id"));
    }
}
