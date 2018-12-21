package MVC.ActivitiService.userTask;

import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;

import java.util.HashMap;
import java.util.Map;

public class userTask2 implements userTask{

    private TaskService taskService = ProcessEngines.getDefaultProcessEngine().getTaskService();

    //员工推荐
    @Override
    public void execute(Map<String,String> vars) {
        Map<String,Object> taskVariables = new HashMap<>();
        String taskId = vars.get("taskId");
        //taskVariables.put("var2");
        taskService.complete(taskId,taskVariables);
        System.out.println("员工推荐");
    }

}
