package util;


import MVC.ActivitiService.ActivitiService;
import ienum.ConnectUser;
import org.activiti.engine.*;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TaskUtil {

    private static String id;

    private static String rrid;

    static ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();

    private static RuntimeService runtimeService = engine.getRuntimeService();

    private static TaskService taskService = engine.getTaskService();

    public static String getId(String name) {
        List<Execution> list = runtimeService.createExecutionQuery().list();
        List<Task> tasks = taskService.createTaskQuery().list();
        for(Execution e : list)
            if(name.equals(e.getName()))
                for(Task t : tasks)
                    if (t.getExecutionId().equals(e.getId()))
                        id = t.getId();
        return id;
    }

    public static String getrr_id(String rec_id) {
        rrid= CommonConnection.singleResultQuery("select rec_rr_id from recommend where rec_id="+rec_id, ConnectUser.SYS);
        return rrid;
    }
}
