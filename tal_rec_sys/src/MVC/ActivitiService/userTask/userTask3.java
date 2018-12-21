package MVC.ActivitiService.userTask;

import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import util.TaskUtil;

import java.util.HashMap;
import java.util.Map;

public class userTask3 implements userTask {

    private TaskService taskService = ProcessEngines.getDefaultProcessEngine().getTaskService();

    //Republish_Demand
    @Override
    public void execute(Map<String,String> vars) {
        String rr_id = vars.get("rr_id");
        String taskId = TaskUtil.getId(rr_id);
        Map<String,Object> taskVariables = new HashMap<>();
        taskService.complete(taskId,taskVariables);
    }
}
