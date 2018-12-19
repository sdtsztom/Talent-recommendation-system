package MVC.Controller;

import MVC.ActivitiService.userTask.UserTaskFactory;
import MVC.ActivitiService.userTask.userTask;
import MVC.Service.MailService;
import bean.Arrangement;
import bean.TaskRepresentation;
import MVC.ActivitiService.ActivitiService;
import com.alibaba.fastjson.JSON;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
        userTask.execute(get(JSON.parseObject(map.get("json"),Arrangement.class).getRec_id()),map);
        return "ok";
    }

    //根据需求Id获取TaskId
    @RequestMapping(value = "/getTaskId",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public String get(String name) {
        return myService.getTaskIdByName(name);
    }

    //获取所有任务
    @RequestMapping(value="/Tasks",method = GET)
    public List<TaskRepresentation> getTasks() {
        List<Task> tasks = myService.getTasks();
        List<TaskRepresentation> list = new ArrayList<TaskRepresentation>();
        for(Task task : tasks) {
            list.add(new TaskRepresentation(task.getId(),task.getName(),task.getExecutionId(),task.getCreateTime(),task.getProcessDefinitionId(),task.getProcessInstanceId(),task.getTaskDefinitionKey()));
        }
        return list;
    }


    @Autowired
    MailService mailService;
    //测试邮件
    @RequestMapping(value = "/mail",method = GET)
    public String mail() throws Exception{

        mailService.sentMail("837070594@qq.com","mail3-subject","mail3-content");
        return "ok";
    }
}
