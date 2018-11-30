package MVC.ActivitiService;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

@Service
public class serviceTask1 implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) {
        String var = (String)delegateExecution.getVariable("var1");
        System.out.println("传入serviceTask1的参数是" + var);
    }

}