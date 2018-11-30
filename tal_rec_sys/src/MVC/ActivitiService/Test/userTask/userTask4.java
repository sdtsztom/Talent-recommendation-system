package MVC.ActivitiService.Test.userTask;

import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;

import java.util.HashMap;
import java.util.Map;

public class userTask4 implements userTask {

    private TaskService taskService = ProcessEngines.getDefaultProcessEngine().getTaskService();

    //HR筛选
    @Override
    public void execute(String taskId, Map<String,String> vars) {
        Map<String,Object> taskVariables = new HashMap<>();
        //taskVariables.put("var4",vars);
        taskService.complete(taskId,taskVariables);
        System.out.println("HR筛选");
    }
}
