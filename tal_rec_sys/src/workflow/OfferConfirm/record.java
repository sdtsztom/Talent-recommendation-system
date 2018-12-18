package workflow.OfferConfirm;

import MVC.Service.RecommendService;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

public class record implements JavaDelegate {

    @Autowired
    RecommendService recommendService;

    @Override
    public void execute(DelegateExecution delegateExecution) {
        recommendService.RecommendUpdate((String)delegateExecution.getVariable("rec_id"),(String)delegateExecution.getVariable("rec_recres_id"));
    }
}
