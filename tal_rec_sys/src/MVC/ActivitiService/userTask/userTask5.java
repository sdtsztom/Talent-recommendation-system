package MVC.ActivitiService.userTask;

import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;

import java.util.HashMap;
import java.util.Map;

public class userTask5 implements userTask {

    private TaskService taskService = ProcessEngines.getDefaultProcessEngine().getTaskService();

    //安排结果
    @Override
    public void execute(String taskId, Map<String,String> vars) {
        Map<String,Object> taskVariables = new HashMap<>();
        taskVariables.put("json",vars.get("json"));
        taskService.complete(taskId,taskVariables);
    }
}
