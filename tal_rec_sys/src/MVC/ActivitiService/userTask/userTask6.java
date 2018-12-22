package MVC.ActivitiService.userTask;

import bean.Arrangement;
import ienum.SRM_Page;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import util.TaskUtil;
import workflow.Tsk4WF.ArrangementListUnpacker;
import workflow.Tsk_sift;

import java.util.HashMap;
import java.util.Map;

public class userTask6 implements userTask {

    private TaskService taskService = ProcessEngines.getDefaultProcessEngine().getTaskService();

    //Sift
    @Override
    public String execute(Map<String,String> vars) {
        String json = vars.get("json");
        Arrangement[] arrangements= ArrangementListUnpacker.unpack2array(json);
        String rr_id = TaskUtil.getrr_id(arrangements[0].getRec_id());
        String taskId = TaskUtil.getId(rr_id);
        Map<String,Object> taskVariables = new HashMap<>();
        taskVariables.put("json",vars.get("json"));
        taskService.complete(taskId,taskVariables);
        String rrid = vars.get("rr_id");
        boolean finish= Tsk_sift.finish(rrid);
        if(finish) return "/function/Query_Recruit_HR.html";
        else return SRM_Page.W_SIFT.toString()+"?rrid="+rrid;
    }
}
