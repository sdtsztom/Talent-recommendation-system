package MVC.Controller;

import MVC.Entity.TaskRepresentation;
import MVC.ActivitiService.ActivitiService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ActivitiController {

    @Autowired
    private ActivitiService myService;

    //开启流程实例
    @RequestMapping(value = "/process",method = RequestMethod.GET)
    public String startProcessInstance() {
        ProcessInstance pi = myService.startProcess();
        return "process start";
    }

    //处理userTask1
    @RequestMapping(value = "/complete/task1",method = RequestMethod.GET)
    public String userTask1(String taskId,String var1,String var2) {
        myService.userTask1(taskId,var1,var2);
        return "task1 complete";
    }

    //获取所有任务
    @RequestMapping(value="/tasks",method = RequestMethod.GET)
    public List<TaskRepresentation> getTasks() {
        List<Task> tasks = myService.getTasks();
        List<TaskRepresentation> dtos = new ArrayList<TaskRepresentation>();
        for(Task task : tasks) {
            dtos.add(new TaskRepresentation(task.getId(),task.getName()));
        }
        return dtos;
    }

    /*//获取任务
    @RequestMapping(value="/tasks/username/{username}",method = RequestMethod.GET)
    public List<TaskRepresentation> getTasksByUsername(@PathVariable String username) {
        List<Task> tasks = myService.getTasksByUser(username);
        List<TaskRepresentation> dtos = new ArrayList<TaskRepresentation>();
        for(Task task : tasks) {
            dtos.add(new TaskRepresentation(task.getId(),task.getName()));
        }
        return dtos;
    }

    //领取任务
    @RequestMapping(value = "/claim/{taskId}/{username}",method = RequestMethod.GET)
    public String claimTask(@PathVariable String taskId,@PathVariable String username) {
        myService.claimTask(taskId,username);
        return taskId + "claim by" + username ;
    }*/
}
