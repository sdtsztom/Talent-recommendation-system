package MVC.ActivitiService.userTask;

import bean.Arrangement;
import com.alibaba.fastjson.JSON;
import ienum.SRM_Page;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import util.TaskUtil;
import workflow.Tsk4WF.ArrangementListUnpacker;
import workflow.Tsk_Itv2;

import java.util.HashMap;
import java.util.Map;

public class userTask11 implements userTask {

    private TaskService taskService = ProcessEngines.getDefaultProcessEngine().getTaskService();

    //Itv2
    @Override
    public String execute(Map<String,String> vars) {
        String json = vars.get("json");
        String rrid = vars.get("rr_id");
        Arrangement[] arrangements= ArrangementListUnpacker.unpack2array(json);
        String rr_id = TaskUtil.getrr_id(arrangements[0].getRec_id());
        String taskId = TaskUtil.getId(rr_id);
        Map<String,Object> taskVariables = new HashMap<>();
        taskVariables.put("json",json);
        taskService.complete(taskId,taskVariables);
        //************************pass it to workflow************************
        boolean finish= Tsk_Itv2.finish(rrid);
        if(finish) return "/function/Query_Recruit_HR.html";
        else return SRM_Page.W_I2.toString()+"?rrid="+rrid;
    }
}
