package MVC.ActivitiService.Test.serviceTask;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

@Service
public class serviceTask2 implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) {
        String var = (String)delegateExecution.getVariable("var2");
        System.out.println("传入serviceTask2的参数是" + var);
    }
}
