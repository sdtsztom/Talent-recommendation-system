package MVC.ActivitiService.serviceTask.OfferConfirm;

import MVC.Service.RecommendService;
import bean.Stuff;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

//新员工注册
public class register_new_stuff implements JavaDelegate {

    @Autowired
    RecommendService recommendService;

    @Override
    public void execute(DelegateExecution delegateExecution) {
        recommendService.StuffInsert((Stuff) delegateExecution.getVariable("stuff"));
    }
}
