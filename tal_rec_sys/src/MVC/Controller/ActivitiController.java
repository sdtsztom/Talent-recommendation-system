package MVC.Controller;

import MVC.ActivitiService.Test.userTask.UserTaskFactory;
import MVC.ActivitiService.Test.userTask.userTask;
import bean.TaskRepresentation;
import MVC.ActivitiService.ActivitiService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class ActivitiController {

    @Autowired
    private ActivitiService myService;

    @Autowired
    private UserTaskFactory userTaskFactory;


    //开启流程实例
    @RequestMapping(value = "/process",method = GET)
    public String startProcessInstance() {
        ProcessInstance pi = myService.startProcess();
        return "process start";
    }

    //testURL : http://localhost:8080/complete/1/?taskId=12&var1=1&check1=1&var2=1&var3=1&check2=1&var4=1&var5=1&check3=1&var6=1&var7=1&var8=1&var9=1
    @RequestMapping(value = "/complete/{task}",method = GET)
    public String userTask(@PathVariable String task, @RequestParam Map<String,String> map) {
        userTask userTask = userTaskFactory.getuserTask(task);
        userTask.execute(map.get("taskId"),map);
        return "ok";
    }

    @RequestMapping(value = "/get",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public String get(String name) {
        return myService.getTaskIdByCategory(name);
    }

    @RequestMapping(value = "/setName",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public void setName(String name) {
        myService.setName(name);
    }

    //获取所有任务
    @RequestMapping(value="/tasks",method = GET)
    public List<TaskRepresentation> getTasks() {
        List<Task> tasks = myService.getTasks();
        List<TaskRepresentation> dtos = new ArrayList<TaskRepresentation>();
        for(Task task : tasks) {
            dtos.add(new TaskRepresentation(task.getId(),task.getName(),task.getExecutionId()));
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
