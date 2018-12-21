package MVC.ActivitiService.userTask;

import bean.Arrangement;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import util.TaskUtil;
import workflow.Tsk4WF.ArrangementListUnpacker;

import java.util.HashMap;
import java.util.Map;

public class userTask4 implements userTask {

    private TaskService taskService = ProcessEngines.getDefaultProcessEngine().getTaskService();

    //resume_entry
    @Override
    public void execute(Map<String,String> vars) {
        String rr_id = vars.get("rr_id");
        String taskId = TaskUtil.getId(rr_id);
        Map<String,Object> taskVariables = new HashMap<>();
        taskService.complete(taskId,taskVariables);
    }
}
