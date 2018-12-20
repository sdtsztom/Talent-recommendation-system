package MVC.ActivitiService.userTask;

import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;

import java.util.HashMap;
import java.util.Map;

public class userTask8 implements userTask {

    private TaskService taskService = ProcessEngines.getDefaultProcessEngine().getTaskService();

    //Itv1Make
    @Override
    public void execute(String taskId,Map<String,String> vars) {
        Map<String,Object> taskVariables = new HashMap<>();
        taskVariables.put("ip_id",vars.get("ip_id"));
        taskVariables.put("rp_id",vars.get("rp_id"));
        taskVariables.put("dealHR_id",vars.get("dealHR_id"));
        taskVariables.put("rr_id",vars.get("rr_id"));
        taskVariables.put("itv_time",vars.get("itv_time"));
        taskVariables.put("exmer_id",vars.get("exmer_id"));
        taskVariables.put("itv_detail",vars.get("itv_detail"));
        taskService.complete(taskId,taskVariables);
    }
}
