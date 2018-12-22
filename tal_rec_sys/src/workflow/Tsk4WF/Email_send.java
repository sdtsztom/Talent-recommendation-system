package workflow.Tsk4WF;

import javafx.beans.binding.ObjectExpression;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import util.Email;
import util.JsonUtils;

import java.util.Map;

public class Email_send implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception{
        //Map<String, Object> map = JsonUtils.json2Map(delegateExecution.getVariable("Json").toString());
        String address = "sdtsztom@163.com";//map.get("address").toString();
        String subject = "新需求发布";//map.get("subject").toString();
        String content = "新需求";//map.get("content").toString();
        Email email = new Email();
        email.setAddr_to(address);
        email.setSubject(subject);
        email.setContent(content);
        email.SendEmail();

    }
}
