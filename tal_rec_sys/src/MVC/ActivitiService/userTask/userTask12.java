package MVC.ActivitiService.userTask;


import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;

import java.util.HashMap;
import java.util.Map;

public class userTask12 implements userTask {

    private TaskService taskService = ProcessEngines.getDefaultProcessEngine().getTaskService();

    //OfferConfirm
    @Override
    public void execute(Map<String, String> vars) {
        Map<String,Object> taskVariables = new HashMap<>();
        taskVariables.put("rec_id",vars.get("rec_id"));
        taskVariables.put("name",vars.get("name"));
        taskVariables.put("sex",vars.get("sex"));
        taskVariables.put("type",vars.get("type"));
        taskVariables.put("username",vars.get("username"));
        taskVariables.put("pwd",vars.get("pwd"));
        String taskId = null;
        taskService.complete(taskId,taskVariables);
    }
}
