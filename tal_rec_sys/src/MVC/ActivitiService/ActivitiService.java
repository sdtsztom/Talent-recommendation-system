package MVC.ActivitiService;

import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ActivitiService {

    //配置
    ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();

    private RuntimeService runtimeService = engine.getRuntimeService();

    private TaskService taskService = engine.getTaskService();

    private RepositoryService repositoryService = engine.getRepositoryService();

    private void ProcessBuild() {
        repositoryService
                .createDeployment()//创建部署对象
                .name("Process")//声明流程的名称
                .category("")//修改category
                .addClasspathResource("Process/Process.bpmn").addClasspathResource("Process/Process.png").deploy();
    }

    //开始流程
    public ProcessInstance startProcess() {
        if(repositoryService.createDeploymentQuery().count()==0) ProcessBuild();
        Map<String,Object> variables = new HashMap<String,Object>();
        return runtimeService.startProcessInstanceByKey("Process",variables);
    }

    //获得任务列表
    public List<Task> getTasks() {
        return taskService.createTaskQuery().list();
    }

    //处理任务1
    public void userTask1(String taskId,String var1,String var2) {
        Map<String,Object> taskVariables = new HashMap<String, Object>();
        taskVariables.put("var1",var1);
        taskVariables.put("var2",var2);
        taskService.complete(taskId,taskVariables);
    }

}


/*    //根据人物查询任务
    public List<Task> getTasksByUser(String username) {
        return taskService.createTaskQuery().taskCandidateUser(username).list();
    }

    //领取任务
    public void claimTask(String taskId,String username) {
        taskService.claim(taskId,username);
    }*/