package MVC.ActivitiService.userTask;


import javafx.concurrent.Task;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import util.TaskUtil;

import java.util.HashMap;
import java.util.Map;

public class userTask12 implements userTask {

    private TaskService taskService = ProcessEngines.getDefaultProcessEngine().getTaskService();

    //OfferConfirm
    @Override
    public String execute(Map<String, String> vars) {
        Map<String,Object> taskVariables = new HashMap<>();
        taskVariables.put("rec_id",vars.get("rec_id"));
        taskVariables.put("name",vars.get("name"));
        taskVariables.put("sex",vars.get("sex"));
        taskVariables.put("type",vars.get("type"));
        taskVariables.put("username",vars.get("username"));
        taskVariables.put("pwd",vars.get("pwd"));
        String rr_id = vars.get("rr_id");
        taskVariables.put("rr_id",rr_id);
        String taskId = TaskUtil.getId(rr_id);
        System.out.println(rr_id);
        System.out.println(taskId);
        taskService.complete(taskId,taskVariables);
        return "/";
    }
}
