package MVC.ActivitiService;

import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.Execution;
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
                .name("workflow")//声明流程的名称
                .category("workflow")//修改category
                .addClasspathResource("Process/workflow.bpmn").addClasspathResource("Process/workflow.png").deploy();
    }

    //根据Execution的NAME获取task的id
    public String getTaskIdByName(String name) {
        List<Execution> list = runtimeService.createExecutionQuery().list();
        List<Task> tasks = taskService.createTaskQuery().list();
        for(Execution e : list)
            if(e.getName().equals(name))
                for(Task t : tasks)
                    if (t.getExecutionId().equals(e.getId()))
                        return t.getId();
        return "null";
    }

    //开始流程
    public ProcessInstance startProcess() {
        if(repositoryService.createDeploymentQuery().count()==0)
        ProcessBuild();
        Map<String,Object> variables = new HashMap<String,Object>();
        ProcessInstance pi = runtimeService.startProcessInstanceByKey("workflow",variables);
        return pi;
    }

    //删除流程
    public void deleteProcess(String name1,String name2) {
        repositoryService.deleteDeployment(name1);
        runtimeService.deleteProcessInstance(name2,"");
    }

    //获得任务列表
    public List<Task> getTasks() {
        return taskService.createTaskQuery().list();
    }

}