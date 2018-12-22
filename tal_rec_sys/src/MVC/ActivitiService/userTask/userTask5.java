package MVC.ActivitiService.userTask;

import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import util.TaskUtil;
import workflow.Tsk_open2sift;

import java.util.HashMap;
import java.util.Map;

public class userTask5 implements userTask {

    private TaskService taskService = ProcessEngines.getDefaultProcessEngine().getTaskService();

    //Open2Sift
    @Override
    public String execute(Map<String,String> vars) {
        String rr_id = vars.get("rr_id");
        System.out.println("workflow"+rr_id);
        String taskId = TaskUtil.getId(rr_id);
        Map<String,Object> taskVariables = new HashMap<>();
        taskVariables.put("rr_id",vars.get("rr_id"));
        taskService.complete(taskId,taskVariables);
        //Tsk_open2sift.finish(rr_id);
        return "/function/Query_Recruit_HR.html";
    }
}
