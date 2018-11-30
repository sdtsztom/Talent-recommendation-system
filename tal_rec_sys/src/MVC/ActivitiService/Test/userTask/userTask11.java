package MVC.ActivitiService.Test.userTask;

import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;

import java.util.HashMap;
import java.util.Map;

public class userTask11 implements userTask {

    private TaskService taskService = ProcessEngines.getDefaultProcessEngine().getTaskService();

    //任职确认
    @Override
    public void execute(String taskId,Map<String,String> vars) {
        Map<String,Object> taskVariables = new HashMap<>();
        //taskVariables.put("var11",vars);
        taskService.complete(taskId,taskVariables);
        System.out.println("任职确认");
    }
}
