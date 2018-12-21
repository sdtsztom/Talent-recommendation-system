package MVC.ActivitiService.userTask;

import bean.Arrangement;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import util.TaskUtil;
import workflow.Tsk4WF.ArrangementListUnpacker;

import java.util.HashMap;
import java.util.Map;

public class userTask9 implements userTask {

    private TaskService taskService = ProcessEngines.getDefaultProcessEngine().getTaskService();

    //Itv1
    @Override
    public void execute(Map<String,String> vars) {
        String json = vars.get("json");
        Arrangement[] arrangements= ArrangementListUnpacker.unpack2array(json);
        String rr_id = TaskUtil.getrr_id(arrangements[0].getRec_id());
        String taskId = TaskUtil.getId(rr_id);
        Map<String,Object> taskVariables = new HashMap<>();
        taskVariables.put("json",vars.get("json"));
        taskService.complete(taskId,taskVariables);
    }
}
