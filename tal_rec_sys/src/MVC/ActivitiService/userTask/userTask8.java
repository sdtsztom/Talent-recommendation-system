package MVC.ActivitiService.userTask;

import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;

import java.util.HashMap;
import java.util.Map;

public class userTask8 implements userTask {

    private TaskService taskService = ProcessEngines.getDefaultProcessEngine().getTaskService();

    //Itv1Make
    @Override
    public void execute(Map<String,String> vars) {
        Map<String,Object> taskVariables = new HashMap<>();
        String taskId = vars.get("taskId");
        taskService.complete(taskId,taskVariables);
    }
}
