package MVC.ActivitiService.userTask;

import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;

import java.util.HashMap;
import java.util.Map;

public class userTask1 implements userTask{

    private TaskService taskService = ProcessEngines.getDefaultProcessEngine().getTaskService();

    //HR发布招聘需求
    @Override
    public void execute(String taskId, Map<String,String> vars) {
        Map<String,Object> taskVariables = new HashMap<>();
        taskVariables.put("var1",vars.get("var1"));
        taskVariables.put("var2",vars.get("var2"));
        taskVariables.put("var3",vars.get("var3"));
        taskVariables.put("var4",vars.get("var4"));
        taskVariables.put("var5",vars.get("var5"));
        taskVariables.put("var6",vars.get("var6"));
        taskVariables.put("var7",vars.get("var7"));
        taskVariables.put("var8",vars.get("var8"));
        taskVariables.put("var9",vars.get("var9"));
        taskVariables.put("check1",vars.get("check1"));
        taskVariables.put("check2",vars.get("check2"));
        taskVariables.put("check3",vars.get("check3"));
        taskVariables.put("name",vars.get("name"));
        taskService.complete(taskId,taskVariables);
        System.out.println("HR发布招聘需求");
    }
}
