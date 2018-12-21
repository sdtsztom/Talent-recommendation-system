package workflow.Tsk4WF;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class beginprocessWork implements JavaDelegate {

    //上传招聘需求
    @Override
    public void execute(DelegateExecution delegateExecution) {
        String name = (String)delegateExecution.getVariable("rr_id");
        function();
    }

    public void function() {
        System.out.println("beginProcessok");
    }


}
